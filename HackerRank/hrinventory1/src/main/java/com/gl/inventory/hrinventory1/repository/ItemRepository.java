package com.gl.inventory.hrinventory1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.inventory.hrinventory1.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	List <Item> findItemsByItemEnteredByUserAndItemStatus(String userName,String status);
	
}
