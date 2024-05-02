package domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    public static final String STOCK_CODE = "AAA";
    public static final int STOCK_PRICE = 10000;
    public static final int STOCK_PRICE_ZERO = 0;
    public static final int STOCK_PRICE_MINUS = -1000;
    public static final String STOCK_CODE_EMPTY = "";

    @Disabled
    @DisplayName("주식 객체가 정상적으로 생성되어야 한다")
    @Test
    void stockCreate() {
        Stock stock = new Stock();
        assertNotNull(stock);
    }

    @Disabled
    @DisplayName("10000원으로 초기화된 주식 종목에서 10000원 가격을 확인할 수 있다")
    @Test
    void getStockPrice() {
        Stock stock = new Stock(STOCK_CODE, STOCK_PRICE);
        int stockPrice = stock.getStockPrice();
        assertEquals(STOCK_PRICE, stockPrice);
    }

    @DisplayName("AAA 코드 값으로 초기화된 주식 종목에서 코드 값을 정상적으로 확인할 수 있다")
    @Test
    void getStockCode() {
        Stock stock = new Stock(STOCK_CODE, STOCK_PRICE);
        String stockCode = stock.getStockCode();
        assertEquals(STOCK_CODE, stockCode);
    }

    @DisplayName("주식 객체는 0으로 초기화 될 수 없다")
    @Test
    void initStockWithZeroPrice() {
        try {
            Stock stock = new Stock(STOCK_CODE, STOCK_PRICE_ZERO);
            fail();
        } catch (IllegalArgumentException e){
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Disabled
    @DisplayName("주식 객체는 음수로 초기화 될 수 없다")
    @Test
    void initStockWithNegativePrice() {
        try {
            Stock stock = new Stock(STOCK_CODE, STOCK_PRICE_MINUS);
            fail();
        } catch (IllegalArgumentException e){
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Disabled
    @DisplayName("주식 객체는 빈 문자열 코드로 초기화 될 수 없다")
    @Test
    void initStockWithEmptyStockCode() {
        try {
            Stock stock = new Stock(STOCK_CODE_EMPTY, STOCK_PRICE);
            fail();
        } catch (IllegalArgumentException e){
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
    }
}