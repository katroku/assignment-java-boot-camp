package com.example.RCTS.branch;

import com.example.RCTS.address.Address;
import com.example.RCTS.cash.Cash;
import com.example.RCTS.cashbox.CashBox;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Branch {

    @Id
    private int id;
    private String name;
    @OneToOne
    @JoinColumn(name = "address_id", nullable = true)
    private Address address;
    @OneToMany
    @JsonManagedReference
    private List<Cash> totalCashAtBranch;
    @OneToMany
    @JsonIgnore
    private List<CashBox> cashBoxList;

    public Branch() {
    }

    public Branch(int id, String name, Address address, List<Cash> totalCashAtBranch) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.totalCashAtBranch = totalCashAtBranch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Cash> getTotalCashAtBranch() {
        return totalCashAtBranch;
    }

    public void setTotalCashAtBranch(List<Cash> totalCashAtBranch) {
        this.totalCashAtBranch = totalCashAtBranch;
    }
}
