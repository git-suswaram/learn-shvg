package com.shvg.frameworks.zResearch.helper;

import com.shvg.frameworks.zResearch.service.impl.BinarySearchImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SearchHelper {

    private static Logger logger = LoggerFactory.getLogger(BinarySearchImpl.class);


    public static int searchNumberInIntArray (int[] arrayOfInts, int numberToSearch){

        logger.info("\nSorted arrayOfInts in SearchHelper: {}",arrayOfInts);
        logger.info("\nnumberToSearch in SearchHelper: {}",numberToSearch);
        logger.info("\nArrays.asList(arrayOfInts) in SearchHelper: {}",Arrays.asList(arrayOfInts));

        return  IntStream
                .range(0, arrayOfInts.length)
                .filter(i->numberToSearch==arrayOfInts[i])
                .findFirst()
                .getAsInt();
    }

}
