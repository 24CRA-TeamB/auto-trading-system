package driver;

import api.KiwerAPI;

public class KiwerDriver implements DriverInterface{
    KiwerAPI kiwerAPI = new KiwerAPI();

    @Override
    public void login(String id, String password) {

    }

    @Override
    public void buy(String stockCode, int amount, int price) {

    }

    @Override
    public void sell(String stockCode, int amount, int price) {

    }

    @Override
    public int getPrice(String stockCode) {
        stockCodeValidationCheck(stockCode);

        return kiwerAPI.currentPrice(stockCode);
    }

    private void stockCodeValidationCheck(String stockCode) {
        if(isStockCodeEmpty(stockCode))
            throw new IllegalArgumentException("Stock Code 비어있음");
    }

    private static boolean isStockCodeEmpty(String stockCode) {
        return stockCode == null || stockCode.equals("");
    }
}
