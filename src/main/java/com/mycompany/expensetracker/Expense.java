/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expensetracker;

/**
 *
 * @author AMSY
 */
public class Expense {
    private String date;
    private String description;
    private double income;
    private double amount;

    public Expense(String date, String description, double income, double amount) {
        this.date = date;
        this.description = description;
        this.income = income;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getIncome() {
        return income;
    }

    public double getAmount() {
        return amount;
    }
    
    public boolean hasDate(String date) {
        return this.date.equals(date);
    }
    
    public void setData(String date, String description, double income, double amount) {
        this.date = date;
        this.description = description;
        this.income = income;
        this.amount = amount;
    }

    public boolean matches(String searchCriteria) {
        // This method checks if the expense matches the search criteria (date or description).
        return this.date.equals(searchCriteria) || this.description.equals(searchCriteria);
    }

    @Override
    public String toString() {
        return "Expense(date=" + date + ", description=" + description + ", income=" + income +" , recurring cost=" + amount + ")";
    }
}

