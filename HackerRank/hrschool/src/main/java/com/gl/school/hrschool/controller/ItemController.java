package com.gl.school.hrschool.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.school.hrschool.model.Item;
import com.gl.school.hrschool.service.ItemService;

@RestController
@RequestMapping("/app")
public class ItemController {
	
	  @Autowired
	    ItemService itemService;

	    //1. insert POST
	    @RequestMapping(value="/item",method = RequestMethod.POST)
	    public ResponseEntity <Item> createItem(@RequestBody Item item) {
	        if (itemService.saveItem(item))
	        {
	            return new ResponseEntity<>(item,HttpStatus.BAD_REQUEST);
	        }
	        else
	        {
	            return new ResponseEntity<>(item, HttpStatus.CREATED);
	        }
	    }
	    //2. update PUT
	    @PutMapping("/item/{itemId}")
	    public ResponseEntity <Item> updateItem(@PathVariable (value = "itemId") int itemId,@RequestBody Item item)
	    {
	            if(itemService.updateItem(itemId, item))
	            {
	                return new ResponseEntity<>(item,HttpStatus.OK);
	            }
	            else
	            {
	                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	            }
	    }

	    //3. delete by itemId DELETE
	    @DeleteMapping("/item/{itemId}")
	    public ResponseEntity <Item> deleteItem(@PathVariable (value = "itemId") int itemId)
	    {
	        if(itemService.deleteItem(itemId))
	        {
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	        {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }
	    //4. delete all DELETE
	    @DeleteMapping("/item")
	    public ResponseEntity <Item> deleteAllItems()
	    {
	        itemService.deleteAllItems();
	        return new ResponseEntity<>(HttpStatus.OK);
	    }

	    //5. get by itemId GET
	    @GetMapping("/item/{itemId}")
	    public ResponseEntity <Item> getItemById(@PathVariable (value = "itemId") int itemId)
	    {
	        if(itemService.getItemById(itemId) != null)
	        {
	            Item _item = itemService.getItemById(itemId);
	            return new ResponseEntity<>(_item, HttpStatus.OK);
	        }
	        else
	        {
	            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
	        }
	    }

	    //6. get all GET
	    @GetMapping("/item/")
	    public ResponseEntity <List <Item>> getAllItems()
	    {
	        List <Item> items = itemService.getAllItems();
	        return new ResponseEntity<>(items,HttpStatus.OK);
	    }

	    //7. filters by fields ?itemStatus={status}&itemEnteredByUser={modifiedBy} GET
	    @GetMapping("/item/?itemStatus={status}&itemEnteredByUser={enteredBy}")
	    public ResponseEntity <List <Item>> getItemsByUserAndStatus(@RequestParam String enteredBy,@RequestParam String status)
	    {
	      List <Item> items = itemService.getItemByEnteredUserAndStatus(enteredBy,status);
	      return new ResponseEntity<>(items,HttpStatus.OK);
	    }
	    //8. select all with sorting and pagination ?pageSize={pageSize}&page={page}&sortBy={sortBy} GET
	    @GetMapping("/item/item?pageSize={pageSize}&page={page}&sortBy={sortByField}")
	    public ResponseEntity <List <Item>> getItemsByPagination(@RequestParam int pageSize,@RequestParam int page,@RequestParam String sortByField)
	    {
	        List <Item> items = itemService.getItemsCustomPaged(page, pageSize, sortByField).get().collect(Collectors.toList());
	        return new ResponseEntity <>(items,HttpStatus.OK);
	    }

}
