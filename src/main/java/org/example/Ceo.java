package org.example;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ceo extends Employee implements IEmployee, Apple{
    private int avgStockPrice = 0;

    private final String ceoRegex = "\\w+=(?<avgStockPrice>\\w+)";
    private final Pattern ceoPat = Pattern.compile(ceoRegex);

    public Ceo(String personText) {
        super(personText);
            Matcher ceoMat = ceoPat.matcher(peopleMat.group("details"));
            if (ceoMat.find()){
                this.avgStockPrice = Integer.parseInt(ceoMat.group("avgStockPrice"));
        }
    }

    public int getSalary(){
//        salary =  3000 + locpd * yoe * iq;
        return 5000 * avgStockPrice;
    }
}
