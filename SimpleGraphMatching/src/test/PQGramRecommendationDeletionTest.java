package test;

import org.junit.Test;

import tree.Tree;

public class PQGramRecommendationDeletionTest {
	int p = 2;
	int q = 3;
	
	private Tree sourceTree;
	private Tree targetTree;

	@Test
	public void testDeleteLeaf() {
		sourceTree = new Tree("a");
		sourceTree.addChild(new Tree("b"));
		sourceTree.addChild(new Tree("c"));
		sourceTree.addChild(new Tree("d"));
		
		targetTree = new Tree("a");
		targetTree.addChild(new Tree("b"));
		targetTree.addChild(new Tree("d"));
		
		TestUtilities.getEditsAndAssertSize(sourceTree, targetTree, 1);
	}
	
	@Test
	public void testDeleteRoot() {
		sourceTree = new Tree("a");
		Tree child1 = new Tree("b");
		sourceTree.addChild(child1);
		child1.addChild(new Tree("c"));
		child1.addChild(new Tree("d"));
		
		targetTree = new Tree("b");
		targetTree.addChild(new Tree("c"));
		targetTree.addChild(new Tree("d"));
		
		TestUtilities.getEditsAndAssertSize(sourceTree, targetTree, 1);
	}
	
	@Test
	public void testDeleteNonLeafNonRoot() {
		sourceTree = new Tree("a");
		Tree child1 = new Tree("b");
		sourceTree.addChild(child1);
		child1.addChild(new Tree("c"));
		child1.addChild(new Tree("d"));
		
		targetTree = new Tree("a");
		targetTree.addChild(new Tree("c"));
		targetTree.addChild(new Tree("d"));
		
		TestUtilities.getEditsAndAssertSize(sourceTree, targetTree, 1);
	}
	
	@Test
	public void testDeleteParentAndChild() {
		sourceTree = new Tree("a");
		Tree child1 = new Tree("b");
		sourceTree.addChild(child1);
		child1.addChild(new Tree("c"));
		child1.addChild(new Tree("d"));
		
		targetTree = new Tree("a");
		targetTree.addChild(new Tree("d"));
		
		TestUtilities.getEditsAndAssertSize(sourceTree, targetTree, 2);
	}
	
	@Test
	public void testDeleteSiblings() {
		sourceTree = new Tree("a");
		Tree child1 = new Tree("b");
		Tree child2 = new Tree("c");
		sourceTree.addChild(child1);
		sourceTree.addChild(child2);
		child1.addChild(new Tree("d"));
		child1.addChild(new Tree("e"));
		child2.addChild(new Tree("f"));
		child2.addChild(new Tree("g"));
		
		targetTree = new Tree("a");
		targetTree.addChild(new Tree("d"));
		targetTree.addChild(new Tree("e"));
		targetTree.addChild(new Tree("f"));
		targetTree.addChild(new Tree("g"));
		
		TestUtilities.getEditsAndAssertSize(sourceTree, targetTree, 2);
	}
	
	@Test
	public void testDeleteParentAndChildWithChildren() {
		sourceTree = new Tree("a");
		Tree child1 = new Tree("b");
		sourceTree.addChild(child1);
		Tree child2 = new Tree("c");
		child1.addChild(child2);
		child1.addChild(new Tree("e"));
		child2.addChild(new Tree("d"));
		
		targetTree = new Tree("a");
		targetTree.addChild(new Tree("d"));
		targetTree.addChild(new Tree("e"));
		
		TestUtilities.getEditsAndAssertSize(sourceTree, targetTree, 2);
	}
	
	

}
