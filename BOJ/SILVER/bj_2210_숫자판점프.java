package SILVER?��?��?���?�?;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//처음?�� ?��?��문제?���???��기도?���?�? 깊이?��?��?��?��?���? ???��?��?��것같?��
//그냥 처음�??�� ?��까�? dfs�? 갈수?��?�� ?���? ?�� 만들?��보기 -> 리스?��?�� indexOf?�� ?��?��?��?�� ?��?���? ?���? 마�?막에 리스?��?�� ?��?���? 출력?���? 
public class bj_2210_?��?��?��?��?�� {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static String[][]map;
	static ArrayList<String>list;
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		map=new String[5][5];
		list=new ArrayList<>();
		for(int r=0;r<5;r++) {
			tokens=new StringTokenizer(br.readLine());
			for(int c=0;c<5;c++) {
				map[r][c]=tokens.nextToken();
			}
		}//?��?��?���?
		
		for(int r=0;r<5;r++) {
			for(int c=0;c<5;c++) {
				
				 dfs(r,c,0,map[r][c]+"");
			}
		}
		
		
		System.out.println(list.size());

	}
	private static void dfs(int r,int c,int cnt,String str) {
		
		if(cnt==5) {
			//찾는 문자?��?�� ?��?���? -1?���?, ?��?���? 처음?���? ?��???��?�� ?��?��?��값을 return?��?��. 
			if(list.indexOf(str)<0) {
				list.add(str);
			}
			return;
		}
		for(int d=0;d<deltas.length;d++) {
			int nr=r+deltas[d][0];
			int nc=c+deltas[d][1];
			if(isIn(nr,nc)) {
				dfs(nr,nc,cnt+1,str+map[nr][nc]);
			}
		}
	}
		
	
	private static boolean isIn(int r,int c) {
		return r>=0&&c>=0&&r<5&&c<5;
	}

}
