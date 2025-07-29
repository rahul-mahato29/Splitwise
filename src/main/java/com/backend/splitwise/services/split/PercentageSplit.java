package com.backend.splitwise.services.split;

import com.backend.splitwise.entities.Split;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PERCENTAGE")
public class PercentageSplit implements SplitStrategy {
    @Override
    public void calculateSplit(List<Split> splitDetails, double amount) {

    }
}
