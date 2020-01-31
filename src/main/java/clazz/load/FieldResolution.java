package clazz.load;

/**
 * 一个同名字段同时出现在某个类的接口和父类当中，或者同时在自己或父类的多个接口中出现，
 * 按照解析规则仍是可以确定唯一的访问字段，但Javac编译器就可能直接拒绝其编译为Class文件。
 */
public class FieldResolution {

    interface Interface0 {
        int A = 0;
    }

    interface Interface1 extends Interface0 {
        int A = 1;
    }

    interface Interface2 {
        int A = 2;
    }

    static class Parent implements Interface1 {
        public static int A = 3;
    }

    static class Sub extends Parent implements Interface2 {
        // 注释下面语句，由于接口与父类同时存在字段A，
        // Oracle公司实现的Javac编译器将提示“ThefieldSub.Aisambiguous”，并且会拒绝编译这段代码。
        public static int A = 4;
    }

    public static void main(String[] args) {
        System.out.println(Sub.A);
    }
}
