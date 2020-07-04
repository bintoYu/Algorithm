package 解决面试题的思路;
import 数据结构.TreeNode;

public class 二叉搜索树和双向链表
{
	private TreeNode preNode = null;
	private TreeNode head = null;
	
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        Convert(pRootOfTree.left);
        
        if(preNode == null)
        {
        	preNode = pRootOfTree;
        	head = preNode;
        }
        else
        {
        	preNode.right = pRootOfTree;
        	pRootOfTree.left = preNode;
        	preNode = pRootOfTree;
        }
        
        Convert(pRootOfTree.right);
        
        return head;
    }
    
    
    public static void main(String[] args)
	{
    	TreeNode head = new TreeNode(4);
    	head.left  = new TreeNode(2);
    	head.right = new TreeNode(5);
    	head.right.right = new TreeNode(6);
		TreeNode convert = new 二叉搜索树和双向链表().Convert(head);
		System.out.println(convert);
	}
}
