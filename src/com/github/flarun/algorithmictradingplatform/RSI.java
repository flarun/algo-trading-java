package com.github.flarun.algorithmictradingplatform;

public class RSI {
    private int period;
    private double gainSum;
    private double lossSum;
    private double previousPrice;

    public RSI(int period) {
        this.period = period;
        this.gainSum = 0;
        this.lossSum = 0;
        this.previousPrice = -1; // Initialized to an invalid price
    }

    public double calculate(double currentPrice) {
        if (previousPrice < 0) {
            previousPrice = currentPrice;
            return 50; // Neutral value for the first calculation
        }

        double change = currentPrice - previousPrice;
        double gain = Math.max(0, change);
        double loss = Math.max(0, -change);

        gainSum = (gainSum * (period - 1) + gain) / period;
        lossSum = (lossSum * (period - 1) + loss) / period;

        double rs = lossSum == 0 ? 100 : gainSum / lossSum;
        double rsi = 100 - (100 / (1 + rs));

        previousPrice = currentPrice;
        return rsi;
    }
}
