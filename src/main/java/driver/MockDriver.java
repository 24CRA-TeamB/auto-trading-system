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

    public void login(String id, String password) {
        if(id==null || id.equals(""))
            throw new IllegalArgumentException("ID가 비어있음");

        if(password==null || password.equals(""))
            throw new IllegalArgumentException("Password가 비어있음");

        System.out.println(id);
    }

    @Override
    public void buy(String stockCode, int amount, int price) {
        //do nothing
    }

    @Override
    public void sell(String stockCode, int amount, int price) {
        //do nothing
    }

    @Override
    public int getPrice(@NotNull String stockCode) {
        if (stockPriceMap.containsKey(stockCode) == false) {
            return 0;
        } else {
            return stockPriceMap.get(stockCode).getStockPrice();
        }
    }
}
