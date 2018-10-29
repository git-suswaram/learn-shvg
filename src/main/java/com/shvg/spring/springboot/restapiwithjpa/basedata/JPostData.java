/*
package com.shvg.spring.springboot.restapiwithjpa.basedata;

import com.shvg.spring.springboot.restapiwithjpa.entity.JDepartment;
import com.shvg.spring.springboot.restapiwithjpa.entity.JPost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JPostData {

//insert into JPOST values(1001,'MyFirstPost',5);
//insert into JPOST values(1002,'MySecondPost',5);
//insert into JPOST values(1003,'MyFirstPost',6);


    private static JPost[] arrayOfJPostsPayLoad =
            {
                    new JPost("My First Post", 5),
                    new JPost("My Second Post", 5),
                    new JPost("My First Post", 6),
            };
    private static List<JPost> immutableListOfJDepartments = Arrays.asList(arrayOfJPostsPayLoad);

    private static List<JPost> mutableListOfJPosts = new ArrayList<>();

    static {
        mutableListOfJPosts.add(new JPost("My First Post", 5));
        mutableListOfJPosts.add(new JPost("My Second Post", 5));
        mutableListOfJPosts.add(new JPost("My First Post", 6));
    }
}
*/
