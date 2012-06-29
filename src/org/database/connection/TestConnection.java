package org.database.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

	public static boolean testConnection(DatabaseConfigurations configs) throws SQLException, ClassNotFoundException {

		switch (configs.getDbType()) {

		case MySQL:

			try {
				Connection conn = ConnectionFactory.getConnection(configs.getDbType(),
						configs);

				if (conn == null) {
					return false;
				} else {
					conn.close();
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

		case MSSQL:

			try {
				Connection conn = ConnectionFactory.getConnection(configs.getDbType(),
						configs);

				if (conn == null) {
					return false;
				} else {
					conn.close();
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

		default:
			return false;
		}

	}

}
