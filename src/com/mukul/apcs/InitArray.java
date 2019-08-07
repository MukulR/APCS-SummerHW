package com.mukul.apcs;

import java.util.Scanner;

public class InitArray {
    public int rows = 0;
    public int columns = 0;

    public InitArray(int r, int c){
        rows = r;
        columns = c;
    }

    public void initArray(int[][] arr){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = i * j;
            }
        }
    }

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);

        int rows = reader.nextInt();
        int columns = reader.nextInt();
        InitArray ia = new InitArray(rows, columns);

        int[][] arr = new int[ia.rows][ia.columns];
        ia.initArray(arr);
        System.out.println(arr[3][5]);
        System.out.println(arr[17][4]);
    }
}
