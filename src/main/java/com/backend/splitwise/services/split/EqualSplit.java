package com.backend.splitwise.services.split;

import com.backend.splitwise.entities.Split;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EQUAL")
public class EqualSplit implements SplitStrategy {
    @Override
    public void calculateSplit(List<Split> splitDetails, double amount) {

    }
}
