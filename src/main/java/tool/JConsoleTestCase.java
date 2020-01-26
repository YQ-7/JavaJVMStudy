package tool;

import java.util.ArrayList;
import java.util.List;


/**
 * VM Args: -Xms100m -Xmx100m -XX:+UseSerialGC
 */
public class JConsoleTestCase {

    /**
     * 内存占位符对象，一个OOMObject大约占64K
     */
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        // 以64KB/50ms速度向java堆中填充数据
        for (int i = 0; i < num; i++) {
            // 稍作延时，令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        // fillHeap里执行gc,无法回收list对象
//        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
        // fillHeap外执行gc,可以回收fillHeap方法里的list对象
        System.gc();
        Thread.sleep(5000);
        System.out.println("debug");
    }

}
