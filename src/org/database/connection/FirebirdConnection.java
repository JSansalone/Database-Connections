package org.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class FirebirdConnection extends GenericConnection {

	@Override
	Connection getConnection(DatabaseConfigurations configs)
			throws SQLException, ClassNotFoundException {

		Class.forName("org.firebirdsql.jdbc.FBDriver");

		if (configs.getUsername() == null) {

			return DriverManager.getConnection("jdbc:firebirdsql://"
					+ configs.getIpAddress() + "/" + configs.getDatabaseName());

		}

		return DriverManager.getConnection(
				"jdbc:firebirdsql://" + configs.getIpAddress() + "/"
						+ configs.getDatabaseName(), configs.getUsername(),
				configs.getPassword());

	}
}
