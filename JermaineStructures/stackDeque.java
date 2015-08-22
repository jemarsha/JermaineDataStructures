package fred;

class stackDeque {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;
	private int right;
	private int left;
	private long temp;

	// the list.insertfirst() use same method for push and pop as deque.
	// --------------------------------------------------------------
	public stackDeque(int s) // constructor
	{
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		left = 0;
		right = maxSize - 1;
		nItems = 0;
	}

	// --------------------------------------------------------------
	public void pop() {
		removeRight();
	}

	public void push(int k) {
		insertLeft(k);

	}

	// --------------------------------------------------------------
	public void peekFront() // peek at front of queue
	{
		System.out.println(queArray[right]);
	}

	public void peekRear() {
		System.out.println(queArray[left]);
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

	public void insertLeft(long j) {// have to make sure it is not full before
									// inserting
		if (!isFull())
			if (left == maxSize - 1)
				left = -1;
		queArray[++left] = j;
		nItems++;
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
		stackDeque theQueue = new stackDeque(3);

		theQueue.push(3);
		theQueue.push(10); // insert 3 items
		theQueue.push(20);
		theQueue.pop();

		// theQueue.insertRight(6);
		theQueue.push(30);
		theQueue.pop();

		// remove 3 items
		//

		theQueue.push(67);

		theQueue.display();

	}
}
// end main()