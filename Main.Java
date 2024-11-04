public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Adding nodes to the tree
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Testing findMax() function
        System.out.println("Max value in the tree: " + bst.findMax());

        // Testing preOrderTraversal() function
        System.out.println("Preorder Traversal: " + bst.preOrderTraversal());

        // Testing postOrderTraversal() function
        System.out.println("Postorder Traversal: " + bst.postOrderTraversal());

        // Testing find() function
        int valueToFind = 40;
        System.out.println("Is " + valueToFind + " in the tree? " + bst.find(valueToFind));
    }
}

// BinarySearchTree class with the required methods
class BinarySearchTree {
    private TreeNode root;

    // TreeNode class
    private class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int value) {
            this.value = value;
            left = right = null;
        }
    }

    // Method to insert a new value into the BST
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);
        if (value < node.value) node.left = insertRec(node.left, value);
        else if (value > node.value) node.right = insertRec(node.right, value);
        return node;
    }

    // 1. Find the maximum value in the binary search tree
    public int findMax() {
        TreeNode current = root;
        while (current.right != null) {
            current = current.right; // Move to the rightmost node
        }
        return current.value; // Return the value of the rightmost node
    }

    // 2. Preorder Traversal (Root -> Left -> Right)
    public String preOrderTraversal() {
        return preOrderHelper(root).trim(); // Helper method to build the traversal string
    }

    private String preOrderHelper(TreeNode node) {
        if (node == null) return ""; // Base case: return empty string for null nodes
        return node.value + " " + preOrderHelper(node.left) + preOrderHelper(node.right);
    }

    // 3. Postorder Traversal (Left -> Right -> Root)
    public String postOrderTraversal() {
        return postOrderHelper(root).trim(); // Helper method to build the traversal string
    }

    private String postOrderHelper(TreeNode node) {
        if (node == null) return ""; // Base case: return empty string for null nodes
        return postOrderHelper(node.left) + postOrderHelper(node.right) + node.value + " ";
    }

    // 4. Find a specific value in the tree
    public boolean find(int value) {
        return findHelper(root, value); // Helper method to search for the value
    }

    private boolean findHelper(TreeNode node, int value) {
        if (node == null) return false; // If node is null, value isn’t in the tree
        if (node.value == value) return true; // If we found the value, return true
        return value < node.value ? findHelper(node.left, value) : findHelper(node.right, value);
    }
}
