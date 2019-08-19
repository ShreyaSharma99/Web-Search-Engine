public class MyLinkedList<E> {
// creating a node sub class
   static class Node<E>{
	                       public E element;
	                       public Node<E> next;

	                       // creating a node
	                       public Node()
	                       {element=null;	next=null;}

	                       public Node(E obj, Node<E> node)
	                       {element=obj; next=node;}
                        }

    public Node<E> first;
   
    //LinkList constructor
  	public MyLinkedList() {
     	
     	 first = null;
    }

    //Returns true if list is empty
    public boolean isEmpty() {
        return (first == null);
    }

    // checks whether e is a member of the MyLinkedList
    	public boolean IsMember(E o)
	 {
	 	Node<E> temp=first;
	 	while(temp != null)
	 	{
	 		if(temp.element.equals(o))
	 			return true;
	 		temp=temp.next;
	 	}
	 	return false;
	 }

    //Inserts a new Link at the first of the list
    public void insertFront(E o) {
     	Node<E> n= new Node<E>(o,first);
        first = n;
    }
    
    //function to insert rear
     public void insertRear(E o)
    {
        
        Node<E> n= new Node<E>(o,null);
        Node<E> temp=first;
        if(temp==null) 
            {
                first=n; return;
            }
             
            
        while(temp.next!=null)
        { 
            temp=temp.next;  
        }
        temp.next=n;
       
    }

//gives number of nodes in a linked list
    public int Number()
    {
    	Node<E> temp=first;
    	int i=0;

    	while(temp!=null)
    	{
    		i++;
    		temp=temp.next;
    	}
    	return i;
    }


//delete element a
      public void Delete(E o)
    {
    	if(IsMember(o))
    	{
		  Node<E> pnt=first;
		  Node<E> temp=first;

		  if(temp.element== o)
		  {first=first.next;return;}

		  temp=temp.next;

	 	while(temp != null)
	 	{
	 		if(temp.element== o)
	 			break;
	 		temp=temp.next;
	 		pnt=pnt.next;
	 	}    
        if(temp==null)
 		System.out.println("element not found in the set");
        pnt.next=temp.next;
    	}   	

    }

//concatenate 2 lists
    public void concat(MyLinkedList<E> l)
    {
        Node<E> temp=first;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=l.first;
    }

}  

