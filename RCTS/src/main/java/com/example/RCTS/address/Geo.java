package com.example.RCTS.address;

import com.example.RCTS.cashbox.CashBox;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Geo {

	@Id
	private int id;
	private double[] coordinates = new double[2];// contains (latitude,longtidue)
	@OneToMany(mappedBy = "location")
	//@JsonManagedReference
	@JsonBackReference //eventhough cashBox is null, json can be displayed for cashbox
	private List<CashBox> cashBox;

	public Geo() {
	}

	public Geo(int id, double[] coordinates, List<CashBox> cashBox) {
		this.id = id;
		this.coordinates = coordinates;
		this.cashBox = cashBox;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(double[] coordinates) {
		this.coordinates = coordinates;
	}

	public List<CashBox> getCashBox() {
		return cashBox;
	}

	public void setCashBox(List<CashBox> cashBox) {
		this.cashBox = cashBox;
	}
}
