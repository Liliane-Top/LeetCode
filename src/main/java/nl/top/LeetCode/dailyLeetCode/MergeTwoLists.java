package nl.top.LeetCode.dailyLeetCode;

public class MergeTwoLists {

  public static class ListNode {
    public int value;
    public ListNode next;

    public ListNode() {}

    public ListNode(int value) {
      this.value = value;
    }

    public ListNode(int value, ListNode next) {
      this.value = value;
      this.next = next;
    }
  }


  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(0);
		ListNode dummyPointer = dummy;
    ListNode pointer1 = list1;
    ListNode pointer2 = list2;
    while (pointer1 != null & pointer2 != null) {
      if (pointer1.value <= pointer2.value) {
	      dummyPointer.next = pointer1;
				pointer1 = pointer1.next;
      } else {
				dummyPointer.next = pointer2;
        pointer2 = pointer2.next;
      }
	    dummyPointer = dummyPointer.next;
    }

		if(pointer1 != null){
			dummyPointer.next = pointer1;
		}
		if(pointer2 != null){
			dummyPointer.next = pointer2;
		}
		list1 = dummy.next;
    return list1;
  }
}
