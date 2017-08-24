package States;

/**
 * Created by diazagasatya on 8/24/17.
 */
public class Node<Generic> {

    private Generic data; // A Generic type of data
    private Node<Generic> next; // A variable called next of type Node

    /**
     * A constructor that takes in a generic object and stores in Node's object
     * Initialize attribute country with given parameter
     * @param genericObject                              Generic type of Object
     */
    public Node(Generic genericObject) {
        this.data = genericObject; // Cast the object into a generic Node object
        this.next = null;
    }

    /**
     * A constructor that takes in two parameters, an object of type Country and an object of type Node
     * @param genericObject                                                      Generic type of Object
     * @param nodeObject                                                       Parametrized object node
     */
    public Node(Generic genericObject, Node<Generic> nodeObject) {
        this.data = genericObject;
        this.next = nodeObject; // this will connect with the calling object
    }

    /**
     * Return the object country
     * @return data      Node's object that stores the Generic's data
     */
    public Generic getData() {
        return data;
    }

    /**
     * Return the next Node's object linked to this node
     * @return next                     next node linked
     */
    public Node getNext() {
        return next;
    }

    /**
     * Set given node object parameter to link with the calling node object
     * @param nodeObject                                    the object node
     */
    public void setNext(Node nodeObject) {
        this.next = nodeObject;
    }

    /**
     * A String representation of Node's object data
     * @return fullString
     */
    @Override
    public String toString() {

        String fullString = data.toString(); // Will call the generic data toString method

        return fullString;
    }



}
