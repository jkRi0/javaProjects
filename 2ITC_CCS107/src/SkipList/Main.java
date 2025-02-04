package SkipList;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int length;
        int number;
        int nodesToSkip = 0;
        int lastValue = 0;
        char choice;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedList linkedList = new LinkedList();
        SkipList skipList = new SkipList();

        System.out.print("How many nodes? ");
        length = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= length; i++) {
            System.out.print("Enter a number: ");
            number = Integer.parseInt(reader.readLine());
            Node node = new Node(number);
            linkedList.addNode(node);
        }

        System.out.print("\nSorting the list...");
        linkedList.bubbleSort();
        linkedList.displayList();

        do {
            System.out.print("\nMENU");
            System.out.print("\n[1] Add Node");
            System.out.print("\n[2] Display List");
            System.out.print("\n[3] Create Skip List");
            System.out.print("\n[4] Display Skip List");
            System.out.print("\n[5] Exit");
            System.out.print("\nSelect an operation: ");

            choice = reader.readLine().charAt(0);

            switch (choice) {
                case '1': // adds a new node to the linked list
                    do {
                        System.out.print("Enter a number: ");
                        number = Integer.parseInt(reader.readLine());

                        Node currentNode = linkedList.getHead();
                        while (currentNode.getNext() != null)
                            currentNode = currentNode.getNext();

                        lastValue = currentNode.getData();

                        if (lastValue >= number)
                            System.out.print("Number must be higher than the last value.");

                    } while (lastValue >= number);

                    Node node = new Node(number);
                    linkedList.addNode(node);

                    if (skipList.getHead() != null) {
                        SkipNode currentSkipNode = skipList.getHead();
                        while (currentSkipNode.getNext() != null)
                            currentSkipNode = currentSkipNode.getNext();

                        Node currentNode = currentSkipNode.getBottom();

                        for (int i = 1; i <= nodesToSkip + 1; i++) {
                            if (currentNode != null)
                                currentNode = currentNode.getNext();
                        }

                        if (currentNode != null) {
                            SkipNode skipNode = new SkipNode();
                            skipNode.setData(currentNode.getData());
                            skipNode.setBottom(currentNode);
                            skipList.addNode(skipNode);
                        }
                    }
                    break;

                case '2': // displays the data of the linked list
                    linkedList.displayList();
                    break;

                case '3': // creates a skip list
                    if (skipList.getHead() != null)
                        System.out.print("Already created a skip list.");
                    else {
                        nodesToSkip = (int) Math.sqrt(linkedList.getLength());

                        SkipNode skipNode = new SkipNode();
                        skipNode.setData(linkedList.getHead().getData());
                        skipNode.setBottom(linkedList.getHead());
                        skipList.addNode(skipNode);

                        Node currentNode = linkedList.getHead();

                        while (currentNode != null) {
                            for (int i = 1; i <= nodesToSkip + 1; i++) {
                                if (currentNode != null)
                                    currentNode = currentNode.getNext();
                                else
                                    break;
                            }

                            if (currentNode != null) {
                                skipNode = new SkipNode();
                                skipNode.setData(currentNode.getData());
                                skipNode.setBottom(currentNode);
                                skipList.addNode(skipNode);
                            }
                        }
                    }
                    System.out.print("Skip list created!");
                    break;

                case '4': // displays the data of the skip list
                    skipList.displayList();
                    break;

                case '5': // exits the program
                    System.out.print("Good bye!");
                    break;

                default:
                    System.out.print("Invalid choice!");
            }
        } while (choice != '5');
    }
}
