package Proxy;

import java.util.Collection;
import java.util.List;

public class DatabaseProxy implements DatabaseAcess{
	private DatabaseAcess database;
	private boolean isLog;
	
	public DatabaseProxy (DatabaseAcess database) {
		this.database = database;
		this.isLog = false;
	}

	public void logIn () {
		this.isLog = true;
	}
	
	public void closeSession() {
		this.isLog = false;
	}
	
	public Collection<String> getSearchResults(String queryString) {
		if (!this.isLog) {
			throw new RuntimeException("access denied"); 
		}
		return this.database.getSearchResults(queryString);
	}

	public int insertNewRow(List<String> rowData) {
		if (!this.isLog) {
			throw new RuntimeException("access denied"); 
		}
		return this.database.insertNewRow(rowData);
	}
}