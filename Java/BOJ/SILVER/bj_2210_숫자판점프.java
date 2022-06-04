package SILVER?…Œ?Š¤?Š¸ì¤?ë¹?;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//ì²˜ìŒ?— ?ˆœ?—´ë¬¸ì œ?¸ê°???‹¶ê¸°ë„?–ˆì§?ë§? ê¹Šì´?š°?„ ?ƒ?ƒ‰?œ¼ë¡? ???–´?•¼?• ê²ƒê°™?‹¤
//ê·¸ëƒ¥ ì²˜ìŒë¶??„° ?ê¹Œì? dfsë¡? ê°ˆìˆ˜?ˆ?Š” ?ˆ˜ë¥? ?‹¤ ë§Œë“¤?–´ë³´ê¸° -> ë¦¬ìŠ¤?Š¸?˜ indexOf?„ ?‚¬?š©?•´?„œ ?—†?œ¼ë©? ?„£ê³? ë§ˆì?ë§‰ì— ë¦¬ìŠ¤?Š¸?˜ ?‚¬?´ì¦? ì¶œë ¥?•˜ê¸? 
public class bj_2210_?ˆ«??Œ? ?”„ {
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
		}//?…? ¥?™„ë£?
		
		for(int r=0;r<5;r++) {
			for(int c=0;c<5;c++) {
				
				 dfs(r,c,0,map[r][c]+"");
			}
		}
		
		
		System.out.println(list.size());

	}
	private static void dfs(int r,int c,int cnt,String str) {
		
		if(cnt==5) {
			//ì°¾ëŠ” ë¬¸ì?—´?´ ?—†?œ¼ë©? -1?´ê³?, ?ˆ?œ¼ë©? ì²˜ìŒ?œ¼ë¡? ?‚˜???‚´?Š” ?¸?±?Š¤ê°’ì„ return?•œ?‹¤. 
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
