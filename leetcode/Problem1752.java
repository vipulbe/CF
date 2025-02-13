package leetcode;
// Check if array is sorted and rotated
//  https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/

import java.util.Scanner;
import java.util.stream.Stream;

public class Problem1752 {
    
    public static boolean isSorted(int nums[]) {
        
        int startIndex = - 1;
        for ( int i = 1; i < nums.length; i++ ) {
            if(nums[i - 1] > nums[i]) {
                startIndex = i;
                break; 
            } 
        }
        if ( startIndex < 0 ) return true;
        
        nums = reverse(nums, 0, startIndex - 1);
        nums = reverse(nums, startIndex, nums.length - 1);
        
        nums = reverse(nums, 0, nums.length -1);
        
        for ( int i = 1; i < nums.length; i++ ) {
            if( nums[i-1] > nums[i] ) return false;
        }
        return true;
        
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
        int[] nums = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(isSorted(nums));
        // int[] result = reverse(nums, 0, nums.length - 1);
        // print(result);
        scanner.close();
    }
}
