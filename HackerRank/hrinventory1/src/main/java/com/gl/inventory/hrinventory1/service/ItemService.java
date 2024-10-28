package com.gl.inventory.hrinventory1.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gl.inventory.hrinventory1.model.Item;
import com.gl.inventory.hrinventory1.repository.ItemRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ItemService {

	@Autowired
    public ItemRepository itemRepository;

    public boolean saveItem(Item item)
    {
    	System.out.println("In Service Posting");
    
    	Item itemFound ;
    	try
    	{
    		itemFound = getItemById(item.getItemId());
    		if(itemFound == null)
    		{
    			 itemRepository.save(item);
                 System.out.println("Saved Item..."+item);
                 return true;
    		}
  
    	}
    	catch(NoSuchElementException nse)
    	{
    		return false;
    	}
    	return false;
      }

      public boolean updateItem(int itemId,Item item)
      {
    	 
        Item itemU ;
    	try
    	{
    		itemU  = itemRepository.findById(itemId).get();
	           itemU.setItemName(item.getItemName());
	           itemU.setItemEnteredByUser(item.getItemEnteredByUser());
	           itemU.setItemEnteredDate(item.getItemEnteredDate());
	           itemU.setItemBuyingPrice(item.getItemBuyingPrice());
	           itemU.setItemSellingPrice(item.getItemSellingPrice());
	           itemU.setItemLastModifiedDate(item.getItemLastModifiedDate());
	           itemU.setItemLastModifiedByUser(item.getItemLastModifiedByUser());
	           itemU.setItemStatus(item.getItemStatus());
	           itemRepository.save(itemU);
	           return true;
  
    	}
    	catch(NoSuchElementException nse)
    	{
    		 
             System.out.println(" Item. Not found..");
             return false;
    	}
    	
         
      }
      public boolean deleteItem(int itemId)
      {
    
        Item itemFound ;
    	try
    	{
    		itemFound = getItemById(itemId);
    		if(itemFound != null)
    		{
    			itemRepository.deleteById(itemId);
    			return true;
    		}
  
    	}
    	catch(NoSuchElementException nse)
    	{
    		
             System.out.println("Item..Not Found.");
             return false;
    	}
    	 return false;
      }
      public boolean deleteAllItems()
      {
            itemRepository.deleteAll();
            return true;
      }

      public Item getItemById(int itemId)
      {
    	  Item itemFound;
    	
    	/*  return	 itemRepository.findById(itemId).orElseThrow();*/
  /*  */	 try
    	 {
    		 
	//	itemRepository.findById(itemId).orElseThrow(()->Exception("sasas"));
	  	itemFound = itemRepository.findById(itemId).get();
    		 	return itemFound;
    		 
    	 }	
    	 catch(NoSuchElementException nse)
      	{
      		
               System.out.println("Item..Not Found.");
               return null;
      	}
      }
      public List <Item> getAllItems()
      {
        List <Item> items = itemRepository.findAll();
        return items;
      }

      public List <Item> getItemByEnteredUserAndStatus(String enteredByUser,String status)
      {
        List <Item> itemsForUserAndStatus = itemRepository.findItemsByItemEnteredByUserAndItemStatus(enteredByUser,status);
        return itemsForUserAndStatus;
      }

      public Page <Item> getItemsCustomPaged(int pageNumber, int numberOfRecordsOnAPage,String sortByField) {
		  Pageable recordsPerPage =  PageRequest.of(pageNumber, numberOfRecordsOnAPage,Sort.by(sortByField));
		  return itemRepository.findAll(recordsPerPage);       
	}

}
