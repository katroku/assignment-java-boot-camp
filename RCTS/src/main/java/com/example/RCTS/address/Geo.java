package com.example.RCTS.address;

import com.example.RCTS.cashbox.CashBox;
import com.example.RCTS.cashbox.CashBoxStatus;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id", scope= Geo.class)
public class Geo {

	@Id
	private int id;
	private double[] coordinates = new double[2];// contains (latitude,longtidue)
	@OneToMany(mappedBy = "location")
	@JsonIgnore //eventhough cashBox is null, json can be displayed for cashbox
	private List<CashBox> cashBox;

	@OneToMany(mappedBy = "location")
	@JsonIgnore
	private List<CashBoxStatus> cashBoxStatusList;

	@OneToMany(mappedBy = "geo")
	@JsonIgnore
	private List<Address> addressList;

	public Geo() {
	}

	public Geo(int id, double[] coordinates) {
		this.id = id;
		this.coordinates = coordinates;
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
