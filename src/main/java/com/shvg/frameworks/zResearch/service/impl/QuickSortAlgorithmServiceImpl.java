package com.shvg.frameworks.zResearch.service.impl;

import com.shvg.frameworks.zResearch.service.SortAlgorithmService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/* What are the beans that we need frameworks to manage?
@Component tells Spring that this is a bean and to manage this bean
*/

@Component
@Primary /* Where there are more than one component of the same type in classpath, @Primary defines the priority*/
public class QuickSortAlgorithmServiceImpl implements SortAlgorithmService {

    public int[] sort(int[] arrayOfInts){

        //TODO: Implement logic to Quick sort the array

        return arrayOfInts;
    }
}
