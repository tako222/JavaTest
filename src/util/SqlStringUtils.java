package util;

public class SqlStringUtils {
    public static String varCharSqlString(final String table, final String column) {
        return String.format("%s.%s %s", table, column, column);
    }

    public static String numberSqlString(final String table, final String column) {
        return String.format("TO_CHAR(%s.%s) %s", table, column, column);
    }

    public static String dateSqlString(final String table, final String column) {
        return String.format("TO_CHAR(%s.%s, 'YYYY/MM/DD') %s", table, column, column);
    }

    public static String timestampSqlString(final String table, final String column) {
        return String.format("TO_CHAR(%s.%s, 'YYYY/MM/DD HH:MI:SS') %s", table, column, column);
    }
}
