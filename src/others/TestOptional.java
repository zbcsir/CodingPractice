package others;

import java.util.Optional;

/**
 * java8 Optional 练习
 */
public class TestOptional {
    public static void main(String[] args) {
        Integer p1 = null;
        Integer p2 = 10;
        Optional<Integer> op1 = Optional.ofNullable(p1);
        Optional<Integer> op2 = Optional.of(p2);
        System.out.println(TestOptional.testSum(op1, op2));
    }

    private static Integer testSum(Optional<Integer> p1, Optional<Integer> p2) {
        System.out.println("参数1 ：" + p1.isPresent());
        System.out.println("参数2 ：" + p2.isPresent());
        Integer v1 = p1.orElse(0);
        Integer v2 = p2.orElse(0);
        return v1 + v2;
    }
}
