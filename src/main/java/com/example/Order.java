package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Assuming an order has a reference to the customer who placed it
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // Other fields like order date, total amount, etc.
    // For simplicity, let's assume there's a totalAmount field
    private Double totalAmount;

    // Constructors, getters, and setters
    public Order() {}

    public Order(Customer customer, Double totalAmount) {
        this.customer = customer;
        this.totalAmount = totalAmount;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String toString() {
        return "Order[id=" + id + ", customer=" + customer + ", totalAmount=" + totalAmount + "]";
    }
}
