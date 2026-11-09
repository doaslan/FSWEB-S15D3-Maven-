
package org.example;

import org.example.entity.Employee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Set<Integer> addedIds = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee employee : employees) {
            if (employee != null) {
                countMap.put(
                    employee.getId(),
                    countMap.getOrDefault(employee.getId(), 0) + 1
                );
            }
        }

        for (Employee employee : employees) {
            if (employee != null
                    && countMap.get(employee.getId()) > 1
                    && addedIds.add(employee.getId())) {
                duplicates.add(employee);
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> employeeMap = new HashMap<>();

        for (Employee employee : employees) {
            if (employee != null) {
                employeeMap.putIfAbsent(employee.getId(), employee);
            }
        }

        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Employee> uniqueEmployees = new LinkedList<>();

        for (Employee employee : employees) {
            if (employee != null) {
                countMap.put(
                    employee.getId(),
                    countMap.getOrDefault(employee.getId(), 0) + 1
                );
            }
        }

        for (Employee employee : employees) {
            if (employee != null
                    && countMap.get(employee.getId()) == 1) {
                uniqueEmployees.add(employee);
            }
        }

        return uniqueEmployees;
    }
}
