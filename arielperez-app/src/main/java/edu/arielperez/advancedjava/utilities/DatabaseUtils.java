package edu.arielperez.advancedjava.utilities;

import com.ibatis.common.jdbc.ScriptRunner;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.arielperez.advancedjava.service.DatabasePersonService;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * A class that contains database related utility methods.
 */
public class DatabaseUtils {

    // Initialization script file
    public static final String initializationFile = "/home/circleci/java_class/arielperez-app/target/classes/stocks_db_initialization.sql";

    // JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/stocks?autoReconnect=true&useSSL=false&relaxAutoCommit=true";

	// Database credentials
	private static final String USER = "aperez";
	private static final String PASS = "locura";

	private static SessionFactory sessionFactory;
	private static Configuration configuration;


    /*
     * @return SessionFactory for use with database transactions
     */
    public static SessionFactory getSessionFactory() {

        // singleton pattern
        synchronized (DatabasePersonService.class) {
            if (sessionFactory == null) {

                Configuration configuration = getConfiguration();

                ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .buildServiceRegistry();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            }
        }
        return sessionFactory;
    }

    /**
     * Create a new or return an existing database configuration object.
     *
     * @return a Hibernate Configuration instance.
     */
    private static Configuration getConfiguration() {

        synchronized (DatabaseUtils.class) {
            if (configuration == null) {
                configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
            }
        }
        return configuration;
    }

    public static Connection getConnection() throws DatabaseConnectionException {
        Connection connection = null;
        Configuration configuration = getConfiguration();
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String databaseUrl = configuration.getProperty("connection.url");
            String username = configuration.getProperty("hibernate.connection.username");
            String password = configuration.getProperty("hibernate.connection.password");
            connection = DriverManager.getConnection(databaseUrl, username, password);

            // an example of throwing an exception appropriate to the abstraction.
        } catch (ClassNotFoundException | SQLException e) {
            throw new DatabaseConnectionException("Could not connection to database." + e.getMessage(), e);
        }
        return connection;
    }

	/**
	 * A utility method that runs a db initialize script.
	 * @param initializationScript    full path to the script to run to create the schema
	 * @throws DatabaseInitializationException
	 */
	public static void initializeDatabase(String initializationScript) throws DatabaseInitializationException {

		Connection connection = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			ScriptRunner runner = new ScriptRunner(connection, false, false);

            InputStream inputStream = new FileInputStream(initializationScript);

			InputStreamReader reader = new InputStreamReader(inputStream);

			runner.runScript(reader);
			reader.close();
			connection.commit();
			connection.close();

		} catch (DatabaseConnectionException | SQLException | IOException e) {
			throw new DatabaseInitializationException("Could not initialize db because of:"
					+ e.getMessage(),e);
		}


	}
}
