package com.example.onlinepracticaltest.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cust_id;

    private String fullName;
    private String address;
    private String phoneNumber;
    private String CCCD;
    private double amount;

    private Date created;

    @OneToMany(mappedBy = "customer")
    private Set<Emi> emis()
    {
        return this.emis();
    }

    public Customer() {
    }

    public Customer(String fullName, String address, String phoneNumber, String CCCD, double amount, Date created) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.CCCD = CCCD;
        this.amount = amount;
        this.created = created;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
