package com.shvg.frameworks.springboot.restapiwithjpa.service;

public interface JPrimitiveDataService {

    int calculateSum(int[] numbers);

    Object getRequestedData(String typeOfData);

    int calculateCustomSum(String typeOfData);
}
