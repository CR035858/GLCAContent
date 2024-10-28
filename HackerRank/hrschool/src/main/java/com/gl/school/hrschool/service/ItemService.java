package com.gl.school.hrschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gl.school.hrschool.model.Item;
import com.gl.school.hrschool.repository.ItemRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ItemService {
	
	 @Autowired
	    public ItemRepository itemRepository;

	    public boolean saveItem(Item item)
	    {
	        if(itemRepository.findById(item.getItemId()) == null)
	        {
	            itemRepository.save(item);
	            return true;
	        }
	        else
	        {
	            return false;
	        }
	      }

	      public boolean updateItem(int itemId,Item item)
	      {
	        if(itemRepository.findById(itemId) == null)
	        {
	                return false;
	        }
	        else
	        {
	           Item itemU  = itemRepository.findById(itemId).get();
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
	      }
	      public boolean deleteItem(int itemId)
	      {
	        if(itemRepository.findById(itemId) == null)
	        {
	            return false;
	        }
	        else
	        {
	            itemRepository.deleteById(itemId);
	            return true;
	        }
	      }
	      public boolean deleteAllItems()
	      {
	            itemRepository.deleteAll();
	            return true;
	      }

	      public Item getItemById(int itemId)
	      {
	         if (itemRepository.findById(itemId) == null)
	         {
	            return null;
	         }
	         else
	         {
	            return itemRepository.findById(itemId).get();
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
