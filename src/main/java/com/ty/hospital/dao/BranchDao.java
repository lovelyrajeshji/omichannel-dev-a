package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Hospital;

public class BranchDao {
	
	public Branch saveBranch(int id,Branch branch) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		HospitalDao h = new HospitalDao();
		Hospital hospital = h.getHospital(id);
		if(hospital!=null) {
			et.begin();
			branch.setHospital(hospital);
			em.persist(branch);
			et.commit();
			return branch;
		}
		else {
			return null;
		}
	} 
	public List<Branch> getBranchByHospitalById(int hospitalId){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
	    String sql =	"select b from Branch b where b.hospital.id=1?";
	    Query query = em.createQuery(sql);
	    query.setParameter(1, hospitalId);
	       List<Branch> b =query.getResultList();
	       return b;
		
	}
	public boolean deleteBranchById(int branchId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		     
		Branch branch  =  em.find(Branch.class, branchId);
		if(branch!=null) {
			et.begin();
			em.remove(branch);
			et.commit();
			return true;
		}
		else {
			return false;
		}
	}

}
