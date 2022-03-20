package com.example.RCTS.address;

public class Geo {
	private float lng;
	private float lat;

	public Geo(float lng, float lat) {
		this.lng = lng;
		this.lat = lat;
	}

	public float getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}
}
