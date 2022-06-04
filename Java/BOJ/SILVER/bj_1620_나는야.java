package SILVER?…Œ?Š¤?Š¸ì¤?ë¹?;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj_1620_?‚˜?Š”?•¼ {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(tokens.nextToken());
		int M=Integer.parseInt(tokens.nextToken());
		//?ˆ«?ë¥? ?–»?„?• Integerê°? key?¸ hashmap?„ ?‚¬?š©
		HashMap<Integer, String>getNum=new HashMap<Integer, String>();
		//ë¬¸ìë¥? ?–»?„?• String?´ key?¸ hashmap?„ ?‚¬?š©
		HashMap<String, Integer>getString=new HashMap<String, Integer>();

		for(int i=1;i<=N;i++) {
			String str=br.readLine();
			getNum.put(i, str); //?ˆ«?ë¡? ì°¾ê³ ?‹¶?„?•Œ
			getString.put(str,i); //ë¬¸ìë¡? ì°¾ê³ ?‹¶?„?•Œ 
		}
		
		for(int i=0;i<M;i++) {
			String ans=br.readLine();
			if(isCheck(ans)) {
				output.append(getNum.get(Integer.parseInt(ans))).append("\n");
			}else {
				output.append(getString.get(ans)).append("\n");
			}
		}
		System.out.println(output);
		
	}
	//?ˆ«??¸ì§? ë¬¸ì?¸ì§? ì²´í¬ 
	private static boolean isCheck(String str) {
		for(int i = 0; i<str.length(); i++){
			char check = str.charAt(i);
			if( check < 48 || check > 58)
			{
				//?•´?‹¹ charê°’ì´ ?ˆ«?ê°? ?•„?‹ ê²½ìš°
				return false;
			}
			
		}		
		return true;
	}

}
