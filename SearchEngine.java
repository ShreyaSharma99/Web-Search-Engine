import java.util.*;
import java.io.*;

public class SearchEngine extends InvertedPageIndex
{
	InvertedPageIndex inv_pg_index;
	public SearchEngine()
	{
		inv_pg_index = new InvertedPageIndex();
	}

	public void performAction(String actionMessage)
	{
		String[] s= actionMessage.split(" ",3);
    
       try{
        if(s[0].equals("addPage"))
            { 	
            	PageEntry pageEntry = new PageEntry(s[1]);
                inv_pg_index.addPage(pageEntry);
            }}
            catch(Exception e){System.out.println("Invalid request");}

		try{
		if(s[0].equals("queryFindPagesWhichContainWord"))  
		{	
			try{
				s[1]=s[1].toLowerCase();
			String a= inv_pg_index.printSet(inv_pg_index.getPagesWhichContainWord(s[1]));
			System.out.println("queryFindPagesWhichContainWord "+s[1]+"-    "+a);
			}
			catch(NullPointerException e){System.out.println("No webpage contains word "+s[1]);}
		} }      
 catch(Exception e){System.out.println("Invalid request");}

		//Print the word indice's where the word x is found in the document y.
		try{
		if(s[0].equals("queryFindPositionsOfWordInAPage"))
		{
			String x=s[1];
			String y=s[2];		
			String a="";

			MySet<Integer> set=(inv_pg_index.positions(s[1],s[2]));

				 a="";
				 if(set!=null){
	    			Node<Integer> temp=set.L.first;

		 	while(temp.next != null)
			 	{
			 		a= a+ temp.element+", ";
			 		temp=temp.next;
			 	}
		 	a=a+ temp.element;
				System.out.println("queryFindPositionsOfWordInAPage "+s[1]+" "+s[2]+"-   "+a);}

				else System.out.println("Webpage "+s[2]+" does not contain word "+s[1]);

			
		}
	}
	 catch(Exception e){System.out.println("Invalid request");}


	}
}

