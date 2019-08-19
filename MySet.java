public class MySet<X> extends MyLinkedList<X>{

MyLinkedList<X> L;
	
// constructor for the set
	public MySet()
	{  L=new MyLinkedList<X>(); }

// isEmpty method
	 public boolean IsEmpty()
	 { return L.isEmpty();}

// checks is e is a member of the set
	 public boolean IsMember(X o)
	 {return L.IsMember(o);}

// Inserts a new element
	void addElement(X element)
	{
		if(!(this.IsMember(element)))
		L.insertRear(element);
    }

//Deletes e from the set if it exists, returns the deleted element and updates the set
    public void Delete(X o)
    {
    	L.Delete(o);
    }

// Reads the set
    public MyLinkedList<X> ReadSet()
    {return L;}


// Finds Union of 2 sets
 	public MySet<X> union(MySet<X> otherSet)
    {

    	Node<X> temp=otherSet.L.first;
	 	while(temp != null)
	 	{
	 		if(!this.IsMember(temp.element))
	 		this.addElement(temp.element);
	 		temp=temp.next;
	 	}
        
        return this;
    }


// Finds Intersection of 2 sets
    public MySet<X> intersection(MySet<X> otherSet)
    {
    	MySet<X> M = new MySet<X>();

    	Node<X> temp=L.first;
	 	while(temp != null)
	 	{
	 		if(otherSet.IsMember(temp.element))
	 		M.addElement(temp.element);
	 		temp=temp.next;
	 	}
        
        return M;
    } 

}