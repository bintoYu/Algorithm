/**
 * 
 */
package 面试中的各项能力;

import 数据结构.TreeNode;

//通过。
public class 二叉搜索树的第k大节点
{
	private int count = 0;
	
	private TreeNode kNode;
	
	public TreeNode getKNode(TreeNode root,int k)
	{
		if(root == null || k <= 0) return null;
		
		getKNode(root.left, k);
		count++;
		if(count == k)
			kNode = root;
		getKNode(root.right, k);
		
		return kNode;
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(9);
		TreeNode kNode = new 二叉搜索树的第k大节点().getKNode(root, 7);
		System.out.println(kNode.val);
	}
}
