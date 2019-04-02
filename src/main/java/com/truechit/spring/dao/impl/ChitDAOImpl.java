package com.truechit.spring.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.truechit.spring.dao.ChitDAO;
import com.truechit.spring.model.Chit;
import com.truechit.spring.model.User;
import com.truechit.spring.model.Chit;

@Repository
public class ChitDAOImpl implements ChitDAO {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public String save(Chit chit) {
      sessionFactory.getCurrentSession().save(chit);
      return chit.getChitId();
   }

   @Override
   public Chit get(String id) {
      return sessionFactory.getCurrentSession().get(Chit.class, id);
   }

   @Override
   public List<Chit> list() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Chit> cq = cb.createQuery(Chit.class);
      Root<Chit> root = cq.from(Chit.class);
      cq.select(root);
      Query<Chit> query = session.createQuery(cq);
      return query.getResultList();
   }

   @Override
   public void update(String id, Chit Chit) {
      Session session = sessionFactory.getCurrentSession();
      Chit Chit2 = session.byId(Chit.class).load(id);
      Chit2.setChitName(Chit.getChitName());
      Chit2.setChitType(Chit.getChitType());
      Chit2.setForemanFee(Chit.getForemanFee());
      Chit2.setMaxBiddingCalculationRegex(Chit.getMaxBiddingCalculationRegex());
      Chit2.setNumberofPhases(Chit.getNumberofPhases());
      Chit2.setNumberofUsers(Chit.getNumberofUsers());

      session.flush();
   }

	@Override
	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		Chit Chit = session.byId(Chit.class).load(id);
		session.delete(Chit);
	}

	@Override
	public double calculateAmountForMonth(String chitId, int cycle) {
		//winningbid-(foremans fee)/number of members;
		// TODO Auto-generated method stub
		
			Chit chit =  sessionFactory.getCurrentSession().get(Chit.class, chitId);
			
			double inputChitAmount = chit.getChitAmount();
			double inputCommision = chit.getForemanFee();
		//	var inputDiscount = $("#inputDiscount").val();
			//int beatreq = cycle;
			
			int months = chit.getNumberofPhases();
			int cmonth = cycle;
			double monthlyAmount = inputChitAmount/months;
			double commision = (inputChitAmount/100)*inputCommision;
		//	discount = parseInt(commision) * (parseInt(inputDiscount)/100);
			
			//winning bid from bid history
			
			int wonbidamount = 75000;
			double bidc = inputChitAmount - commision - wonbidamount;
			double split_each = bidc / months;

			//double percent = (bidc / (months - cmonth) / wonbidamount) * 100;
			//$("#tbl_percent").html(percent.toFixed(2));

			double nextmonth = monthlyAmount - split_each;
			
			return nextmonth;
	}

}
