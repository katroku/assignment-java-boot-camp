package com.example.week1.catalogs;

import com.example.week1.products.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Catalog{
	@Id
	private int catalogId;
	private String filter;
	private String name;
	@OneToMany(mappedBy = "catalog", fetch= FetchType.EAGER)
	@Column(nullable = true)
	@JsonManagedReference
	private List<Product> productList;

	public Catalog() {
	}

	public Catalog(int catalogId, String filter, String name, List<Product> productList) {
		this.catalogId = catalogId;
		this.filter = filter;
		this.name = name;
		this.productList = productList;
	}

	public void setFilter(String filter){
		this.filter = filter;
	}

	public String getFilter(){
		return filter;
	}

	public void setCatalogId(int catalogId){
		this.catalogId = catalogId;
	}

	public int getCatalogId(){
		return catalogId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setProductList(List<Product> productList){
		this.productList = productList;
	}

	public List<Product> getProductList(){
		return productList;
	}
}