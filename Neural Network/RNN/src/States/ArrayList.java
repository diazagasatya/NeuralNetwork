package States;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by diazagasatya on 8/24/17.
 */
public class ArrayList<Generic> implements Iterable<Generic>{

    private Node<Generic> head; // A variable that represents the head of the list (start node)
    private Node<Generic> tail; // A variable that represents the tail of the list (end node)
    private int elementCount; // A variable that will count the number of nodes in list

    /**
     * Creates an empty ArrayList object
     */
    public ArrayList() {
        this.head = null; // Sets the head to beginning of the node
        this.elementCount = 0; // Initialize element count
    }

    /**
     * Adds a new Node object containing a generic's data to the end of the list
     * @param genericObject            Node's object
     */
    public void add(Generic genericObject) {
        // Creates a new object of Node to store parameter object
        Node newNode = new Node(genericObject);
        Node current = head;

        // If the LinkedList is empty
        if (this.isEmpty()) {
            head = newNode;
            this.elementCount++; // add elementCount every time a Node is added to the list
        }
        else if (elementCount == 1) { //
            // If we reach here the node isn't empty
            current.setNext(newNode);
            tail = current.getNext(); // initialize tail to reference the latest insertion
            this.elementCount++;
        }
        else {
            tail.setNext(newNode);
            tail = tail.getNext(); // Always set tail to be the end of linked list
            this.elementCount++;
        }
    }

    /**
     * Insert a new Node containing Generic's data at the specified location by index
     * @param genericObject                                    Generic type of object
     * @param index                                                   index specified
     */
    public void insertAtIndex(Generic genericObject, int index) {
        // Create a reference to traverse the list
        Node walker = head;
        Node after = head;

        // Instantiate a new Node object to store Country object
        Node newNode = new Node(genericObject);
        int element = 0;

        if(index == 0) {
            newNode.setNext(head);
            head = newNode;
            elementCount++;
        }
        else if(index > elementCount) {
            tail.setNext(newNode);
            tail = tail.getNext(); // Always set tail to the end of linked list
            elementCount++;
        }
        else {
            while((index - 1) != element) {
                walker = walker.getNext();
                after = walker.getNext();
                element++;
            }
            walker.setNext(newNode);
            newNode.setNext(after);
            elementCount++;
        }
    }

    /**
     * Returns a Generic Object from a given index
     * Checks the validity of the index, if invalid throw an IndexOutOfBoundsException
     * @param index                                                  Number of element
     * @return walker                                                   Generic object
     */
    public Generic getIndex(int index) throws IllegalArgumentException {
        // Creates a walker that will travel through the list
        Node walker = head;
        int element = 0;

        if (!(indexValidity(index))) {
            throw new IllegalArgumentException();
        }
        //Traverse the list until either walker reaches the end of the list or we've reached clients index of interest
        while(walker != null) {
            if(element == index)
                return (Generic)walker.getData();

            //Travel through the list until it reach client's index
            walker = walker.getNext();
            element++;
        }
        return null;
    }

    /**
     * Takes a generic object as parameter and checks if the object can be found in the linked list
     * @param genericObject                                                          Generic object
     * @return targetObject                                    Target Object after equal validation
     */
    public Generic contains(Generic genericObject) {
        // Create a node object reference to travel in the list
        Node<Generic> walker = head;
        Generic targetObject;

        // Walker will travel through the list until it founds the equal object
        while(walker != null) {
            if(walker.getData().equals(genericObject)) {
                targetObject = walker.getData(); // Get the data of the equal Node's object
                return targetObject;
            }
            // Move on to the next node
            walker = walker.getNext();
        }
        return null;
    }

    /**
     * Returns a string containing information about every data in the Linked list
     * Traversing all the nodes and printing each one
     * @return allData                       Information of every data in the list
     */
    public String toString() {
        String allData = "\n";

        // Create a walker to travel the list
        Node walker = head;

        while(walker != null) {
            allData += walker.getData().toString() + "\n";
            walker = walker.getNext();
        }
        return allData;
    }

    /**
     * Returns the number of nodes in linked list
     * @return elementCount         number of nodes added in the list
     */
    public int size() {
        return elementCount;
    }

    /**
     * Returns Iterator object of type class ListIterator.
     * ListIterator returns a new iterator object that starts at the beginning of the list.
     * @return iteratorObject                                          ListIterator object
     */
    @Override
    public Iterator<Generic> iterator() {
        // Creates an Iterator object from class List Iterator
        return new ListIterator();
    }

    /**
     * An inner class of LinkedList that is used to traverse the collection of objects in the list.
     */
    public class ListIterator implements Iterator<Generic>  {
        // A generic field called current that keeps track of the current location being traversed.
        private Node<Generic> current;

        // A constructor that initializes current to the beginning of the list.
        public ListIterator() {
            current = head;
        }

        /**
         * Checks if there's a next value stored in the list
         * @return condition            True/False condition
         */
        @Override
        public boolean hasNext() {
            if(current == null)
                return false;
            return true;
        }


        /**
         * A method that returns the next object in the list.
         * @return nextObject                Next Node Object
         */
        @Override
        public Generic next() {
            // Catch null exceptions for error
            if(!this.hasNext())
                throw new NoSuchElementException();

            // Creates a new object reference to the next node of the list
            Generic nextObject = current.getData();

            // Move the current walker to the next node for future use
            current = current.getNext();

            return nextObject;
        }
    }

    /**
     * Check's if the head is pointing to any node
     * @return condition          boolean validity
     */
    public boolean isEmpty() {
        boolean condition = false;

        if (head == null) {
            condition = true;
            return condition;
        }
        return condition;
    }

    /**
     * Checks the validity of index given from client
     * @param index                  Number of element
     * @return condition          True/False condition
     */
    public boolean indexValidity(int index) {

        if (index < 0) {
            return false;
        } else if (index >= elementCount) {
            return false;
        }
        // Validity pass
        return true;
    }


}
