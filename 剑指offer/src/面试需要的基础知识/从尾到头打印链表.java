package 面试需要的基础知识;

import java.util.ArrayList;
import java.util.Stack;

import 数据结构.ListNode;

/**
 * 倒序的三种方法：
 * 1、改变链结构，使其倒序
 * 2、使用栈
 * 3、递归
 * @author binto
 *
 */
public class 从尾到头打印链表
{
	private ArrayList<Integer> res = new ArrayList<>();
	
	//递归
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
    	if(listNode != null)
    	{
    		printListFromTailToHead(listNode.next);
    		res.add(listNode.val);
    	}
    	return res;
    }
    
    //使用栈
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	Stack<Integer> stack = new Stack<>();
    	while(listNode != null)
    	{
    		stack.push(listNode.val);
    		listNode = listNode.next;
    	}
    	
    	while(!stack.isEmpty())
    	{
    		res.add(stack.pop());
    	}
    	
    	return res;
    }
    
    //改变结构，详见leetcode Reverse_LinkedList_206
    
    public static void main(String[] args)
	{
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(4);
    	head.next.next.next.next = new ListNode(5);
    	ArrayList<Integer> p = new 从尾到头打印链表().printListFromTailToHead(head);
    	System.out.println(1);
	}
}
