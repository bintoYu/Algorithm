package 面试需要的基础知识;

public class 机器人的运动范围
{
	private int sum = 0;
	
	public int movingCount(int k,int m, int n)
	{
		int[][] board = new int[m][n];
		
		int[][] isVisited = new int[m][n];
		
		movingCount(k, 0, 0, board, isVisited);
		
		return sum;
	}
	
	public void movingCount(int k,int row,int column,int[][] board,int[][] isVisited)
	{
		//失败条件
		if(getDigitSum(row, column) > k || row < 0 || row >= isVisited.length || column < 0 || column >= isVisited[0].length || isVisited[row][column]==1 )
		{
			return ;
		}
		
		//成功条件
		sum++;
		
		isVisited[row][column] = 1;
		
		//递归
		movingCount(k, row+1, column, board, isVisited);
		movingCount(k, row, column+1, board, isVisited);
		movingCount(k, row-1, column, board, isVisited);
		movingCount(k, row, column-1, board, isVisited);
		
//		isVisited[row][column] = 0;
	}
	
	public int getDigitSum(int row,int column)
	{
		int sum = 0;
		while(row!=0)
		{
			sum += row%10;
			row /= 10;
		}
		while(column!=0)
		{
			sum += column%10;
			column /= 10;
		}
		
		return sum;
	}
	
	public static void main(String[] args)
	{
		int digitSum = new 机器人的运动范围().movingCount(18,36,39);
		System.out.println(digitSum);
	}
}
