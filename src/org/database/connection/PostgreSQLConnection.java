package org.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection extends GenericConnection {

	@Override
	Connection getConnection(DatabaseConfigurations configs) throws SQLException, ClassNotFoundException {

			Class.forName("org.postgresql.Driver");

			if (configs.getUsername() == null) {

				return DriverManager.getConnection("jdbc:postgresql" + "://"
						+ configs.getIpAddress() + ":" + configs.getPort()
						+ "/" + configs.getDatabaseName());

			}

			return DriverManager.getConnection("jdbc:postgresql" + "://"
					+ configs.getIpAddress() + ":" + configs.getPort() + "/"
					+ configs.getDatabaseName(), configs.getUsername(),
					configs.getPassword());

	}

}
