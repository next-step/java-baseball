package stadium;

import config.MasterConfig;
import master.Master;

public class BaseballStadium {
    public static void main(String[] args) {
        Master baseballMaster = new MasterConfig().baseballMaster();
        baseballMaster.initAnswer();
        baseballMaster.open();
    }
}
