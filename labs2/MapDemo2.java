package java112.labs2;

import java.util.*;

/**
 * @author Your Name Here
 * class MapDemo2
 */
public class MapDemo2 {
    
    public void run() {
        
        Map<String, Integer> map = new HashMap();
        
        map.put("one", new Integer(1));
        map.put("two", new Integer(2));
        map.put("three", new Integer(3));
        map.put("four", new Integer(4));
        map.put("four", new Integer(444));
        
        Integer test = map.get("two");
        
        test++;
        
        System.out.println("test: " + test);
        
        System.out.println();
        System.out.println(map);
        System.out.println();
        System.out.println("three: " + map.get("three"));
        System.out.println();
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            
            System.out.println("key: " + entry.getKey() + 
                               ", value: " + entry.getValue());
        }
    }
    
    /**
     * TODO: comment
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        
        MapDemo2 mapDemo = new MapDemo2();
        mapDemo.run();
    }
    
}