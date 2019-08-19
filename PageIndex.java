public class PageIndex extends MyLinkedList<WordEntry>
{
	private MyLinkedList<WordEntry> list_words= new MyLinkedList();
	
	public void addPositionForWord(String str, Position p)
	{
		Node<WordEntry> temp= list_words.first;

		while(temp!=null)
		{
			if(str.equals(temp.element.s))
				break;
			temp=temp.next;
		}

		if(temp==null)
		{
			WordEntry w;
				w= new WordEntry(str);
				w.addPosition(p);
				list_words.insertRear(w);
		}

		else
		{
			temp.element.addPosition(p);
		}
	}


	//return the list of word entries of the words present in the page
	//this word entry contains only the positions of a word in this page
	public MyLinkedList<WordEntry> getWordEntries()
	{ return list_words;}
}


