package com.truechit.spring.dao.impl;

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

import com.truechit.spring.dao.ChitAmountDAO;
import com.truechit.spring.model.BidHistory;
import com.truechit.spring.model.Chit;
import com.truechit.spring.model.ChitAmount;

@Repository
@Transactional
public class ChitAmountsDAOImpl implements ChitAmountDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Long addChitAmount(ChitAmount amount) {
		sessionFactory.getCurrentSession().save(amount);
		return amount.getChitId();
	}

	@Override
	public void updateChitAmount(ChitAmount amount) {

		Session session = sessionFactory.getCurrentSession();
		ChitAmount amount2 = session.byId(ChitAmount.class).load(amount.getId());
		amount2.setAmount(amount.getAmount());
		amount2.setChitCycle(amount.getChitCycle());
		amount2.setChitId(amount.getChitId());
		sessionFactory.getCurrentSession().save(amount2);
	    session.flush();
	}

	@Override
	public List<ChitAmount> getChitAmountsByChitId(String chitId) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<ChitAmount> cq = cb.createQuery(ChitAmount.class);
		Root<ChitAmount> root = cq.from(ChitAmount.class);
		cq.select(root).where(cb.equal(root.get("chitId"), chitId));
		Query<ChitAmount> query = session.createQuery(cq);
		List<ChitAmount> resAmounts = query.getResultList();

		return resAmounts;
	}

	@Override
	public List<ChitAmount> getChitAmountsByUserId(String userId) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<ChitAmount> cq = cb.createQuery(ChitAmount.class);
		Root<ChitAmount> root = cq.from(ChitAmount.class);
		cq.select(root).where(cb.equal(root.get("userId"), userId));
		Query<ChitAmount> query = session.createQuery(cq);
		List<ChitAmount> resAmounts = query.getResultList();

		return resAmounts;
	}

	@Override
	public List<ChitAmount> getChitAmount(String userId, String chitId) {
		Session session = sessionFactory.getCurrentSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<ChitAmount> cq = cb.createQuery(ChitAmount.class);
		
		Root<ChitAmount> root = cq.from(ChitAmount.class);
		
		Predicate[] predicates = new Predicate[3];
		predicates[0] = cb.equal(root.get("userId"), userId);
		predicates[1] = cb.equal(root.get("chitId"), chitId);
		cq.select(root).where(predicates);
		
		Query<ChitAmount> query = session.createQuery(cq);
		List<ChitAmount> resAmounts = query.getResultList();

		return resAmounts;
	}

	@Override
	public ChitAmount getChitAmount(String userId, String chitId, int cycle) {
		Session session = sessionFactory.getCurrentSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<ChitAmount> cq = cb.createQuery(ChitAmount.class);
		
		Root<ChitAmount> root = cq.from(ChitAmount.class);
		
		Predicate[] predicates = new Predicate[3];
		predicates[0] = cb.equal(root.get("userId"), userId);
		predicates[1] = cb.equal(root.get("chitId"), chitId);
		predicates[2] = cb.equal(root.get("cycle"), cycle);
		cq.select(root).where(predicates);
		
		Query<ChitAmount> query = session.createQuery(cq);
		ChitAmount resAmount = query.getResultList().get(0);

		return resAmount;
	}

}
