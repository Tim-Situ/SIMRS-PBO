package timsitu.config;


public class DatabaseConfig {
    
    public static String getDbUrl() {
        return System.getProperty("DB_URL");
    }

    public static String getDbUser() {
        return System.getProperty("DB_USER");
    }

    public static String getDbPassword() {
        return System.getProperty("DB_PASSWORD");
    }
}
