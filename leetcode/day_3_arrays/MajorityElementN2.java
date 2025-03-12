package leetcode.day_3_arrays;

// Problem 169: Majority Element N/2
// https://leetcode.com/problems/majority-element/description/
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class MajorityElementN2 {
    
    // time: O(n) space: O(n)
    public static int majorityElementBruteForce(int[] array) {
        Map<Integer, Integer> elementCount = new HashMap<>();
        int frequency = -1;
        int result = -1;
        for(int i = 0; i < array.length; i++) {
            elementCount.put(array[i], elementCount.getOrDefault(array[i], 0)+1);
            if(frequency < elementCount.get(array[i])) {
                frequency = elementCount.get(array[i]);
                result = array[i];
            }
        }
        return result;
    }

    public static int majorityElement(int[] array) {
        int element = -1;
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if(count == 0) {
                count = 1;
                element = array[i];
            }else if(element == array[i]) count++;
            else count--;
        }
        return element;
    }

    // Problem 229. Majority Elements 2
    // https://leetcode.com/problems/majority-element-ii/description/
    public List<Integer> majorityElementAppearN3(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> elementCount = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            elementCount.put(nums[i], elementCount.getOrDefault(nums[i], 0)+1);
            if(elementCount.get(nums[i]) > nums.length/3 && !result.contains(nums[i])) {
                result.add(nums[i]);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array = {2,2,1,1,2,2,2,1,1,1,1,2,2,2,2,2,2};
        System.out.println(majorityElement(array));
    }
}
