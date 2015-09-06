package java.util;
import java.util.ArrayList;

/**
 * ArrayList‚É‚Â‚¢‚Ä‚½‚ß‚·
 * @author tako
 *
 */
public class ArrayListTest {
    
    public static void test(){
        ArrayList<String> list = new ArrayList<>();
        list.add("test");
        list.add("test2");
        ArrayList<String> list2 = new ArrayList<>(list);

        System.out.println(list);
        System.out.println(list2);
        
        list.set(0, "test3");

        System.out.println(list);
        System.out.println(list2);
        
        list.clear();
        
        System.out.println(list);
        System.out.println(list2);
    }
}
