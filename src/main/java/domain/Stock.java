package domain;

public class Stock {
    private final String stockCode;
    private int stockPrice;

    public Stock(String stockCode) {
        this.stockCode = stockCode;
    }

    public Stock(String stockCode, int stockPrice) {
        this.stockCode = stockCode;
        this.stockPrice = stockPrice;
    }

    public int getStockPrice() {
        return stockPrice;
    }
}
