package com.shvg.java8.streams;

// Fig. 17.10: ProcessingEmployees.java
// Processing fig17_09_16 of SafariEmployee objects.

import com.shvg.java8.streams.model.SafariEmployee;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployees
{
    public static void main(String[] args)
    {
        // initialize array of Employees
        SafariEmployee[] employees = {
                new SafariEmployee("Jason", "Red", 5000, "IT"),
                new SafariEmployee("Ashley", "Green", 7600, "IT"),
                new SafariEmployee("Matthew", "Indigo", 3587.5, "Sales"),
                new SafariEmployee("James", "Indigo", 4700.77, "Marketing"),
                new SafariEmployee("Luke", "Indigo", 6200, "IT"),
                new SafariEmployee("Jason", "Blue", 3200, "Sales"),
                new SafariEmployee("Wendy", "Brown", 4236.4, "Marketing")};

        // get List view of the Employees
        List<SafariEmployee> list = Arrays.asList(employees);

        // display all Employees
        System.out.println("Complete SafariEmployee list:");
        list.stream().forEach(System.out::println);

        // Predicate that returns true for salaries in the range $4000-$6000
        Predicate<SafariEmployee> fourToSixThousand =
                e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

        // Display Employees with salaries in the range $4000-$6000
        // sorted into ascending order by salary
        System.out.printf(
                "%nEmployees earning $4000-$6000 per month sorted by salary:%n");
        list.stream()
                .filter(fourToSixThousand)
                .sorted(Comparator.comparing(SafariEmployee::getSalary))
                .forEach(System.out::println);

        // Display first SafariEmployee with salary in the range $4000-$6000
        System.out.printf("%nFirst employee who earns $4000-$6000:%n%s%n",
                list.stream()
                        .filter(fourToSixThousand)
                        .findFirst()
                        .get());

        // Functions for getting first and last names from an SafariEmployee
        Function<SafariEmployee, String> byFirstName = SafariEmployee::getFirstName;
        Function<SafariEmployee, String> byLastName = SafariEmployee::getLastName;

        // Comparator for comparing Employees by first name then last name
        Comparator<SafariEmployee> lastThenFirst =
                Comparator.comparing(byLastName).thenComparing(byFirstName);

        // sort employees by last name, then first name
        System.out.printf(
                "%nEmployees in ascending order by last name then first:%n");
        list.stream()
                .sorted(lastThenFirst)
                .forEach(System.out::println);

        // sort employees in descending order by last name, then first name
        System.out.printf(
                "%nEmployees in descending order by last name then first:%n");
        list.stream()
                .sorted(lastThenFirst.reversed())
                .forEach(System.out::println);

        // display unique employee last names sorted
        System.out.printf("%nUnique employee last names:%n");
        list.stream()
                .map(SafariEmployee::getLastName)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // display only first and last names
        System.out.printf(
                "%nEmployee names in order by last name then first name:%n");

        list.stream()
                .sorted(lastThenFirst)
                .map(SafariEmployee::getName)
                .forEach(System.out::println);

        // group Employees by department
        System.out.printf("%nEmployees by department:%n");

        Map<String, List<SafariEmployee>> groupedByDepartment =
                list.stream()
                        .collect(Collectors.groupingBy(SafariEmployee::getDepartment));

        groupedByDepartment.forEach(
                (department, employeesInDepartment) ->
                {
                    System.out.println(department);
                    employeesInDepartment.forEach(
                            employee -> System.out.printf("   %s%n", employee));
                }
        );

        // count number of Employees in each department
        System.out.printf("%nCount of Employees by department:%n");

        Map<String, Long> employeeCountByDepartment =
                list.stream()
                        .collect(
                                Collectors.groupingBy(
                                        SafariEmployee::getDepartment, TreeMap::new, Collectors.counting()
                                ));

        employeeCountByDepartment.forEach(
                (department, count) -> System.out.printf(
                        "%s has %d employee(s)%n", department, count));

        // sum of SafariEmployee salaries with DoubleStream sum method
        System.out.printf(
                "%nSum of Employees' salaries (via sum method): %.2f%n",
                list.stream()
                        .mapToDouble(SafariEmployee::getSalary)
                        .sum());

        // calculate sum of SafariEmployee salaries with Stream reduce method
        System.out.printf(
                "Sum of Employees' salaries (via reduce method): %.2f%n",
                list.stream()
                        .mapToDouble(SafariEmployee::getSalary)
                        .reduce(0, (value1, value2) -> value1 + value2));

        // average of SafariEmployee salaries with DoubleStream average method
        System.out.printf("Average of Employees' salaries: %.2f%n",
                list.stream()
                        .mapToDouble(SafariEmployee::getSalary)
                        .average()
                        .getAsDouble());
    } // end main
} // end class ProcessingEmployees


/*************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

