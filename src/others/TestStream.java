package others;

import com.google.common.base.Joiner;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Java 8 Stream 练习
 */
public class TestStream {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 6, 7, 3};
        List<String> listStr = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<Integer> list = List.of(nums);
        long count = list.stream().filter(num -> num > 1).count();
        System.out.println(count);
        System.out.println(list.stream().filter(num -> num > 1).collect(Collectors.toList()));
        String s = Joiner.on(" ==> ").join(list.stream().filter(num -> num > 1).collect(Collectors.toList()));
        System.out.println(s);
        List<Integer> square = list.stream().map(i -> i*i).limit(3).collect(Collectors.toList());
        List<Integer> squareDistinct = list.stream().map(i -> i*i).distinct().collect(Collectors.toList());
        System.out.println(square);
        System.out.println(squareDistinct);
        IntSummaryStatistics stats = list.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(stats.getAverage());
        System.out.println(stats.getSum());
        System.out.println(listStr.stream().filter(str -> str.length() != 0).collect(Collectors.joining("=>")));
    }
}
