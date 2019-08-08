package com.mukul.apcs;

import java.util.concurrent.TimeUnit;

/**
 * Author: Mukul Rao
 *
 * Learnt about Conway's Game of Life and its rules (https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)
 * The following code may be a little inefficient as we check every index and its neighbors every time.
 * Perhaps there is a faster, more efficient way of simulating Conway's Game of Life...
 *
 * */
public class Life {
    public static void printGrid(int[][] board) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(board[i][j] == 1){
                    System.out.printf(String.format("%5s", "●"));
                } else {
                    System.out.printf("%5s", "○");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] grid = new int[5][5];
        grid[1][2] = 1;
        grid[2][2] = 1;
        grid[3][2] = 1;
        printGrid(grid);
        while(true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch(InterruptedException e) {
                System.out.println("got interrupted!");
            }
            int[][] updatedGrid = conways(grid);
            grid = updatedGrid;
            printGrid(updatedGrid);
        }
    }

    public static int[][] conways(int[][] grid) {
        int[][] updatedGrid = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int aliveNeighbors = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int d = j - 1; d <= j + 1; d++) {
                        if (!(k < 0 || k >= grid.length || d < 0 || d >= grid[0].length)) {
                            if (grid[k][d] == 1) {
                                aliveNeighbors++;
                            }
                        }
                    }
                }
                aliveNeighbors = aliveNeighbors - grid[i][j];
                if(grid[i][j] == 1 && aliveNeighbors < 2){ // under-population
                    updatedGrid[i][j] = 0;
                } else if(grid[i][j] == 1 && (aliveNeighbors == 2 || aliveNeighbors == 3)){ // survival
                    updatedGrid[i][j] = 1;
                } else if(grid[i][j] == 1 && aliveNeighbors > 3){ // over-population
                    updatedGrid[i][j] = 0;
                } else if(grid[i][j] == 0 && aliveNeighbors == 3){ // birth
                    updatedGrid[i][j] = 1;
                }
            }
        }
        return updatedGrid;
    }
}