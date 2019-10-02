
public class DNode extends Node {
	
	private DNode prev, next;
	
	public DNode (Object newItem) {
		super(newItem);
		this.prev = this;
		this.next = this;
	}
	
	public void setPrev (DNode prev) {
		this.prev= prev;
	}
	
	public DNode getPrev () {
		return prev;
	}
	
	public void setNext(DNode next) {
		this.next = next;
	}
	
	public DNode getNext() {
		return next;
	}
}
