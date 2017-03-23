/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crce.swapriorimodified;

import com.google.common.collect.Multimap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Leon
 */
public class StartClass {
    public static void main(String [] args) throws IOException{
        String fileName = "C:/Users/leons/Desktop/sample_data_1.csv";
        double minSupport = 0;
        CSVPreprocessor preprocessor = new CSVPreprocessor(fileName);
        SWApriori swapriori = new SWApriori();
        ArrayList<Triple> listOfTriples = swapriori.convertToTriples(fileName);
        ArrayList<Triple> numericalTriples = swapriori.convertToNumericalValues( listOfTriples, fileName);
        
        Map<String, Multimap> ObjectInfo = swapriori.convertToObjectInfoStructure(numericalTriples);
        Generate2LargeItemSets generate = new Generate2LargeItemSets();
        generate.generate2LargeItemsets(ObjectInfo,minSupport,listOfTriples);
    }
}
