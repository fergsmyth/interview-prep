## Hashmap/Hashtable

```java
class HashMap {
    LinkedList[] data; 
    boolean put(String key, Object value){
        int hashcode = key.hashcode(); // Call hash function
        int index = asIndex(hashcode);
        LinkedList list = data[index];
        list.insert(key, value); // Check for duplicates
    }
}
```

#### Read more
* Collision handling
* Hashtable grow/shrinking
* Implement simple hashtable
* Practice questions
* What makes a good hashcode

#### Overview
* Stores key/value pair mapping.
* Key and value can be any object.
* Hashcode is generated for key.
* Hashcode is linked to array index where value is stored.
* Object must implement hashcode and equals.
* Ex string->hashcode-index.
* Two keys may share the same hashcode.
* Two hash codes may share the same index. 

#### Hashmap
* Not synchronised, not thread safe.
* Null key and null values allowed. 

#### Collisions
* Two keys map to the same index.
* Chaining : store collisions as a linked list.
* List stores a "tuple" (value, key) to link value back to original key.

#### Time complexity
Assuming a good hash table and hash function that distributes values well. 
Then getting/setting is constant time : O(1)
If lots of collisions
Then getting/setting is linear time : O(n)

#### Hashcode function :  hashcode()
* Hashcode is used to group/distribute object across the hashmap space.
* Integer that represents the object.
