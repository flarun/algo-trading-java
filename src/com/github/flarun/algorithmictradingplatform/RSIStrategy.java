package com.github.flarun.algorithmictradingplatform;

public class RSIStrategy {
    private RSI rsiIndicator;
    private double overboughtThreshold = 70;
    private double oversoldThreshold = 30;

    public RSIStrategy(int rsiPeriod) {
        this.rsiIndicator = new RSI(rsiPeriod);
    }

    public boolean shouldBuy(double price) {
        double rsiValue = rsiIndicator.calculate(price);
        return rsiValue < oversoldThreshold;
    }

    public boolean shouldSell(double price) {
        double rsiValue = rsiIndicator.calculate(price);
        return rsiValue > overboughtThreshold;
    }
}
