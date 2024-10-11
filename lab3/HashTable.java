import java.util.LinkedList; // это класс - для работы со списком элементов

public class HashTable<K, V> {                  // HashTable это структура данных, которая используется для
    private static class Entry<K, V> {          // хранения пар «ключ-значение». Она основана на идее хэш-функции,
        private K key;                          // которая преобразует ключ в индекс массива, где хранится значение
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] table; // переменная массива списков
    private int size;

    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % table.length; // получаем остаток от деления хэшкода на длину массива
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> list = table[index]; // вытаскиваем из массива значение которое хранится по этому индексу и присваиваем его list
        if (list == null) {
            list = new LinkedList<>();
            table[index] = list;
        }
        for (Entry<K, V> entry : list) { // перебираем список состоящий из экземпляров Entry(при пустом списке цикл на сработает)
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        list.add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> list = table[index];
        if (list != null) {
            for (Entry<K, V> entry : list) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> list = table[index];
        if (list != null) {
            for (Entry<K, V> entry : list) {
                if (entry.getKey().equals(key)) {
                    list.remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
