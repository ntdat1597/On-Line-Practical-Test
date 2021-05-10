package com.example.onlinepracticaltest.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Emi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emi_id;
    private String employeeName;
    private double loan_amount;
    private double rate_of_interest;
    private double team_of_the_loan;
    private double emi_total;
    private String status;
    private Date timeEnd;
    private Date created;
    private Date updated;

    @ManyToOne
    @JoinColumn(name = "cust_id",referencedColumnName = "cust_id")
    private Customer customer;

    public Emi() {
    }

    public Emi(String employeeName, double loan_amount, double rate_of_interest, double team_of_the_loan, double emi_total, Date created, Date updated, Customer customer) {
        this.employeeName = employeeName;
        this.loan_amount = loan_amount;
        this.rate_of_interest = rate_of_interest;
        this.team_of_the_loan = team_of_the_loan;
        this.emi_total = emi_total;
        this.created = created;
        this.updated = updated;
        this.customer = customer;
    }

    public int getEmi_id() {
        return emi_id;
    }

    public void setEmi_id(int emi_id) {
        this.emi_id = emi_id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(double loan_amount) {
        this.loan_amount = loan_amount;
    }

    public double getRate_of_interest() {
        return rate_of_interest;
    }

    public void setRate_of_interest(double rate_of_interest) {
        this.rate_of_interest = rate_of_interest;
    }

    public double getTeam_of_the_loan() {
        return team_of_the_loan;
    }

    public void setTeam_of_the_loan(double team_of_the_loan) {
        this.team_of_the_loan = team_of_the_loan;
    }

    public double getEmi_total() {
        return emi_total;
    }

    public void setEmi_total(double emi_total) {
        this.emi_total = emi_total;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }}
