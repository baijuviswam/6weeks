import java.util.Stack;

public class NextBinaryNumber {
	/** 

	DCP # 443  // Facebook // Medium

	Given an integer n, find the next biggest integer with the same number of 1-bits on. For example, given the number 6 (0110 in binary), return 9 (1001)

	**/

	//optimal solution
	public int nextBinaryNumber(int num){
		int rightOne, nextHigherOneBit, rightOnesPattern, next = 0; 
		if(x > 0) { 
		    // right most set bit 
		    rightOne = x & -x; 
		    // reset the pattern and set next higher bit 
		    // left part of x will be here 
		    nextHigherOneBit = x + rightOne; 
		    // nextHigherOneBit is now part [D] of the above explanation. 
		    // isolate the pattern 
		    rightOnesPattern = x ^ nextHigherOneBit; 
		    // right adjust pattern 
		    rightOnesPattern = (rightOnesPattern)/rightOne; 
		    // correction factor 
		    rightOnesPattern >>= 2; 
		    // rightOnesPattern is now part [A] of the above explanation.
		    // integrate new pattern (Add [D] and [A]) 
		    next = nextHigherOneBit | rightOnesPattern; 
		} 
		return next; 
	}

	//Brute force 
	private int nextBinaryNumber(int num){
		
		int arr [] = new int[2];
		arr[0] = getOnesCount(num);
		for(int nextNum = num+1; nextNum<=Integer.MAX_VALUE; nextNum++){
			arr[1] = getOnesCount(nextNum);
			if(arr[0]==arr[1]){
				return nextNum;
			}
		}
		return -1;
	}
	//find 1's in binray representation of a number 
	int getOnesCount(int num){
		int count = 0;
		while(num!=0){
			int d = num%2;
			if(d==1) ++count;
			num=num/2;
		}	
		return count;
	}
	public static void main(String[] args) {
		NextBinaryNumber nb = new NextBinaryNumber();
		int n = 156;		
		System.out.println("Next Binary number "+nb.nextBinaryNumber(n));
	}
}