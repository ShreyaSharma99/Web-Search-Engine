import java.util.*;
import java.io.*;
import java.lang.*;

public class MyHashTable extends MyLinkedList<WordEntry>
{
	public BucketArray[] a= new BucketArray[26];

	public MyHashTable()
	{
		for(int j=0; j<26; j++)
		{
			a[j]=new BucketArray();
		}
	}

	//This method adds the positions of a word.
	public void addPositionsForWord(WordEntry w)
	{
		int ascii=this.getHashIndex(w.s);
		Node<WordEntry> temp= a[ascii].list.first;

		while(temp!=null)
		{
			if(temp.element.s.equals(w.s))
		     break;
			temp=temp.next;
		}

		if(temp==null)
		{
			a[ascii].list.insertRear(w);
		}
		else
			temp.element.getAllPositionsForThisWord().concat(w.getAllPositionsForThisWord());
	}


	//This is the Hash Function defined. It returns the value of the index of the array in which a word will be stored.
	public int getHashIndex(String str)
	{
		int i=(int)str.charAt(0)-97;
		if(i>=0 && i<26)
		return i; 
		else return 0;
	}


}