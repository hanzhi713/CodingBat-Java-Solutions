package problems;

import java.util.Arrays;
import java.util.List;

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
    public void test_no34(){

        assertEquals(no34(Arrays.asList("a", "bb", "ccc")).equals(Arrays.asList("a", "bb")), true);
        assertEquals(Arrays.equals(new String[]{"a", "bb", "ccc", "dddd"}, new String[]{"a", "bb"}), true);
        assertEquals(Arrays.equals(new String[]{"ccc", "dddd", "apple"}, new String[]{"apple"}), true);
    }

}
