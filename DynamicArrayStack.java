public class DynamicArrayStack<AnyType> implements Stack<AnyType> {
	public static final int DEFAULT_CAPACITY = 256;		// the size() of elements
    private AnyType[] data;		// elements of the list
    private int topOfStack ;		// current topOfStack of elements
    public DynamicArrayStack() { this(DEFAULT_CAPACITY); }
    public DynamicArrayStack(int capacity) {			// set the size() of the DynamicArray
        topOfStack=-1;
        data = (AnyType[]) new Object[capacity];
    }
    public int size() {	
		return data.length;					// return the size() of the stack
	}	
    public boolean isEmpty() {			
        return (topOfStack == -1);			// check if the topOfStack is -1
    }
    public void push(AnyType newValue)
    {
    	if (topOfStack== size() -1) resize(2 * data.length);
    	topOfStack++;						// increment the index every time add an element
    	data[topOfStack] = newValue;		// store the element into the stack
        					

    
    }

    public AnyType top()
    {
    	 if (this.isEmpty()) { 					// check if there is any element in the stack
         	return null; 						// if stack is empty then return null
         }
         return this.data[topOfStack];			// 	else then return the data on top of the stack
    } 
   

    public AnyType pop()
    {
    	if(isEmpty()){						// check if there is any element in the stack
    		return null;					// if stack is empty then return null
    	}
    	AnyType temp=data[topOfStack];		// save the element form top of stack
    	data[topOfStack]=null;				// set top of the stack to null
    	topOfStack--;						// decrement top of the stack 
    	
    	return temp;						// return what was on top of the stack
    		
     
    }
	
	protected void resize(int newCapacity){
		int n = size();
	    AnyType[] temp = (AnyType[]) new Object[newCapacity];
	    for (int i=0; i < n; i++)
	      temp[i] = data[i];
	    data = temp;
	}
}

