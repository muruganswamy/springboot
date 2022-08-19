package net.javaguides.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "item")
public class ShoppingItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "vendor")
	private String vendor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public ShoppingItem(String itemName, String categoryName, String vendor) {
		super();
		this.itemName = itemName;
		this.categoryName = categoryName;
		this.vendor = vendor;
	}
	
	public ShoppingItem() {
		
	}
}
