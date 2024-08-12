package com.github.flarun.algorithmictradingplatform;

import java.util.HashMap;
import java.util.Map;

public class Broker {
    private Map<String, Long> lastTradeTime;
    private long cooldownPeriod = 5000; // Cooldown period in milliseconds

    public Broker() {
        this.lastTradeTime = new HashMap<>();
    }

    public boolean canTrade(String asset) {
        long currentTime = System.currentTimeMillis();
        Long lastTime = lastTradeTime.get(asset);
        if (lastTime == null || (currentTime - lastTime) >= cooldownPeriod) {
            lastTradeTime.put(asset, currentTime);
            return true;
        }
        return false;
    }

    public void placeOrder(String action, String asset, double price) {
        if (canTrade(asset)) {
            System.out.println("Placing " + action + " order for " + asset + " at price " + price);
        } else {
            System.out.println("Cannot place " + action + " order for " + asset + " yet. Cooldown in effect.");
        }
    }
}
