package domain;

public class Stock {
    private final String stockCode;
    private int stockPrice;
      
    public Stock(String stockCode) {
        this.stockCode = stockCode;
    }
      
    public Stock(String stockCode, int stockPrice) {

        checkIllegalArgument(stockCode, stockPrice);

        this.stockCode = stockCode;
        this.stockPrice = stockPrice;
    }

    public int getStockPrice() {
        return stockPrice;
    }
  
    private void checkIllegalArgument(String stockCode, int stockPrice) {
        if(stockCode == null || stockCode.equals(""))
            throw new IllegalArgumentException("Stock Code가 비어있음.");

        if(stockPrice < 0)
            throw new IllegalArgumentException("Stock Price는 음수로 설정할 수 없음.");
    }
}
