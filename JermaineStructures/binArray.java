package many;

class OrdArray {
	private long[] a; // ref to array a
	private int nElems; // number of data items

	// -----------------------------------------------------------
	public OrdArray(int max) // constructor
	{
		a = new long[max]; // create array
		nElems = 0;
	}

	// -----------------------------------------------------------
	public int size() {
		return nElems;
	}

	// -----------------------------------------------------------
	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curIn;

		while (true) {
			curIn = (lowerBound + upperBound) / 2;
			if (a[curIn] == searchKey)
				return curIn; // found it
			else if (lowerBound > upperBound)
				return nElems; // can't find it
			else // divide range
			{
				if (a[curIn] < searchKey)
					lowerBound = curIn + 1; // it's in upper half
				else
					upperBound = curIn - 1; // it's in lower half
			} // end else divide range
		} // end while
	} // end find()

	// -----------------------------------------------------------
	public void insert(long value) // put element into array
	{
		int j=0;
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curIn=0;

		while (lowerBound<= upperBound) {
			curIn = (lowerBound + upperBound) / 2;
			if (a[curIn] == value)
				break; // found it
			 if (a[curIn]> lowerBound)
				 lowerBound=curIn+1;
			 
			 if(a[curIn]<upperBound)
				 upperBound=curIn-1;
				 // can't find it
			
		} // end while
		if(a[curIn]==0)
			a[curIn]=value;
		else
			j=curIn;
	 // end find()
		for (j = 0; j < nElems; j++)
			// find where it goes
			if (a[j] > value) // (linear search)
				break;
		for (int k = nElems; k > j; k--)
			// move bigger ones up
			a[k] = a[k - 1];
		a[j] = value; // insert it
		nElems++; // increment size
	} // end insert()

	// -----------------------------------------------------------
	public boolean delete(long value) {
		int j = find(value);

		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curIn;

		while (true) {
			curIn = (lowerBound + upperBound) / 2;
			if (a[curIn] == value) {
				// found it
				for (int k = j; k < nElems; k++)
					// move bigger ones down
					a[k] = a[k + 1];
				nElems--; // decrement size
				return true;

			} else if (lowerBound > upperBound || j == nElems)
				return false; // can't find it

			if (a[curIn] < value)
				lowerBound = curIn + 1; // it's in upper half
			else
				upperBound = curIn - 1; // it's in lower half
		} // end else divide range
	} // end while

	// end delete()

	// -----------------------------------------------------------
	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++)
			// for each element,
			System.out.print(a[j] + " "); // display it
		System.out.println("");
	}
	// -----------------------------------------------------------
} // end class OrdArray
// //////////////////////////////////////////////////////////////

class OrderedApp {
	public static void main(String[] args) {
		int maxSize = 100; // array size
		OrdArray arr; // reference to array
		arr = new OrdArray(maxSize); // create the array

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

		int searchKey = 55; // search for item
		if (arr.find(searchKey) != arr.size())
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can't find " + searchKey);

		arr.display(); // display items

		arr.delete(00); // delete 3 items
		arr.delete(55);
		arr.delete(99);

		arr.display(); // display items again
	} // end main()
} // end class OrderedApp

