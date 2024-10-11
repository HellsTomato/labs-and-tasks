public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);

        System.out.println("is empty? " + hashTable.isEmpty());

        hashTable.put("one", 1);
        hashTable.put("one", 11);
        hashTable.put("two", 2);
        hashTable.put("two", 22);
        hashTable.put("three", 3);
        hashTable.put("three", 33);

        System.out.println("Size: " + hashTable.size());
        System.out.println("Get 'two': " + hashTable.get("two"));

        hashTable.remove("two");
        System.out.println("Size after removing 'two': " + hashTable.size());
        System.out.println("Get 'two': " + hashTable.get("two"));

        System.out.println("is empty? " + hashTable.isEmpty());

    }
}

