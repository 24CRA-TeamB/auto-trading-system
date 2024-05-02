package domain;

public class Stock {
    private String stock_code;
    private int stock_price;

    public Stock(String stock_code, int stock_price) {

        checkIllegalArgument(stock_code, stock_price);

        this.stock_code = stock_code;
        this.stock_price = stock_price;
    }

    private void checkIllegalArgument(String stock_code, int stock_price) {
        if(stock_code == null || stock_code.equals(""))
            throw new IllegalArgumentException("Stock Code가 비어있음.");

        if(stock_price < 0)
            throw new IllegalArgumentException("Stock Price는 음수로 설정할 수 없음.");
    }
}
