/**
 * 
 */
package 解决面试题的思路;

public class 顺时针打印矩阵
{
	public void printMatrixByClockwisely(int[][] matrix)
	{
		if(matrix == null || matrix.length==0 || matrix[0].length == 0)
			return ;
		
		int start = 0;
		while(matrix.length > start*2 && matrix[0].length > start*2)
		{
			printMatrixByClockwisely(matrix,start);
			start++;
		}
	}

	private void printMatrixByClockwisely(int[][] nums, int start)
	{
		int endRow = nums.length - 1 - start;
		int endColumn = nums[0].length - 1 - start;
		
		//第一步,从左向右打印
		for(int i = start; i <= endColumn; i++)
			printNumber(nums[start][i]);
		
		//第二步，从上向下打印
		if(start < endRow)
		{
			for(int i = start; i <= endRow; i++)
				printNumber(nums[i][endColumn]);
		}
		
		//第三步，从右向左打印
		if(start < endColumn && start < endColumn)
		{
			for(int i = endColumn -1; i >= start; i--)
				printNumber(nums[endRow][i]);
		}
		
		//第四步，从下向上打印
		if(endRow - start >= 2 && start < endColumn)
		{
			for(int i = endRow -1; i >= start; i--)
				printNumber(nums[i][start]);
		}
	}

	private void printNumber(int i)
	{
		System.out.println(i + "  ");
	}
}
