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

    public void put(K key, V val){
        root=put(root, key, val);
    }
    private Node put(Node current,K key, V val) {
            if(current==null){
                return new Node(key, val);
            }
            int compare= key.compareTo(current.key);
            if(compare<0){
                current.left=put(current.left,key,val);
            } else if (compare>0) {
                current.right=put(current.right,key,val);
            }
            else{
                current.val=val;
            }
            return current;
    }


    public V get(K key) {
        Node node=get(root,key);
        return node!=null?node.val:null;
    }
    private Node get(Node node,K key){
        if(node==null){
            return null;
        }
        int compare= key.compareTo(node.key);
        if(compare>0){
            return get(node.right,key);
        } else if (compare<0) {
            return get(node.left,key);
        }
        else{
            return node;
        }
    }
    public void delete(K key) {
        root=delete(root,key);
    }
    private Node delete(Node node,K key){
        if(node==null){
            return null;
        }
        int compare=key.compareTo(node.key);
        if(compare>0){
            node.right=delete(node.right,key);
        } else if (compare<0) {
            node.left=delete(node.left,key);
        }
        else{
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
    public Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }



    public Iterable<K> iterator() {
        List<K> keys=new ArrayList<>();
        inOrder(root,keys);
        return keys;
    }
    private void inOrder(Node node,List<K> keys){
        if(node==null){
            return;
        }
        inOrder(node.left,keys);
        keys.add(node.key);
        inOrder(node.right,keys);
    }
}