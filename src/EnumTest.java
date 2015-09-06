public enum EnumTest {
    A("A") {
        @Override
        public Base newInstance() {
            return new A();
        }
    },
    B("B") {
        @Override
        public Base newInstance() {
            return new B();
        }
    };

    private final String type;

    EnumTest(String type) {
        this.type = type;
    }

    public static EnumTest getType(String type) throws Exception {
        for (EnumTest t : values()) {
            if (type.equalsIgnoreCase(t.type)) {
                return t;
            }
        }
        throw new Exception("type is wrong:" + type);
    }

    public abstract Base newInstance();
}

interface Base {
    public void print();
}

class A implements Base {

    @Override
    public void print() {
        System.out.println("type is A");
    }

}

class B implements Base {

    @Override
    public void print() {
        System.out.println("type is B");
    }

}
