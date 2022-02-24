package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_16472_고냥이 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static char[]arr;
	static int[]alph;
	static int N;
	public static void main(String[] args) throws Exception{
		N=Integer.parseInt(br.readLine());
		
		// N개의 종류의 알파벳만을 가져야한다.
		
		String str=br.readLine();
		arr=new char[str.length()];
		for(int i=0;i<str.length();i++) {
			arr[i]=str.charAt(i);
		}
		int max=Integer.MIN_VALUE;
		// 다해보기
		for(int i=0;i<str.length()-1;i++) {
			alph=new int[26];
			int cnt=1; // 첫번째부터 끝-1까지 다 해보기 
			int len=1;
			char start=arr[i]; // 내 문자열
			for(int j=i+1;j<str.length();j++) {
				if(start!=arr[j]) {
					if(alph[arr[j]-'a']==0) {
						cnt++; //무작정 올리면 안된다. -> 만약 이전에 나오지 않은거라면 ++
						alph[arr[j]-'a']++;
					}
				}
				if(cnt>N) {
					break; //크면 for문을 탈출한다.
				}
				len++; //빠져나가지 않았다면 
			}
			
			max=Math.max(max, len);
		}
		
		System.out.println(max);
		
	}

}
