/**
 * 
 */
package 解决面试题的思路;

import java.util.ArrayList;

import 数据结构.TreeNode;

public class 二叉树中和为某一值的路径
{
	private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> tmpList = new ArrayList<>();
	
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return res;
        target -= root.val;
        tmpList.add(root.val);
        if(target == 0 && root.left == null && root.right == null)
        	res.add(new ArrayList<>(tmpList));
        if(root.left != null)
        	FindPath(root.left, target);
        if(root.right != null)
        	FindPath(root.right, target);
        
        //遍历完删掉根节点
        tmpList.remove(tmpList.size()-1);
        return res;
    }
}
