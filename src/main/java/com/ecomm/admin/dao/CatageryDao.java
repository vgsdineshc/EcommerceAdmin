package com.ecomm.admin.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.admin.pojo.Catagery;
import com.ecomm.admin.repo.CatageryRepo;

@Service
public class CatageryDao {

	@Autowired
	private CatageryRepo catageryRepo;

	public Catagery saveCategory(Catagery catagery) {
	
		return catageryRepo.save(catagery);
	}

	public List<Catagery> getListofCatageries() {

		return catageryRepo.findAll();
	}

	public void deletbyId(int catId) {
		catageryRepo.deleteById(catId);
	}

	public Catagery getCategories(int catId) {
		
		Catagery catagery = catageryRepo.findById(catId).orElse(null);

		return catagery;
	}

	

	public void updateCategory(Catagery catagery) {
		Catagery catagery1 = catageryRepo.findById(catagery.getCid()).orElse(null);
		catagery1.setCname(catagery.getCname());
		catageryRepo.save(catagery1);
	}

}
