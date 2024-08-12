package com.github.flarun.algorithmictradingplatform;

public class MACD {
    private SimpleMovingAverage shortTermEMA;
    private SimpleMovingAverage longTermEMA;
    private SimpleMovingAverage signalLine;
    private double macdValue;

    public MACD(int shortTermPeriod, int longTermPeriod, int signalPeriod) {
        this.shortTermEMA = new SimpleMovingAverage(shortTermPeriod);
        this.longTermEMA = new SimpleMovingAverage(longTermPeriod);
        this.signalLine = new SimpleMovingAverage(signalPeriod);
    }

    public double calculate(double price) {
        double shortTermEMAValue = shortTermEMA.calculate(price);
        double longTermEMAValue = longTermEMA.calculate(price);
        macdValue = shortTermEMAValue - longTermEMAValue;

        double signalValue = signalLine.calculate(macdValue);

        return macdValue - signalValue; // MACD Histogram value
    }

    public double getMACDValue() {
        return macdValue;
    }
}
