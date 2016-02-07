package sql;

public class SqlStringUtils {
    public static void test() {
        final AbstractSqlGenerator gen = new AbstractSqlGenerator("TEST", "T");
        System.out.println(gen.varCharSqlString("USER_NM"));
        System.out.println(gen.numberSqlString("USER_ID"));
        System.out.println(gen.dateSqlString("TEST_YMD"));
        System.out.println(gen.timestampSqlString("TEST_TIME"));

        String sql = new SelectSqlGenerator("M_USER", "MU").addNumber("USER_ID")
                .add("USER_NM").generate();
        System.out.println(sql);
    }
}
