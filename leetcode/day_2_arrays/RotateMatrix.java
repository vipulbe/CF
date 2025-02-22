package leetcode.day_2_arrays;
// Problem 48: Rotate Matrix
// https://leetcode.com/problems/rotate-image/

public class RotateMatrix {
    // time: O(m * n), Space = O(m * n)
    public static int[][] rotateMatrix90(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                // [i][j] = [j][length-1-i]
                result[j][matrix.length-1-i] = matrix[i][j];
            }
        }
        return result;
    }

    public static int[][] rotateMatrix90WithoutSpace(int[][] matrix) {
        // matrix transposition: convert cols to row
        for(int i = 0; i < matrix.length-1; i++) {
            for(int j = i+1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // reverse rows
        for(int i = 0; i < matrix.length; i++) {
            matrix[i] = reverse(matrix[i]);
        }
        return matrix;
    }

    public static int[] reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
        return nums;
    }
    public static void print(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        print(rotateMatrix90WithoutSpace(matrix));
    }
}
