package sql;

import java.util.ArrayList;
import java.util.List;

/**
 * SELECT文を生成
 *
 * @author tako
 *
 */
public class SelectSqlGenerator extends AbstractSqlGenerator {

    private final List<String> column = new ArrayList<>();

    private String whereSql;

    public SelectSqlGenerator(String table, String alias) {
        super(table, alias);
    }

    /**
     * VARCHAR取得項目
     *
     * @param column
     *            項目
     * @return 自インスタンス
     */
    public SelectSqlGenerator add(final String column) {
        this.column.add(varCharSqlString(column));
        return this;
    }

    /**
     * NUMBER取得項目
     *
     * @param column
     *            項目
     * @return 自インスタンス
     */
    public SelectSqlGenerator addNumber(final String column) {
        this.column.add(numberSqlString(column));
        return this;
    }

    /**
     * DATE取得項目
     *
     * @param column
     *            項目
     * @return 自インスタンス
     */
    public SelectSqlGenerator addDate(final String column) {
        this.column.add(dateSqlString(column));
        return this;
    }

    /**
     * TIMESTAMP取得項目
     *
     * @param column
     *            項目
     * @return 自インスタンス
     */
    public SelectSqlGenerator addTimeStamp(final String column) {
        this.column.add(timestampSqlString(column));
        return this;
    }

    public SelectSqlGenerator addWhere(final List<List<String>> whereList) {
        final List<String> andList = new ArrayList<>();
        for (List<String> orList : whereList) {
            if (orList.size() > 1) {
                andList.add(String.format("(%s)", String.join(OR, orList)));
            } else {
                andList.add(orList.get(0));
            }
        }
        this.whereSql = String.join(AND, andList);
        return this;
    }

    public String generate() {
        return String.format("SELECT %s FROM %s %s WHERE %s ",
                String.join(", ", this.column), this.table, this.alias,
                this.whereSql);
    }

}
