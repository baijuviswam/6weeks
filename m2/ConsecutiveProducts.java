import java.util.Arrays;

/**


Given an array of integers nums of size n, and an int k. Return an array result of size n such that result[i] = nums[max(0, i-k+1)] * ... * nums[i]. 
In other words, each element is the product formed from a sliding window of size k, possibly cut short by the left side of the array.

Example:

Input: nums = [1, 3, 3, 6, 5, 7, 0, -3], k = 3
Output: [1, 3, 9, 54, 90, 210, 0, 0]
Explanation: 1 (1), 3 (1x3), 9 (1x3x3), 54 (3x3x6), 90 (3x6x5), 210 (6x5x7), 0 (5x7x0), 0 (7x0x-3)

**/

public class ConsecutiveProducts {
	
	private int[] consecutiveProducts(int [] nums, int k){
			int n = nums.length-1;
			int j = 0;
			while(n > 1){
				int product = 1;
				j = n>k ? (n-k)+1 : 0;
				while(j <= n){
					product *= nums[j++];
				}
				nums[n--]=product;
			}
			return nums;
		}

	public static void main(String[] args) {
		ConsecutiveProducts cp = new ConsecutiveProducts();
		int nums[] = new int[]{1, 3, 3, 6, 5, 7, 0, -3};
		int k = 3;
		System.out.println(Arrays.toString(cp.consecutiveProducts(nums, k)));
	}
}