package org.database.connection;

public enum DatabaseType {

	Derby(1),MySQL(2), MSSQL(3), Firebird(4), Oracle(5), PostgreeSQL(6), MSAccess(7), MSExcel(8), DBF(9);

	private int codigo;

	private DatabaseType(int type) {

		codigo = type;

	}

}
