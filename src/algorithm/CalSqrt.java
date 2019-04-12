package algorithm;

public class CalSqrt {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(new CalSqrt().calSqrt1(5));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        System.out.println();
        startTime = System.currentTimeMillis();
        System.out.println(Math.sqrt(5));
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    public double calSqrt1(int n) {
        double res = n;
        while (res * res - n > 1e-11) {
            res = res - (res - n/res) / 2;
        }
        return res;
    }

//    public double calSqrt2(int x) {
//        if(x == 0) return 0;
//        float result = x;
//        float xhalf = 0.5f*result;
//        int i = *(int*)&result;
//        i = 0x5f375a86- (i>>1); // what the fuck?
//        result = *(float*)&i;
//        result = result*(1.5f-xhalf*result*result); // Newton step, repeating increases accuracy
//        result = result*(1.5f-xhalf*result*result);
//        return 1.0f/result;
//    }
}
