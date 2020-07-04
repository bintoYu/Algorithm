package 面试中的各项能力;

import 数据结构.TreeNode;

public class 平衡二叉树
{
    private boolean isBalanced = false;//最后的返回值
    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }
    public int getDepth(TreeNode root) {
        if(root == null) {
            isBalanced = true;
            return 0;
        }
        int left = getDepth(root.left);//左子树
        int right = getDepth(root.right);//右子树
        int depth = (left > right ? left : right) + 1;
        if(Math.abs(left-right)>1)
            isBalanced = false;
        return depth;//下层的深度，上层可以接着用免得再遍历
    }

}
