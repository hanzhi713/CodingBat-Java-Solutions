package problems;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class String_3 {
    /*
     Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all other characters.
     Return 0 if there are no digits in the string.
     (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'.
     Integer.parseInt(string) converts a string to an int.)
     sumDigits("aa1bc2d3") → 6
     sumDigits("aa11b33") → 8
     sumDigits("Chocolate") → 0
     * */
    public int sumDigits(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                sum += Integer.parseInt(str.substring(i, i + 1));
            }
        }
        return sum;
        // actually can be refactored to (automatically done by intellij...)
        // return IntStream.range(0, str.length()).filter(i -> Character.isDigit(str.charAt(i))).map(i -> Integer.parseInt(str.substring(i, i + 1))).sum();
    }

    @Test
    public void test_sumDigits() {
        assertEquals(sumDigits("aa1bc2d3"), 6);
        assertEquals(sumDigits("aa11b33"), 8);
        assertEquals(sumDigits("Chocolate"), 0);
    }

    /*
    *
    Given a string, return the length of the largest "block" in the string.
    A block is a run of adjacent chars that are the same.
    maxBlock("hoopla") → 2
    maxBlock("abbCCCddBBBxx") → 3
    maxBlock("") → 0
    * */
    public int maxBlock(String str) {
        if (str.length() == 0) return 0;
        int count = 1;
        int maxCount = 1;
        char blockStart = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == blockStart) {
                if (++count > maxCount) maxCount = count;
            } else {
                blockStart = str.charAt(i);
                count = 1;
            }
        }
        return maxCount;
    }

    @Test
    public void test_maxBlock() {
        assertEquals(maxBlock("hoopla"), 2);
        assertEquals(maxBlock("abbCCCddBBBxx"), 3);
        assertEquals(maxBlock(""), 0);
    }

}
