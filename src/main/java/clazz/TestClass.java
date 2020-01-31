package clazz;

/**
 * 分析Class字节码
 * 命令:javap -verbose TestClass
 */
public class TestClass {
    private int m;
    public int inc() {
        return m + 1;
    }
}
