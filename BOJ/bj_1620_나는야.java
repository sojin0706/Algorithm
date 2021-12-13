package 코딩테스트준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj_1620_나는야 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(tokens.nextToken());
		int M=Integer.parseInt(tokens.nextToken());
		//숫자를 얻을땐 Integer가 key인 hashmap을 사용
		HashMap<Integer, String>getNum=new HashMap<Integer, String>();
		//문자를 얻을땐 String이 key인 hashmap을 사용
		HashMap<String, Integer>getString=new HashMap<String, Integer>();

		for(int i=1;i<=N;i++) {
			String str=br.readLine();
			getNum.put(i, str); //숫자로 찾고싶을때
			getString.put(str,i); //문자로 찾고싶을때 
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
	//숫자인지 문자인지 체크 
	private static boolean isCheck(String str) {
		for(int i = 0; i<str.length(); i++){
			char check = str.charAt(i);
			if( check < 48 || check > 58)
			{
				//해당 char값이 숫자가 아닐 경우
				return false;
			}
			
		}		
		return true;
	}

}
