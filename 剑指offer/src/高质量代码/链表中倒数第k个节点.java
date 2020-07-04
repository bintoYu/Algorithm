/**
 * 
 */
package 高质量代码;

import 数据结构.ListNode;

//已通过测试
public class 链表中倒数第k个节点
{
	public ListNode findTheLastKthNode(ListNode head,int k)
	{
		if(head == null)
			return null;
		ListNode p1 = head;
		ListNode p2 = head;
		//p2挪动k个位置
		for(int i = 0; i < k; i++)
		{
			if (p2 != null)
				p2 = p2.next;
			else
				return null;
		}
		while(p2!=null)
		{
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;
	}
}
