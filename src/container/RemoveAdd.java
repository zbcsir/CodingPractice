package container;

import java.util.ArrayList;
import java.util.List;

public class RemoveAdd {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
//        list.add("0");
        list.add("1");
//        list.add("1");
        list.add("2");
        for (String item : list) {
//            System.out.println(item);
            if ("2".equals(item)) {// Ϊʲô"1"�����������ж������ַ����쳣
                list.remove(item);
            }
        }
//        for (String item : list) {
//            System.out.println(item);
//        }
    }
}
