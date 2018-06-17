import java.util.*;
class BinaryTree2{
	static Node root;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);


		addToBT("ritika", 19);
		addToBT("cool guy", 21);
		addToBT("rishahb", 17);
		//addToBT("ritika", 4);
		addToBT("rishahb", 16);
		addToBT("rishahb", 18);
		addToBT("rishahb", 12);
		//addToBT("rishahb", 18);
		//addToBT("anushka", 1);
		//addToBT("rishahb", 2);
		inOrder(root);
		System.out.println(isBalanced(root));
		System.out.println(height(root));

		System.out.println(isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	static boolean isBSTUtil(Node node, int min, int max)
	{
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.val < min || node.val > max)
			return false;

        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.leftChild, min, node.val-1) &&
        	isBSTUtil(node.rightChild, node.val+1, max));
    }

    static boolean isBalanced(Node node){
    	if(node == null)
    		return true;
    	else if(node.leftChild != null && node.rightChild == null || 
    		node.leftChild == null && node.rightChild != null)
    		return false;
    	else{
    		return (isBalanced(node.leftChild) && isBalanced(node.rightChild));
    	}
    }

    static int max(int a, int b){
    	return a>b? a : b;
    }

    static int height(Node node){
    	if(node == null){
    		return 0;
    	}
    	else{
    		return 1 + max(height(node.leftChild), height(node.rightChild));
    	}
    }

    public static void addToBT(String name, int val){
    	Node newNode = new Node(name, val);
    	if(root == null){
    		root = newNode;
    	}
    	else{
    		Node focusNode = root;
    		Node parent;
    		while(true){
    			parent = focusNode;
    			if(focusNode.val > val){
    				focusNode = focusNode.leftChild;

    				if(focusNode == null){
    					parent.leftChild = newNode;
    					return;
    				}
    			} else{
    				focusNode = focusNode.rightChild;
    				if(focusNode == null){
    					parent.rightChild = newNode;
    					return;
    				}
    			}
    		}
    	}
    }


    static public void inOrder(Node root){
    	if(root!=null){
    		inOrder(root.leftChild);
    		System.out.println(root);

    		inOrder(root.rightChild);
    	}
    }
    static public void preOrder(Node root){
    	if(root!=null){
    		System.out.println(root);

    		inOrder(root.leftChild);
    		inOrder(root.rightChild);
    	}
    }
    static public void postOrder(Node root){
    	if(root!=null){
    		inOrder(root.leftChild);

    		inOrder(root.rightChild);
    		
    		System.out.println(root);
    	}
    }

}

class Node{
	String name;
	int val;
	Node leftChild;
	Node rightChild;
	Node(String name, int val){
		this.name = name;
		this.val = val;
	}

	public String toString(){
		return name+"has a value of " + val;
	}
}