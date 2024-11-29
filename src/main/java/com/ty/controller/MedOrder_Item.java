package com.ty.controller;

import com.ty.hospital.dao.ItemDao;
import com.ty.hospital.dao.MedOrder_dao;
import com.ty.hospital.dto.Item;
import com.ty.hospital.dto.MedOrder;

public class MedOrder_Item {
	
	public static void main(String[] args) {
		ItemDao  i1 = new ItemDao();
		MedOrder_dao m1 = new MedOrder_dao();
		
		
		MedOrder medorder = new MedOrder();
		
		medorder.setMesseage("dolo 650");
		medorder.setOrderDate("22-2-23");
		medorder.setDeliveryDate("23-3-45");
		medorder.setTotal(1);

        m1.saveMedOrder( medorder);
        
        
        
        int a = 1;
        m1.getMedOrder(a);
        System.out.println(medorder.getDeliveryDate());
        System.out.println(medorder.getMesseage());
        
        	Item item = new Item();
        	item.setName("dolo650mg");
        	item.setCost(234);
        	item.setQuantity(30);
        	
        int in = 1;
        i1.saveItem(in, item);
        
        int it = 1;
        i1.getItem(1);
        System.out.println(item.getCost());
        
        
        
        
		
	}

}
