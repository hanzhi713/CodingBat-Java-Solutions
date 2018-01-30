package problems;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Recursion_2 {

    /*
    Given an array of ints, is it possible to choose a group of some of the ints,
    such that the group sums to the given target with this additional constraint:
    If a value in the array is chosen to be in the group,
    the value immediately following it in the array must not be chosen. (No loops needed.)
    groupNoAdj(0, [2, 5, 10, 4], 12) , true
    groupNoAdj(0, [2, 5, 10, 4], 14) , false
    groupNoAdj(0, [2, 5, 10, 4], 7) , false
    * */
    public boolean groupNoAdj(int start, int[] nums, int target) {
        // one line form :/
        return target == 0 || !(start >= nums.length) && (groupNoAdj(start + 1, nums, target) || (target -= nums[start]) == 0 || groupNoAdj(start + 2, nums, target));

        // more human friendly form :|
//        if (target == 0)
//            return true;
//
//        if (start >= nums.length)
//            return false;
//        else {
//            if (groupNoAdj(start + 1, nums, target))
//                return true;
//            target -= nums[start];
//            if (target == 0)
//                return true;
//            else
//                return groupNoAdj(start + 2, nums, target);
//        }

    }

    @Test
    public void test_groupNoAdj() {
        assertEquals(groupNoAdj(0, new int[]{2, 5, 10, 4}, 12), true);
        assertEquals(groupNoAdj(0, new int[]{2, 5, 10, 4}, 14), false);
        assertEquals(groupNoAdj(0, new int[]{2, 5, 10, 4}, 7), false);
    }

    /*
    Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the two groups are the same.
    Every int must be in one group or the other.
    Write a recursive helper method that takes whatever arguments you like,
    and make the initial call to your recursive helper from splitArray(). (No loops needed.)
    splitArray([2, 2]) , true
    splitArray([2, 3]) , false
    splitArray([5, 2, 3]) , true
    * */
    // a NP-complete problem
    public boolean splitArray(int[] nums) {
        return helper(nums, 0, 0, 0);

//        Pair<List<Integer>, List<Integer>> partitions = partition(nums, 0, new ArrayList<>(), new ArrayList<>());
//        if (partitions != null)
//            System.out.println(partitions.toString());
//        return partitions != null;
    }

    // probably this is the correct version of the helper method that the problem intends us to write
    public boolean helper(int[] nums, int curIdx, int sum1, int sum2) {
        // I hope you know my logic...
        // the one line form of this method is more easy to understand than that of groupNoAdj.
        return curIdx < nums.length ? helper(nums, curIdx + 1, sum1 + nums[curIdx], sum2) || helper(nums, curIdx + 1, sum1, sum2 + nums[curIdx]) : sum1 == sum2;
    }

    // a partition method that can get the result of partition as a pair, rather than just a boolean
    // just for fun
    public Pair<List<Integer>, List<Integer>> partition(int[] nums, int curIdx, List<Integer> list1, List<Integer> list2) {
        if (curIdx < nums.length) {
            List<Integer> addedToList1 = new ArrayList<>(list1);
            List<Integer> addedToList2 = new ArrayList<>(list2);
            addedToList1.add(nums[curIdx]);
            addedToList2.add(nums[curIdx]);
            Pair<List<Integer>, List<Integer>> result1 = partition(nums, curIdx + 1, addedToList1, list2);
            Pair<List<Integer>, List<Integer>> result2 = partition(nums, curIdx + 1, list1, addedToList2);
            if (result1 == null)
                return result2;
            else
                return result1;
        } else {
            if (list1.stream().mapToInt(i -> i).sum() == list2.stream().mapToInt(i -> i).sum())
                return new Pair<>(list1, list2);
            else
                return null;
        }
    }

    @Test
    public void test_splitArray() {
        assertEquals(splitArray(new int[]{2, 2}), true);
        assertEquals(splitArray(new int[]{2, 3}), false);
        assertEquals(splitArray(new int[]{5, 2, 3}), true);
    }


}
