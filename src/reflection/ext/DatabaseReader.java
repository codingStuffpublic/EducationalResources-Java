package reflection.ext;

public interface DatabaseReader {

    int countRowsInTable(String tableName) throws InterruptedException;

    String[] readRow(String sqlQuery) throws InterruptedException;
}
