import static org.junit.Assert.*;

import org.junit.Test;


public class NodeTests {
	
	private static Node<Integer> n(int value, Node<Integer> left, Node<Integer> right) {
		return new Node<Integer>(value, left, right);
	}
	@Test
	public void test() {
		Node<Integer> puu = n(1,
				n(2, n(4, null, null),null),
				n(3, null, null));
		
		System.out.println(puu);
		assertEquals(false, puu.contains(5));
		
	}


}
