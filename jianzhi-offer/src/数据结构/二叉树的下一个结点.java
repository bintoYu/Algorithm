/**
 * 
 */
package 数据结构;

public class 二叉树的下一个结点
{
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null) return null;
        //如果右不为空，一直到右子树的最左结点
        if(pNode.right != null)
        {
            TreeLinkNode cur = pNode.right;
            while(cur.left != null)
                cur = cur.left;
            return cur;
        }
        //如果右为空
        else
        {
            if(pNode.parent != null)
            {
                //如果它是左孩子,则父节点就是下一个节点
                if(pNode == pNode.parent.left)
                    return pNode.parent;
                //如果它是右孩子，则需要一直往上遍历直到某个父节点成为左孩子为止
                else
                {
                    TreeLinkNode cur = pNode.parent;
                    while(cur.parent != null && cur != cur.parent.left)
                        cur = cur.parent;
                    return cur.parent;
                }
             }
        }
        return null;
    }
    
    public static void main(String[] args)
	{
    	TreeLinkNode root = new TreeLinkNode(1);
	}
}
