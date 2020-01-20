package gc;

/**
 * VM Args：-Xlog:gc*
 * testGC()方法执行后，通过gc日志看出，objA、objB均被回收，
 * 证明虚拟机并没有因为这两个对象互相引用就放弃回收它们，
 * 这也从侧面说明了Java虚拟机并不是通过引用计数算法来判断对象是否存活的。
 */
public class ReferenceCountGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountGC objA = new ReferenceCountGC();
        ReferenceCountGC objB = new ReferenceCountGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }

    public static void main(String[] args) {
        ReferenceCountGC.testGC();
    }

}
