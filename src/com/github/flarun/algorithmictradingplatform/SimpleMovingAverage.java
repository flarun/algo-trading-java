package com.github.flarun.algorithmictradingplatform;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleMovingAverage {
    private int period;
    private Queue<Double> window;
    private double sum;

    public SimpleMovingAverage(int period) {
        this.period = period;
        this.window = new LinkedList<>();
        this.sum = 0;
    }

    public double calculate(double price) {
        sum += price;
        window.add(price);

        if (window.size() > period) {
            sum -= window.poll();
        }

        return sum / window.size();
    }
}
