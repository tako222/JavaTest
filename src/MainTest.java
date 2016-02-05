import enumerate.UseEnumTest;
import util.SqlStringUtils;

public class MainTest {

    public static void main(String[] args) {
        System.out.println(SqlStringUtils.varCharSqlString("TEST", "USER_NM"));
        System.out.println(SqlStringUtils.numberSqlString("TEST", "USER_ID"));
        System.out.println(SqlStringUtils.dateSqlString("TEST", "TEST_YMD"));
        System.out.println(SqlStringUtils.timestampSqlString("TEST", "TEST_TIME"));
    }
}
