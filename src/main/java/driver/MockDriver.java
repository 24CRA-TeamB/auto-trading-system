package driver;

public class MockDriver implements DriverInterface {

    @Override
    public void login(String id, String password) {

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
    public int getPrice(String stockCode) {
        return 0;
    }
}
