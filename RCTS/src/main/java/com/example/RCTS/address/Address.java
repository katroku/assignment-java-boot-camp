package com.example.RCTS.address;

import com.example.RCTS.branch.Branch;

import javax.persistence.*;

@Entity
public class Address {
	@Id
	private int id;
	@ManyToOne
	@JoinColumn(name = "geo_id", nullable = true)
	private Geo geo;
	private String zipcode;
	private String buildingNumber;
	private String floor;
	private String street;
	private String district;
	private String province;
	@OneToOne
	@JoinColumn(name = "branch_id", nullable = true)
	private Branch branch;

	public Address(){

	}
	public Address(int id, String zipcode, Geo geo) {
		this.id = id;
		this.zipcode = zipcode;
		this.geo = geo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
}
