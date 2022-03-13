import java.util.*;
import java.util.Arrays;

public class TestAVLTree {

	
		// TODO Auto-generated method stub
		public static void main(String[] args) {
		    new TestAVLTree();
		  }

		  public TestAVLTree() {
			  AVLTree<Integer> tree = new AVLTree<>( new Integer[] {50,25,80,35,90,40,45,47,42,20,22});
			  tree.preorder();
			  System.out.println();
			  tree.remove(40);
			  tree.preorder();
		  }
		  
		

	}


