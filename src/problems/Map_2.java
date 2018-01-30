package problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Map_2 {
    /*
    We'll say that 2 strings "match" if they are non-empty and their first chars are the same.
    Loop over and then return the given array of non-empty strings as follows:
    if a string matches an earlier string in the array, swap the 2 strings in the array.
    A particular first char can only cause 1 swap, so once a char has caused a swap, its later swaps are disabled.
    Using a map, this can be solved making just one pass over the array. More difficult than it looks.

    firstSwap(["ab", "ac"]) , ["ac", "ab"]
    firstSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) , ["ay", "by", "cy", "cx", "bx", "ax", "aaa", "azz"]
    firstSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) , ["ay", "by", "ax", "bx", "ai", "aj", "bx", "by"]
    * */
    public String[] firstSwap(String[] strings) {
        Map<Character, Integer> cMap = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            Character firstChar = strings[i].charAt(0);
            if (!cMap.containsKey(firstChar)) {
                cMap.put(firstChar, i);
            } else {
                int prevIdx = cMap.get(firstChar);
                if (prevIdx != -1) {
                    cMap.replace(firstChar, -1);
                    String temp = strings[i];
                    strings[i] = strings[prevIdx];
                    strings[prevIdx] = temp;
                }
            }
        }
        return strings;
    }

    @Test
    public void test_firstSwap() {
        assertEquals(Arrays.equals(firstSwap(new String[]{"ab", "ac"}), new String[]{"ac", "ab"}), true);
        assertEquals(Arrays.equals(firstSwap(new String[]{"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"}), new String[]{"ay", "by", "cy", "cx", "bx", "ax", "aaa", "azz"}), true);
        assertEquals(Arrays.equals(firstSwap(new String[]{"ax", "bx", "ay", "by", "ai", "aj", "bx", "by"}), new String[]{"ay", "by", "ax", "bx", "ai", "aj", "bx", "by"}), true);
    }

    /*
    Loop over the given array of strings to build a result string like this: 
    when a string appears the 2nd, 4th, 6th, etc. time in the array, append the string to the result. 
    Return the empty string if no string appears a 2nd time.
    
    wordAppend(["a", "b", "a"]) , "a"
    wordAppend(["a", "b", "a", "c", "a", "d", "a"]) , "aa"
    wordAppend(["a", "", "a"]) , "a"
     */
    public String wordAppend(String[] strings) {
        String result = "";
        if (strings.length == 0) return result;
        Map<String, Integer> strStats = new HashMap<>();
        strStats.put(strings[0], 0);
        for (String s : strings){
            if (strStats.containsKey(s)){
                int count =  strStats.get(s);
                strStats.replace(s, ++count);
                if (count % 2 == 0)
                    result += s;
            }
            else{
                strStats.put(s, 1);
            }
        }
        return result;
    }
    
    @Test
    public void test_wordAppend(){
        assertEquals(wordAppend(new String[]{"a", "b", "a"}) , "a");
        assertEquals(wordAppend(new String[]{"a", "b", "a", "c", "a", "d", "a"}) , "aa");
        assertEquals(wordAppend(new String[]{"a", "", "a"}) , "a");
    }
}
