/**
 * 
 */
package 解决面试题的思路;

import 数据结构.TreeNode;

public class 二叉树的镜像
{
	public void snapshotOfBinaryTree(TreeNode root)
	{
		if(root == null)
			return ;
		
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		snapshotOfBinaryTree(root.left);
		snapshotOfBinaryTree(root.right);
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(9);
//		root.right.right = new TreeNode(11);
		
		new 二叉树的镜像().snapshotOfBinaryTree(root);
		System.out.println(root);
	}
}
