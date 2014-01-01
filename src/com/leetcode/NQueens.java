package com.leetcode;

import java.util.*;
import java.lang.*;

public class NQueens {

    int n;
    ArrayList<String[]> solutions;
    char[][] board;
    
    public ArrayList<String[]> solveNQueens(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        this.n = n;
        this.solutions = new ArrayList<String[]>();
        this.board = new char[n][n];
        for (int i=0; i<n; i++)
        for (int j=0; j<n; j++) {
            board[i][j] = '.';
        }
        dfs(0, 0, 0);
        return solutions;
    }
    
    public void dfs(int x, int y, int count) {
        if (count == n) {
            saveSolution();
        } else {
            for (int i=x; i<n; i++)
            for (int j=y; j<n; j++) {
                if (!underAttack(i, j)) {
                    board[i][j] = 'Q';
                    dfs(i+1, 0, count+1);
                    board[i][j] = '.';
                }
            }
        }
    }
    
    public static final int[] dx = { -1,  0, -1, -1 };
    public static final int[] dy = {  0, -1, -1,  1 };
    
    public boolean underAttack(int x, int y) {
        for (int d=0; d<4; d++) {
            int px = x + dx[d];
            int py = y + dy[d];
            while (isValid(px) && isValid(py)) {
                if (board[px][py] == 'Q') {
                    return true;
                }
                px += dx[d]; py += dy[d];
            }
        }
        return false;
    }
    
    public boolean isValid(int p) {
        return p>=0 && p<n;
    }
    
    public void saveSolution() {
        String[] solution = new String[n];
        for (int i=0; i<n; i++) {
            solution[i] = new String(board[i]);
        }
        solutions.add(solution);
    }
}
