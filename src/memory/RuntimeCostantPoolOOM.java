package memory;

import java.util.ArrayList;
import java.util.List;

public class RuntimeCostantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        // 为什么下面的代码会一直执行下去？
        while (true) {
            String s = String.valueOf(i++).intern();
            list.add(s);
            System.out.println(s);
        }
    }
}
