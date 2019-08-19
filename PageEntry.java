import java.util.*;
import java.io.*;

public class PageEntry
{
	public String pageName;	
	private PageIndex pg_index=new PageIndex();
	private MySet<String> Connector= new MySet<String>() ;
	private MySet<Integer> Punct= new MySet<Integer>();
	public int num=0;
	private MySet<String> plurals= new MySet<String>();

	public PageEntry(String pageName)
	{
		this.pageName=pageName;

		//construct 3 sets of plurals, punctuations and connectors
		plurals.addElement("stack");plurals.addElement("structure");plurals.addElement("application");
 
		Connector.addElement("a");Connector.addElement("an"); Connector.addElement("the"); Connector.addElement("they"); 
		Connector.addElement("these"); Connector.addElement("this"); Connector.addElement("for"); Connector.addElement("is");
		Connector.addElement("are"); Connector.addElement("was"); Connector.addElement("of"); Connector.addElement("or"); 
		Connector.addElement("and"); Connector.addElement("does"); Connector.addElement("will"); Connector.addElement("whose");

		Punct.addElement(27); Punct.addElement(29); Punct.addElement(60); Punct.addElement(62); Punct.addElement(61); 
		Punct.addElement(40);Punct.addElement(41); Punct.addElement(44); Punct.addElement(46); Punct.addElement(59); 
		Punct.addElement(39); Punct.addElement(34);Punct.addElement(42); Punct.addElement(35); Punct.addElement(33); 
		Punct.addElement(58); Punct.addElement(126);Punct.addElement(45);

	try{
		//read file word by word
		FileReader fr = new FileReader(pageName);
		Scanner scan = new Scanner(fr);
		String word=null;
		String w1=null;
		String w2=null;

		while(scan.hasNext())
		{
			word=scan.next();
			word=word.toLowerCase();

			for(int j=0; j<word.length(); j++)
			{
		 	if(Punct.IsMember((int)word.charAt(j)))	
		 		word=word.replace(word.charAt(j),' ');
			}

			//String[] str= word.split("\\s+");
			Scanner scan1= new Scanner(word);
			//int i=0;
			while (scan1.hasNext()) 
			{
				this.addWord(scan1.next());
				
			}
		}	
			// int f;
			// int length=word.length();

			// for(int i=0; i<length-1; i++)
			// {
			// 	f=(int)word.charAt(i);
			// //	System.out.println(f);

			// 	if(Punct.IsMember(f))
			// 	{
			// 		word=word.substring(i+1,length);
			// //		System.out.println("2");
			//     }
			// 	else break;
			// }

			// 	length=word.length();
			// 	for(int j=length-1; j>0; j--)
			// 	{
			// 	//System.out.println(j);
			// 	//System.out.println(length);
			// 		f=(int)word.charAt(j);
			// 	//System.out.println(word.charAt(j-1));

			// 		if( Punct.IsMember(f))
			// 		{
			// 			word=word.substring(0,j);
			// 		}
			// 		else break;
			// 	}
 				
 		// 		length=word.length();
			// 	 if(length==1)
			// 	 {
			// 	 	f=(int)word.charAt(0);
			// 	 	if( !Punct.IsMember(f))
			// 	 		{this.addWord(word);} 
				 	
			// 	 }

			// 	// int k;
			// 	 if(length>1){
			// 	 	this.recur(word,length);
		}
		//
	catch(FileNotFoundException e){System.out.println(e);};
	//System.out.println("done");
	}


	public void addWord(String word){
		if(word!=null){
			num++;
				if(!Connector.IsMember(word))
				{
					
					//System.out.println(word);
					//System.out.println(num);
					Position p= new Position(this,num);
					//System.out.println(p.getWordIndex());	
						if(!plurals.IsMember(word)){
						// if(word.equals("stack"))
						// 	System.out.println("2");
							pg_index.addPositionForWord(word,p);
							
						}
						else{
							//System.out.println("33");
							pg_index.addPositionForWord(word+"s",p);
						}
					
				}}
	}


	public PageIndex getPageIndex()
	{ return pg_index;}


	public void recur(String word,int length)
	{
		String w1="";
		String w2=""; 
		int k;
		if(length>1){
	 		for( k=1; k<length-1; k++)
				 {
					//System.out.println(word.charAt(k))	;
					if(Punct.IsMember((int)word.charAt(k)))
						{
							w1=word.substring(0,k);
							//System.out.println(w1)	;
							 w2=word.substring(k+1,length);
							 //System.out.println(w2)	;
							break;
						}
				 }
				
				 if(k==length-1 && length>1){
				 //	System.out.println("1")	;
				 	this.addWord(word);}
				 else {
				 	//System.out.println("2")	;
				 	this.addWord(w1);
				 	this.recur(w2,w2.length());
				 
				}
		}
	 }
	
}