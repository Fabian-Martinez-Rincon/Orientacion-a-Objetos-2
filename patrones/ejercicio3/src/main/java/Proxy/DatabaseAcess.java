package Proxy;

import java.util.Collection;
import java.util.List;

public interface DatabaseAcess {
    Collection<String> getSearchResults(String queryString);

    int insertNewRow(List<String> rowData);
}