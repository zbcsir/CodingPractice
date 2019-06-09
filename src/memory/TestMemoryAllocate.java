package memory;

/**
 * -verbose:gc -Xms 20M -Xmx 20M -Xmn 10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class TestMemoryAllocate {
    private static final int _1MB = 1024*1024;
    private static void testAllocate1() {
        byte[] a1, a2, a3, a4;
        a1 = new byte[2 * _1MB];
        a2 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        a4 = new byte[4 * _1MB];
    }

    /**
     * -XX:PretenureSizeThreshold=3145728
     */
    private static void testPretenureSizeThreshold() {
        byte[] a = new byte[4 * _1MB];
        byte[] a2 = new byte[4 * _1MB];
        byte[] a3 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
//        testAllocate1();
        testPretenureSizeThreshold();
    }
}
