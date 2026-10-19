
public class PriorityTokenInsertion {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        Node head;

        // Insert token at the beginning
        void addFirst(int token) {
            Node newNode = new Node(token);
            newNode.next = head;
            head = newNode;
        }

        // Insert token at the end
        void addLast(int token) {
            Node newNode = new Node(token);

            if (head == null) {
                head = newNode;
                return;
            }

            Node current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        // Insert token at a specified 0-based index
        void insertAt(int index, int token) {
            if (index < 0) {
                throw new IndexOutOfBoundsException("Invalid index");
            }

            if (index == 0) {
                addFirst(token);
                return;
            }

            Node current = head;

            for (int i = 0; i < index - 1; i++) {
                if (current == null) {
                    throw new IndexOutOfBoundsException("Invalid index");
                }
                current = current.next;
            }

            if (current == null) {
                throw new IndexOutOfBoundsException("Invalid index");
            }

            Node newNode = new Node(token);
            newNode.next = current.next;
            current.next = newNode;
        }

        // Display the list
        void display() {
            Node current = head;

            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }

            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Starting list: 101 -> 102 -> 103
        list.addLast(101);
        list.addLast(102);
        list.addLast(103);

        // Perform the given operations
        list.addFirst(100);
        list.addLast(104);
        list.insertAt(2, 150);

        // Print the final list
        list.display();
    }
}
