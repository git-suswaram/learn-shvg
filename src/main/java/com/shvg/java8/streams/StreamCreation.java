package com.shvg.java8.streams;

import com.shvg.java8.streams.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.abs;

public class StreamCreation {

    private static Employee[] arrayOfEmployees = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(11, "Jeff B", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(22, "Bill G", 200000.0),
            new Employee(3, "Mark Zuckerberg", 3000000.0),
            new Employee(33, "Mark Z", 3000000.0)
    };
    private static List<Employee> listOfEmployees = Arrays.asList(arrayOfEmployees);

    private static int[] primitiveIntArrayOfNumbers = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7, 1, 3, 10};

    public static void main (String[] args){


        //Option 1 - Building Stream from existing list using - Arrays.asList().stream()
        System.out.println("\nBuilding Stream from existing list - Arrays.asList().stream()");
        List<Employee> empStreamFromExistingList= Arrays.asList(arrayOfEmployees);
        empStreamFromExistingList.stream().forEach(System.out::println);

        //Option 2A - Building Stream from Existing Array using - Stream.of()
        System.out.println("Building Stream from Existing Array - Stream.of()");
        Stream<Employee> empSteamUsingStreamOf = Stream.of(arrayOfEmployees);
        empSteamUsingStreamOf.forEach(System.out::println);

        //Option 2B - Building Stream from individual objects using - Stream.of()
        System.out.println("\nBuilding Stream from individual objects using - Stream.of()");
        Stream<Employee> empStreamFromIndivObjects = Stream.of(arrayOfEmployees[0],arrayOfEmployees[1],arrayOfEmployees[2]);
        empStreamFromIndivObjects.forEach(System.out::println);


        //Option 3A - Building Stream using - Stream.builder().accept().build()
        System.out.println("\nBuilding Stream using - Stream.builder().accept().build()");
        Stream.Builder<Employee> empStreamBuilderAccept = Stream.builder();
        empStreamBuilderAccept.accept(arrayOfEmployees[0]);
        empStreamBuilderAccept.accept(arrayOfEmployees[1]);
        empStreamBuilderAccept.accept(arrayOfEmployees[2]);
        Stream<Employee> empStreamUsingStreamBuilderAccept = empStreamBuilderAccept.build();
        empStreamUsingStreamBuilderAccept.forEach(System.out::println);


        //Option 3B - Building Stream using - Stream.builder().add().build()
        System.out.println("\nBuilding Stream using - Stream.builder().add().build()");
        Stream.Builder<Employee> empStreamBuilderAdd = Stream.builder();
        empStreamBuilderAdd.add(arrayOfEmployees[0]);
        empStreamBuilderAdd.add(arrayOfEmployees[1]);
        empStreamBuilderAdd.add(arrayOfEmployees[2]);
        Stream<Employee> empStreamUsingStreamBuilderAdd = empStreamBuilderAdd.build();
        empStreamUsingStreamBuilderAdd.forEach(System.out::println);

        //Option 4 - Building Stream using - Stream.iterate()
        System.out.println("\n//Building Stream using - Stream.iterate()");
        Stream<Integer> infiniteIntegerStream = Stream.iterate(4, i->i*2);
        infiniteIntegerStream
                .skip(0)
                .limit(9)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //Option 5 - Building Stream using - Stream.generate()
        Supplier<Double> random = Math::random;

        System.out.println("\n//Building Int Stream using - Stream.generate()");
        Stream.generate(random).map(e->((int)abs(e*1000)))
        .limit(5)
        .forEach(System.out::println);

        System.out.println("\n//Building Stream using - Stream.generate()");
        Stream.generate(random)
                .limit(5)
                .forEach(System.out::println);


        //######################################################################################

        //Option 1 - Create IntStream using - mapToInt()
        int latestEmpId = listOfEmployees.stream()
                .mapToInt(Employee::getId)
                .max()
                .orElseThrow(NoSuchElementException::new);

        System.out.println("\nLatest EmployeeID is - "+latestEmpId);

        //Option 2A - Create IntStream using - IntStream.of(array)

        /* When you have a method that receives a variable length argument list,
           you can either provide a comma separated list of values of the appropriate type,
           in this case integers, or you can give it an array of that type as well.

           in the lambda expression itself you're allowed to use other local variables
           in the scope where the lambda expression is declared, but like anonymous classes,
           anonymous inner classes, the local variables that you use must be final or
           as of Java Standard Edition 8 they can be what we call, effectively final local variables.
           So if I wanted to use the local variable in the lambda expression I can provided
           that it's never modified after it's initialized anywhere in the lexical scope where
           this lambda expression is actually declared.

           So we'll see cases where we use effectively final local variables in subsequent examples.
           In addition, a lambda expression is capable of doing what we call capturing local variable values.
           If a lambda expression uses a local variables value, then the lambda is called a capturing lambda.
           And what that basically means is that the lambda expression, the compiler really, is going to make
           sure that the local variable that we use is going to be available whenever the lambda expression
           eventually executes, which could be in a completely different scope inside of an application.
           One thing that's interesting about lambda expressions is that you can pass them off to other methods
           for execution. So if I have a lambda expression that I'm passing off to a different scope and it uses
           a local variable in the current scope, the value of that local variable at the time of the call needs
           to somehow make it's way into the other scope where the lambda's actually going to execute and
           that's the process of capturing that value. All of that is done for you by the compiler, you don't
           have to worry about that mechanism, it's all handled underneath the hood.
         */

        IntStream intArrayStream = IntStream.of(primitiveIntArrayOfNumbers);
        System.out.println("\nCreate IntStream using - IntStream.of(array)");
        intArrayStream.forEach(System.out::println);

        //Option 2B - Create IntStream using - IntStream.of(values)
        IntStream intValueStream = IntStream.of(primitiveIntArrayOfNumbers);
        System.out.println("\nCreate IntStream using - IntStream.of(values).forEach(System.out::print)");
        intValueStream.forEach(System.out::print);

        System.out.println("\nCreate IntStream using - IntStream.of(values).forEach(value->System.out.printf(\"%d \",value))");
        IntStream intValueStream1 = IntStream.of(primitiveIntArrayOfNumbers);
        intValueStream1.forEach(value->System.out.printf("%d ",value));
        /*We can also declare the type of parameter in a lambda expression,
        provided we wrap the parameter list within parenthesis-(int value)
        Ex-
          intValueStream1.forEach((int value)->System.out.printf("%d ",value));
        */
        System.out.println();

        //Option 3A - Create IntStream using - IntStream.range()
        IntStream intStreamUsingRange = IntStream.range(10,12);
        System.out.println("\nCreate IntStream using - IntStream.range()");
        intStreamUsingRange.forEach(System.out::println);

        //Option 3B - Create IntStream using - IntStream.rangeClosed()
        IntStream intStreamUsingRangeClosed = IntStream.rangeClosed(10,12);
        System.out.println("\nCreate IntStream using - IntStream.rangeClosed()");
        intStreamUsingRangeClosed.forEach(System.out::println);
    }

}
