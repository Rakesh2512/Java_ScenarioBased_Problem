package HashMap;


class Entity<K,V>{
    K Key;
    V Value;
    Entity<K,V> next;

    Entity(K Key,V Value){
        this.Key = Key;
        this.Value = Value;
        this.next = null;
    }
}
public class MyHashMap<K,V> {

    private int capacity = 16;
    Entity<K,V>[] bucket;

    @SuppressWarnings("unchecked")
    MyHashMap(){
        bucket = (Entity<K,V>[]) new Entity[capacity];
    }

    public int getIndex(K Key){
        return Math.abs(Key.hashCode())%capacity;
    }

    public void put(K Key,V Value){
        int index = getIndex(Key);
        Entity<K,V>head = bucket[index];

        while(head != null){
            if(head.Key.equals(Key)){
                head.Value = Value;
                return ;
            }
            head = head.next;
        }
        Entity<K,V>newNode = new Entity<>(Key, Value);
        newNode.next = bucket[index];
        bucket[index] = newNode;
    }

    public V get(K Key){
        int index = getIndex(Key);
        Entity<K,V>head = bucket[index];
        while(head != null){
            if(head.Key.equals(Key)){
                return head.Value;
            }
            head = head.next;
        }
        return null;
    }

    public void remove(K Key){
        int index = getIndex(Key);
        Entity<K,V>head = bucket[index];
        Entity<K,V>prev = null;

        if(head == null){
            return ;
        }

        while(head != null){
            if(head.Key.equals(Key)){
                if(prev == null){
                    bucket[index] = head.next;
                }
                else{
                    prev.next = head.next;
                }
                return;
            }
            
            prev = head;
            head = head.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer>mp = new MyHashMap<>();
		
		mp.put("abc", 1);
		mp.put("cde", 2);
		mp.put("xyz", 36);
		
		System.out.println(mp.get("abc"));
		
		mp.remove("abc");
		
		System.out.println(mp.get("abc"));
    }
}
