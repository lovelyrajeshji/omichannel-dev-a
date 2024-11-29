package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dto.MedOrder;

public class MedOrder_dao {
	
	public MedOrder saveMedOrder(MedOrder medorder) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		 et.begin();
		 em.persist(medorder);
		 et.commit();
		 return medorder;
	}
	public MedOrder getMedOrder(int id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		 MedOrder m = em.find(MedOrder.class,id);
		 return m;
	}
	public MedOrder updateMedOrder(MedOrder medorder) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(medorder);
		et.commit();
		return medorder;
		
		
	}
	public boolean delete(int id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		MedOrder m = em.find(MedOrder.class, id);
		if(m!=null) {
			et.begin();
			em.remove(m);
			et.commit();
			return true;
		}
		else {
			return false;
		}
	}

}
