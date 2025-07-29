package com.backend.splitwise.services.split;

import com.backend.splitwise.entities.Split;

import java.util.List;

public interface SplitStrategy {
    void calculateSplit(List<Split> splitDetails, double amount);
}
