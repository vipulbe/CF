package leetcode;

// Problem 31: Next permutation 
// https://leetcode.com/problems/next-permutation/description/
import java.util.Scanner;
import java.util.stream.Stream;

public class NextPermutation {
    
    public static int[] nextPermutation(int[] nums) {
        // find the first number from the last that's smaller than its next;
        int index = -1;
        for(int i = nums.length-2; i >= 0; i--) {
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1) {
            nums = reverse(nums, 0, nums.length -1);
            return nums; 
        }
        for(int i = nums.length - 1; i >= index; i-- ) {
            if(nums[i] > nums[index]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                nums = reverse(nums, index+1, nums.length-1);
                break;
            }
        }
        return nums;
    }
    public static int[] reverse(int[] nums, int startIndex, int endIndex) {
        while(startIndex < endIndex) {
            int temp = nums[startIndex];
            nums[startIndex++] = nums[endIndex];
            nums[endIndex--] = temp;
            
        }
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
        int[] result = nextPermutation(nums);
        print(result);
        scanner.close();
    }

}
