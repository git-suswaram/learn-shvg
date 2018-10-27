package com.shvg.java8.streams;
// Fig. 17.10: ProcessingEmployees.java
// Processing fig17_09_16 of SafariEmployee objects.
import com.shvg.java8.streams.model.SafariEmployee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProcessingEmployees_Practice
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
        System.out.println("List of Employees %s\n"+list);

        // group Employees by department
        Map<String, List<SafariEmployee>> groupedByDepartment =
                list.stream().collect(Collectors.groupingBy(SafariEmployee::getDepartment));

        System.out.println("List of Employees grouped by department %s\n"+groupedByDepartment);

        groupedByDepartment.forEach(
                (dept, empInDept) ->
                {
                    System.out.println(dept);
                    empInDept.forEach(
                            employee->System.out.printf("       %s%n",employee)
                    );
                }
        );








    } // end main
} // end class ProcessingEmployees
