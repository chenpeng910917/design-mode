package com.design.pattern.structure.composite.company;

/**
 * 组合模式 员工信息
 *
 * @author chenpeng
 */
public class EmployeeDemo {
    public static void main(String[] args) {
        Employee CEO = new Employee("John", "CEO", 30000);

        // 销售主管
        Employee headSales = new Employee("Robert", "Head Sales", 20000);
        // 营销主管
        Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);

        // 文员1
        Employee clerk1 = new Employee("Laura", "Marketing", 10000);
        // 文员2
        Employee clerk2 = new Employee("Bob", "Marketing", 10000);

        // 销售1
        Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
        // 销售2
        Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        // 打印该组织的所有员工
        System.out.println("该组织所有员工：" + CEO);
        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println(headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }
    }
}
