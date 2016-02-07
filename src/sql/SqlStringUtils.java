package sql;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class SqlStringUtils {
    public static void test() {
        final AbstractSqlGenerator gen = new AbstractSqlGenerator("TEST", "T");
        System.out.println(gen.varCharSqlString("USER_NM"));
        System.out.println(gen.numberSqlString("USER_ID"));
        System.out.println(gen.dateSqlString("TEST_YMD"));
        System.out.println(gen.timestampSqlString("TEST_TIME"));

        final List<List<String>> whereList = new ArrayList<>();
        whereList.add(Lists.newArrayList(" 1 = 1 ", "2 = 2"));
        whereList.add(Lists.newArrayList(" MU.USER_ID = ? "));
        whereList.add(Lists.newArrayList(" MU.USER_NM = ? "));

        String sql = new SelectSqlGenerator("M_USER", "MU")
                .addNumber("USER_ID")
                .add("USER_NM")
                .addWhere(whereList)
                .generate();
        System.out.println(sql);
    }
}
