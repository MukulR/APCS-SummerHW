package com.mukul.apcs;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
public class SumList  {
    private static double sumList(ArrayList<Double> list){
        double total = 0;
        for(int i = 0; i < list.size(); i++){
            total = total + list.get(i);
        }
        return total;
    }

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter doubles, # to print");
        String line = reader.nextLine();
        ArrayList<Double> theList = new ArrayList<Double>();
        DecimalFormat oneDecimal = new DecimalFormat("#0.0");
        while(true){
            if(line.equals("#")){
                break;
            } else {
                theList.add(Double.parseDouble(line));
            }
            line = reader.nextLine();
        }
        System.out.println(oneDecimal.format(sumList(theList)));
    }
}