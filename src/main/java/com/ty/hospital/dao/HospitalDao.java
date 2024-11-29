package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dto.Hospital;

public class HospitalDao {
	
	public Hospital saveHospital(Hospital hospital) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(hospital);
		et.commit();
		return hospital; 
	}
	public Hospital getHospital(int id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		
		Hospital hospital = em.find(Hospital.class, id);
		return hospital;
	}
	public List<Hospital>  getAllHospital(){

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		                  
		Query query = em.createQuery("select h from Hospital h");
		List<Hospital> h  = query.getResultList();
		return h;
		
		
		
	}
	public boolean deleteHospital(int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Hospital hospital = em.find(Hospital.class, id);
		if(hospital!=null) {
			et.begin();
			em.remove(hospital);
			et.commit();
			return true;
		}
		else {
			return false;
		}
		           
		
		
		
	}
	public Hospital updateHospital(Hospital hospital) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		           et.begin();
		           em.merge(hospital);
		           et.commit();
		           return hospital;
	}
	

}
