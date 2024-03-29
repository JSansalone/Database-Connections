package org.jdevelopment.database.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

	private static MySQLConnection mySQLInstance;
	private static OracleConnection oracleInstance;
	private static MSSQLConnection msSQLInstance;
	private static FirebirdConnection firebirdInstance;
	private static PostgreSQLConnection postgreeSQLInstance;
	private static MSAccessConnection accessInstance;
	private static DBFConnection dbfInstance;

	/**
	 * Returns a connection with the specified database. This method was
	 * deprecated because the parameter <b>configs</b> is not necessary being
	 * that it is a member of {@link DatabaseConfigurations} object. In your
	 * next codes, use the overloaded version of this method:
	 * <b>getConnection(DatabaseConfigurations)</b>
	 * 
	 * @param dbType
	 * @param configs
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Deprecated
	public static Connection getConnection(DatabaseType dbType,
			DatabaseConfigurations configs) throws SQLException,
			ClassNotFoundException {

		switch (dbType) {
		case Oracle:

			if (oracleInstance == null)
				oracleInstance = new OracleConnection();

			return oracleInstance.getConnection(configs);

		case MySQL:

			if (mySQLInstance == null)
				mySQLInstance = new MySQLConnection();

			return mySQLInstance.getConnection(configs);

		case MSSQL:

			if (msSQLInstance == null)
				msSQLInstance = new MSSQLConnection();

			return msSQLInstance.getConnection(configs);

		case Firebird:

			if (firebirdInstance == null)
				firebirdInstance = new FirebirdConnection();

			return firebirdInstance.getConnection(configs);

		case PostgreeSQL:

			if (postgreeSQLInstance == null)
				postgreeSQLInstance = new PostgreSQLConnection();

			return postgreeSQLInstance.getConnection(configs);

		case MSAccess:

			if (accessInstance == null)
				accessInstance = new MSAccessConnection();

			return accessInstance.getConnection(configs);

		case DBF:

			if (dbfInstance == null)
				dbfInstance = new DBFConnection();

			return dbfInstance.getConnection(configs);

		default:

			return null;

		}

	}

	/**
	 * Returns a {@link Connection} with the specified database.
	 * 
	 * @param configs
	 *            - Database configuration parameters
	 * @return - A connection
	 * @throws SQLException
	 *             - If the parameters are incorrect
	 * @throws ClassNotFoundException
	 *             - If the JDBC Driver is not found
	 */
	public static Connection getConnection(DatabaseConfigurations configs)
			throws SQLException, ClassNotFoundException {

		return getConnection(configs.getDbType(), configs);

	}

}
