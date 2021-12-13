package 코딩테스트준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//처음에 순열문제인가?싶기도했지만 깊이우선탐색으로 풀어야할것같다
//그냥 처음부터 끝까지 dfs로 갈수있는 수를 다 만들어보기 -> 리스트의 indexOf을 사용해서 없으면 넣고 마지막에 리스트의 사이즈 출력하기 
public class bj_2210_숫자판점프 {
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
		}//입력완료
		
		for(int r=0;r<5;r++) {
			for(int c=0;c<5;c++) {
				
				 dfs(r,c,0,map[r][c]+"");
			}
		}
		
		
		System.out.println(list.size());

	}
	private static void dfs(int r,int c,int cnt,String str) {
		
		if(cnt==5) {
			//찾는 문자열이 없으면 -1이고, 있으면 처음으로 나타내는 인덱스값을 return한다. 
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
