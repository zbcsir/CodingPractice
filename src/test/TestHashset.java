package test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * HashSetһ����˵������ģ�����Ҳ����һ������ǿ�������ģ�
 * ��HashSet��ŵ�ֵ�����ͣ��Ҵ�ŵ�ֵ����������HashSet�ĳ�ʼ����ʱ��HashSet�������
 */
public class TestHashset {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(100);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            set.add(random.nextInt(100));
        }
        for (int i : set) {
            System.out.print(i + "\t");
        }
    }
}
