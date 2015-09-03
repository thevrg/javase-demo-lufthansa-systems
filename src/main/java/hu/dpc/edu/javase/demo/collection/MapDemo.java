/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.collection;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author U122951
 */
public class MapDemo {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("szin", "piros");
        m.put("szam", 34);
        m.put("datum", new Date());
        
        System.out.println("m: " + m);
        
        for (Object key : m.keySet()) {
            Object value = m.get(key);
            System.out.println(key + " = " + value);
        }
        
        
        for (Object o : m.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("........");
        for (Iterator it = m.entrySet().iterator(); it.hasNext();) {
            Object next = it.next();
            Map.Entry entry = (Map.Entry) next;
            if (entry.getKey().equals("datum")) {
                it.remove();
            }
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        
        System.out.println("m: "  + m);
    }
}
