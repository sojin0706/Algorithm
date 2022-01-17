package GOLD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_9663_Nqueen {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static StringTokenizer tokens;
	static int C;
	static int[]map;
	static int cnt;
	//ê³µê²©?•  ?ˆ˜ ?—†ê²? ?†“?Š”ë²? => ê°™ì??—´ x ??ê°ì„  x
	public static void main(String[] args) throws NumberFormatException, IOException {
		C=Integer.parseInt(br.readLine()); //?–‰?? ?•­?ƒ +1?¼ê±°ë‹ˆê¹? ?—´ë§? ë°›ëŠ”?‹¤.(1ì°¨ì›ë°°ì—´ë¡? ?ƒê°?)
		map=new int[C]; 
			cnt=0;	
			queen(0);
			System.out.println(cnt);
	}
	
	static void queen(int r) {
		if(r==C) {
			cnt++;
			return;
		}
		
		for(int i=0;i<C;i++) {
			map[r]=i; //ì²«ë²ˆì§¸ì— i?„£ê¸?
			if(isCheck(r)==true) { //?´ ?ë¦? ê°??Š¥?•œì§? ì²´í¬?•˜ê³? ?„˜?–´ê°?ê¸? 
				queen(r+1);
			}
		}
		
		
	}
	static boolean isCheck(int r) {
		for(int i=0;i<r;i++) { //?´? „ê²ƒì´?‘ ë¹„êµ  (?´?›„?Š” ?–´ì°¨í”¼ ?—†?œ¼?‹ˆ ë¹„êµx)
			//ë§Œì•½ ?—´?„ ê°™ì? ?•Šê³? ??ê°ì„ ?— ?ˆì§? ?•Š?œ¼ë©? return true 
			if((map[r]==map[i])||(Math.abs(map[r]-map[i])==Math.abs(r-i))){
				return false;
			}
		}
		return true;
	}
	
}
