import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;


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
			int j = 1;
			while(n > 1){
				int product = 1;
				if(n>k)
					j=(n-k)+1;
				else 
					j = 0;
				while(j <= n && j >=0){
					product = product * nums[j];
					j++;
				}
				nums[n]=product;
				n--;
			}
			return nums;
		}


	/**

	private int[] product(int n, int k, int [] nums){
		if(n==1){
			return nums[n];
		// }else if(n< k && n > 1){
			 nums[n] = product(nums[n], k, nums) *  product(nums[n-1], k, nums);
		}else{
			nums[n] = product(nums[n], k, nums) *  product(nums[n-1], k, nums)* product(nums[n-2], k, nums);
		}
		return nums[n];
	}

	**/

	public static void main(String[] args) {
		ConsecutiveProducts cp = new ConsecutiveProducts();
		int nums[] = new int[]{1, 3, 3, 6, 5, 7, 0, -3};
		int k = 3;
		System.out.println(Arrays.toString(cp.consecutiveProducts(nums, k)));
	}
}