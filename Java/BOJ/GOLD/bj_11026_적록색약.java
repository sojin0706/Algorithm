package GOLD;
import java.awt.DefaultFocusTraversalPolicy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_11026_? ë¡ìƒ‰?•½ {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static char[][]map;
	static int N;
	static boolean[][]visited; //? ë¡ìƒ‰?•½
	static int count; //?ƒ‰?•½ ì¹´ìš´?Š¸
	static int[][] delta= {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		N=Integer.parseInt(br.readLine());
		map=new char[N][N];

		visited=new boolean[N][N];
		for(int r=0;r<N;r++) {
			String str=br.readLine();
			for(int c=0;c<N;c++) {
				map[r][c]=str.charAt(c);
			}
		}
		//? •?ƒ?¸
		count=0;
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(visited[r][c]==false) {
					count++;
					dfs(r,c,map[r][c]);
				}
			}
		}
		output.append(count).append(" ");
		
		make_s(); //?ƒ‰?•½ ë§Œë“¤ê¸? 
		visited=new boolean[N][N]; //?‹¤?‹œ ì´ˆê¸°?™”
		//? ë¡ìƒ‰?•½
				count=0;
				
				for(int r=0;r<N;r++) {
					for(int c=0;c<N;c++) {
						if(visited[r][c]==false) {
							count++;
							dfs(r,c,map[r][c]);
						}
					}
				}
				output.append(count);
				
				System.out.println(output);
	}
	private static void dfs(int r,int c,char color) {
		if(visited[r][c]==true) return;
		visited[r][c]=true;
		for(int d=0;d<delta.length;d++) {
			int nr=r+delta[d][0];
			int nc=c+delta[d][1];
			if(isIn(nr,nc)&&map[nr][nc]==color) {
				
				dfs(nr,nc,color);
			}
		}
	
	}
	private static void make_s() {
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c]=='R') {
					map[r][c]='G'; //ê·¸ëƒ¥ ë¹¨ê°•?„ ì´ˆë¡?œ¼ë¡? ë°”ê¿”ë²„ë¦¬ê¸? 
				}
			}
		}
	}
	
	private static boolean isIn(int r,int c) {
		return r>=0&&r<N&&c>=0&&c<N;
	}
	
}
