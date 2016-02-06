package util;

public class SqlStringUtils {
    public static void test() {
        System.out.println(SqlStringUtils.varCharSqlString("TEST", "USER_NM"));
        System.out.println(SqlStringUtils.numberSqlString("TEST", "USER_ID"));
        System.out.println(SqlStringUtils.dateSqlString("TEST", "TEST_YMD"));
        System.out.println(SqlStringUtils.timestampSqlString("TEST", "TEST_TIME"));
    }

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
