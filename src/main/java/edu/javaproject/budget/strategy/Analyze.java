package edu.javaproject.budget.strategy;

import java.io.IOException;

public class Analyze {

    private final AnalyzeStrategy strategy;

    public Analyze(AnalyzeStrategy strategy) {
        this.strategy = strategy;

    }

    public void show() throws IOException {
        strategy.sort();
    }
}
