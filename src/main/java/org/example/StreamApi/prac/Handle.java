package org.example.StreamApi.prac;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Handle {

    public static void main(String[] args) {
        Map<String, List<Product>> h = new HashMap<>();

        h.put("Electronics", Arrays.asList(new Product("Phone", 2000), new Product("Laptop", 20000)) );
        h.put("Accessories", Arrays.asList(new Product("Bag", 200)));
        h.put("Stationary", Arrays.asList(new Product("Pen", 2)));

//        Ques - 1
//        Filter out products with a price less than 50.

         Map<String,List<Product>> prod = h.entrySet().stream().
                collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry->entry.getValue().stream().
                                filter(e->e.getPrice()>50).
                                collect(toList()))
                );

         prod.entrySet().stream().
                 forEach(a-> a.getValue().stream().
                         forEach(i->System.out.println(i.getName())));

//        List<String> prodres = prod.entrySet().stream().
//                map(e->e.getValue().get(0).getName()
//                        .toString()).toList();

//        System.out.println(prodres);

//        Ques - 2
//        Flatten the lists of products into a single list.
         List<Product> singleProdList = h.values().stream().flatMap(List::stream).toList();
         System.out.println(singleProdList);
        singleProdList.stream().
                forEach(a-> System.out.println(a.getName()));


    }
}
