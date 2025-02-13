package leetcode;
// Left rotate array by K places
// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
// Example 1:

// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]

import java.util.Scanner;
import java.util.stream.Stream;
public class Problem189 {
    
    public static int[] leftRotate(int[] nums, int k) {
        if ( nums.length <= 1) return nums;
        int length = nums.length;
        int places = k % length;
        nums = reverse(nums, 0, (length - places - 1));
        nums = reverse(nums, length - places, length - 1 );
        nums = reverse(nums, 0 , length - 1);
        return nums;
    }
    
    public static int[] reverse(int[] nums, int startIndex, int endIndex) {
        while( startIndex < endIndex ) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
        return nums;
    }

    public static void print(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();
        int[] nums = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        print(nums);
        print(leftRotate(nums, k));
        scanner.close();
    }    
}
