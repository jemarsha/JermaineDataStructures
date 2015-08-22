package campingwithqu;

class deque {

	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;
	private int right;
	private int left;
	private long temp;

	// --------------------------------------------------------------
	public deque(int maSize) // constructor
	{
		maxSize = maSize;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
		left = 0;
		right = maxSize - 1;

	}

	// --------------------------------------------------------------
	public boolean isEmpty() // true if queue is empty
	{
		return (nItems == 0);
	}

	// --------------------------------------------------------------
	public boolean isFull() // true if queue is full
	{
		return (nItems == maxSize);
	}

	// --------------------------------------------------------------

	public void insertLeft(long j) {
		if (!isFull()) {
			if (left == 0)
				left = maxSize;
			queArray[--left] = j;
			nItems++;
		}
	}

	public long removeRight() {
		long temp = -1;

		// make sure it is not empty first
		if (!isEmpty()) {
			temp = queArray[right];

			if (right == 0)
				right = maxSize;
			--right;
			nItems--;
		}
		// need to increment front after you remove an item
		return temp;
	}

	public void insertRight(long i) {
		if (!isFull()) {
			if (right == maxSize - 1)
				right = -1;
			queArray[++right] = i;
			nItems++;
		}
	}

	public long removeLeft() {
		long temp = -1;
		if (!isEmpty()) {
			temp = queArray[left];

			if (left == maxSize - 1)
				left = -1;
			++left;
			nItems--;
		}
		return temp;
	}

	public void display() {
		int i = front;
		do {

			System.out.print(queArray[i] + " ");
			i++;
			if (i >= maxSize) {
				i = 0;

			}
		} while (i != (rear + 1) % maxSize);
	}
	// --------------------------------------------------------------
} // end class
// //////////////////////////////////////////////////////////////

class QueueApp {
	public static void main(String[] args) {
		deque theQueue = new deque(7); // queue holds 7 items

		theQueue.insertLeft(10); // insert 4 items
		theQueue.insertRight(20);
		theQueue.insertLeft(30);
		theQueue.insertRight(40);

		theQueue.removeLeft(); // remove 3 items
		theQueue.removeRight(); // (10, 20, 30)
		theQueue.removeLeft();

		theQueue.insertRight(50); // insert 4 more items
		theQueue.insertLeft(60); // (wraps around)
		theQueue.insertRight(70);
		theQueue.insertLeft(80);
		theQueue.insertRight(27);
		theQueue.insertLeft(100);
		theQueue.display();

		System.out.println("");
	} // end main()

}