package com.leetcode;

import java.util.*;
import java.lang.*;

public class WordSearch {

	public static void main(String[] args) {
		new WordSearch().exist(new char[][] { { 'a' } }, "ab");
	}

    static final int[] dx = new int[] { -1, 0, 1, 0 };
    static final int[] dy = new int[] { 0, 1, 0, -1 };
    
    int n;
    int m;
    char[][] board;
    String word;
    boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        
        this.n = board.length;
        this.m = board[0].length;
        this.board = board;
        this.word = word;
        for (int i=0; i<n; i++)
        for (int j=0; j<m; j++) {
            visited = new boolean[n][m];
            if (isMatch(i, j, 0)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isMatch(int x, int y, int index) {
        if (board[x][y] == word.charAt(index)) {
            if (index == word.length()-1) {
                return true;
            } else {
                visited[x][y] = true;
                for (int i=0; i<4; i++) {
                    int nextx = x + dx[i];
                    int nexty = y + dy[i];
                    if (isValid(nextx, nexty) && !visited[nextx][nexty] && isMatch(nextx, nexty, index+1)) {
                        return true;
                    }
                }
                visited[x][y] = false;
            }
        }
        return false;
    }
    
    public boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
