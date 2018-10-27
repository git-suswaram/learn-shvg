package com.shvg.spring.springboot.zResearch.service.impl;

import com.shvg.spring.springboot.zResearch.helper.SearchHelper;
import com.shvg.spring.springboot.zResearch.service.SortAlgorithmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*  What are the beans that we need spring to manage?
    @Component tells Spring that this is a bean and to manage this bean
*/
@Component
public class BinarySearchImpl  {


    /* What are the dependencies of a bean?
            @Autowired tells Spring that this is a dependency for this bean
            In this case, SortAlgorithmService is a dependency of BinarySearchImpl.
        */
    @Autowired
    private SortAlgorithmService sortAlgorithmService;

    private static Logger logger = LoggerFactory.getLogger(BinarySearchImpl.class);

    /*
       Required for Constructor based dependency injection
       Default is setter based dependency injection.
       No need to explicitly create setter method for autowired components.
    */

    public BinarySearchImpl(SortAlgorithmService sortAlgorithmService) {
        this.sortAlgorithmService = sortAlgorithmService;
    }

    public int binarySearch (int[] arrayOfInts, int numberToSearch){

        logger.info("\nSorted arrayOfInts in BinarySearchImpl: {}",arrayOfInts);
        logger.info("\nnumberToSearch in BinarySearchImpl: {}",numberToSearch);

        int[] bubbleSortedArray= sortAlgorithmService.sort(arrayOfInts);
        logger.info("\nSorted arrayOfInts in BinarySearchImpl: {}",arrayOfInts);
        logger.info("\nsortAlgorithmService in BinarySearchImpl: {}", sortAlgorithmService);

        int indexOfNumberToSearch = SearchHelper.searchNumberInIntArray(bubbleSortedArray,numberToSearch);
        logger.info("\nindexOfNumberToSearch in BinarySearchImpl: {}\n",indexOfNumberToSearch);

        return indexOfNumberToSearch;
    }

}
