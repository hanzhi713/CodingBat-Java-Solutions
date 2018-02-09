package problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Array_3 {

    /*
    Given n>=0, create an array length n*n with the following pattern, shown here for n=3 : 
    {0, 0, 1,    0, 2, 1,    3, 2, 1} (spaces added to show the 3 groups).
    squareUp(3) , [0, 0, 1, 0, 2, 1, 3, 2, 1]
    squareUp(2) , [0, 1, 2, 1]
    squareUp(4) , [0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1]
    * */
    public int[] squareUp(int n) {
        int[] result = new int[n * n];
        for (int i = 0; i < n * n; i += n) {
            for (int j = i; j < i + n; j++) {
                result[j] = n - 1 - (j - i) > i / n ? 0 : n - (j - i);
            }
        }
        return result;
    }

    @Test
    public void test_squareUp() {
        assertArrayEquals(squareUp(3), new int[]{0, 0, 1, 0, 2, 1, 3, 2, 1});
        assertArrayEquals(squareUp(2), new int[]{0, 1, 2, 1});
        assertArrayEquals(squareUp(4), new int[]{0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1});
    }

    /*
     Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value. 
     Return the number of clumps in the given array.
    countClumps([1, 2, 2, 3, 4, 4]) , 2
    countClumps([1, 1, 2, 1, 1]) , 2
    countClumps([1, 1, 1, 1, 1]) , 1
     */
    public int countClumps(int[] nums) {
        if (nums.length == 0) return 0;
        int currentClump = nums[0];
        int currentClumpLength = 1;
        int numClumps = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == currentClump)
                currentClumpLength += 1;
            else {
                currentClump = nums[i];
                if (currentClumpLength > 1) numClumps++;
                currentClumpLength = 1;
            }
        }
        if (currentClumpLength > 1) numClumps++;
        return numClumps;
    }

    @Test
    public void test_countClumps() {
        assertEquals(countClumps(new int[]{1, 2, 2, 3, 4, 4}), 2);
        assertEquals(countClumps(new int[]{1, 1, 2, 1, 1}), 2);
        assertEquals(countClumps(new int[]{1, 1, 1, 1, 1}), 1);
    }
}
