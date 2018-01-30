package problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Logic_2 {

    /*
    Given three ints, a b c, return true if one of b or c is "close" (differing from a by at most 1),
    while the other is "far", differing from both other values by 2 or more.
    Note: Math.abs(num) computes the absolute value of a number.
    closeFar(1, 2, 10) , true
    closeFar(1, 2, 3) , false
    closeFar(4, 1, 3) , true
    */
    public boolean closeFar(int a, int b, int c) {
        // one line form
        return Math.abs(b - a) <= 1 ? Math.abs(c - a) >= 2 && Math.abs(c - b) >= 2 : Math.abs(c - a) <= 1 && Math.abs(b - a) >= 2 && Math.abs(b - c) >= 2;

        // human friendly form
//        if (Math.abs(b - a) <= 1) {
//            return Math.abs(c - a) >= 2 && Math.abs(c - b) >= 2;
//        }
//        return Math.abs(c - a) <= 1 && Math.abs(b - a) >= 2 && Math.abs(b - c) >= 2;
    }

    @Test
    public void test_closeFar(){
        assertEquals(closeFar(1, 2, 10) , true);
        assertEquals(closeFar(1, 2, 3) , false);
        assertEquals( closeFar(4, 1, 3) , true);
    }


    /*
    We want make a package of goal kilos of chocolate. We have small bars (1 kilo each) and big bars (5 kilos each).
    Return the number of small bars to use, assuming we always use big bars before small bars.
    Return -1 if it can't be done.
    makeChocolate(4, 1, 9) , 4
    makeChocolate(4, 1, 10) , -1
    makeChocolate(4, 1, 7) , 2
    * */
    public int makeChocolate(int small, int big, int goal) {
        // one line form
        return (small + big * 5 < goal || small < goal % 5) ? -1 : big*5 < goal ? goal - big*5 : goal % 5;

        // human friendly form
//        if (small + big * 5 < goal)
//            return -1;
//        if (small < goal % 5)
//            return -1;
//
//        if (big*5 < goal)
//            return goal - big*5;
//        else
//            return goal % 5;

    }

    @Test
    public void test_makeChocolate() {
        assertEquals(makeChocolate(4, 1, 9), 4);
        assertEquals(makeChocolate(4, 1, 10), -1);
        assertEquals(makeChocolate(4, 1, 7), 2);
    }
}
