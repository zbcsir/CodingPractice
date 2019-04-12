package container;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFast {
    static List<Integer> a = new ArrayList<>();
    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            a.add(i+1);
        }

        int r = a.remove(10);
        System.out.println(r);
        for (int t : a) {
            if (t == 1) {
                // remove操作会触发ConcurrentModificationException异常
                a.remove(t);
            }
        }

//        test1();
    }

    public static void test1()  {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(Integer.valueOf(i));
        }

        // 遍历1
        Iterator<Integer> iterator = arrayList.iterator();
//        while (iterator.hasNext()) {
//            Integer integer = iterator.next();
//            if (integer.intValue() == 5) {
//                //arrayList.remove(integer);//触发ConcurrentModificationException异常
//                iterator.remove(); //不会触发异常
//            }
//        }

        // 遍历2
        iterator = arrayList.iterator();
        for (Integer value : arrayList) {
            Integer integer = iterator.next();
            if (integer.intValue() == 5) {
//                arrayList.remove(integer); //与遍历1相同
                iterator.remove();
            }
        }

        for (int ele : arrayList) {
            System.out.print(ele + "\t");
        }
        System.out.println();
    }

}
