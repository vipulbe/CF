package leetcode.day_1_arrays;
// Kadane's Algorithm
// Problem 53: Max subarray
// https://leetcode.com/problems/maximum-subarray/description/
import java.util.Scanner;
import java.util.stream.Stream;

public class MaximumSubarray {
    // O(n^2)
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        System.out.println(" brute force max : "+max);
        return max;
    }
    // O(n)
    public static int kadanesAlgorithm(int[] nums) {
        // if(nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            
            if(sum < 0) sum = 0; 
        
        }
        System.out.println("max : "+max);
        return max;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        maxSubArray(nums);
        kadanesAlgorithm(nums);
        scanner.close();
    }
}
