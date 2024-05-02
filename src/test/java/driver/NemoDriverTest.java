package driver;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NemoDriverTest {
    public static final String USER_ID = "USER";
    public static final String PASSWORD = "PASSWORD";
    public static final String STOCK_CODE = "AAA";
    public static final int AMOUNT = 10;
    public static final int PRICE = 10000;
    ByteArrayOutputStream outputStream;
    PrintStream originalOut;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @DisplayName("로그인 테스트")
    @Nested
    class Login {
        @Test
        void loginWithUserIdAndPassword(){
            // given
            DriverInterface driver = new NemoDriver();

            // when
            driver.login(USER_ID, PASSWORD);

            // then
            String actual = outputStream.toString();
            assertEquals(actual, USER_ID + "님 로그인 성공");
        }
    }

    @DisplayName("매수/매도 테스트")
    @Nested
    class BuyAndSell {
        @Test
        void buyStockWithCode_Amount_Price(){
            // given
            DriverInterface driver = new KiwerDriver();

            // when
            driver.buy(STOCK_CODE, AMOUNT, PRICE);

            // then
            String expected = STOCK_CODE + "를 " + PRICE + "가격에 매수하였음";
            assertEquals(expected, outputStream.toString().trim());
        }

        @Test
        void sellStockWithCode_Amount_Price(){
            // given
            DriverInterface driver = new KiwerDriver();

            // when
            driver.sell(STOCK_CODE, AMOUNT, PRICE);

            // then
            String expected = STOCK_CODE + "를 " + PRICE + "가격에 매도하였음";
            assertEquals(expected, outputStream.toString().trim());
        }
    }

    @DisplayName("가격 조회 테스트")
    @Nested
    class Price {
        @DisplayName("현재 가격을 조회한다")
        @Test
        void getPriceWithCode(){
            // given
            DriverInterface driver = new KiwerDriver();

            // when
            int price = driver.getPrice(STOCK_CODE);

            // then
            assertThat(price).isBetween(4000, 6000);
        }
    }
}