package org.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class MSAccessConnection extends GenericConnection {

	@Override
	Connection getConnection(DatabaseConfigurations configs)
			throws SQLException, ClassNotFoundException {

		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		return DriverManager.getConnection("jdbc:odbc:" + configs.getDatabaseName(),"","");

	}

}
