package sql;

public class AbstractSqlGenerator {

    /** テーブル */
    protected final String table;

    /** テーブルのエイリアス名 */
    protected final String alias;

    protected static String OR = " OR ";
    protected static String AND = " AND ";

    public AbstractSqlGenerator(String table, String alias) {
        this.table = table;
        this.alias = alias;
    }

    protected String varCharSqlString(final String column) {
        return String.format("%s.%s %s", alias, column, column);
    }

    protected String timestampSqlString(final String column) {
        return String.format("TO_CHAR(%s.%s, 'YYYY/MM/DD HH:MI:SS') %s", alias,
                column, column);
    }

    protected String dateSqlString(final String column) {
        return String.format("TO_CHAR(%s.%s, 'YYYY/MM/DD') %s", alias, column,
                column);
    }

    protected String numberSqlString(final String column) {
        return String.format("TO_CHAR(%s.%s) %s", alias, column, column);
    }

}
