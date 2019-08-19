public class InvertedPageIndex extends MyLinkedList<Object>
{
	public MyHashTable hash = new MyHashTable();
	public MySet<String> pages = new MySet<String>();


//adds a page to the Inverted Page Index and puts all its words in the Hash Table
	public void addPage(PageEntry p)
	{
		pages.addElement(p.pageName);
		Node<WordEntry> temp= p.getPageIndex().getWordEntries().first;

		while(temp!=null)
		{
			hash.addPositionsForWord((WordEntry)temp.element);	
			temp=temp.next;
		}
	}

	public MySet<PageEntry> getPagesWhichContainWord(String str)
	{
		MySet<PageEntry> set= new MySet<PageEntry>();
		try{
			if(str.equals("stack")||str.equals("structure")||str.equals("application"))
				str=str+"s";
			WordEntry w;
			int i= hash.getHashIndex(str);

			Node<WordEntry> tem= hash.a[i].list.first;

			while(tem!=null)
			{
				if(tem.element.s.equals(str))
					break;
				tem=tem.next;
			}
			if(tem!=null)
				w=tem.element;
			else {
					return null;
				 }
			Node<Position> temp= w.getAllPositionsForThisWord().first;

			while(temp!=null)
			{

				set.addElement((PageEntry)temp.element.getPageEntry());
				temp=temp.next;
			}
		}
		catch(Exception e){
System.out.println(e);
			set=null;};
		return set;
	}

	// to print the elemnts of a set
    public String printSet(MySet<PageEntry> set)
    {

    	String s="";
    	Node<PageEntry> temp=set.L.first;

	 	while(temp.next != null)
		 	{
		 		s= s+ temp.element.pageName+", ";
		 		temp=temp.next;
		 	}
	 	s=s+ temp.element.pageName;
	 	return s;

    }

    //function to find position of a word (word) in a webpage (page)
    public MySet<Integer> positions(String word, String page)
    {
    	MySet<Integer> position= new MySet<Integer>();
    	if(word.equals("stack")||word.equals("structure")||word.equals("application"))
				word=word+"s";
    	int i= hash.getHashIndex(word);

    	Node<WordEntry> tem= hash.a[i].list.first;
    	 while(tem!=null)
			{   
				if(tem.element.s.equals(word))
					break;
				tem=tem.next;
			}

			WordEntry w ;
			if(tem!=null)
				{
					w=tem.element;
				}
			else {
					return null;
				 }
			Node<Position> temp= w.getAllPositionsForThisWord().first;
			while(temp!=null)
			{
				if(temp.element.getPageEntry().pageName.equals(page))
					position.addElement(temp.element.getWordIndex());
				temp=temp.next;
			}
			return position;
    }

}