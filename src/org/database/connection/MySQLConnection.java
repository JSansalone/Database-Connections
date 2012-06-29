package org.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class MySQLConnection extends GenericConnection {

	@Override
	Connection getConnection(DatabaseConfigurations configs)
			throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");

		if (configs.getUsername() == null) {

			return DriverManager.getConnection("jdbc:mysql" + "://"
					+ configs.getIpAddress() + ":" + configs.getPort() + "/"
					+ configs.getDatabaseName());

		}

		return DriverManager.getConnection(
				"jdbc:mysql" + "://" + configs.getIpAddress() + ":"
						+ configs.getPort() + "/" + configs.getDatabaseName(),
				configs.getUsername(), configs.getPassword());

	}

}
