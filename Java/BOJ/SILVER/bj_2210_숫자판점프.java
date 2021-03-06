package SILVER??€?Έμ€?λΉ?;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//μ²μ? ??΄λ¬Έμ ?Έκ°???ΆκΈ°λ?μ§?λ§? κΉμ΄?°? ???Όλ‘? ???΄?Ό? κ²κ°?€
//κ·Έλ₯ μ²μλΆ??° ?κΉμ? dfsλ‘? κ°μ?? ?λ₯? ?€ λ§λ€?΄λ³΄κΈ° -> λ¦¬μ€?Έ? indexOf? ?¬?©?΄? ??Όλ©? ?£κ³? λ§μ?λ§μ λ¦¬μ€?Έ? ?¬?΄μ¦? μΆλ ₯?κΈ? 
public class bj_2210_?«??? ? {
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
		}//?? ₯?λ£?
		
		for(int r=0;r<5;r++) {
			for(int c=0;c<5;c++) {
				
				 dfs(r,c,0,map[r][c]+"");
			}
		}
		
		
		System.out.println(list.size());

	}
	private static void dfs(int r,int c,int cnt,String str) {
		
		if(cnt==5) {
			//μ°Ύλ λ¬Έμ?΄?΄ ??Όλ©? -1?΄κ³?, ??Όλ©? μ²μ?Όλ‘? ????΄? ?Έ?±?€κ°μ return??€. 
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
