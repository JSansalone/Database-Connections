package org.jdevelopment.database.connection;

import java.sql.Connection;
import java.sql.SQLException;

abstract class GenericConnection {

	abstract Connection getConnection(DatabaseConfigurations configs) throws SQLException, ClassNotFoundException;

}
