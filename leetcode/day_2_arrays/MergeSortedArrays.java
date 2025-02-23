package leetcode.day_2_arrays;

// Problem 88. Merge sorted Arrays
// https://leetcode.com/problems/merge-sorted-array/description/
import java.util.Scanner;
import java.util.stream.Stream;

public class MergeSortedArrays {
    // time: 3*O(n), space: O(n)
    public static int[] mergeSortedArrayBruteForce(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length+arr2.length];
        int firstPointer = 0;
        int secondPointer = 0;
        int index = 0;
        while(firstPointer < arr1.length && secondPointer < arr2.length) {
            if(arr1[firstPointer] <= arr2[secondPointer]) {
                result[index++] = arr1[firstPointer++];
            }else{
                result[index++] = arr2[secondPointer++];
            }
        }        
        while(firstPointer < arr1.length) {
            result[index++] = arr1[firstPointer++];
        }
        while(secondPointer < arr2.length) {
            result[index++] = arr2[secondPointer++];
        }
        return result;
    }

    // arr1.size = m + n; arr2.size = n;
    public static int[] mergeSortedArrayWithoutExtraSpace(int[] nums1, int[] nums2) {
        
        int fLength = nums1.length-nums2.length - 1;
        int sLength = nums2.length - 1;
        int mergedLength = nums1.length - 1;
        
        while(sLength >= 0){
            if(fLength >= 0 && nums1[fLength] > nums2[sLength]){
                nums1[mergedLength--] = nums1[fLength--];
            }else{
                nums1[mergedLength--] = nums2[sLength--];
            }
        }
        return nums1;
    }
    public static void print(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array1 = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] array2 = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // print(mergeSortedArrayBruteForce(array1, array2));
        print(mergeSortedArrayWithoutExtraSpace(array1, array2));
        scanner.close();
    }
}
