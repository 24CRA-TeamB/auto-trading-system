package driver;

public interface DriverInterface {
    void login(String id, String password);

    void buy(String stockCode, int amount, int price);

    void sell(String stockCode, int amount, int price);

    int getPrice(String stockCode);
}
