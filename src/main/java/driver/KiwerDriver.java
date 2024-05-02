package driver;

import java.util.HashMap;

public class KiwerDriver implements DriverInterface{
    private final HashMap<String, String> userLoginInfo = new HashMap<>();

    public KiwerDriver() {
        initUserLoginInfo();
    }

    @Override
    public void login(String userId, String password) {
        if (userLoginSucess(userId, password)) {
            System.out.print(userId + "님 로그인 성공");
        }
    }

    @Override
    public void buy(String stockCode, int amount, int price) {

    }

    @Override
    public void sell(String stockCode, int amount, int price) {

    }

    @Override
    public int getPrice(String stockCode) {
        return 0;
    }

    private void initUserLoginInfo() {
        userLoginInfo.put("USER", "PASSWORD");
    }

    private boolean userLoginSucess(String userId, String password) {
        return userLoginInfo.containsKey(userId) && userLoginInfo.get(userId).equals(password);
    }
}
