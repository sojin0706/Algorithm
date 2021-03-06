package SILVER??€?Έμ€?λΉ?;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_14620_κ½κΈΈ {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	static int N;
	static int[][]map;
	static boolean[][]visited;
	static int min=Integer.MAX_VALUE;
	//κ°??₯?λ¦¬λ ??x -> ?΄μ°¨νΌ λΆκ??₯??κΉ?
	// 1λΆ??° N-1κΉμ?λ§? λ³΄λ©΄??€. (dfsλ‘? ???κ³?, ?¬λ°? λ°©λ¬Έμ²΄ν¬ ??? λ°©λ¬Έxλ©? sum? κ΅¬νκΈ?)
	public static void main(String[] args) throws NumberFormatException, IOException {
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int r=0;r<N;r++) {
			tokens=new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(tokens.nextToken());
			}
		}//?? ₯?λ£?
		visited=new boolean[N][N];
		dfs(0,0);
		System.out.println(min);
	
	}
	
	private static void dfs(int cnt,int sum) {
		if(cnt==3) {
			min=Integer.min(sum, min);
			return;
		}else {
			for(int r=1;r<N-1;r++) {
				for(int c=1;c<N-1;c++) {
					//λ§μ½ κ°? ? ??€λ©??
					if(isCheck(r,c)&&visited[r][c]==false) {
						visited[r][c]=true;
						dfs(cnt+1,sum+sum(r,c));
						nocheck(r,c); //?€? μ΄κΈ°? ?μΌμ£ΌκΈ? 
					}
				}
			}
		}
	}
	private static boolean isCheck(int r,int c) {
		for(int d=0;d<deltas.length;d++) {
			int nr=r+deltas[d][0];
			int nc=c+deltas[d][1];
			//λ§μ½ ?? ?κ±°λ, ?κ³³μ΄?Ό? λ°©λ¬Έ?΄ ??€λ©? return false
			if(isIn(nr,nc)==false||visited[nr][nc]==true) {
				return false; 
			}
		}
		return true; //κ·Έκ² ???Όλ©? return true
	}
	private static void nocheck(int r,int c) {
		visited[r][c]=false;
		for(int d=0;d<deltas.length;d++) {
			int nr=r+deltas[d][0];
			int nc=c+deltas[d][1];
			//λ§μ½ ?? ?κ±°λ, ?κ³³μ΄?Ό? λ°©λ¬Έ?΄ ??€λ©? return false
			visited[nr][nc]=false;
		}
	}
	private static int sum(int r,int c) {
		int sum=0;
		sum+=map[r][c];
		for(int d=0;d<deltas.length;d++) {
			int nr=r+deltas[d][0];
			int nc=c+deltas[d][1];
			sum+=map[nr][nc];
			visited[nr][nc]=true;
		}
		return sum;
	}
	
	private static boolean isIn(int r,int c) {
		return r>=0&&c>=0&&r<N&&c<N;
	}
	private static class Point{
		int r,c;
		
		public Point(int r,int c){
			this.r=r;
			this.c=c;
			
		}
	}

}
