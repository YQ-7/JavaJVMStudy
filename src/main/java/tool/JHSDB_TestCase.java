package tool;

/**
 *  VM Args：-Xmx10m -XX:+UseSerialGC -XX:-UseCompressedOops
 * 问题：staticObj、instanceObj、localObj这三个变量本身（而不是它们所指向的对象）存放在哪里？
 * 用JHSDB工具进行验证
 */
public class JHSDB_TestCase {

    static class Test{
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done"); // 设置断点调试
        }
    }
    private static class ObjectHolder{
        int count = 1;
    }

    public static void main(String[] args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }
}
