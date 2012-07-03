package org.jdevelopment.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class MSSQLConnection extends GenericConnection {

	@Override
	Connection getConnection(DatabaseConfigurations configs)
			throws SQLException, ClassNotFoundException {

		Class.forName("net.sourceforge.jtds.jdbc.Driver");

		if (configs.getUsername() == null) {

			return DriverManager.getConnection("jdbc:jtds:sqlserver://"
					+ configs.getIpAddress() + "/" + configs.getDatabaseName());

		}

		return DriverManager.getConnection(
				"jdbc:jtds:sqlserver://" + configs.getIpAddress() + "/"
						+ configs.getDatabaseName(), configs.getUsername(),
				configs.getPassword());

	}

}
