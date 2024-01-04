package lab8;

/**
 * Subclass of IntList that guarantees that the elements are always in ascending
 * order.
 */
public class IntListSorted extends IntList {
	/**
	 * Constructs an empty list.
	 */
	public IntListSorted() {
		super();
	}

	/**
	 * Adds a new item to this list, inserting it so that the list remains sorted.
	 */
	@Override
	public void add(int newItem) {
		if (size() == 0 || get(size() - 1) <= newItem) {
			super.add(newItem);
		} else {
			int i = size();
			while (i > 0 && newItem < get(i - 1)) {
				i -= 1;
			}

			// now i is 0, or newItem >= list[i - 1], so put the new
			// element at position i
			super.insert(i, newItem);
		}
	}

	/**
	 * Inserts a new item in this list, inserting it so that the list remains
	 * sorted. (The given index is ignored.)
	 */
	@Override
	public void insert(int index, int newItem) {
		this.add(newItem);
	}
	
	/**
	 * Use the get method in IntList to get the first number in the arraylist
	 */
	@Override
	public int getMinimum() {
		return this.get(0);
	}
	
	
	/**
	 * Use size method in the IntList class to find the size of arraylist and set it to a varable
	 * Use the length varable to find the last number by minusing the length by 1
	 */
	@Override
	public int getMaximum() {
		int length = this.size();
		return this.get(length - 1);
	}
	
	/**
	 * returns the median of the listArray
	 * @return
	 */
	public int getMedian() {
		int length = size();
		return this.get((length-1)/2);
	}
	
	
}