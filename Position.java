public class Position
{
	public PageEntry pe;
	public int wordIndex;

	public Position(PageEntry p, int wordIndex)
	{
		pe=p; 
		this.wordIndex=wordIndex;
	}

	public PageEntry getPageEntry()
	{ return pe;}

	public int getWordIndex()
	{return wordIndex;}
	
}