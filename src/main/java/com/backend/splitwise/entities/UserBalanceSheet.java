package com.backend.splitwise.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;

@Entity
@Data
@Table(name = "balance_sheet")
public class UserBalanceSheet {

    private Map<Long, Balance> friendBalance;     //Long - user's id

    private double totalHasToPay;

    private double totalHasToReceive;

    private double totalExpense;    //+ totalHasToReceive - totalHasToPay
}
