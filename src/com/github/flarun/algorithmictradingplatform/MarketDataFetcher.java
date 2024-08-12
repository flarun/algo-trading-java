package com.github.flarun.algorithmictradingplatform;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MarketDataFetcher {
    private Random random = new Random();
    private Map<String, Double> assetPrices = new HashMap<>();

    public MarketDataFetcher() {
        // Initialize some assets with default random prices
        assetPrices.put("AAPL", 150.0);  // Stock: Apple
        assetPrices.put("EURUSD", 1.1);  // Forex: Euro to USD
        assetPrices.put("GOLD", 1800.0); // Commodity: Gold
    }

    public double getPrice(String asset) {
        // Check if the asset is already in the map; if not, initialize it
        assetPrices.putIfAbsent(asset, generateInitialPrice(asset));
        
        // Simulate price changes
        double price = assetPrices.get(asset);
        price += (random.nextDouble() - 0.5) * 2;  // Random fluctuation
        assetPrices.put(asset, price);
        return price;
    }

    private double generateInitialPrice(String asset) {
        // Generate an initial price based on the asset type or default value
        if (asset.equals("AAPL")) {
            return 150.0; // Default price for Apple
        } else if (asset.equals("EURUSD")) {
            return 1.1; // Default price for EUR/USD
        } else if (asset.equals("GOLD")) {
            return 1800.0; // Default price for Gold
        } else {
            return 100.0; // Default price for any other asset
        }
    }
}
