package driver;

import java.util.HashMap;
import api.KiwerAPI;

public class KiwerDriver implements DriverInterface{
    private final HashMap<String, String> userLoginInfo = new HashMap<>();
    private KiwerAPI kiwerAPI;

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
        getKiwerAPI().buy(stockCode, amount, price);
    }

    @Override
    public void sell(String stockCode, int amount, int price) {
        getKiwerAPI().sell(stockCode, amount, price);
    }

    private KiwerAPI getKiwerAPI() {
        if (kiwerAPI == null) {
            kiwerAPI = new KiwerAPI();
        }

        return kiwerAPI;
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
