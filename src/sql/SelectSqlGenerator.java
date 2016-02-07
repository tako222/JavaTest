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

    public SelectSqlGenerator(String table, String alias) {
        super(table, alias);
    }

    public SelectSqlGenerator add(final String column) {
        this.column.add(varCharSqlString(column));
        return this;
    }

    public SelectSqlGenerator addNumber(final String column) {
        this.column.add(numberSqlString(column));
        return this;
    }

    public String generate() {
        return String.format("SELECT %s FROM %s %s",
                String.join(", ", this.column), this.table, this.alias);
    }

}
