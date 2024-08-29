package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.org.dto.Appointment;
import com.org.dto.Appointment;
@Repository
public class AppointmentDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");

	public void insertAndUpdateAppointment(Appointment appointment) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(appointment);
		et.commit();
	}

	public Appointment fetchAppointment(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		return em.find(Appointment.class, id);
	}

	public List<Appointment> fetchAll() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("SELECT d FROM Appointment d");
		List<Appointment> list = query.getResultList();

		return list;

	}

	public List<Appointment> verifyAppointmentByEmailAndPassword(String email, String password) {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT d from Appointment d WHERE d.email=?1 and d.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);

		List<Appointment> list = query.getResultList();

		return list;

	}

	public boolean deleteAppointmentById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Appointment appointment = em.find(Appointment.class, id);

		if (appointment != null) {
			et.begin();
			em.remove(appointment);
			et.commit();
			return true;
		}
		return false;

	}
}
