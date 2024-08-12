package com.github.flarun.algorithmictradingplatform;

public class TradingPlatform {
    public static void main(String[] args) {
        MarketDataFetcher dataFetcher = new MarketDataFetcher();
        RSIStrategy rsiStrategy = new RSIStrategy(14);  // 14-period RSI
        Broker broker = new Broker();

        String[] assets = {"AAPL", "EURUSD", "GOLD"};

        for (int i = 0; i < 10; i++) {
            for (String asset : assets) {
                double currentPrice = dataFetcher.getPrice(asset);
                System.out.println("Current price for " + asset + ": " + currentPrice);

                if (rsiStrategy.shouldBuy(currentPrice)) {
                    broker.placeOrder("BUY", asset, currentPrice);
                } else if (rsiStrategy.shouldSell(currentPrice)) {
                    broker.placeOrder("SELL", asset, currentPrice);
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
