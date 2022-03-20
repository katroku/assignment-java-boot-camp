package com.example.RCTS.cashbox;

import com.example.RCTS.address.Geo;
import com.example.RCTS.branch.Branch;
import com.example.RCTS.cash.Cash;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.HashMap;
import java.util.List;

@Entity
public class CashBox {

	@Id
	private int id;
//	private List<Cash> cashList;
//	private Branch sender;
//	private Branch recipient;

	@ManyToOne //at any point in time a box should have one location but a location can have many boxes
	@JoinColumn(name = "geo_id", nullable = true)
	private Geo location;
//	private HashMap<String, Object[]> status;
	private int timeCreated;

	public CashBox() { //for serialization
	}

	public CashBox(int id, List<Cash> cashList, Branch sender, Branch recipient, Geo location, HashMap<String, Object[]> status, int timeCreated) {
		this.id = id;
//		this.cashList = cashList;
//		this.sender = sender;
//		this.recipient = recipient;
		this.location = location;
//		this.status = status;
		this.timeCreated = timeCreated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
//
//	public List<Cash> getCashList() {
//		return cashList;
//	}
//
//	public void setCashList(List<Cash> cashList) {
//		this.cashList = cashList;
//	}
//
//	public Branch getSender() {
//		return sender;
//	}
//
//	public void setSender(Branch sender) {
//		this.sender = sender;
//	}
//
//	public Branch getRecipient() {
//		return recipient;
//	}
//
//	public void setRecipient(Branch recipient) {
//		this.recipient = recipient;
//	}

	public Geo getLocation() {
		return location;
	}

	public void setLocation(Geo location) {
		this.location = location;
	}

//	public HashMap<String, Object[]> getStatus() {
//		return status;
//	}
//
//	public void setStatus(HashMap<String, Object[]> status) {
//		this.status = status;
//	}

	public int getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(int timeCreated) {
		this.timeCreated = timeCreated;
	}
}