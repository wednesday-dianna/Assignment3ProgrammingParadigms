package model.ADT;

import exceptions.ADTException;
import exceptions.KeyNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyMap <K, V> implements MyIMap<K, V> {
    private Map<K, V> map;
    public MyMap() {
        this.map = new HashMap<>();
    }
    public V getValue(K key) throws ADTException {
        if (this.map.containsKey(key)) {
            return this.map.get(key);
        }
        throw new KeyNotFoundException();
    }
    public void put(K key, V value) {
        this.map.put(key, value);
    }
    public boolean containsKey(K key) {
        return this.map.containsKey(key);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symtable {\n");
        for (Map.Entry<K, V> entry : this.map.entrySet()) {
            sb.append(entry.getKey() + " -> " + entry.getValue() + "\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
    public Set<K> getKeys(){
        return this.map.keySet();
    }
}