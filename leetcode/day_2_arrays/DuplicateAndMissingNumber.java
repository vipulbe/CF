package leetcode.day_2_arrays;

import java.util.Scanner;
import java.util.stream.Stream;

public class DuplicateAndMissingNumber {
    public static int[] findDuplicateMissing(int[] nums) {
        int[] temp = new int[nums.length+1];
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if(temp[nums[i]] != 0) {
                result[0] = nums[i];
            }else {
                temp[nums[i]] = 1;
            }
        }
        for(int i = 1; i < temp.length; i++) {
            if(temp[i] == 0){
                result[1] = i;
                break;
            }
        }
        return result;
    } 
    public static int[] findDuplicateMissingOptimized(int[] nums) {
        int[] result = new int[2];
        int length = nums.length;
        long sumOfN = (length * (length + 1))/2;
        long sumOfNSquares = (length * (length +1) * (2*length+1))/6;
        long sumOfElements = 0;
        long sumOfElementSquares = 0;
        for(int i = 0; i < nums.length; i++) {
            sumOfElements += nums[i];
            sumOfElementSquares += (nums[i] * nums[i]);
        }
        long nDiff = sumOfElements - sumOfN; 
        long nSqDiff = sumOfElementSquares - sumOfNSquares;
        nSqDiff = nSqDiff / nDiff;
        result[0] = (int)(nDiff + nSqDiff) / 2;
        result[1] = (int) ((int) result[0] - nDiff);
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();	
        int[] result = findDuplicateMissingOptimized(nums);
        System.out.println("Duplicate : "+result[0]+" Missing: "+result[1]);
        scanner.close();
    }
}
