package qu;

class display {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;

	// --------------------------------------------------------------
	public display(int s) // constructor
	{
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	// --------------------------------------------------------------
	public void insert(long j) // put item at rear of queue
	{
		if (rear == maxSize - 1) // deal with wraparound
			rear = -1;
		queArray[++rear] = j; // increment rear and insert
		nItems++; // one more item
	}

	// --------------------------------------------------------------
	public long remove() // take item from front of queue
	{
		long temp = queArray[front++]; // get value and incr front
		if (front == maxSize) // deal with wraparound
			front = 0;
		nItems--; // one less item
		return temp;
	}

	// --------------------------------------------------------------
	public long peekFront() // peek at front of queue
	{
		return queArray[front];
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
} // end
// //////////////////////////////////////////////////////////////

class QueueApp {
	public static void main(String[] args) {
		display theQueue = new display(5); // queue holds 5 items

		theQueue.insert(10); // insert 4 items
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(40);

		theQueue.remove(); // remove 3 items
		theQueue.remove(); // (10, 20, 30)
		theQueue.remove();

		theQueue.insert(50); // insert 4 more items
		theQueue.insert(60); // (wraps around)
		theQueue.insert(70);
		theQueue.insert(80);
		theQueue.display();

		System.out.println("");
	} // end main()
}
// //////////////////////////////////////////////////////////////