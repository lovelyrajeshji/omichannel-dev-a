package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dto.Item;
import com.ty.hospital.dto.MedOrder;

public class ItemDao {
	
	public Item saveItem(int id,Item item) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		MedOrder_dao m = new MedOrder_dao();
		MedOrder med = m.getMedOrder(id);
		if(med!=null) {
			
			et.begin();
			item.setMedorder(med);
			em.persist(item);
			et.commit();
			return item;
			
		}
		else {
			
			return null;
		}
		}
	public Item getItem(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		 Item i = em.find(Item.class, id);
		 return i;
		
	}
	public List<Item> getAllItems(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		 String sql = "select i from Item i where i.medorder.id=1?";
		      Query query =  em.createQuery(sql);
		      query.setParameter(1, id);
		    List<Item>  m = query.getResultList();
		     return m;
		    
	}
	public boolean delete(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		  Item i = em.find(Item.class, id);
		  if(i!=null) {
			  et.begin();
			  em.remove(i);
			  et.commit();
			  return true;
		  }else
			  return false;
	}
	}
