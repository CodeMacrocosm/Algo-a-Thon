/*
Custom implementation of Hash Map

- Stores key-value pairs.
- Insert and search the pair in constant time O(1) in best case.
- Backed by an array, also known as hash table. Each index of an array is know as hash bucket.
 */


public class MyHashMap<K, V> {

  private static int DEFAULT_CAPACITY = 16;

  private Entry<K, V>[] table;
  private int capacity;

  MyHashMap() {
    this(DEFAULT_CAPACITY);
  }

  MyHashMap(int capacity) {
    this.capacity = capacity;
    /**
     * Initialize "Hash Table" with initial capacity which is nothing but an Array
     * Each index of an array is called "Hash Bucket"
     */
    this.table = new Entry[capacity];
  }

  /**
   * Each Entry stores a key-value pair Each Entry also stores the address of next
   * Entry in case of "Hash Collision"
   */
  static class Entry<K, V> {

    K key;
    V value;
    Entry<K, V> next;

    Entry(K key, V value) {
      this.key = key;
      this.value = value;
    }

    Entry(K key, V value, Entry<K, V> next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  public void put(K key, V value) {
    if (key == null) {
      return;
    }

    // Create a key-value pair
    Entry<K, V> newEntry = new Entry<>(key, value);

    // Find the right Bucket by hashing the key
    int hash = hash(key);

    // if - Empty Bucket
    if (table[hash] == null) {
      table[hash] = newEntry;
      // else - "Hash Bucket" is not Empty, Known as "Hash Collision"
      // New Entry is created and linked to Previous Node in Same Bucket
    } else {
      Entry<K, V> current = table[hash];
      Entry<K, V> previous = null;
      while (current != null) {
        if (current.key.equals(key)) {
          current.value = newEntry.value;
          return;
        }
        previous = current;
        current = current.next;
      }
      previous.next = newEntry;
    }
  }

  public V get(K key) {
    if (key == null) {
      return null;
    }

    // Find the right Bucket by hashing the key
    int hash = hash(key);

    // if - "Hash Bucket" is Empty, Return null
    if (table[hash] == null) {
      return null;
      // else - "Hash Bucket" is not Empty
      // Traverse through all the linked Nodes in the Bucket
      // Use `equals` method to find the correct key-value pair
    } else {
      Entry<K, V> current = table[hash];
      while (current != null) {
        if (current.key.equals(key)) {
          return current.value;
        }
        current = current.next;
      }
    }
    return null;
  }

  private int hash(K key) {
    // Using modulo "% capacity" to make sure that returned hash in the range of
    // underlying Array size
    return Math.abs(key.hashCode()) % capacity;
  }

  public static void main(String[] args) {
    MyHashMap<String, Integer> likesPerPost = new MyHashMap<String, Integer>();
    likesPerPost.put("Learning Hash Map", 5);
    System.out.println(likesPerPost.get("Learning Hash Map"));
  }
}
