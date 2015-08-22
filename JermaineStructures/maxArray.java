package alphaphi;

class maxArray {
	private long[] a; //  to array a
	private int nElems; // number of data items

	// -----------------------------------------------------------
	public maxArray(int max) // constructor
	{
		a = new long[max]; // create the array
		nElems = 0; // no items yet
	}

	// -----------------------------------------------------------
	public boolean find(long searchKey) { // find specified value
		int j;
		for (j = 0; j < nElems; j++)
			// for each element,
			if (a[j] == searchKey) // found item?
				break; // exit loop before end
		if (j == nElems) // gone to end?
			return false; // yes, can't find it
		else
			return true; // no, found it
	} // end find()

	// -----------------------------------------------------------
	public void insert(long value) // put element into array
	{
		a[nElems] = value; // insert it
		nElems++; // increment size
	}

	// -----------------------------------------------------------
	public boolean delete(long value) {
		int j;
		for (j = 0; j < nElems; j++)
			// look for it
			if (value == a[j])
				break;
		if (j == nElems) // can't find it
			return false;
		else // found it
		{
			for (int k = j; k < nElems; k++)
				// move higher ones down
				a[k] = a[k + 1];
			nElems--; // decrement size
			return true;
		}
	} // end delete()

	// -----------------------------------------------------------
	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++)
			// for each element,
			System.out.print(a[j] + " "); // display it
		System.out.println("");
	}
	public void getmax()
	{
	long max=a[0];
		for (int i=1; i<nElems; i++)
		{
			if (a[i]>max)
			max=a[i];
			else
				if(a==null)
					System.out.println(-1);
		}
		System.out.println(max+ " ");
		
		}
	}
//}
	// -----------------------------------------------------------
 // end class HighArray
// //////////////////////////////////////////////////////////////

class HighArrayApp {
	public static void main(String[] args) {
		int maxSize = 100; // array size
		maxArray arr; // reference to array
		arr = new maxArray(maxSize); // create the array

		arr.insert(77); // insert 10 items
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		
		arr.insert(33);
		arr.getmax();
		arr.display(); // display items

		int searchKey = 35; // search for item
		if (arr.find(searchKey))
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can't find " + searchKey);

		arr.delete(00); // delete 3 items
		arr.delete(55);
		arr.delete(99);
		arr.getmax();
		arr.display(); // display items again
		
	} // end main()
} // end class HighArrayApp


