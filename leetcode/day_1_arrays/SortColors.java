package leetcode.day_1_arrays;

// problem 75:Sort colors
// https://leetcode.com/problems/sort-colors/description/

import java.util.Scanner;
import java.util.stream.Stream;

public class SortColors {
    // O(n) + O(n)
    public static int[] sortColorsBruteForce(int[] nums) {
        int red = 0;
        int white = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                red++;
            }else if(nums[i] == 1) {
                white++;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(red > 0) {
                nums[i] = 0;
                red--;
            }else if(white > 0) {
                nums[i] = 1;
                white--;
            }else {
                nums[i] = 2;
            }
        }
        return nums;
    }
    
    // Dutch national flag algorithm O(n)
    public static int[] sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = nums.length - 1;
        while(white <= blue) {
            if(nums[white] == 0) {
                nums = swap(nums, white, red);
                white++;
                red++;
            }else if(nums[white] == 1) {
                white++;
            }else {
                nums = swap(nums, white, blue);
                blue--;
            }
        }
        return nums;
    }
    public static int[] swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
        return nums;
    }
    public static void print(int[] nums){
        for(int i = 0; i < nums.length; i++) {
            System.out.print( nums[i]+ " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        print(sortColorsBruteForce(nums));
        print(sortColors(nums));
        scanner.close();
   } 
}
