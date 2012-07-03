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

	public static Connection getConnection(DatabaseType dbType,
			DatabaseConfigurations configs) throws SQLException,
			ClassNotFoundException {

		switch (dbType) {
		case Oracle:

			if (oracleInstance == null) {

				oracleInstance = new OracleConnection();

			}

			return oracleInstance.getConnection(configs);

		case MySQL:

			if (mySQLInstance == null) {

				mySQLInstance = new MySQLConnection();

			}

			return mySQLInstance.getConnection(configs);

		case MSSQL:

			if (msSQLInstance == null) {

				msSQLInstance = new MSSQLConnection();

			}

			return msSQLInstance.getConnection(configs);

		case Firebird:

			if (firebirdInstance == null) {

				firebirdInstance = new FirebirdConnection();

			}

			return firebirdInstance.getConnection(configs);

		case PostgreeSQL:

			if (postgreeSQLInstance == null) {

				postgreeSQLInstance = new PostgreSQLConnection();

			}

			return postgreeSQLInstance.getConnection(configs);

		case MSAccess:

			if (accessInstance == null) {

				accessInstance = new MSAccessConnection();

			}

			return accessInstance.getConnection(configs);

		default:

			return null;

		}

	}

	public static Connection getConnection(DatabaseConfigurations configs)
			throws SQLException, ClassNotFoundException {

		return getConnection(configs.getDbType(), configs);

	}

}
