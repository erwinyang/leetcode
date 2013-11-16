package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SurroundedRegions {

	public static void main(String[] args) {
		String[] cc = new String[] {
				"O"};
		
		char[][] ccc = new char[cc.length][cc[0].length()];
		for (int i=0; i< ccc.length; i++) {
			for (int j=0; j<cc[i].length(); j++) {
				ccc[i][j] = cc[i].charAt(j);
			}
		}
		
		new SurroundedRegions().solve(ccc);
	}

	public void solve(char[][] board) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (board.length > 0 && board[0].length > 0) {
			int n = board.length;
			int m = board[0].length;
			boolean[][] visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				go2(i, 0, board, visited);
				go2(i, m - 1, board, visited);
			}
			for (int j = 0; j < m; j++) {
				go2(0, j, board, visited);
				go2(n - 1, j, board, visited);
			}

			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++) {
					if (!visited[i][j] && board[i][j] == 'O')
						board[i][j] = 'X';
				}
		}
	}

	class P {
		int x, y;
		public P(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int[] dx = new int[] { 0, 0, 1, -1 };
	public static int[] dy = new int[] { 1, -1, 0, 0 };
	
	public void go2(int i, int j, char[][] board, boolean[][] visited) {
		int n = board.length;
		int m = board[0].length;
		
		Queue<P> q = new LinkedList<P>();
		if (!(i >= 0 && i < n && j >= 0 && j < m && board[i][j] == 'O' && !visited[i][j])) {
			q.add(new P(i,j));
		}
		
		P p = null;
		while ((p = q.poll()) != null) {
			for (int k=0; k<4; k++) {
				int xx = p.x + dx[k];
				int yy = p.y + dy[k];
				if (xx >= 0 && xx < n && yy >= 0 && yy < m && board[xx][yy] == 'O' && !visited[xx][yy]) {
					visited[xx][yy] = true;
					q.add(new P(xx, yy));
				}
			}
		}
	}

	public void go(int i, int j, char[][] board, boolean[][] visited) {
		int n = board.length;
		int m = board[0].length;
		if (i >= 0 && i < n && j >= 0 && j < m && board[i][j] == 'O'
				&& !visited[i][j]) {
			visited[i][j] = true;
			go(i - 1, j, board, visited);
			go(i + 1, j, board, visited);
			go(i, j + 1, board, visited);
			go(i, j - 1, board, visited);
		}
	}

}
