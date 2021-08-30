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
	//공격할 수 없게 놓는법 => 같은열 x 대각선 x
	public static void main(String[] args) throws NumberFormatException, IOException {
		C=Integer.parseInt(br.readLine()); //행은 항상 +1일거니까 열만 받는다.(1차원배열로 생각)
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
			map[r]=i; //첫번째에 i넣기
			if(isCheck(r)==true) { //이 자리 가능한지 체크하고 넘어가기 
				queen(r+1);
			}
		}
		
		
	}
	static boolean isCheck(int r) {
		for(int i=0;i<r;i++) { //이전것이랑 비교  (이후는 어차피 없으니 비교x)
			//만약 열도 같지 않고 대각선에 있지 않으면 return true 
			if((map[r]==map[i])||(Math.abs(map[r]-map[i])==Math.abs(r-i))){
				return false;
			}
		}
		return true;
	}
	
}
