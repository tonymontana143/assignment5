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
    }

    public Iterable<K> iterator() {
    }
}