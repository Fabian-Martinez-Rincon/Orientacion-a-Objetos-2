package Proxy;

import java.util.*;


public class DatabaseRealAccess implements DatabaseAcess {
    private Map<String, List<String>> data;
    private int currentId;

    public DatabaseRealAccess() {
        super();
        this.data = new HashMap<>();
        this.currentId = 3;
        this.data.put("select * from comics where id=1", Arrays.asList("Spiderman", "Marvel"));
        this.data.put("select * from comics where id=2", Arrays.asList("Batman", "DC comics"));
    }

    public Collection<String> getSearchResults(String queryString) {
        return this.data.getOrDefault(queryString, Collections.emptyList());
    }

    public int insertNewRow(List<String> rowData) {
        this.data.put("select * from comics where id=" + this.currentId, rowData);
        this.currentId = this.currentId + 1;

        return this.currentId - 1;
    }
}