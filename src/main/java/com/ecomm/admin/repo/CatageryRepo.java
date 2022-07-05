package com.ecomm.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.admin.pojo.Catagery;


@Repository
public interface CatageryRepo extends JpaRepository<Catagery, Integer>{

}
