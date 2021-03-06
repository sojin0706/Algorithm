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
	//κ³΅κ²©?  ? ?κ²? ??λ²? => κ°μ??΄ x ??κ°μ  x
	public static void main(String[] args) throws NumberFormatException, IOException {
		C=Integer.parseInt(br.readLine()); //??? ?­? +1?Όκ±°λκΉ? ?΄λ§? λ°λ?€.(1μ°¨μλ°°μ΄λ‘? ?κ°?)
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
			map[r]=i; //μ²«λ²μ§Έμ i?£κΈ?
			if(isCheck(r)==true) { //?΄ ?λ¦? κ°??₯?μ§? μ²΄ν¬?κ³? ??΄κ°?κΈ? 
				queen(r+1);
			}
		}
		
		
	}
	static boolean isCheck(int r) {
		for(int i=0;i<r;i++) { //?΄? κ²μ΄? λΉκ΅  (?΄?? ?΄μ°¨νΌ ??Ό? λΉκ΅x)
			//λ§μ½ ?΄? κ°μ? ?κ³? ??κ°μ ? ?μ§? ??Όλ©? return true 
			if((map[r]==map[i])||(Math.abs(map[r]-map[i])==Math.abs(r-i))){
				return false;
			}
		}
		return true;
	}
	
}
