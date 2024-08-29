package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.org.dto.Doctor;

@Repository
public class DoctorDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");

	public void insertAndUpdateDoctor(Doctor doctor) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(doctor);
		et.commit();
	}

	public Doctor fetchDoctor(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		return em.find(Doctor.class, id);
	}

	public List<Doctor> fetchAll() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("SELECT d FROM Doctor d");
		List<Doctor> list = query.getResultList();

		return list;

	}

	public List<Doctor> verifyDoctorByEmailAndPassword(String email, String password) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("SELECT d from Doctor d WHERE d.email=?1 and d.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);

		List<Doctor> list = query.getResultList();

		return list;

	}

	public boolean deleteDoctorById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Doctor doctor = em.find(Doctor.class, id);

		if (doctor != null) {
			et.begin();
			em.remove(doctor);
			et.commit();
			return true;
		}
		return false;

	}
}
