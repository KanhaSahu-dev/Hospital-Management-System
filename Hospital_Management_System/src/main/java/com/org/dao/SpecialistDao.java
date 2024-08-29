package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.org.dto.Specialist;

@Repository
public class SpecialistDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");

	public void insertAndUpdateSpecialist(Specialist specialist) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(specialist);
		et.commit();
	}

	public List<Specialist> fetchAll() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("SELECT d FROM Specialist d");
		List<Specialist> list = query.getResultList();

		return list;

	}

}
