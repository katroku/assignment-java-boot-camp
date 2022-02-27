package com.example.week1.products;

import com.example.week1.catalogs.Catalog;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
public class Product{

	@Id
	private int id;
	private String image;
	private String originalPrice;
	private String price;
	private String review;
	private String name;
	private String discount;
	private boolean addToCart;
	private String location;
	private String productUrl;
	private int stock;
	private String ratingScore;

//		@NotFound(
//			action = NotFoundAction.IGNORE)
	@ManyToMany(mappedBy = "productList")
	@JsonBackReference
	private List<Catalog> catalog;

	public Product(){ //for serialization
	}

	public Product(int id, String image, String originalPrice, String price, String review, String name, String discount, boolean addToCart, String location, String productUrl, int stock, String ratingScore, List<Catalog> catalog) {
		this.id = id;
		this.image = image;
		this.originalPrice = originalPrice;
		this.price = price;
		this.review = review;
		this.name = name;
		this.discount = discount;
		this.addToCart = addToCart;
		this.location = location;
		this.productUrl = productUrl;
		this.stock = stock;
		this.ratingScore = ratingScore;
		this.catalog = catalog;
	}

	public List<Catalog> getCatalog() {
		return catalog;
	}

	public void setCatalog(List<Catalog> catalog) {
		this.catalog = catalog;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setOriginalPrice(String originalPrice){
		this.originalPrice = originalPrice;
	}

	public String getOriginalPrice(){
		return originalPrice;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setReview(String review){
		this.review = review;
	}

	public String getReview(){
		return review;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDiscount(String discount){
		this.discount = discount;
	}

	public String getDiscount(){
		return discount;
	}

	public void setAddToCart(boolean addToCart){
		this.addToCart = addToCart;
	}

	public boolean isAddToCart(){
		return addToCart;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setProductUrl(String productUrl){
		this.productUrl = productUrl;
	}

	public String getProductUrl(){
		return productUrl;
	}

	public void setStock(int stock){
		this.stock = stock;
	}

	public int getStock(){
		return stock;
	}

	public void setRatingScore(String ratingScore){
		this.ratingScore = ratingScore;
	}

	public String getRatingScore(){
		return ratingScore;
	}
}
