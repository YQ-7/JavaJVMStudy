package other;

/**
 * 自JDK7起，原本存放在永久代的字符串常量池被移至Java堆之中
 * String::intern()是一个本地方法，
 *   它的作用是如果字符串常量池中已经包含一个等于此String对象的字符串，
 *   则返回代表池中这个字符串的String对象的引用；
 *   否则，会将此String对象包含的字符串添加到常量池中，并且返回此String对象的引用。
 */
public class RuntimeConstantPool {
    public static void main(String[] args) {
        // 以下测试JDK6均返回false：常量池中的字符串存放在方法区中，而由StringBuilder创建的字符串对象实例在Java堆上。

        String str1 = new StringBuffer("计算机")
                .append("软件")
                .toString();
        // JDK7返回true：由于"计算机软件"字符串是首次出现，intern()获取的字符串引用与StringBuffer创建的实例是同一个。
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuffer("ja")
                .append("va")
                .toString();
        // JDK7返回true：由于"java"字符串并非首次出现，其他内置包中以出现过。
        System.out.println(str2.intern() == str2);
    }
}
