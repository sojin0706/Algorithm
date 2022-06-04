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
	//공격?�� ?�� ?���? ?��?���? => 같�??�� x ??각선 x
	public static void main(String[] args) throws NumberFormatException, IOException {
		C=Integer.parseInt(br.readLine()); //?��?? ?��?�� +1?��거니�? ?���? 받는?��.(1차원배열�? ?���?)
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
			map[r]=i; //첫번째에 i?���?
			if(isCheck(r)==true) { //?�� ?���? �??��?���? 체크?���? ?��?���?�? 
				queen(r+1);
			}
		}
		
		
	}
	static boolean isCheck(int r) {
		for(int i=0;i<r;i++) { //?��?��것이?�� 비교  (?��?��?�� ?��차피 ?��?��?�� 비교x)
			//만약 ?��?�� 같�? ?���? ??각선?�� ?���? ?��?���? return true 
			if((map[r]==map[i])||(Math.abs(map[r]-map[i])==Math.abs(r-i))){
				return false;
			}
		}
		return true;
	}
	
}
