package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.org.dto.User;

@Repository
public class UserDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void insertAndUpdateUser(User user) {
		et.begin();
		em.merge(user);
		et.commit();
	}

	public User fetchUser(int id) {
		return em.find(User.class, id);
	}

	public List<User> fetchAll() {
		Query query = em.createQuery("SELECT d FROM User d");
		List<User> list = query.getResultList();

		return list;

	}

	public List<User> verifyUserByEmailAndPassword(String email, String password) {
		Query query = em.createQuery("SELECT d from User d WHERE d.email=?1 and d.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);

		List<User> list = query.getResultList();

		return list;

	}

	public boolean deleteUserById(int id) {
		User user = em.find(User.class, id);

		if (user != null) {
			et.begin();
			em.remove(user);
			et.commit();
			return true;
		}
		return false;

	}

}
