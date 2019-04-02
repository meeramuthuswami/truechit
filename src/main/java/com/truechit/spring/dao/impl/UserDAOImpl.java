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

import com.truechit.spring.dao.UserDAO;
import com.truechit.spring.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public String save(User User) {
      sessionFactory.getCurrentSession().save(User);
      return User.getId();
   }

   @Override
   public User get(String id) {
      return sessionFactory.getCurrentSession().get(User.class, id);
   }

   @Override
   public List<User> list() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<User> cq = cb.createQuery(User.class);
      Root<User> root = cq.from(User.class);
      cq.select(root);
      Query<User> query = session.createQuery(cq);
      return query.getResultList();
   }

   @Override
   public void update(String id, User user) {
      Session session = sessionFactory.getCurrentSession();
      User user2 = session.byId(User.class).load(id);
      user2.setAge(user.getAge());
      user2.setName(user.getName());
      user2.setSalary(user.getSalary());
      session.flush();
   }
 
   @Override
   public void delete(String id) {
      Session session = sessionFactory.getCurrentSession();
      User User = session.byId(User.class).load(id);
      session.delete(User);
   }

@Override
public boolean addChitToUser(String userId, String chitId) {
	Session session = sessionFactory.getCurrentSession();
	User user = session.byId(User.class).load(userId);
	user.addChitList(chitId);
	session.flush();
	return false;
}

@Override
public boolean submitBid(String chitId, double amount) {
	// TODO Auto-generated method stub
	return false;
}

}
