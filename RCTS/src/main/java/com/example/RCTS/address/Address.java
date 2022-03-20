package com.example.RCTS.address;

public class Address {
	private String zipcode;
	private Geo geo;
	private String buildingNumber;
	private String floor;
	private String street;
	private String district;
	private String province;

	public Address(String zipcode, Geo geo, String buildingNumber, String floor, String street, String district, String province) {
		this.zipcode = zipcode;
		this.geo = geo;
		this.buildingNumber = buildingNumber;
		this.floor = floor;
		this.street = street;
		this.district = district;
		this.province = province;
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
