package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Functional_2 {
    /*
    Given a list of strings, return a list of the strings, omitting any string length 3 or 4.

    no34(["a", "bb", "ccc"]) → ["a", "bb"]
    no34(["a", "bb", "ccc", "dddd"]) → ["a", "bb"]
    no34(["ccc", "dddd", "apple"]) → ["apple"]
    * */
    public List<String> no34(List<String> strings) {
        strings.removeIf((n) -> n.length() == 3 || n.length() == 4);
        return strings;
    }

    @Test
    public void test_no34() {
        assertEquals(no34(th("a", "bb", "ccc")).equals(th("a", "bb")), true);
        assertEquals(no34(th("a", "bb", "ccc", "dddd")).equals(th("a", "bb")), true);
        assertEquals(no34(th("ccc", "dddd", "apple")).equals(th("apple")), true);
    }

    /*
    Given a list of integers, return a list of those numbers squared and the product added to 10,
    omitting any of the resulting numbers that end in 5 or 6.
    square56([3, 1, 4]) → [19, 11]
    square56([1]) → [11]
    square56([2]) → [14]
    * */
    public List<Integer> square56(List<Integer> nums) {
        nums.replaceAll(n -> n * n + 10);
        nums.removeIf(n -> n % 10 == 5 || n % 10 == 6);
        return nums;
    }

    @Test
    public void test_square56(){
        assertEquals(square56(th(3, 1, 4)).equals(th(19, 11)), true);
        assertEquals(square56(th(1)).equals(th(11)), true);
        assertEquals(square56(th(2)).equals(th(14)), true);
    }

    // Test Helper
    private <T> List<T> th(T... args) {
        return new ArrayList<>(Arrays.asList(args));
    }

}
