package driver;

import api.KiwerAPI;

public class KiwerDriver implements DriverInterface {

    private KiwerAPI kiwerAPI;

    @Override
    public void login(String id, String password) {

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
}
