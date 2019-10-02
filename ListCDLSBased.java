
/*
 * Purpose: Data Structure and Algorithms Lab 4 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 09/23/19
 * Submitted:  10/1/19
 * @author: Nick Setaro
 * @version: 2019.10.01
 */

public class ListCDLSBased implements ListInterface {
	
	DNode tail = null;
	int numItems = 0;
	
	public ListCDLSBased () {
		
	}
	
	public void add(int index, Object item) throws ListIndexOutOfBoundsException{
		if (isValidIndex(index)) {
			DNode newNode = new DNode(item);
			DNode curr = find(index);
			if (index == numItems) {
				tail.setPrev(newNode);
				newNode.setNext(tail);
				curr.setNext(newNode);
				newNode.setPrev(curr);
			} else {
				curr.getPrev().setNext(newNode);
				newNode.setPrev(curr.getPrev());
				newNode.setNext(curr);
				curr.setPrev(newNode);
			}
			if (index == 0) {
				tail = newNode;
			}
		
		} else {
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on add.");
		}
	}
	
	public void remove(int index) throws ListIndexOutOfBoundsException{
		
		if (isValidIndex(index)) {
			
			DNode curr = find(index);
			
			if (index == 0) {
				tail = curr.getNext();
			} else {
	
			}			
			curr.getNext().setPrev(curr.getPrev());
			curr.getPrev().setNext(curr.getNext());
			numItems--;
		} else {
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on remove.");
		}
	}
	
	public boolean isEmpty() {
		
		if (tail == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Object get(int index) throws ListIndexOutOfBoundsException {
		
		if (isValidIndex(index)) {
			
			DNode curr = tail;
			for (int i = 0; i < index; i++) {
				curr = tail.getNext();
			}
			return curr;
		} else {
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on get.");
		}
	}
	
	public void removeAll() {
		tail = null;
		numItems = 0;
	}

	public int size() {
		return numItems;
	}
	
	private boolean isValidIndex(int index) {
		
		if (index >= 0 && index <= numItems) {
			return true;
		} else {
			return false;
		}
		
	}
	
	private DNode find(int index)
    {
        DNode curr = tail;
        for (int skip = 0; skip < index; skip++)
        {
            curr = curr.getNext();
        } // end for
        return curr;
    } // end find
	
	public String toString() {
		String s = "";
		DNode curr = tail;
		for (int i = 0; i < numItems; i++) {
			s = s + curr.getItem() + " ";
			curr = curr.getNext();
		}
		return s;
	}
}
