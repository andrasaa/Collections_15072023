package org.example;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) {
        String peopleText = """
            Flinstone1, Fred1, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone2, Fred2, 1/1/1900, Programmerzzzz, {locpd=1300,yoe=14,iq=100}
            Flinstone3, Fred3, 1/1/1900, Programmer, {locpd=2300,yoe=8,iq=105}
            Flinstone4, Fred4, 1/1/1900, Programmer, {locpd=1630,yoe=3,iq=115}
            Flinstone5, Fred5, 1/1/1900, Programmer, {locpd=5,yoe=10,iq=100}
            Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
            Rubble2, Barney2, 2/2/1905, Manager, {orgSize=100,dr=4}
            Rubble3, Barney3, 2/2/1905, Manager, {orgSize=200,dr=2}
            Rubble4, Barney4, 2/2/1905, Manager, {orgSize=500,dr=8}
            Rubble5, Barney5, 2/2/1905, Manager, {orgSize=175,dr=20}
            Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
            Flinstone2, Wilma2, 3/3/1910, Analyst, {projectCount=4}
            Flinstone3, Wilma3, 3/3/1910, Analyst, {projectCount=5}
            Flinstone4, Wilma4, 3/3/1910, Analyst, {projectCount=6}
            Flinstone5, Wilma5, 3/3/1910, Analyst, {projectCount=9}
            Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
            """;

        Matcher peopleMat   = Employee.PEOPLE_PAT.matcher(peopleText);


        int totalSalaries = 0;
        IEmployee employee = null;
        List<IEmployee> employees = new LinkedList<>();
        while (peopleMat.find()) {
            employee = Employee.createEmployee(peopleMat.group());
            employees.add(employee);
            //Changed:

//            if (employee instanceof Programmer prog){
////                Programmer prog = (Programmer) employee;
//                System.out.println(prog.getIq());
//            } else if (employee instanceof Manager man){
//                System.out.println(man.toString());
//            } else if (employee instanceof Analyst){
//                System.out.println();
//            } else if (employee instanceof Ceo){
//                System.out.println();
//            } else {
//                System.out.println("Default output");
//            }
//            System.out.println(employee.toString());
//            totalSalaries+= employee.getSalary();
        }



        IEmployee myEmp = employees.get(5);
        System.out.println(employees.contains(myEmp));

        IEmployee employee1 = Employee.createEmployee("Flinstone5, Fred5, 1/1/1900, Programmer, {locpd=5,yoe=10,iq=100}");
        System.out.println(employees.contains(employee1));

        System.out.println(myEmp.equals(employee1));

        Collections.shuffle();
        Collections.sort(employees, Comparator.reverseOrder());

//        employees.sort((o1, o2) -> {
//            if (o1 instanceof Employee emp1 && o2 instanceof Employee emp2){
//                int lnameResult =  emp1.lastName.compareTo(emp2.lastName);
//                return lnameResult != 0 ? lnameResult : Integer.compare(emp1.getSalary(),emp2.getSalary());
//            }
//        return 0;
//        });

//        employees.set(0, Employee.createEmployee("Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300)"));
//
//        List<String> undesirables = new ArrayList<>(List.of("Wilma5","Barney4","Fred2"));
//        undesirables.sort(Comparator.naturalOrder());
//        System.out.println(undesirables);
        //        removeUndesirables(employees, undesirables);
//
//        List<String> newStrings = new ArrayList<>();
//        newStrings.addAll(undesirables);
//        System.out.println(newStrings.size());
//
        for(IEmployee worker : employees){
            System.out.println(worker.toString());
            totalSalaries += worker.getSalary();
        }

//        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
//        System.out.printf("The total payout should be %s%n", currencyInstance.format(totalSalaries));
//
//    Weirdo larry = new Weirdo("David", "Larry", LocalDate.of(1950,1,1));
//    Weirdo jake = new Weirdo("Snake","Jake");
//    jake.sayHello();
}

    private static void removeUndesirables(List<IEmployee> employees, List<String> removalNames) {
        for (Iterator<IEmployee> it = employees.iterator(); it.hasNext(); ){
            IEmployee worker = it.next();
            if (worker instanceof Employee tmpWorker){
               if (removalNames.contains(tmpWorker.firstName)){
                   it.remove();
               }
            }
        }
    }
}
