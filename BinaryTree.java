
public class BinaryTree {

	public Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	public void insert(String newRecord) {
		root = subtreeInsert(root, newRecord);
	}
	
	private Node subtreeInsert(Node topNode, String newRecord) {
		if (topNode == null) {
			topNode = new Node(newRecord);
		} else if (newRecord.compareTo(topNode.record)<0) {
			topNode.left = subtreeInsert(topNode.left, newRecord);
		} else {
			topNode.right = subtreeInsert(topNode.right, newRecord);
		}
		return topNode;
	}
	
	public void inOrder() {
		inOrderSubtree(root);
	}
	
	private void inOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			inOrderSubtree(topNode.left);
			System.out.print(topNode.record + " ");
			inOrderSubtree(topNode.right);
		}
	}
	
	public void preOrder() {
		preOrderSubtree(root);
	}
	
	private void preOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			System.out.print(topNode.record + " ");
			preOrderSubtree(topNode.left);

			preOrderSubtree(topNode.right);
			}
		}

	public void postOrder() {
		postOrderSubtree(root);
	}
	
	private void postOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			postOrderSubtree(topNode.left);
			postOrderSubtree(topNode.right);
			System.out.print(topNode.record + " ");

			}
		}
	
	public int size() {
		return subtreeSize(root);
	}
	
	private int subtreeSize(Node topNode) {
		if (topNode == null) {
			return 0;
		} else {
			 return(subtreeSize(topNode.left) + subtreeSize(topNode.right) + 1);			
		}
	}
		
	public int maxDepth() {
		return subtreeMaxDepth(root);
	}
	
	private int subtreeMaxDepth(Node topNode) {
		int kl;
		int kr;
		if (topNode == null) {
			return 0;
		} else {
			kl = subtreeMaxDepth(topNode.left);
			kr = subtreeMaxDepth(topNode.right);
			if (kl > kr) {
				return (kl+1);
			} else {
				return (kr+1);
			}
		}
	}
	public int minDepth() {
		return subtreeMinDepth(root);
	}
	private int subtreeMinDepth(Node topNode) {
		int kl;
		int kr;
		if (topNode == null) {
			return 0;
		} else {
			kl = subtreeMinDepth(topNode.left);
			kr = subtreeMinDepth(topNode.right);
			if (kl >= kr) {
				return (kr + 1);
			} else {
				return (kl + 1);
			}
		}
	}
	public int countMatches(String key) {
		return subtreeCountMatches(root, key); 
	}
	private int subtreeCountMatches(Node topNode, String key) {
		if (topNode == null) {
			return 0;
		} else {
			if (topNode.record.equals(key)) {
				return (1+subtreeCountMatches(topNode.left, key)+ subtreeCountMatches(topNode.right, key));
			} else {
				return (subtreeCountMatches(topNode.left,key)+ subtreeCountMatches(topNode.right,key));
			}
		}
	}
}
