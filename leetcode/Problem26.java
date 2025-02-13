package leetcode;
// Remove Duplicates from Sorted Array

import java.util.Scanner;
import java.util.stream.Stream;
public class Problem26 {
   
    public static int removeDuplicates(int[] nums) {
        
        int uniqueIndex = 1;
        int index = 0;
        while ( uniqueIndex < nums.length) {
            // swap next unique element with next element
            if ( nums[index] != nums[uniqueIndex] ) {
                nums[++index] = nums[uniqueIndex];    
            }
            uniqueIndex++;
        }
        // 0 indexed array....need to return unique element count
        return ++index;
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
        System.out.println(removeDuplicates(nums));
        scanner.close();
    }
}
