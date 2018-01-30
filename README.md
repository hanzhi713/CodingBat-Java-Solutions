# CodingBat-Java-Solutions

My computer science teacher, Dr. Di Wu, requires her students to complete two hardest Java problems for each section on [CodingBat](http://codingbat.com/java). This repo contains the source code of my implementations.

Apart from standard implementations, I also went on to explore some interesting stuffs.

### JUnit Test
```java
    /*
     Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value. 
     Return the number of clumps in the given array.
    countClumps([1, 2, 2, 3, 4, 4]) , 2
    countClumps([1, 1, 2, 1, 1]) , 2
    countClumps([1, 1, 1, 1, 1]) , 1
     */
    public int countClumps(int[] nums) {...}

    @Test
    public void test_countClumps() {
        assertEquals(countClumps(new int[]{1, 2, 2, 3, 4, 4}), 2);
        assertEquals(countClumps(new int[]{1, 1, 2, 1, 1}), 2);
        assertEquals(countClumps(new int[]{1, 1, 1, 1, 1}), 1);
    }
```

### "Human-friendly form vs one-line form"
Human-friendly form
```java
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
        if (target == 0)
            return true;

        if (start >= nums.length)
            return false;
        else {
            if (groupNoAdj(start + 1, nums, target))
                return true;
            target -= nums[start];
            if (target == 0)
                return true;
            else
                return groupNoAdj(start + 2, nums, target);
        }
    }
```
One-line form
```java
    public boolean groupNoAdj(int start, int[] nums, int target) {
        return target == 0 || !(start >= nums.length) && (groupNoAdj(start + 1, nums, target) || (target -= nums[start]) == 0 || groupNoAdj(start + 2, nums, target));
    }
```
I hope this is not very mind-burning.
