package com.backend.splitwise.services.split;

import com.backend.splitwise.entities.Enum.SplitType;
import org.springframework.stereotype.Component;

@Component
public class SplitFactory {

    public SplitStrategy getSplitObject(SplitType splitType) {

        switch (splitType) {
            case EQUAL:
                return new EqualSplit();
            case EXACT:
                return new ExactSplit();
            case PERCENTAGE:
                return new PercentageSplit();
            default:
                return null;
        }
    }
}
