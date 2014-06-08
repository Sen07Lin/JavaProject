import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
/**
 * Implement the hash table interface here.
 * 
 * @author [Sen Lin]
 * @author Julia Ting
 * 
 */
public class HashTable<K, V> implements HashTableInterface<K, V> {
    /**
     * DO NOT CHANGE THIS NUMBER.
     * 
     * This is the constant determining max load factor, or when you will
     * have to regrow the table.
     */
    private static final double MAX_LOAD_FACTOR = .71;
    /**
     * DO NOT CHANGE THIS NUMBER.
     * 
     * This is the constant determining what size you will initialize your
     * table array to.
     */
    private static final int INITIAL_CAPACITY = 11;
    /**
     * The number of entries in the table.
     */
    private int size;
    /**
     * The backing array of your hash table.
     */
    private MapEntry<K, V>[] table;
    /**
     * Initialize the backing array to the initial capacity and the size
     * to the appropriate starting size.
     */
    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new MapEntry[INITIAL_CAPACITY];
        size = 0;
    }
    @Override
    public V put(K key, V value) {
        MapEntry<K, V> mE = new MapEntry<K, V>(key, value);
        int index = getIndex(key);
        if (index > 0) {
            // The same key, replace old mapEntry with new value;
            V temp = table[index].getValue();
            table[index] = mE;
            return temp;
        }
        // a new unique key
        size++;
        double loadFac = (double) size / (double) table.length;
        if (loadFac < MAX_LOAD_FACTOR) {
            table = linearProbing(table, mE);
        } else {
            table = resize(mE);
        }
        return null;
    }
    /**
     * This methods handles possible collisions by linear Probing.
     * @param tempTable the hashTable to be put
     * @param mE The MapEntry to be put on the hashTable
     * @return a new hashTable after putting an item
     */
    private MapEntry<K, V>[] linearProbing(MapEntry<K, V>[] tempTable,
            MapEntry<K, V> mE) {
        int i = Math.abs(mE.getKey().hashCode()) % tempTable.length;
        while (tempTable[i] != null && !tempTable[i].isRemoved()) {
            if (i == tempTable.length - 1) {
                i = -1;
            }
            i++;
        }
        tempTable[i] = mE;
        return tempTable;
    }
    /**
     * This method helps the hash table to resize when table exceed the load
     * factor.
     * @param mE The new mapEntry that cause resize, to be added.
     * @return a new hashTable after resize.
     */
    private MapEntry<K, V>[] resize(MapEntry<K, V> mE) {
        @SuppressWarnings("unchecked")
        MapEntry<K, V>[] newTable = new MapEntry[table.length * 2 + 1];
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && !table[i].isRemoved()) {
                // rehash keys
                newTable = linearProbing(newTable, table[i]);
            }
        }
        return linearProbing(newTable, mE);
    }
    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && !table[i].isRemoved()
                    && table[i].getKey().equals(key)) {
                return table[i].getValue();
            }
        }
        return null;
    }
    /**
     * get index of Key on the hashTable.
     * @param key the key to be searched for.
     * @return the index of the key.
     */
    private int getIndex(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && !table[i].isRemoved()
                    && table[i].getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && !table[i].isRemoved()
                    && table[i].getKey().equals(key)) {
                table[i] = new MapEntry<K, V>(null, table[i].getValue());
                table[i].setRemoved(true);
                size--;
                return table[i].setValue(null);
            }
        }
        return null;
    }
    @Override
    public boolean contains(V value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        return values().contains(value);
    }
    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return keySet().contains(key);
    }
    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<K>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && !table[i].isRemoved()) {
                set.add(table[i].getKey());
            }
        }
        return set;
    }
    @Override
    public Collection<V> values() {
        Collection<V> collection = new ArrayList<V>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && !table[i].isRemoved()) {
                collection.add(table[i].getValue());
            }
        }
        return collection;
    }
    @Override
    public Set<MapEntry<K, V>> entrySet() {
        Set<MapEntry<K, V>> set = new HashSet<MapEntry<K, V>>();
        for (MapEntry<K, V> mE : table) {
            if (mE != null && !mE.isRemoved()) {
                set.add(mE);
            }
        }
        return set;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        table = new MapEntry[INITIAL_CAPACITY];
        size = 0;
    }
    
}
