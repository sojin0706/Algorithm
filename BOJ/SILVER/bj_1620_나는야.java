package SILVER?��?��?���?�?;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj_1620_?��?��?�� {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(tokens.nextToken());
		int M=Integer.parseInt(tokens.nextToken());
		//?��?���? ?��?��?�� Integer�? key?�� hashmap?�� ?��?��
		HashMap<Integer, String>getNum=new HashMap<Integer, String>();
		//문자�? ?��?��?�� String?�� key?�� hashmap?�� ?��?��
		HashMap<String, Integer>getString=new HashMap<String, Integer>();

		for(int i=1;i<=N;i++) {
			String str=br.readLine();
			getNum.put(i, str); //?��?���? 찾고?��?��?��
			getString.put(str,i); //문자�? 찾고?��?��?�� 
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
	//?��?��?���? 문자?���? 체크 
	private static boolean isCheck(String str) {
		for(int i = 0; i<str.length(); i++){
			char check = str.charAt(i);
			if( check < 48 || check > 58)
			{
				//?��?�� char값이 ?��?���? ?��?�� 경우
				return false;
			}
			
		}		
		return true;
	}

}
