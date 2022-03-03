package com.design.mode.structure.composite.company;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 员工
 *
 * @author chenpeng
 */
public class Employee {

    /**
     * 员工名称
     */
    private String name;
    /**
     * 部门
     */
    private String department;
    /**
     * 工资
     */
    private double salary;
    /**
     * 下属
     */
    private List<Employee> subordinates;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        subordinates = Lists.newArrayList();
    }

    /**
     * 添加员工
     *
     * @param employee 员工信息
     */
    public void add(Employee employee) {
        subordinates.add(employee);
    }

    /**
     * 删除员工
     *
     * @param employee 员工信息
     */
    public void remove(Employee employee) {
        subordinates.remove(employee);
    }

    /**
     * 获取下属信息
     * @return 下属信息
     */
    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString(){
        return ("Employee :[ Name : "+ name
                +", department : "+ department + ", salary :"
                + salary+" ]");
    }
}
