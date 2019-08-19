public class WordEntry extends MyLinkedList<Position>
{
	public String s;
	private MyLinkedList<Position> list;
	public int total_words;

	//constructor 
	public WordEntry(String word)
	{ 	s=word;
		list = new MyLinkedList<Position>();
	}

	//adds position to the list of poitions of this word
	public void addPosition(Position position)
	{
		list.insertRear(position);
	}

	//joins the new list of positions to the end of existing list
	public void addPositions(MyLinkedList<Position> positions)
	{
		Node<Position> temp= list.first;
		while(temp.next!=null)
		{
			temp=temp.next;
		}

		temp.next=positions.first;
	}

	//Returns a linked list of all position entries for str.
	public MyLinkedList<Position> getAllPositionsForThisWord()
	{
		return list;
	}

	//Return the term frequency of the word in a webpage.
	public float getTermFrequency(String word)
	{
		return (list.Number()/total_words);
	}


}
