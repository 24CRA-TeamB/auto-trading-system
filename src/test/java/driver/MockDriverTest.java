package driver;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MockDriverTest {
    public static final String USER_ID = "USER_ID";
    public static final String EMPTY_STRING = "";
    public static final String PASSWORD = "PASSWORD";
    public static final String STOCK_CODE = "AAA";
    public static final int STOCK_AMOUNT = 10;
    public static final int STOCK_PRICE = 10000;

    @Nested
    class Login {
        @Test
        @DisplayName("USER, PASSWORD 로 로그인을 시도했을 때, 로그인 메소드가 1회 호출된다")
        void loginMockCallCnt(){
            MockDriver driver = new MockDriver();
            driver.login(USER_ID, PASSWORD);

            verify(driver, times(1)).login(USER_ID, PASSWORD);
        }

        @Test
        @DisplayName("USER, PASSWORD 로 로그인을 시도했을 때, USER ID를 출력한다")
        void loginMockPrintContainUserID(){
            MockDriver driver = new MockDriver();

            // set log stream
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outputStream));

            // act
            driver.login(USER_ID, PASSWORD);

            // set log stream to origin
            String actual = outputStream.toString();
            System.setOut(originalOut);

            assertThat(actual).contains(USER_ID);
        }

        @Test
        @DisplayName("ID에 빈 문자열이 전달되었을 때, Exception이 발생한다")
        void loginMockWithoutUserId(){
            MockDriver driver = new MockDriver();

            try {
                driver.login(EMPTY_STRING, PASSWORD);
                fail();
            }catch (IllegalArgumentException e){
                assertThat(e).isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Test
        @DisplayName("PASSWORD에 빈 문자열이 전달되었을 때, Exception이 발생한다")
        void loginMockWithoutPassword(){
            MockDriver driver = new MockDriver();

            try {
                driver.login(USER_ID, EMPTY_STRING);
                fail();
            }catch (IllegalArgumentException e){
                assertThat(e).isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    class BuyAndSell {
        @Test
        @DisplayName("주식 코드(AAA), 수량(10), 가격(10000)을 전달했을 때, buy 메소드가 1회 호출된다")
        void buyMockCallCnt(){
            MockDriver driver = new MockDriver();
            assertDoesNotThrow(() -> driver.buy(STOCK_CODE, STOCK_AMOUNT, STOCK_PRICE));
        }

        @Test
        @DisplayName("주식 코드(AAA), 수량(10), 가격(10000)을 전달했을 때, sell 메소드가 1회 호출된다")
        void sellMockCallCnt(){
            MockDriver driver = new MockDriver();
            assertDoesNotThrow(() -> driver.sell(STOCK_CODE, STOCK_AMOUNT, STOCK_PRICE));
        }
    }

    @Nested
    class Price {
        @Test
        @DisplayName("주식 코드(AAA)를 전달했을 때, 현재 가격 10000을 반환한다")
        void getPriceMock(){
            MockDriver driver = new MockDriver();
            int price = driver.getPrice(STOCK_CODE);
            assertThat(price).isEqualTo(STOCK_PRICE);
        }
    }
}
