import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import 数据结构.TreeNode;

/**
 * 
 */

/**
 * @author Administrator
 *
 * @date 2018年12月31日  
 * @version 1.0  
 */
public class test
{
	public List<List<Integer>> bfs(TreeNode root)
	{
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null) return res;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty())
		{
			ArrayList<Integer> list = new ArrayList<>();
			int size = queue.size();
			for(int i = 0; i < size; i++)
			{
				TreeNode node = queue.poll();
				list.add(node.val);
				if(node.left!=null) queue.offer(node.left);
				if(node.right!=null) queue.offer(node.right);
			}
			res.add(list);
		}
		
		return res;
	}
}
