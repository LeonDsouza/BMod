/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crce.swapriorimodified;

import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Leon
 */
public class Generate2LargeItemSets {
    
    
    public void generate2LargeItemsets(Map<String,Multimap> ObjectInfo, double minSupport,ArrayList<Triple> listOfTriples){
        LinkedHashSet<String> objectSet = new LinkedHashSet(1000);
        /**
         * debug
         */
        /*
        for (Triple t : listOfTriples) {
        objectSet.add(t.object);
        }
         */
        listOfTriples.forEach((t) -> {
            objectSet.add(t.object);
        });
        for(String i : objectSet){
            for(String j : objectSet){
                /**
                 * debug
                 */
                System.out.println(i + "\t\t" + j);
                if(!i.equals(j)){
                    System.out.println("-----------------------------");
                    Set<String> setOfPredicatesI = ObjectInfo.get(i).keySet();
                    /**
                     * debug
                     */
                    System.out.println("\tSet of predicates " + i + "\t" + setOfPredicatesI);
                    Set<String> setOfPredicatesJ = ObjectInfo.get(j).keySet();
                    /**
                     * debug
                     */
                    System.out.println("\tSet of predicates " + j + "\t" + setOfPredicatesJ);
                    for(String i1 : setOfPredicatesI){
                        for(String j1 : setOfPredicatesJ){
                            Collection<String> subjectI = ObjectInfo.get(i).get(i1);
                            /**
                             * debug
                             */
                            System.out.println("\t\tSubject list of " + i1 + "\t" + subjectI);
                            Collection<String> subjectJ = ObjectInfo.get(i).get(j1);
                            /**
                             * debug
                             */
                            System.out.println("\t\tSubject list of " + j1 + "\t" + subjectJ);
                        }
                    }
                }
            }
        }
    }
    
}
