package leetcode.day_2_arrays;
// Problem 287: Find the duplicate number in an N+1 integers
// https://leetcode.com/problems/find-the-duplicate-number/description/
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DuplicateNumber{
    // time: O(n) space: O(n)
	public static int findDuplicateBruteForce(int[] nums) {
        Map<Integer, Integer> numbers = new HashMap<>();
        int duplicate = -1;
        for(int i = 0; i < nums.length; i++) {
            if(numbers.containsKey(nums[i])) {
                duplicate = nums[i];
                break;
            } else {
                numbers.put(nums[i], 1);
            }
        }
        return duplicate;
    }

    public static int findDuplicate(int[] nums) {
        int slowPointer = nums[0];
        int fastPointer = nums[0];
        do {
            slowPointer = nums[slowPointer];
            fastPointer = nums[nums[fastPointer]];
        }while(slowPointer != fastPointer);
        fastPointer = nums[0];
        while(slowPointer != fastPointer) {
            slowPointer = nums[slowPointer];
            fastPointer = nums[fastPointer];
        }
        return slowPointer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();	
        System.out.println(findDuplicate(nums));
        scanner.close();
    }
}
