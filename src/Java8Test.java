import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class Java8Test {

    public static void test() {
        List<String> list = Arrays.asList("list1", "list2", "list3", "list4",
                "list5");
    
        // Stream�C���X�^���X�̐���
        Stream<String> stream1 = list.stream();
    
        Stream<String> stream2 = stream1.map(String::toUpperCase);
    
        stream2.forEach(System.out::println);
    }

    public static void test2() {
        Integer[] array = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
    
        System.out.println("���̂܂ܕ\��");
        Arrays.stream(array).forEach(System.out::println);
    
        System.out.println("----- filter���\�b�h -----");
        Stream<Integer> stream1 = Arrays.stream(array);
        // �v�f�������݂̂ɍi��܂�
        Stream<Integer> filterStream = stream1.filter(value -> value % 2 == 0);
        filterStream.forEach(value -> System.out.println("filterStream: "
                + value));
        System.out.println("----- limit���\�b�h -----");
        Stream<Integer> stream2 = Arrays.stream(array);
        // �v�f���ŏ�����3�v�f�܂łɍi��܂�
        Stream<Integer> limitStream = stream2.limit(3);
        limitStream.forEach(value -> System.out
                .println("limitStream: " + value));
        System.out.println("----- distinct���\�b�h -----");
        Stream<Integer> stream3 = Arrays.stream(array);
        // �v�f�̏d�����Ȃ����܂�
        Stream<Integer> distinctStream = stream3.distinct();
        distinctStream.forEach(value -> System.out.println("distinctStream: "
                + value));
    }

}
