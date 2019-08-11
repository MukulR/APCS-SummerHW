package com.mukul.apcs;

import java.util.concurrent.TimeUnit;

/**
 * Author: Mukul Rao
 *
 * Learnt about Conway's Game of Life and its rules (https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)
 * The following code is my first attempt at implementing Conway's Game of Life.
 * I know of many inefficiencies that I intend to iterate on in the future. The following are some of them:
 * 1. For every new generation I am making a new copy of the grid. I intend to come up with an algorithm
 *    that will eliminate copying.
 * 2. Allow customization of grid size and initial state. The current implementation has hard coded
 *    grid dimensions and initial state. (GUI w/ Processing)?
 */

public class ConwaysGameOfLife {
    public static void printGrid(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //For nicer looking grids
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
        int[][] grid = new int[10][10];
        // Sample initial position (oscillating "Toad" - as called by wikipedia)
        grid[4][4] = 1;
        grid[4][5] = 1;
        grid[4][6] = 1;
        grid[3][5] = 1;
        grid[3][6] = 1;
        grid[3][7] = 1;
        printGrid(grid);
        while(true) {
            // 1 second delay between grid read-outs.
            // try catch to prevent interruption exceptions
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch(InterruptedException e) {
                System.out.println("got interrupted!");
            }
            int[][] updatedGrid = updateGrid(grid);
            grid = updatedGrid;
            printGrid(updatedGrid);
        }
    }

    /**
     * In order to find 8 neighbors for a given cell, I form a 3x3 matrix
     * around the given cell. (The 2 inner for loops)
     *
     * I take into account that for certain some neighbors may be invalid, (out of bounds)
     * and process the valid neighbors only.
     */
    public static int[][] updateGrid(int[][] grid) {
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