package leetcode.day_2_arrays;

import java.util.ArrayList;
import java.util.List;

// Problem 56: Merge Intervals
// https://leetcode.com/problems/merge-intervals/

import java.util.Scanner;
import java.util.stream.Stream;
import java.util.Arrays;

public class MergeIntervals {
    // O(n^2)
    public static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i = 0; i < intervals.length; i++) {
            for(int j = i+1; j < intervals.length; j++) {
                if(intervals[i][1] >= intervals[j][0]){
                    if(intervals[i][1] <= intervals[j][1]){
                        intervals[i][1] = intervals[j][1];
                    }
                    intervals[j][0] = -1;
                    intervals[j][1] = -1;                    
                }
            }
        }
        List<int[]> result = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] != -1){
                result.add(intervals[i]);
            }
        }
        return result.toArray(int[][]::new);
    }
    // O(n)
    public static int[][] mergeIntervalsOptimized(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int index = -1;
        for(int i = 0; i < intervals.length; i++) {
            if(result.size() == 0) {
                result.add(intervals[i]);
                index = 0;
                continue;
            }
            int[] currentInterval = result.get(index);
            if(currentInterval[1] >= intervals[i][0]) {
                if(currentInterval[1] < intervals[i][1]){
                    currentInterval[1] = intervals[i][1];
                    result.remove(index);
                    result.add(index, currentInterval);
                }
            }else{
                result.add(intervals[i]);
            }
        }
        return result.toArray(int[][]::new);
    }
    

    public static void print(int[][] matrix) {
        System.out.println("size : "+matrix.length);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfIntervals = scanner.nextInt();
        scanner.nextLine();
        int[][] intervals = new int[noOfIntervals][2];
        for(int i = 0; i < noOfIntervals; i++) {
            intervals[i] = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        // int[][] intervals = {
        //     {1,3},
        //     {2,6},
        //     {8,10},
        //     {15,18}
        // };
        // print(mergeIntervals(intervals));
        print(mergeIntervalsOptimized(intervals));
        scanner.close();
    }
}
