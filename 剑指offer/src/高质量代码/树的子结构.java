/**
 * 
 */
package 高质量代码;

import 数据结构.TreeNode;

public class 树的子结构
{
	public boolean hasSubTree(TreeNode root1, TreeNode root2)
	{
		if(root1 == null || root2 == null)
			return false;
		
		if(root1.val == root2.val && isSubTree(root1,root2))
		{
			return true;
		}
		
		//错误示例
//		result = hasSubTree(head1.left, head2);
//		result = hasSubTree(head1.right, head2);
		
		//正确示例
		return hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
	}
	
	private boolean isSubTree(TreeNode root1, TreeNode root2)
	{
		if(root1 == null && root2 != null)
			return false;
		
		//1.成功条件是遍历到最后子树head2为null！
		if(root2 == null)
			return true;
		
		if(root1.val != root2.val)
			return false;
		
		return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
	}

	
	public static void main(String[] args)
	{
		TreeNode head1 = new TreeNode(8);
		head1.left = new TreeNode(8);
		head1.right = new TreeNode(7);
		head1.left.left = new TreeNode(9);
		head1.left.right = new TreeNode(2);
		head1.left.right.left = new TreeNode(4);
		head1.left.right.right = new TreeNode(7);
		
		TreeNode head2 = new TreeNode(8);
		head2.left = new TreeNode(9);
		head2.right = new TreeNode(2);
		
		boolean hasSubTree = new 树的子结构().hasSubTree(head1, head2);
		System.out.println(hasSubTree);
	}
}
