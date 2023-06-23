

public class LinkedList{
    //Definition of singly linked list
    class Node{
        int val;
        Node next;
        Node() {}
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    //you can either make it static or non-static
    //here the node is static so it can be called directly in the main to test code
    static Node head;
    private int size;

    /**
     * Default constructor that instantiate the head of your linked list
     */
    public LinkedList(){
        head = null;
        size = 0;
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Add node of type int at the end of the list (5%)
     * @param val int to be added
     */
    public void add(int val) {
        if (head == null) {
        	head = new Node(val);
        }
        
        Node prev = head;
        for(int i = 0; i < size; i++) {
        	prev = prev.next;
        }
        Node node = new Node(val);
        prev.next = node;
        ++size;
        //throw new UnsupportedOperationException("Not yet implemented");

    }

    /**
     * Add node of type int at the given index (5%)
     * @param val int to be added
     * @param position where index to be added
     */
    public void add(int val, int position) {
        if(position == 0) {
        	Node node = new Node(val);
        	node.next = head;
        	head = node;
        	++size;
        } else {
        	Node prev = head;
        	for(int i = 0; i < position - 1; i++) {
        		prev = prev.next;
        	}
        	Node node = new Node(val);
        	node.next = prev.next;
        	prev.next = node;
        	++size;
        }
        //throw new UnsupportedOperationException("Not yet implemented");

    }

    /**
     * Remove and return the node of type int (10%)
     * @param position index to be deleted
     * @return removed linked list
     */
    public Node remove(int position) {
        if (position == 0) {
        	Node node = head;
        	head = head.next;
        	--size;
        	return node;
        } else {
        	Node prev = head;
        	for(int i = 0; i < position - 1; i++) {
        		prev = prev.next;
        	}
        	Node node = prev.next;
        	prev.next = node.next;
        	--size;
        	return node;
        }
        //throw new UnsupportedOperationException("Not yet implemented");

    }

    /**
     * Reverse and return the new head (15%)
     * @param head list to be reversed
     * @return new linked list
     */
    public Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while(current != null) {
        	next = current.next;
        	current.next = prev;
        	prev = current;
        	current = next;
        }
        head = prev;
        return head;
        //throw new UnsupportedOperationException("Not yet implemented");

    }

    /**
     * Function you need to implement (20% of the grade)
     * @param head from singly linked list
     * @return true if the linked list is palindrome
     */
    public boolean isPalindrome(Node head){
        if(head == null) {
        	return true;
        }
        Node p = head;
        Node prev = new Node(p.next.val);
        while(p.next != null) {
        	Node temp = new Node(p.next.val);
        	temp.next = prev;
        	prev = temp;
        	p = p.next;
        }
        Node p1 = head;
        Node p2 = prev;
        while(p1 != null) {
        	if(p1.val != p2.val) {
        		return false;
        	}
        	p1 = p1.next;
        	p2 = p2.next;
        }
        return true;
        //throw new UnsupportedOperationException("Not yet implemented");

    }

    /**
     * convert the binary numbers of a linked list from base 2 to base 10 decimals
     * @param head head node of the list
     * @return decimals in base 10
     */
    public int getDecimalValue(Node head) {
    	int value = 0;
        while(head != null) {
        	value = value * 2 + head.val;
        	head = head.next;
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node node = head;
        while (node != null) {
            result.append(node.val).append("->");
            node = node.next;
        }
        result.append("NULL");
        return result.toString();
    }

    public static void main(String[] args) {
        //Modify the main as needed
        LinkedList myList = new LinkedList();
        myList.add(1);
        myList.add(3);
        myList.add(2);
        myList.add(1);
        System.out.print("Add list:  ");
        System.out.println(myList);

        System.out.print("Add 2 at index 1:  ");
        myList.add(2,1);
        System.out.println(myList);

        System.out.print("Remove element at index 4:  ");
        head = myList.remove(4);
        System.out.println(myList);

        System.out.print("Reverse list:  ");
        head = myList.reverse(head);
        System.out.println(myList);
        
        //generating new list to test isPalindrome function
        LinkedList myList2 = new LinkedList();
        myList2.add(1);
        myList2.add(2);
        myList2.add(3);
        myList2.add(2);
        myList2.add(1);
        if(myList2.isPalindrome(head)){
        	System.out.println("false");
        } else {
        	System.out.println("true");
        }
        
        //generating new list to test getDecimalValue function
        LinkedList myList3 = new LinkedList();
        myList3.add(1);
        myList3.add(0);
        myList3.add(1);
        System.out.println(myList3.getDecimalValue(head));

    }
}