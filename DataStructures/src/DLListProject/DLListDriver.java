package DLListProject;

public class DLListDriver {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> testList = new DoublyLinkedList<Integer>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.printList();
        testList.reverse();
        System.out.println("");
        testList.printList();
    }





}
