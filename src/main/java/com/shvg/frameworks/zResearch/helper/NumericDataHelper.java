package com.shvg.frameworks.zResearch.helper;

import java.util.List;

public class NumericDataHelper {
    private List<Integer> numbers;

    public NumericDataHelper(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getTotal() {

        int total = 0;

        for (int i = 0; i < numbers.size(); i++) {
            total += numbers.get(i);
        }

        return total;
    }
}
