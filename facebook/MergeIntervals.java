import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;


/**


56. Merge Intervals -- Medium -- https://leetcode.com/problems/merge-intervals/


Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104


**/

public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals,(a,b)->a[0]-b[0]);

		LinkedList<int[]> merged = new LinkedList<>();

		for(int[] interval : intervals){
			if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
				merged.add(interval);
			}else{
				merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
			}
		}

		return merged.toArray(new int[merged.size()][]);
	}

	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
		int [][] intervals  = new int[][]{{7,15},{1,4},{4,5},{5,9},{10,12}};
		System.out.println(Arrays.deepToString(mi.merge(intervals)));
	}
}