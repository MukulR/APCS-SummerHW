package com.mukul.apcs;
import java.util.Scanner;

public class SumSquares {
    public static int sumSquares(int start, int end) {
        int total = 0;
        for (int i = start; i <= end; i++){
            total = total + i*i;
        }
        return total;
    }

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter two integers");
        int start = reader.nextInt();
        int end = reader.nextInt();
        System.out.println(sumSquares(start, end));
        reader.close();
    } //End of main
} //End of SumSquares Class