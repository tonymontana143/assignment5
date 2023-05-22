import java.util.ArrayList;
import java.util.List;


public class BST<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    // Inserts a key-value pair into the binary search tree
    public void put(K key, V val) {
        root = put(root, key, val);
    }

    // Helper method for inserting a key-value pair recursively
    private Node put(Node current, K key, V val) {
        if (current == null) {
            return new Node(key, val);
        }
        int compare = key.compareTo(current.key);
        if (compare < 0) {
            current.left = put(current.left, key, val); // Recursively insert into the left subtree
        } else if (compare > 0) {
            current.right = put(current.right, key, val); // Recursively insert into the right subtree
        } else {
            current.val = val; // Update the value if the key already exists
        }
        return current;
    }

    // Retrieves the value associated with a given key from the binary search tree
    public V get(K key) {
        Node node = get(root, key);
        return node != null ? node.val : null; // Returns the value if the key exists, otherwise null
    }

    // Helper method for retrieving a node with a given key recursively
    private Node get(Node node, K key) {
        if (node == null) {
            return null; // Key not found in the tree
        }
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            return get(node.right, key); // Recursively search in the right subtree
        } else if (compare < 0) {
            return get(node.left, key); // Recursively search in the left subtree
        } else {
            return node; // Found the node with the given key
        }
    }

    // Deletes a node with the given key from the binary search tree
    public void delete(K key) {
        root = delete(root, key);
    }

    // Helper method for deleting a node with a given key recursively
    private Node delete(Node node, K key) {
        if (node == null) {
            return null; // Key not found in the tree
        }
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            node.right = delete(node.right, key); // Recursively delete in the right subtree
        } else if (compare < 0) {
            node.left = delete(node.left, key); // Recursively delete in the left subtree
        } else {
            // Found the node to delete
            if (node.left == null) {
                return node.right; // Replace the node with its right child
            } else if (node.right == null) {
                return node.left; // Replace the node with its left child
            } else {
                // Node to delete has both left and right child
                Node minRightNode = findMin(node.right); // Find the minimum node in the right subtree
                node.key = minRightNode.key; // Replace the key and value with the minimum node's key and value
                node.val = minRightNode.val;
                node.right = delete(node.right, minRightNode.key); // Recursively delete the minimum node from the right subtree
            }
        }
        return node;
    }

    // Finds the node with the minimum key in a given subtree
    public Node findMin(Node node) {
        while (node.left != null) {
            node = node.left; // Traverse the left child until reaching the minimum node
        }
        return node;
    }

    // Returns an iterator over the keys in ascending order
    public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        inOrder(root, keys); // Perform an in-order traversal to collect the keys
        return keys; // Return the keys as an iterable object
    }

    // Helper method for performing in-order traversal recursively
    private void inOrder(Node node, List<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys); // Recursively traverse the left subtree
        keys.add(node.key); // Add the key to the list
        inOrder(node.right, keys); // Recursively traverse the right subtree
    }

    // Returns the number of nodes in the binary search tree
    public int size() {
        return size(root); // Call the private size method with the root node
    }

    // Helper method for calculating the size of a subtree recursively
    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.right) + size(node.left); // Recursively calculate the size of the left and right subtrees and add 1 for the current node
        }
    }

    //высота binary search tree
    public int height() {
        return height(root);
    }
    private int height(Node node){
        if(node==null){
            return 0;
        }
        int leftSide=height(node.left);
        int rightSide=height(node.right);
        return 1+Math.max(leftSide,rightSide);
    }

}



