package com.truechit.spring.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.truechit.spring.dao.BidHistoryDAO;
import com.truechit.spring.model.BidHistory;
import com.truechit.spring.model.Chit;
import com.truechit.spring.service.ChitService;

@Repository
@Transactional
public class BidHistoryDAOImpl implements BidHistoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ChitService chitService;                   

	public BidHistory getWinningBid(Long chitId, int cycle) {
		
		Session session = sessionFactory.getCurrentSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<BidHistory> cq = cb.createQuery(BidHistory.class);
		Root<BidHistory> root = cq.from(BidHistory.class);
		cq.orderBy(cb.asc(root.get("bidAmount")));
		
		cq.select(root);
		Query<BidHistory> query = session.createQuery(cq);
		BidHistory bidAmount = query.getResultList().get(0);
		// scan the bid table and get least valued and eligible bid
		return bidAmount;
	}

	@Override
	public String submitBid(BidHistory bid) {
		// is user eligible to bid.
		Session session = sessionFactory.getCurrentSession();
		
		if(isUserEligilbeToBid(bid))
			session.save(bid);
		
		return bid.getId().toString();
	}
	
	boolean isUserEligilbeToBid(BidHistory bid)
	{
		Session session = sessionFactory.getCurrentSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<BidHistory> cq = cb.createQuery(BidHistory.class);
		Root<BidHistory> root = cq.from(BidHistory.class);
		Predicate[] predicates = new Predicate[2];
		predicates[0] = cb.equal(root.get("userId"), bid.getUserId());
		predicates[1] = cb.equal(root.get("chitId"), bid.getChitId());
		
		cq.select(root).where(predicates);
		Query<BidHistory> query = session.createQuery(cq);
		if (query.getResultList().isEmpty())
			return true;
		else 
			return false;
	}

	@Override
	public BidHistory get(Long id) {
		return sessionFactory.getCurrentSession().get(BidHistory.class, id);
	}

	@Override
	public List<BidHistory> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<BidHistory> cq = cb.createQuery(BidHistory.class);
		Root<BidHistory> root = cq.from(BidHistory.class);
		cq.select(root);
		Query<BidHistory> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public double getMaxBidAmount(Long chitId, int cycle) {
		Chit chit = chitService.findById(chitId);
		double percentage = 0.0;
		if (cycle >= chit.getNumberofPhases()/2)
			percentage = chit.getNumberofPhases() - cycle ;
		else
			percentage = chit.getNumberofPhases() - (cycle*1.5);
//		double maxDiscount =  chit.getChitAmount() * (percentage/100);
//		double maxBidAmount = chit.getChitAmount() - maxDiscount;
		double maxBidAmount = chit.getChitAmount() - (chit.getChitAmount() * (percentage/100));
		//get percentage of the regex calculation.
		return maxBidAmount;
	}
	
}
