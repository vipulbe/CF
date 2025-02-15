package leetcode;

import java.util.Scanner;
import java.util.stream.Stream;
// findMissingNumber

public class FindMissingNumber268 {

    public static int findMissingNumber(int[] nums) {
        int sum = (nums.length *(nums.length + 1))/2;
        for(int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum; 
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
        System.out.println(findMissingNumber(nums));
        scanner.close();
    }
}
