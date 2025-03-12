package leetcode.day_3_arrays;

// Problem 74: Search in 2D Matrix 
// https://leetcode.com/problems/search-a-2d-matrix/description/
public class SearchIn2DMatrix {
    
    // O(log(n))
    public static boolean binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = (left+right)/2;
            if(target == array[mid]){
                return true;
            }else if(target > array[mid]){
                left = mid+1;
            }else {
                right = mid -1;
            }
        }
        return false;
    }
    // O(log(n)+ log(m)) -- better solution
    public static boolean binarySearchMatrix(int[][] matrix, int target) {
        int left = 0; 
        int length = matrix[0].length-1;
        int right = matrix.length-1;
        int row = -1;
        if(matrix[0][0] > target || matrix[right][length] < target) {
            System.out.println("No search");
            return false;
        };
        
        while(left <= right) {
            int mid = (left+right)/2;
            if(target >= matrix[mid][0] && target <= matrix[mid][length]){
                row = mid;
                break;
            }else if(target < matrix[mid][0]) {
                right = mid - 1;
            }else {
                left = mid +1;
            }
        }
        if( row == -1)
            return false;
        return binarySearch(matrix[row], target);    
    }

    // O(log(n*m)) -- Optimized solution
    public static boolean binarySearchFlatMatrix(int[][] matrix, int target) {
        int low = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int high = (rows * cols) - 1;
        while(low <= high) {
            int mid = (low + high)/2;
            int row = mid / cols;
            int col = mid % cols;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return false;
    }

    // O(n+m)
    public static boolean search(int[][] matrix, int target) {
        int iIndex = 0;
        int length = matrix[0].length-1;
        for(int i = 0; i < matrix.length; i++) {
            if( matrix[i][0] <= target && matrix[i][length] >= target) {
                iIndex = i;
                break;
            }
        }
        for(int j = 0; j < matrix[iIndex].length; j++) {
            if(matrix[iIndex][j] == target) {
                return true;
            }
        }
        return false;
    }
    // O(n^2) - brute force
    public static boolean searchBruteForce(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}
        };
        int target = 33;
        // System.out.println(searchBruteForce(matrix, target));
        System.out.println(binarySearchFlatMatrix(matrix, target));
        
    }
}
