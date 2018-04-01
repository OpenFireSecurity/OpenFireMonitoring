package openFire.security.monitoring.bot.database;

import org.telegram.telegrambots.logging.BotLogger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DatabaseManager {
    private static final String LOGTAG = "DATABASEMANAGER";

    private static volatile DatabaseManager instance;
    private static volatile ConectionDB connetion;

    /**
     * Private constructor (due to Singleton)
     */
    private DatabaseManager() {
        connetion = new ConectionDB();
        recreateTable(CreationStrings.version);
    }

    /**
     * Get Singleton instance
     *
     * @return instance of the class
     */
    public static DatabaseManager getInstance() {
        final DatabaseManager currentInstance;
        if (instance == null) {
            synchronized (DatabaseManager.class) {
                if (instance == null) {
                    instance = new DatabaseManager();
                }
                currentInstance = instance;
            }
        } else {
            currentInstance = instance;
        }
        return currentInstance;
    }

    /**
     * Recreates the DB
     */
    private void recreateTable(int currentVersion) {
        try {
            connetion.initTransaction();
            if (currentVersion == 0) {
                createNewTables();
            }
            connetion.commitTransaction();
        } catch (SQLException e) {
            BotLogger.error(LOGTAG, e);
        }
    }

    private int createNewTables() throws SQLException {
        connetion.executeQuery(CreationStrings.CREATE_USERS_TABLE);
        return CreationStrings.version;
    }

    public boolean setNewUserForStartBot(Integer userId, String name) {
        int updatedRows = 0;
        try {
            final PreparedStatement preparedStatement = connetion.getPreparedStatement("INSERT INTO Users (userId, name) VALUES(?, ?) ON DUPLICATE KEY UPDATE name=?");
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, name);

            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connetion.commitTransaction();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return updatedRows == 0;
    }

    public boolean deleteUser(Integer userId) {
        int updatedRows = 0;
        try {
            final PreparedStatement preparedStatement = connetion.getPreparedStatement("DELETE FROM Users WHERE userId=?;");
            preparedStatement.setInt(1, userId);

            updatedRows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedRows > 0;
    }

    public List<Integer> getAllSubscribers() {
        List<Integer> subscribers = new ArrayList<>();

        try {
            final PreparedStatement preparedStatement = connetion.getPreparedStatement("select * FROM Users");
            final ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                subscribers.add(result.getInt("userId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subscribers;
    }


}
