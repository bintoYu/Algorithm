package tree;

public class Path_Sum_III_437
{
	private int res = 0;
    public int pathSum(TreeNode root, int sum) {
    	if(root == null) return 0; 
    	if(root.val == sum) return 1;
        
         res +=pathSum(root.left, sum-root.val);
         res +=pathSum(root.right, sum-root.val);
         
         return res;
    }
    
    public static void main(String[] args)
	{
    	TreeNode root = new TreeNode(10);
    	 root.left = new TreeNode(5);
    	 root.right = new TreeNode(-3);
    	 root.left.left = new TreeNode(3);
    	 root.left.right = new TreeNode(2);
    	 root.right.right = new TreeNode(11);
    	 root.left.left.left = new TreeNode(3);
		int res = new Path_Sum_III_437().pathSum(root, 8);
		System.out.println(res);
	}
}
