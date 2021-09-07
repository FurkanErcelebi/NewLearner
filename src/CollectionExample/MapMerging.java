package CollectionExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapMerging {
    
    public static void main(String[] args) {
        
        HashMap<Integer, Object> map1 = new HashMap<>();
 
        map1.put(1, "A");
        map1.put(2, "B");
        map1.put(3, "C");
        map1.put(5, "E");

        
        //map 2
        HashMap<Integer, Object> map2 = new HashMap<>();
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        map2.put(1, "G");   //It will replace the value 'A'
        map2.put(2, "B");
        map2.put(3, "C");
        map2.put(4, "D");   //A new pair to be added
        map2.put(6, list1);
        
        //map 2
        HashMap<Integer, Object> map3 = new HashMap<>();
        
        List<String> list2 =  new ArrayList<>();
        list2.add("x");
        list2.add("y");
        list2.add("z");
        map3.put(10, "x");
        map3.put(11, "y");
        map3.put(12, "z");
        map2.put(6, list2/* map3 */);

        //Merge maps
        map1.putAll(map2);
        
        System.out.println(map1);

        /* map2.forEach(
            (key, value) -> map1.merge( key, value, (v1, v2) -> v1.equalsIgnoreCase(v2) ? v1 : v1 + "," + v2)
        );

        System.out.println(map1); */

    }

}
