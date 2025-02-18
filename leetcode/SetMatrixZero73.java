package leetcode;
// Problem 73: https://leetcode.com/problems/set-matrix-zeroes/description/

import java.util.Map;
import java.util.HashMap;

public class SetMatrixZero73 {
    // Time: O(m*n) Space: O(m) + O(n): 
    public static int[][] setMatrixZero(int[][] matrix) {
        Map<Integer, Boolean> xZeros = new HashMap();
        Map<Integer, Boolean> yZeros = new HashMap();
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    xZeros.put(i, true);
                    yZeros.put(j, true);
                }
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(xZeros.containsKey(i) || yZeros.containsKey(j)) {
                    matrix[i][j] = 0; // O(1)
                }
            }
        }
        return matrix;
    }
    public static void print(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] input = {
            {0,1,2,0},
            {3,4,5,2},
            {1,3,1,5}
        };
       
        int[][] matrix = setMatrixZero(input);
        print(matrix);
    }    
}
