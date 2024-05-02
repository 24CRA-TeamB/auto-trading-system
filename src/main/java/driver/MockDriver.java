package driver;

import com.sun.istack.internal.NotNull;
import domain.Stock;

import java.util.HashMap;

public class MockDriver implements DriverInterface {
    public static final String STOCK_CODE_AAA = "AAA";
    public static final int INITIAL_PRICE_AAA = 10000;
    private HashMap<String, Stock> stockPriceMap = new HashMap<>();

    public MockDriver() {
        initStockPriceMap();
    }

    private void initStockPriceMap() {
        stockPriceMap.put(STOCK_CODE_AAA, new Stock(STOCK_CODE_AAA, INITIAL_PRICE_AAA));
    }

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
    public int getPrice(@NotNull String stockCode) {
        if (stockPriceMap.containsKey(stockCode) == false) {
            return 0;
        } else {
            return stockPriceMap.get(stockCode).getPrice();
        }
    }
}
