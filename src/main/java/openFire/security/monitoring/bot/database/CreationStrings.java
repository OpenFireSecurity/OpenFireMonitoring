package openFire.security.monitoring.bot.database;

public class CreationStrings {
    public static final int version = 0;
    public static final String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS Users (userId INTEGER PRIMARY KEY, name VARCHAR(100) NOT NULL);";
}
