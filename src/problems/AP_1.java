package problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AP_1 {

    /*
    (A variation on the sumHeights problem.) We have an array of heights, representing the altitude along a walking trail. 
    Given start/end indexes into the array, return the number of "big" steps for a walk starting at the start index 
    and ending at the end index. We'll say that step is big if it is 5 or more up or down. 
    The start end end index will both be valid indexes into the array with start <= end.
    
    bigHeights([5, 3, 6, 7, 2], 2, 4) , 1
    bigHeights([5, 3, 6, 7, 2], 0, 1) , 0
    bigHeights([5, 3, 6, 7, 2], 0, 4) , 1
    * */
    public int bigHeights(int[] heights, int start, int end) {
        int numOfBigs = 0;
        for (int i = start; i < end; i++) {
            if (Math.abs(heights[i + 1] - heights[i]) >= 5)
                numOfBigs += 1;
        }
        return numOfBigs;
    }

    @Test
    public void test_bigHeights() {
        assertEquals(bigHeights(new int[]{5, 3, 6, 7, 2}, 2, 4) , 1);
        assertEquals(bigHeights(new int[]{5, 3, 6, 7, 2}, 0, 1) , 0);
        assertEquals(bigHeights(new int[]{5, 3, 6, 7, 2}, 0, 4) , 1);
    }

    /*
    Start with two arrays of strings, a and b, each in alphabetical order, possibly with duplicates.
    Return the count of the number of strings which appear in both arrays.
    The best "linear" solution makes a single pass over both arrays,
    taking advantage of the fact that they are in alphabetical order.

    commonTwo(["a", "c", "x"], ["b", "c", "d", "x"]) , 2
    commonTwo(["a", "c", "x"], ["a", "b", "c", "x", "z"]) , 3
    commonTwo(["a", "b", "c"], ["a", "b", "c"]) , 3
    * */
    public int commonTwo(String[] a, String[] b) {
        int aPointer = 0;
        int bPointer = 0;
        int numOfCommons = 0;
        while (aPointer < a.length && bPointer < b.length){
            String aStr = a[aPointer];
            String bStr = b[bPointer];
            String pStr = aPointer > 0 ? a[aPointer - 1] : null;
            if (aStr.compareTo(bStr) < 0)
                aPointer++;
            else if (aStr.compareTo(bStr) > 0)
                bPointer++;
            else{
                if (!aStr.equals(pStr))
                    numOfCommons++;
                aPointer++;
                bPointer++;
            }
        }
        return numOfCommons;
    }

    @Test
    public void test_commonTwo(){
        assertEquals(commonTwo(new String[]{"a", "c", "x"}, new String[]{"b", "c", "d", "x"}) , 2);
        assertEquals(commonTwo(new String[]{"a", "c", "x"}, new String[]{"a", "b", "c", "x", "z"}) , 3);
        assertEquals(commonTwo(new String[]{"a", "b", "c"}, new String[]{"a", "b", "c"}) , 3);
    }

}
