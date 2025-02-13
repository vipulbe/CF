package searching;

import java.util.Scanner;
import java.util.stream.Stream;
public class LinearSearch {
    
    public static boolean linearSearch(int[] nums, int search) {
        boolean found = false;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == search) {
                found = true;
                break;
            }
        }
        return found;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int search = scanner.nextInt();
        System.out.println(linearSearch(nums, search));
        scanner.close();
    }
}
