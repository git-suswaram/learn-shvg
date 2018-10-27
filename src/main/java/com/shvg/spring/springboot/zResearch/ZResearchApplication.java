
package com.shvg.spring.springboot.zResearch;

import com.shvg.spring.springboot.zResearch.service.impl.BinarySearchImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class ZResearchApplication {

    private static Logger logger = LoggerFactory.getLogger(ZResearchApplication.class);

    public static int[] intArrayPayloads =
            {
                    1, 2, 3, 4, 5
            };

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(ZResearchApplication.class, args);

        /*To print list of all beans available in applicationContext-ctx
        for (String beanNames : ctx.getBeanDefinitionNames()) {
            logger.info("\nBeans in applicationContext: {} ", beanNames);
        }
        */

        BinarySearchImpl binarySearchImpl = ctx.getBean(BinarySearchImpl.class);
        int numberToSearch = 3;
        int indexOfNumberToSearch = binarySearchImpl.binarySearch(intArrayPayloads, numberToSearch);
        logger.info("\nindexOfNumberToSearch in RestAPIApplication: {} \n", indexOfNumberToSearch);

        ctx.close();

    }
}
