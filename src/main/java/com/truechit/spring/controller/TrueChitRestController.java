package com.truechit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.truechit.spring.model.BidHistory;
import com.truechit.spring.model.Chit;
import com.truechit.spring.model.ChitAmount;
import com.truechit.spring.model.User;
import com.truechit.spring.service.BidHistoryService;
import com.truechit.spring.service.ChitAmountService;
import com.truechit.spring.service.ChitService;
import com.truechit.spring.service.UserService;

@RestController
@EnableTransactionManagement
//@RequestMapping("/chit")
public class TrueChitRestController {


	@Autowired
	UserService userService; 

	@Autowired
	ChitService chitService; 
	
	@Autowired
	BidHistoryService bidService;
	
	@Autowired
	ChitAmountService chitAmountService;
	
	@RequestMapping(value = "/")
	public String welcomeMessage() {

		return "welcome user";
	}
	
	//-------------------Create a User--------------------------------------------------------
	
	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user, 	UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + user.getName());

		if (userService.isUserExist(user.getId())) {
			System.out.println("A User with name " + user.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		userService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//-------------------Create a Chit--------------------------------------------------------
	
	@RequestMapping(value = "/chit/", method = RequestMethod.POST)
	public ResponseEntity<Void> createChit(@RequestBody Chit chit, 	UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Chit " + chit.getChitName());

		if (chitService.isChitExist(chit.getChitId())) {
			System.out.println("A Chit with name " + chit.getChitName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		chitService.saveChit(chit);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/chit/{id}").buildAndExpand(chit.getChitId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/users/", method = RequestMethod.POST)
	public ResponseEntity<Void> addUserstoChit(@RequestBody Chit chit, 	UriComponentsBuilder ucBuilder) {
	
		chitService.updateChit(chit.getChitId(), chit);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/chit/{id}").buildAndExpand(chit.getChitId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/maxbid", method = RequestMethod.GET)
	public ResponseEntity<Double> maxBid(@RequestParam Long chitId, @RequestParam int cycle, UriComponentsBuilder ucBuilder) {
		Double maxBidAmount = bidService.getMaxBidAmount(chitId, cycle);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/maxbid/{chitId}").buildAndExpand(chitId).toUri());
		return new ResponseEntity<Double>(maxBidAmount, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/submitbid/", method = RequestMethod.POST)
	public ResponseEntity<Void> submitBid(@RequestBody BidHistory bid, 	UriComponentsBuilder ucBuilder) {
		bidService.submitBid(bid);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/submitbid/{id}").buildAndExpand(bid.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
//	@RequestMapping(value = "/getwinningbid/", method = RequestMethod.POST)
//	public ResponseEntity<BidHistory> getWinningBid(@RequestBody Chit chit, 	UriComponentsBuilder ucBuilder) {
//	
//		BidHistory bidAmount = bidService.getWinningBet(chit.getChitId(), Integer.parseInt(chit.getStatus()));
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(ucBuilder.path("/submitbid/{id}").buildAndExpand(chit.getChitId()).toUri());
//
//		return new ResponseEntity<BidHistory>(bidAmount, HttpStatus.OK);
//	}
	
	
	@RequestMapping(value = "/getBidOfMonth/", method = RequestMethod.POST)
	public ResponseEntity<BidHistory> getBidOfMonth(@RequestBody Chit chit, 	UriComponentsBuilder ucBuilder) {
	
		BidHistory bidAmount = bidService.getWinningBet(chit.getChitId(), Integer.parseInt(chit.getStatus()));
		// y = number of users /number of phases
		// x = (chit amount -winning bid amount) - foreman fee 
		// z = (x/ number of users) -y 
		double standardAmount = chit.getChitAmount() / chit.getNumberofPhases();
		double balance  = (chit.getChitAmount() - bidAmount.getBidAmount()) - chit.getForemanFee();
		double currentChitAmount = standardAmount - (balance / chit.getNumberofUsers());
		bidAmount.setWon(true);
		
		chitAmountService.addChitAmount(new ChitAmount(chit.getChitId(), bidAmount.getChitCycle(), currentChitAmount));
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/submitbid/{id}").buildAndExpand(chit.getChitId()).toUri());

		return new ResponseEntity<BidHistory>(bidAmount, HttpStatus.OK);
	}
	
	
}
