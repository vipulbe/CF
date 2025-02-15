package leetcode;

import java.util.Scanner;
import java.util.stream.Stream;

// Problem 486: https://leetcode.com/problems/max-consecutive-ones/description/ 
public class MaxConsecutiveOnes486 {
    
    public static int maxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                ++currentCount;
                if(maxCount < currentCount) {
                    maxCount = currentCount;
                }
            }else {
                currentCount = 0;
            }
        }
        return maxCount;
    }

    public static void print(int[] nums) {
        for ( int i = 0; i < nums.length; i++ ) {
            System.out.print(nums[i]+ " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        print(nums);
        System.out.println(maxConsecutiveOnes(nums));
        scanner.close();
    }
}
