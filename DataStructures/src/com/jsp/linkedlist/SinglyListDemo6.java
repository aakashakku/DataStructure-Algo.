package com.jsp.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SinglyListDemo6
{
Node first = null;
int count = 0;
public void addNodes(Object e)
{
	if(first == null)
	{
		first = new Node(e, null);
		count++;
	}
	else
	{
		Node current = first;
		while(current.next != null)
		{
			current = current.next;
		}
		current.next = new Node(e, null);
		count++;
	}
}
public int size()
{
	return count;
}
public void display()
{
	if(first == null)
	{
		System.out.println("List is empty");
	}
	else
	{
		Node current = first;
		while(current != null)
		{
			System.out.print(current.ele+" ");
			current = current.next;
		}
	}
	System.out.println();
}
public void reverse()
{
	if(first == null)
	{
		System.out.println("List is empty");
	}
	else
	{
		Node prev = null;
		Node current = first;
		Node next = null;
		while(current != null) //    20 2->3->4->5
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			
		}
		first = prev;
		
	}
}
public void addNodeAtBeginning(Object e)
{
	if(first == null)
	{
		System.out.println("List is empty");
	}
	else
	{
		Node temp = first;
		temp = new Node(e, first);
		first = temp;
		count++;
	}
}
public void addNodeAtEnd(Object e)
{
	if(first == null)
	{
		System.out.println("List is empty");
	}
	else
	{
		Node current = first;
		while(current.next != null)
		{
			current = current.next;
		}
		current.next = new Node(e, null);
		count++;
	}
}
public void addNodeAtSpecificPosition(Object e, int position)
{
	if(first == null)
	{
		System.out.println("List is empty");
	}
	else
	{
		int countOfNodes = 1;
		Node prev = null;
		Node current = first;
		if(position == 1)
		{
			Node temp = first;
			temp = new Node(e, first);
			first = temp;
			count++;
			return;
		}
       int linkedListOverallSize = size();
		
		if(position > linkedListOverallSize+1)
		{
			System.out.println("Invalid possition");
			return;
		}
		while(position != countOfNodes)
		{
			prev = current;
			current = current.next;
			countOfNodes++;
		}
		prev.next = new Node(e, current);
		count++;
		
	}
}
public void deleteNodeAtSpeicificPosition(int position)
{
	int countOfNodes = 1;
	Node current = first;
	Node prev = null;
	if(position == 1)
	{
		first = current.next;
		count--;
		return;
	}
	while(position != countOfNodes)
	{
		prev = current;
		current = current.next;
		countOfNodes++;
	}
	prev.next = current.next;
	count--;
}
public void deleteFirstNode()
{
	if(first == null)
	{
		System.out.println("List is empty"); // 12 --> 13 ---> 19 ---> 20 --->
	}
	else
	{
		Node current = first;
		first = current.next;
		count--;
		
	}
}
public void searchNode(Object elementToBeSearched)
{
	int nodeCount = 1;
	Node current = first;
	while(current != null)
	{
		if(elementToBeSearched.equals(current.ele))
		{
			System.out.println("Element "+elementToBeSearched+" found at Node "+nodeCount);
			return;
		}
		else
		{
			current = current.next;
			nodeCount++;
		}
	}
	System.out.println("Not found");
}
public void converNodesEleIntoString()
{
	if(first == null)
	{
		System.out.println("List is empty");
	}
	else
	{
		String s1 = "";
		Node current = first;
		while(current != null)
		{
			s1 = s1 + current.ele+" ";
			current = current.next;
		}
		System.out.println("The linked list: "+s1+"");
	}
}
public void convertLinkedListToArray()
{
	if(first == null)
	{
		System.out.println("List is empty");
		return;
	}
	else
	{
		int sizeOfLinkedList = size();
		int arr[] = new int[sizeOfLinkedList];
		Node current = first;
		int i = 0;
		while(current != null)
		{
			
			arr[i] = ((Integer)current.ele).intValue();
			i++;
			current = current.next;
		}
		for(int a : arr)
		{
			System.out.print(a+" ");
		}
	}
	System.out.println();
}
public void mergeTwoLinkedList(SinglyListDemo6 l1, SinglyListDemo6 l2)
{
	if(l1.first == null)
	{
		System.out.println("List is empty");
	}
	else
	{
		Node current = l1.first;
		while(current.next!= null)
		{
			current = current.next;
		}
		current.next = l2.first;
		current = l1.first;
		count = l1.size()+l2.size();
		while(current != null)
		{
			System.out.print(current.ele+" ");
			current = current.next;
		}
		System.out.println();
	}
	//Sorting using down casting!!
	int sizeOfMergedList = count;
	Node current = l1.first;
	int arr[] = new int[sizeOfMergedList];
	int i = 0;
	while(current!= null)
	{
		arr[i] = ((Integer)current.ele).intValue();
		i++;
		current = current.next;
	}
	for(int j = 0; j < arr.length-1; j++)
	{
		for(int k = j+1; k < arr.length; k++)
		{
			if(arr[k] < arr[j])
			{
				int temp = arr[j];
				arr[j] = arr[k];
				arr[k] = temp;
			}
		}
	}
	for(int a : arr)
	{
		System.out.print(a+" ");
	}

}
public void mergeAndSortUsingoComparable(SinglyListDemo6 l1, SinglyListDemo6 l2)
{
	if(l1.first == null)
	{
		System.out.println("LinkedList 1 is empty");
	}
	else
	{
		Node current = l1.first;
		while(current.next != null)
		{
			current = current.next;
		}
		if(l2.first == null)
		{
			System.out.println("LinkedList 2 is empty");
			return;
		}
		else
		{
			current.next = l2.first;
		}
	}
	Node currentTwo = l1.first;
	System.out.println("Merging two LinkedList into a single SingleLinkedList..");
	while(currentTwo != null)
	{
		System.out.print(currentTwo.ele+" ");
		currentTwo = currentTwo.next;
	}
	System.out.println();
	System.out.println("Putting the merged LinkedList into a single List");
	List<Object> listOfMergeedLinkedList = new ArrayList<Object>();
	Node current = l1.first;
	while(current != null)
	{
		listOfMergeedLinkedList.add(current.ele);
		current = current.next;
	}
	System.out.println(listOfMergeedLinkedList);
	System.out.println("Now sorting using Comparable Interface");
	Comparator<Object> Comparator = new Comparator<Object>()
	{
		@Override
		@SuppressWarnings("unchecked")
		public int compare(Object i, Object j)
		{
			return ((Comparable<Integer>)i).compareTo((Integer)j); //((Comparable)i).compareTo(j);
		}
	};
	Collections.sort(listOfMergeedLinkedList, Comparator);
	System.out.println(listOfMergeedLinkedList);
	
}
public void checkIfLinkedListIsAPalindrome(SinglyListDemo6 linkedListThreeForPalindromCheck)
{
	SinglyListDemo6 copyOfOriginalList = new SinglyListDemo6();
	
	if(linkedListThreeForPalindromCheck.first == null)
	{
		System.out.println("Recieved list is empty");
	}
	else
	{	
		Node current = linkedListThreeForPalindromCheck.first;
		while(current != null)
		{
			copyOfOriginalList.addNodes(current.ele);
			current = current.next;
		}
	}
	copyOfOriginalList.reverse();
	System.out.println("-------->>>");
	copyOfOriginalList.display();
	linkedListThreeForPalindromCheck.display();
	System.out.println("-------->>>");
	Node current = linkedListThreeForPalindromCheck.first;
	Node currentOfCopyList = copyOfOriginalList.first;
	boolean flag = false;
	while(current != null)
	{
		if(current.ele.equals(currentOfCopyList.ele))
		{
			flag = true;
			current = current.next;
			currentOfCopyList = currentOfCopyList.next;
		}
		else
		{
			flag = false;
			current = current.next;
			currentOfCopyList = currentOfCopyList.next;
		}
	}
	if(flag == true)
	{
		System.out.println("true");
	}
	else
	{
		System.out.println("false");
	}

}
public void compareAndSort(SinglyListDemo6 list1)
{
	if(list1.first == null)
	{
		System.out.println("List is empty!!");
	}
	else
	{
		System.out.println("Printing the list in compareAndSort");
		list1.display();
	}
	List<Integer> list = new ArrayList<Integer>();
	Node current = list1.first;
	while(current != null)
	{
		try
		{
			Integer integerValue = (Integer)current.ele;
			list.add(integerValue);
		}
		catch(Exception e)
		{
			System.out.println(current.ele+" isnt a of type Integer");
		}
		current = current.next;
	}
	System.out.println("Printing the  normal list.. ");
	System.out.println(list);
	System.out.println("............................");
	System.out.println("Sorting in process!");
	
	Comparator<Integer> Comparator = new Comparator<Integer>()
	{
	 @Override	
	 public int compare(Integer i, Integer j)
	 {
		 if(i > j)
		 {
			 return 1;
		 }
		 else
		 {
			 return -1;
		 }
	 }
	};
	 current = list1.first;
	
	Collections.sort(list, Comparator);
	System.out.println(list);
	System.out.println("------->>>");
	while(!list.isEmpty())
	{
		current.ele = list.get(0);
		list.remove(0);
		current = current.next;
	}
	list1.display();
}
public static void main(String[] args) 
{
	SinglyListDemo6 linkedListOne = new SinglyListDemo6();
	linkedListOne.addNodes(10);
	linkedListOne.addNodes(20);
	linkedListOne.addNodes(30);
	linkedListOne.addNodes(40);
	linkedListOne.addNodes(50);
	linkedListOne.display();
	linkedListOne.size();
	linkedListOne.reverse();
	linkedListOne.display();
	linkedListOne.size();
	linkedListOne.addNodeAtBeginning(100);
	linkedListOne.display();
	linkedListOne.size();
	linkedListOne.addNodeAtEnd(200);
	linkedListOne.display();
	linkedListOne.size();
	linkedListOne.addNodeAtSpecificPosition(900, 8);
	linkedListOne.display();
	linkedListOne.deleteFirstNode();
	linkedListOne.display();
	linkedListOne.deleteNodeAtSpeicificPosition(3);
	linkedListOne.display();
	linkedListOne.deleteNodeAtSpeicificPosition(1);
	linkedListOne.display();
	System.out.println(linkedListOne.size());
	linkedListOne.deleteNodeAtSpeicificPosition(1);
	linkedListOne.display();
	linkedListOne.converNodesEleIntoString();
	linkedListOne.convertLinkedListToArray();
	SinglyListDemo6 linkedListTwo = new SinglyListDemo6();
	linkedListTwo.addNodes(15);
	linkedListTwo.addNodes(23);
	linkedListTwo.addNodes(55);
	linkedListTwo.addNodes(95);
	linkedListTwo.display();
	linkedListTwo.mergeAndSortUsingoComparable(linkedListOne, linkedListTwo);
	SinglyListDemo6 linkedListThreeForPalindromCheck = new SinglyListDemo6();
	linkedListThreeForPalindromCheck.addNodes(9);
	linkedListThreeForPalindromCheck.addNodes(2);
	linkedListThreeForPalindromCheck.addNodes(1);
	linkedListThreeForPalindromCheck.addNodes(2);
	linkedListThreeForPalindromCheck.addNodes(8);
	linkedListThreeForPalindromCheck.display();
	linkedListThreeForPalindromCheck.checkIfLinkedListIsAPalindrome(linkedListThreeForPalindromCheck);
	linkedListOne.compareAndSort(linkedListOne);
	
	
}
}

