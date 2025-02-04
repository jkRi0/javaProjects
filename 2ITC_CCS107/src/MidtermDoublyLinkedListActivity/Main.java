package MidtermDoublyLinkedListActivity;

public class Main {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addNode(new ListNode());
		list.addNode(new ListNode("Anderson", "Elliot"));
		list.addNode(new ListNode("Micheal", "Brandon"));
		list.addNode(new ListNode("Rivera", "Ashley"));
		list.addNode(new ListNode("Bond", "James"));
		list.DisplayNames();
		
		//UPDATE THE LIST
		System.out.println("\nREMOVE THE SECOND NODE");
		list.RemoveSecondNode();
		list.DisplayNames();
	}
}
