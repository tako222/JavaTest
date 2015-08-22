import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class Java8Test {

    public static void test() {
        List<String> list = Arrays.asList("list1", "list2", "list3", "list4",
                "list5");
    
        // Streamインスタンスの生成
        Stream<String> stream1 = list.stream();
    
        Stream<String> stream2 = stream1.map(String::toUpperCase);
    
        stream2.forEach(System.out::println);
    }

    public static void test2() {
        Integer[] array = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
    
        System.out.println("そのまま表示");
        Arrays.stream(array).forEach(System.out::println);
    
        System.out.println("----- filterメソッド -----");
        Stream<Integer> stream1 = Arrays.stream(array);
        // 要素を偶数のみに絞ります
        Stream<Integer> filterStream = stream1.filter(value -> value % 2 == 0);
        filterStream.forEach(value -> System.out.println("filterStream: "
                + value));
        System.out.println("----- limitメソッド -----");
        Stream<Integer> stream2 = Arrays.stream(array);
        // 要素を最初から3要素までに絞ります
        Stream<Integer> limitStream = stream2.limit(3);
        limitStream.forEach(value -> System.out
                .println("limitStream: " + value));
        System.out.println("----- distinctメソッド -----");
        Stream<Integer> stream3 = Arrays.stream(array);
        // 要素の重複をなくします
        Stream<Integer> distinctStream = stream3.distinct();
        distinctStream.forEach(value -> System.out.println("distinctStream: "
                + value));
    }

}
