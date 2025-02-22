package leetcode.day_1_arrays;
// Problem 121: Best time to buy and sell stock 
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

import java.util.Scanner;
import java.util.stream.Stream;

public class StockTrade {
    
    public static int maxProfit(int[] nums) {
        int maxProfit = 0;
        int buy = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] >= buy) {
                maxProfit = Math.max(maxProfit, nums[i] - buy);
            }else {
                buy = nums[i];
            }
        }
        return maxProfit;
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
        System.err.println(maxProfit(nums));
        scanner.close(); 
    }
}
