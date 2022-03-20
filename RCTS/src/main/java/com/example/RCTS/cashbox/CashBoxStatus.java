package com.example.RCTS.cashbox;

import com.example.RCTS.address.Geo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.HashMap;

@Entity
public class CashBoxStatus {

    @Id
    private int id;
    private double timestamp;

    @ManyToOne
    @JoinColumn(name = "geo_id", nullable = true)
    @JsonManagedReference
    private Geo location;
    private LocationStatus locationStatus;

    @ManyToOne //one status should not have more than one cashbox
    @JoinColumn(name = "cashbox_id", nullable = true)
    @JsonBackReference
    private CashBox cashBox;

    public CashBoxStatus(int id, double timestamp, Geo location, LocationStatus locationStatus, CashBox cashBox) {
        this.id = id;
        this.timestamp = timestamp;
        this.location = location;
        this.locationStatus = locationStatus;
        this.cashBox = cashBox;
    }

    public CashBoxStatus() {
    }

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }

    public Geo getLocation() {
        return location;
    }

    public void setLocation(Geo location) {
        this.location = location;
    }

    public LocationStatus getLocationStatus() {
        return locationStatus;
    }

    public void setLocationStatus(LocationStatus locationStatus) {
        this.locationStatus = locationStatus;
    }

    public CashBox getCashBox() {
        return cashBox;
    }

    public void setCashBox(CashBox cashBox) {
        this.cashBox = cashBox;
    }
}
