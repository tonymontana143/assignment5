## Assignment 5
## Method "put"
**Description**: *put(K key, V val)*

**Explanation**: This method inserts a new key-value pair into the binary search tree.

**Solution**:
```java
public void put(K key, V val) {
        root = put(root, key, val);
        }

private Node put(Node current, K key, V val) {
        if (current == null) {
        return new Node(key, val);
        }
        int compare = key.compareTo(current.key);
        if (compare < 0) {
        current.left = put(current.left, key, val);
        } else if (compare > 0) {
        current.right = put(current.right, key, val);
        } else {
        current.val = val;
        }
        return current;
        }
```
## Method "get"
**Description**: *get(K key)*

**Explanation**: This method retrieves the value associated with a given key from the binary search tree.

**Solution**:
```java
public V get(K key) {
        Node node = get(root, key);
        return node != null ? node.val : null;
        }

private Node get(Node node, K key) {
        if (node == null) {
        return null;
        }
        int compare = key.compareTo(node.key);
        if (compare > 0) {
        return get(node.right, key);
        } else if (compare < 0) {
        return get(node.left, key);
        } else {
        return node;
        }
        }
```
## Method "delete"
**Description**: *delete(K key)*

**Explanation**: This method deletes a node with the given key from the binary search tree.

**Solution**:
```java
public void delete(K key) {
        root = delete(root, key);
        }

private Node delete(Node node, K key) {
        if (node == null) {
        return null;
        }
        int compare = key.compareTo(node.key);
        if (compare > 0) {
        node.right = delete(node.right, key);
        } else if (compare < 0) {
        node.left = delete(node.left, key);
        } else {
        if (node.left == null) {
        return node.right;
        } else if (node.right == null) {
        return node.left;
        } else {
        // Node to delete has both left and right child
        Node minRightNode = findMin(node.right);
        node.key = minRightNode.key;
        node.val = minRightNode.val;
        node.right = delete(node.right, minRightNode.key);
        }
        }
        return node;
        }
```
## Method "findMin"
**Description**: *findMin(Node node))*

**Explanation**: This method finds the node with the minimum key in a given subtree.

**Solution**:
```java
public Node findMin(Node node) {
        while (node.left != null) {
        node = node.left;
        }
        return node;
        }
```
## Method "iterator"
**Description**: *iterator()*

**Explanation**: This method returns an iterator over the keys in ascending order.

**Solution**:
```java
public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        inOrder(root, keys);
        return keys;
        }
```
## Method "inOrder"
**Description**: *inOrder(Node node, List<K> keys)*

**Explanation**: This is a recursive helper method used by the iterator method.

**Solution**:
```java
private void inOrder(Node node, List<K> keys) {
        if (node == null) {
        return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
        }
```
## Method "Size"
**Description**: *size()*

**Explanation**: This method returns the number of nodes in the binary search tree.

**Solution**:
```java
public int size() {
        return size(root);
        }

private int size(Node node) {
        if (node == null) {
        return 0;
        } else {
        return 1 + size(node.right) + size(node.left);
        }
        }
```

