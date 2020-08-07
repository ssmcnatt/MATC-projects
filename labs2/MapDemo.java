package java112.labs2;

import java.util.*;

/**
 * @author Eric Knapp
 * class MapDemo
 */
public class MapDemo {
    
    
    /**
     * Run the demo
     */
    public void run() {
        Map<Integer, String> map = new TreeMap<Integer, String>();
        
        map.put(new Integer(1), "One");
        map.put(new Integer(2), "Two");
        map.put(new Integer(3), "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        
        System.out.println();
        System.out.println(map);
        System.out.println();
        
        System.out.println("3: " + map.get(3));
        System.out.println();
        
        Integer test = new Integer(100);
        
        test++;
        
        System.out.println("test: " + test);
        
        int total = 0;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
            total += entry.getKey();
        }
        
        System.out.println("total: " + total);
    }
    
    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        MapDemo demo = new MapDemo();
        demo.run();
    }
    
}
