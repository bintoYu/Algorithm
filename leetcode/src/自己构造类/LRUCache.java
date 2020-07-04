package 自己构造类;

import java.util.HashMap;
import java.util.Map;

class Node
{
	public String key;
	public String value;
	public Node pre;
	public Node next;
	
	public Node(String key,String value)
	{
		this.key = key;
		this.value = value;
	}
}

public class LRUCache
{
	private Map<String,Node> map;
	private int limit;
	private Node head;
	private Node tail;
	
	public LRUCache(int limit)
	{
		this.limit = limit;
		map = new HashMap<>();
	}
	
	//不管是addNode还是removeNode：都是先head再tail
	public void addNode(Node node)
	{
		if(head == null)
			head = node;
		
		if(tail != null)
		{
			tail.next = node;
			node.pre = tail;
			node.next = null;
		}
		
		tail = node;
	}
	
	public String removeNode(Node node)
	{
		if(head == node)
		{
			head = node.next;
			head.pre = null;
		}
		else if(tail == node)
		{
			tail = node.pre;
			tail.next = null;
		}
		else
		{
			node.next.pre = node.pre;
			node.pre.next = node.next;
		}
		return node.key;
	}
	
	//用于调整已有的位置
	public void refresh(Node node)
	{
		if(node == tail)
			return ;
		removeNode(node);
		addNode(node);
	}
	
	
	public void put(String key,String value)
	{
		Node node = map.get(key);
		//有的话刷新，没有的话添加
		if(node == null)
		{
			//如果LRUCache已满，队头需要出队
			if(map.size() >= limit)
			{
				String oldKey = removeNode(head);
				map.remove(oldKey);
			}
			node = new Node(key, value);
			addNode(node);
			map.put(key, node);
		}
		else
		{
			node.value = value;
			refresh(node);
		}
	}
	
	public String get(String key)
	{
		Node node = map.get(key);
		if(node == null)
			return null;
		refresh(node);
		return node.value;
	}
	
	public void remove(String key)
	{
		Node node = map.get(key);
		if(node == null)
			return ;
		removeNode(node);
		map.remove(node);
	}
}
