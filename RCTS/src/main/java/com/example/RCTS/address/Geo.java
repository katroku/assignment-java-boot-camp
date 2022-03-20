package com.example.RCTS.address;

import com.example.RCTS.cashbox.CashBox;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Geo {

	@Id
	private int id;
	private float[] coordinates = new float[2];// contains (latitude,longtidue)
	@OneToMany(mappedBy = "location")
	private List<CashBox> cashBox;

	public Geo() {
	}
}
