package nl.top.LeetCode.dailyLeetCodeTests;

import static nl.top.LeetCode.dailyLeetCode.MergeTwoLists.*;

import nl.top.LeetCode.dailyLeetCode.MergeTwoLists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeTwoListsTests {

  @Test
  void call_mergeTwoLists() {
    ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
    ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
    ListNode output = MergeTwoLists.mergeTwoLists(list1, list2);
    Assertions.assertEquals(1, output.value);
    Assertions.assertEquals(1, output.next.value);
	  Assertions.assertEquals(2, output.next.next.value);
	  Assertions.assertEquals(3, output.next.next.next.value);
	  Assertions.assertEquals(4, output.next.next.next.next.value);
	  Assertions.assertEquals(4, output.next.next.next.next.next.value);

		ListNode list3 = new ListNode();
		ListNode list4 = new ListNode();
		ListNode output2 = MergeTwoLists.mergeTwoLists(list3, list4);
    Assertions.assertEquals(new ListNode().value, output2.value);
  }
  }
