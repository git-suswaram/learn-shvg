package com.shvg.spring.springboot.zResearch.service.impl;

import com.shvg.spring.springboot.zResearch.service.SortAlgorithmService;
import org.springframework.stereotype.Component;

/* What are the beans that we need spring to manage?
@Component tells Spring that this is a bean and to manage this bean
*/
@Component
public class BubbleSortAlgorithmServiceImpl implements SortAlgorithmService {

    public int[] sort(int[] arrayOfInts){

        //TODO: Implement logic to Bubble sort the array

        return arrayOfInts;
    }
}
