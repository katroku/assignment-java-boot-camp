package com.example.RCTS.cashbox;

import com.example.RCTS.address.Geo;
import com.example.RCTS.branch.Branch;
import com.example.RCTS.cash.Cash;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jdk.jshell.Snippet;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

@Entity
public class CashBox {

	@Id
	private int id;
	@OneToMany(mappedBy = "cashBox")
	@JsonManagedReference
	private List<Cash> cashList;
//	private Branch sender;
//	private Branch recipient;

	@ManyToOne //at any point in time a box should have one location but a location can have many boxes
	@JoinColumn(name = "geo_id", nullable = true)
	//@JsonBackReference
	@JsonManagedReference
	private Geo location;


	@OneToMany(mappedBy = "cashBox")
	@JsonManagedReference
	private List<CashBoxStatus> statusList;
	private int timeCreated;

	public CashBox() { //for serialization
	}

	public CashBox(int id, List<Cash> cashList, Branch sender, Branch recipient, Geo location, List<CashBoxStatus> statusList, int timeCreated) {
		this.id = id;
//		this.cashList = cashList;
//		this.sender = sender;
//		this.recipient = recipient;
		this.location = location;
		this.statusList = statusList;
		this.timeCreated = timeCreated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Cash> getCashList() {
		return cashList;
	}

	public void setCashList(List<Cash> cashList) {
		this.cashList = cashList;
	}

	public void updateCashList(Cash cash) {
		this.cashList.add(cash);
	}

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

	public List<CashBoxStatus> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<CashBoxStatus> status) {
		this.statusList = status;
	}

	public void updateStatus(CashBoxStatus status) {
		this.statusList.add(status);
	}

	public int getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(int timeCreated) {
		this.timeCreated = timeCreated;
	}
}