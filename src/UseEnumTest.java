
public class UseEnumTest {
    public static void test() {
        try {
            Base b = EnumFactory.newInstance("A");
            b.print();
        } catch (Exception e) {
        }
        
        try {
            Base b = EnumFactory.newInstance("B");
            b.print();
        } catch (Exception e) {
        }
        
        try {
            Base b = EnumFactory.newInstance("C");
            b.print();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}

class EnumFactory {
    public static Base newInstance(String type) throws Exception {
        EnumTest e = EnumTest.getType(type);
        return e.newInstance();
    }
}