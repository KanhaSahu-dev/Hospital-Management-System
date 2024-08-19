package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.org.dto.Admin;

@Repository
public class AdminDao {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");

	public void insertAndUpdateAdmin(Admin admin) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(admin);
		et.commit();
	}

	public Admin fetchAdmin(int id) {
		EntityManager em = emf.createEntityManager();

		return em.find(Admin.class, id);
	}

	public List<Admin> fetchAll() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("SELECT d FROM Admin d");
		List<Admin> list = query.getResultList();

		return list;

	}

	public List<Admin> verifyAdminByEmailAndPassword(String email, String password) {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT d from Admin d WHERE d.email=?1 and d.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);

		List<Admin> list = query.getResultList();

		return list;

	}

	public boolean deleteAdminById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Admin admin = em.find(Admin.class, id);

		if (admin != null) {
			et.begin();
			em.remove(admin);
			et.commit();
			return true;
		}
		return false;

	}

}
