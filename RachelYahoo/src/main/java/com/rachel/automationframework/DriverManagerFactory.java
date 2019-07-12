package com.rachel.automationframework;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager = null;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            /*case IE:
                driverManager = new IEDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = new SafariDriverManager();
                break;*/
        }
        return driverManager;

    }
    
    public enum DriverType {
        CHROME,
        FIREFOX,
        IE,
        SAFARI;
    }
}
