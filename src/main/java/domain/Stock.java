package domain;

public class Stock {
    private String stockCode;
    private int stockPrice;
      
    public Stock(String stockCode) {
        setStockCode(stockCode);
    }
      
    public Stock(String stockCode, int stockPrice) {
        setStockCode(stockCode);
        setStockPrice(stockPrice);
    }
      
    public String getStockCode() {
        return this.stockCode;
    }

    private void setStockCode(String stockCode) {
        if (stockCode == null || stockCode.isEmpty()) {
            throw new IllegalArgumentException("Stock Code가 비어있음.");
        }
        this.stockCode = stockCode;
    }

    public int getStockPrice() {
        return stockPrice;
    }

    private void setStockPrice(int stockPrice) {
        if(stockPrice <= 0) {
            throw new IllegalArgumentException("Stock Price는 음수로 설정할 수 없음.");
        }
        this.stockPrice = stockPrice;
    }
}
