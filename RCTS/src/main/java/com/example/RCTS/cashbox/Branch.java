package com.example.RCTS.cashbox;

import com.example.RCTS.address.Address;

import java.util.List;

public class Branch {

    private int id;
    private String name;
    private Address address;
    private List<Cash> totalCashAtBranch;

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
