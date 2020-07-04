package 面试需要的基础知识;

public class 矩阵中的路径
{
	public boolean hasPath(char[][] matrix, String path)
	{
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		if (path == null || path.length() == 0)
			return false;

		boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				if(hasPath(matrix, isVisited, path, 0, 0, 0)) return true;
			}
		}
		
		return false;
	}

	public boolean hasPath(char[][] matrix, boolean[][] isVisited, String path,
			int i, int j, int index)
	{
		// 失败条件
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length
				|| isVisited[i][j] == true
				|| matrix[i][j] != path.charAt(index))
			return false;
		// 成功条件
		if (index == path.length() - 1)
			return true;

		// 移动（成功返回true）
		isVisited[i][j] = true;
		if (hasPath(matrix, isVisited, path, i + 1, j, index + 1)
				|| hasPath(matrix, isVisited, path, i, j + 1, index + 1)
				|| hasPath(matrix, isVisited, path, i - 1, j, index + 1)
				|| hasPath(matrix, isVisited, path, i, j - 1, index + 1))
			return true;

		//改回visit
		isVisited[i][j] = false;
		//最后没找到路径，返回false
		return false;
	}
}
