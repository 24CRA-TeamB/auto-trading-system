package domain;

public class Stock {
    private String stockCode;
    private int stockPrice;

    public Stock() {

    }

    public Stock(String stockCode, int stockPrice) throws IllegalArgumentException {
        this.stockCode = stockCode;
        this.stockPrice = stockPrice;

        verifyStockPrice();
    }

    private void verifyStockPrice() {
        if (this.stockPrice == 0) {
            throw new IllegalArgumentException("StockPrice should not be zero");
        }
    }

    public String getStockCode() {
        return this.stockCode;
    }

    public int getStockPrice() {
        return this.stockPrice;
    }
}
