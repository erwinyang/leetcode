package com.leetcode;

import java.util.*;
import java.lang.*;

public class SudokuSolver {

	public static void main(String[] args) {
		char[][] board = new char[9][9];
		for (int i=0; i<9; i++)
		for (int j=0; j<9; j++) {
			board[i][j] = '.';
		}
		new SudokuSolver().solveSudoku(board);
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
    public void solveSudoku(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
    	go(board, 0, 0);
    }
    
    public boolean go(char[][] board, int x, int y) {
    	if (x == 9) {
    		return true;
    	}
    	
		int nextx = x;
		int nexty = y + 1;
		if (nexty == 9) { nexty = 0; nextx++; }
    	
    	if (board[x][y] == '.') {
    		boolean[] av = available(board, x, y);
    		for (int i=0; i<9; i++) {
    			if (av[i]) {
    				board[x][y] = (char) ('1' + i);
    	    		if (go(board, nextx, nexty)) {
    	    			return true;
    	    		}
    			}
    		}
    		board[x][y] = '.';
    	} else {
    		return go(board, nextx, nexty);
    	}
    	
    	return false;
    }
    
    boolean[] available(char[][] board, int x, int y) {
    	boolean[] av = new boolean[9];
    	for (int i=0; i<9; i++) {
    		av[i] = true;
    	}
    	for (int i=0; i<9; i++) {
    		if (board[x][i] != '.') av[board[x][i]-'1'] = false;
    		if (board[i][y] != '.') av[board[i][y]-'1'] = false;
    	}
    	int xx = x / 3 * 3;
    	int yy = y / 3 * 3;
    	for (int i=0; i<3; i++)
    	for (int j=0; j<3; j++) {
    		int xxx = xx+i;
    		int yyy = yy+j;
    		if (board[xxx][yyy] != '.') av[board[xxx][yyy]-'1'] = false;
    	}
    	return av;
    }

}
