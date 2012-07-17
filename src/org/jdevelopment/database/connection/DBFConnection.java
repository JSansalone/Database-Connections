package org.jdevelopment.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBFConnection extends GenericConnection {

	@Override
	Connection getConnection(DatabaseConfigurations configs)
			throws SQLException, ClassNotFoundException {

		Class.forName("com.hxtt.sql.dbf.DBFDriver");

		return DriverManager.getConnection("jdbc:DBF:/"
				+ configs.getDatabaseName());

	}

}
