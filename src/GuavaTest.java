import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

public class GuavaTest {
    public static void test() {
        
    }

    private static void intUtility() {
        int[] intArray = {1, 7, 2, 4, 6};
        System.out.println("max:" + Ints.max(intArray));
        System.out.println("min:" + Ints.min(intArray));
        System.out.println("join->[" + Ints.join(", ", intArray) + "]");
    }

    /**
     * null‚Ì—v‘f‚ğ–³‹‚µ‚Äjoin
     */
    private static void joiner() {
        String[] arrayString = new String[] { "a", null, "b", null, "c" };
        System.out.println(Joiner.on("-").skipNulls().join(arrayString));

        List<String> list = Lists.newArrayList("d", null, "e", "f", null, null,
                "g", "h", "i", null);
        System.out.println(Joiner.on("+").skipNulls().join(list));
    }

    /**
     * ArrayList‚Å”z—ñ‚Á‚Û‚­‰Šú‰»
     */
    private static void initArrayList() {
        List<String> list = Lists.newArrayList("a", "b", "c");
        list.stream().forEach(value -> System.out.println(value));
    }
}
