/** A linked list of character data objects.
 *  (Actually, a list of Node objects, each holding a reference to a character data object.
 *  However, users of this class are not aware of the Node objects. As far as they are concerned,
 *  the class represents a list of CharData objects. Likwise, the API of the class does not
 *  mention the existence of the Node objects). */
public class List {

    // Points to the first node in this list
    private Node first;

    // The number of elements in this list
    private int size;

    public static void main(String args[]) {
        List test = new List();
        test.addFirst('e');
        test.addFirst('t');
        test.first.cp.count = 2;
        test.addFirst('i');
        test.addFirst('m');
        test.first.cp.count = 2;
        test.addFirst('o');
        test.addFirst('c');
        System.out.println(test);
        System.out.println(test.getFirst());
        System.out.println(test.indexOf('m'));
    }

	
    /** Constructs an empty list. */
    public List() {
        first = null;
        size = 0;
    }

    /** Returns the number of elements in this list. */
    public int getSize() {
 	      return this.size;
    }

    /** Returns the first element in the list */
    public CharData getFirst() {
        return this.first.cp;
    }

    /** GIVE Adds a CharData object with the given character to the beginning of this list. */
    public void addFirst(char chr) {
        Node newNode = new Node(new CharData(chr));
        newNode.next=this.first;
        first=newNode;
        this.size++;
    }
    
    /** GIVE Textual representation of this list. */
    public String toString() {
        String s = "(";
        for (int i = 0; i < size; i++) {
            s += this.listIterator(i).current + " ";
        }
        return s.substring(0, s.length() - 1) + ")";
    }

    /** Returns the index of the first CharData object in this list
     *  that has the same chr value as the given char,
     *  or -1 if there is no such object in this list. */
    public int indexOf(char chr) {
        Node cur = this.first;
        int index = 0;
        while (cur != null) {
            if (cur.cp.equals(cur)) {
                return index;
            }
            cur = cur.next;
            index++;
        }
        return -1;
    }

    /** If the given character exists in one of the CharData objects in this list,
     *  increments its counter. Otherwise, adds a new CharData object with the
     *  given chr to the beginning of this list. */
    public void update(char chr) {
        if(indexOf(chr)==-1) addFirst(chr);
        else get(indexOf(chr)).count++;
    }

    /** GIVE If the given character exists in one of the CharData objects
     *  in this list, removes this CharData object from the list and returns
     *  true. Otherwise, returns false. */
    public boolean remove(char chr) {
        Node prev=null;
        Node cur=this.first;
        while (cur!=null && cur.cp.equals(chr)) {
            prev=cur;
            cur=cur.next;
        }
        if(cur==null) return false;  
        if(prev==null) this.first=this.first.next;
        else prev.next=cur.next;
        size--;
        return true;
    }

    /** Returns the CharData object at the specified index in this list. 
     *  If the index is negative or is greater than the size of this list, 
     *  throws an IndexOutOfBoundsException. */
    public CharData get(int index) {
        if(index<0 || index>this.size) throw new IndexOutOfBoundsException();
        Node cur=this.first;
        for(int i=0; i<index; i++){
            cur=cur.next;
        }
        return cur.cp;
    }

    /** Returns an array of CharData objects, containing all the CharData objects in this list. */
    public CharData[] toArray() {
	    CharData[] arr = new CharData[size];
	    Node current = first;
	    int i = 0;
        while (current != null) {
    	    arr[i++]  = current.cp;
    	    current = current.next;
        }
        return arr;
    }

    /** Returns an iterator over the elements in this list, starting at the given index. */
    public ListIterator listIterator(int index) {
	    // If the list is empty, there is nothing to iterate   
	    if (size == 0) return null;
	    // Gets the element in position index of this list
	    Node current = first;
	    int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        // Returns an iterator that starts in that element
	    return new ListIterator(current);
    }
}
