package com.gl.inventory.hrinventory1.model;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.gl.inventory.hrinventory1.enums.ItemStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="items")
public class Item {

	  	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	  //	@GeneratedValue(strategy = GenerationType.AUTO) can use this for H2
	    private int itemId;
	  
	    private String itemName;
	    private String itemEnteredByUser;
	    @CreationTimestamp
	    private Timestamp itemEnteredDate;
	    private double itemBuyingPrice;
	    private double itemSellingPrice;
	    private Date itemLastModifiedDate = new Date();
	    private String itemLastModifiedByUser;
	    @Enumerated(EnumType.STRING)
	    private ItemStatus itemStatus = ItemStatus.AVAILABLE;
}
