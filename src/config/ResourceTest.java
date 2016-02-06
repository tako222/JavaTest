package config;

public class ResourceTest {
    public static void test() {
        System.out.println(ResourceUtils.RESOURCE.getString("test"));
        System.out.println(ResourceUtils.RESOURCE.getString("test2"));
        System.out.println(ResourceUtils.RESOURCE.getString("test2", "tako222"));
        System.out.println(ResourceUtils.RESOURCE.getString("test2", "param"));
        System.out.println(ResourceUtils.RESOURCE.getString("test3", "t", "a", "k", "o"));
    }
}
