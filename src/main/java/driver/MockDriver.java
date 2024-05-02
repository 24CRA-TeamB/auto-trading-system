package driver;

public class MockDriver implements DriverInterface {

    @Override
    public void login(String id, String password) {
        if(id==null || id.equals(""))
            throw new IllegalArgumentException("ID가 비어있음");

        if(password==null || password.equals(""))
            throw new IllegalArgumentException("Password가 비어있음");

        System.out.println(id);
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
