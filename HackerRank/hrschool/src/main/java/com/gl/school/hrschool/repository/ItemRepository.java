package com.gl.school.hrschool.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.school.hrschool.model.Item;

@Repository
public interface ItemRepository  extends JpaRepository<Item, Integer> {

		List <Item> findItemsByItemEnteredByUserAndItemStatus(String userName,String status);
		//List <Item> findByItemEnteredByUserAndItemStatus();
}
