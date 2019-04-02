package com.truechit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.truechit.spring.model.Chit;
import com.truechit.spring.model.User;
import com.truechit.spring.service.ChitService;
import com.truechit.spring.service.UserService;


@RestController
@RequestMapping("/chit")
public class TrueChitRestController {


	@Autowired
	UserService userService; 

	@Autowired
	ChitService chitService; 
	
	
	@RequestMapping(value = "/")
	public String welcomeMessage() {

		return "welcome user";
	}
	
//	//-------------------Create a User--------------------------------------------------------
//	
//	@RequestMapping(value = "/user/", method = RequestMethod.POST)
//	public ResponseEntity<Void> createUser(@RequestBody User user, 	UriComponentsBuilder ucBuilder) {
//		System.out.println("Creating User " + user.getName());
//
//		if (userService.isUserExist(user.getId())) {
//			System.out.println("A User with name " + user.getName() + " already exist");
//			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//		}
//
//		userService.saveUser(user);
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
//		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//	}
//	
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
	
	@RequestMapping(value = "/chit/", method = RequestMethod.POST)
	public ResponseEntity<Void> addUserstoChit(@RequestBody Chit chit, 	UriComponentsBuilder ucBuilder) {
	
		chitService.updateChit(chit.getChitId(), chit);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/chit/{id}").buildAndExpand(chit.getChitId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}
