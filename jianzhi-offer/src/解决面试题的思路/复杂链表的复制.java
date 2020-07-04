/**
 * 
 */
package 解决面试题的思路;

import 数据结构.RandomListNode;

public class 复杂链表的复制
{
    public RandomListNode Clone(RandomListNode pHead)
    {
        clone(pHead);
        connectSiblingNodes(pHead);
        return splitList(pHead);
    }
    
    public void clone(RandomListNode pHead)
    {
    	RandomListNode pNode = pHead;
    	while(pNode != null)
    	{
    		RandomListNode cloneNode = new RandomListNode(pNode.label);
    		cloneNode.next = pNode.next;
    		pNode.next = cloneNode;
    		
    		pNode = cloneNode.next;
    	}
    }
    
    public void connectSiblingNodes(RandomListNode pHead)
    {
    	RandomListNode pNode = pHead;
    	while(pNode != null)
    	{
    		RandomListNode cloneNode = pNode.next;
    		
    		if(pNode.random != null)
    			cloneNode.random = pNode.random.next;
    		
    		pNode = cloneNode.next; 
    	}
    }
    
    public RandomListNode splitList(RandomListNode pHead)
    {
    	if(pHead==null)
    		return null;
    	RandomListNode pNode = pHead;
    	RandomListNode cloneHead = pHead.next;
    	RandomListNode cloneNode = cloneHead;
    	
    	pNode = cloneNode.next;
    	
    	while(pNode!=null)
    	{
    		cloneNode.next = pNode.next;
    		cloneNode = cloneNode.next;
    		pNode.next = cloneNode.next;
    		pNode = cloneNode.next;
    	}
    	
    	return cloneHead;
    }
}
