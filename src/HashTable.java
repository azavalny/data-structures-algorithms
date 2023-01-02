import java.lang.reflect.Array;
import java.util.ArrayList;

public class HashTable {
    private ArrayList<ArrayList<Object>> main;
    public HashTable(){
        main = new ArrayList<ArrayList<Object>>();
    }
    public void put(String key, Object value){
        int index = getIndexFromHash(key);
        if(this.main.get(index) == null){
            ArrayList<Object> newBucket = new ArrayList<>();
            newBucket.add(value);
            this.main.add(index, newBucket);
        } else{
            ArrayList<Object> oldBucket = this.get(key);
            oldBucket.add(value);
            this.main.add(index, oldBucket);
        }
    }
    public ArrayList<Object> get(String key){
        return this.main.get(getIndexFromHash(key));
    }
    private int getIndexFromHash(Object o){
        return o.hashCode()%main.size();
    }
}
