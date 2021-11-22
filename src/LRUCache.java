import java.util.HashMap;

class ListNode {
    int key;
    int track = 0;
    ListNode next = null;
    ListNode previous = null;

    public ListNode(int key) {
        this.key = key;

    }
    @Override
    public String toString(){
        return "( key = " + key + ", track " + track +")";
    }
}


class LRUCache {
    private int maxSize = 0;
    private final HashMap<Integer, Integer> map = new HashMap<>();
    private final HashMap<Integer, ListNode> track = new HashMap<>();

    private ListNode node;
    // min listnode

    public LRUCache(int size) {
        this.maxSize = size;
    }

    private String print(ListNode node) {
        var n = node;
        StringBuilder builder = new StringBuilder();
        while (n != null) {
            builder.append(" " + n);

            n = n.next;
        }

        return builder.toString();

    }

    public int get(int key) {

        if (map.containsKey(key)) {
            ListNode keyNode = track.get(key);
            keyNode.track++;

            // swap to the right
            ListNode tempNext = keyNode.next;
            ListNode tempPrevious = keyNode.previous;
            keyNode.next = null;
            keyNode.previous = null;

            if (tempNext != null) tempNext.previous = tempPrevious;
            if (tempPrevious != null) tempPrevious.next = tempNext;


            if (tempNext != null) {
                var tempNextNext = tempNext.next;
                tempNext.next = keyNode;
                keyNode.previous = tempNext;
                keyNode.next = tempNextNext;

            }
            // System.out.println( " get "+key+" -- "+print(node) + " " + track);

            return map.get(key);
        }

        //System.out.println( " get "+key+" -- "+print(node)  + " " + track);
        return -1;
    }

    public void remove() {

        if (node != null) {
            int toRemoveKey = node.key;
            map.remove(toRemoveKey);
            track.remove(toRemoveKey);

            if (node.next != null) {
                node.next.previous = null;
                node = node.next;
            } else {
                node = null;
            }
        }

    }


    public void put(int key, int value) {


        if (!map.containsKey(key)) {
            ListNode n = new ListNode(key);

            if (map.size() + 1 > maxSize) {
                remove();
            }

            if (node != null) {
                System.out.println("//"+print(node));
                node.previous = n;
                n.next = node;


            }
            node = n;

            track.put(key, n);
        }


        map.put(key, value);
        System.out.println("put -- key " + key + " value " + value + " track " + print(node));


    }

    public static void main(String[] args){
var obj = new LRUCache(2);


        obj.put(2,2);
        obj.put(1,1);
}
}

/**
 put -- key 2 value 1 track  ( key = 2)
 put -- key 1 value 1 track  ( key = 2) ( key = 1)
 put -- key 2 value 3 track  ( key = 2) ( key = 1)
 put -- key 4 value 1 track  ( key = 1) ( key = 4)
 get 1 --  ( key = 4) ( key = 1) {1=( key = 1), 4=( key = 4)}
 get 2 --  ( key = 4) ( key = 1) {1=( key = 1), 4=( key = 4)}

 */
