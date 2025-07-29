package com.backend.splitwise.entities;

import jakarta.persistence.Entity;

@Entity
public class Balance {

    private double hasToPay;

    private double hasToReceive;
}
