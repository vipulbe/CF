package leetcode;
//  Move zeros to the end
// https://leetcode.com/problems/move-zeroes/description/
// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// Note that you must do this in-place without making a copy of the array.

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]

import java.util.Scanner;
import java.util.stream.Stream;

public class Problem283 {
    
    public static int[] moveZeros(int[] nums) {
        if( nums.length <= 1 ) return nums;
        int zeroIndex = -1;
        // find first non-zero element O(n)
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zeroIndex = i;
                break;
            }
        }
        if( zeroIndex == -1) return nums;
        int nextNonZeroIndex = zeroIndex + 1;
        while(nextNonZeroIndex < nums.length) {
            if(nums[nextNonZeroIndex] != 0) {
                nums[zeroIndex] = nums[nextNonZeroIndex];
                zeroIndex++;
                nums[nextNonZeroIndex] = 0;
            }
            nextNonZeroIndex++;
        }
        
        // for(int i = zeroIndex; i < nums.length; i++) {
        //     nums[i] = 0;
        // }

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
        int[] nums = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        print(moveZeros(nums));
        scanner.close();
    }    
}
