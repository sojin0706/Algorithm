package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_20437_문자열게임2 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		char[]arr;
		int[]alph;
		for(int t=0;t<T;t++) {
			alph=new int[26]; //알파벳 개수 
			String str=br.readLine();
			int N=Integer.parseInt(br.readLine());
			
			arr=new char[str.length()];
			for(int i=0;i<str.length();i++) {
				arr[i]=str.charAt(i);
				alph[str.charAt(i)-97]++;
			}

			int min=Integer.MAX_VALUE; //가장 짧은 연속 문자열 길이
			int max=Integer.MIN_VALUE; //가장 긴 문자열 길이 
			boolean flag=false;
			//특정 알파벳의 길이가 N개인것 찾기 
			for(int i=0;i<str.length();i++) {
				// N보다 큰게 있을때만 확인한다. 
				if(alph[arr[i]-97]>=N) {
					flag=true;
					int cnt=0;
					
					for(int j=i;j<str.length();j++) {
						//같은게 있으면
						if(str.charAt(j)==str.charAt(i)) {
							cnt++;
							}
						if(cnt==N) {
							min=Math.min(min, j-i+1); //어차피 최소는 둘이 같은것임
							max=Math.max(max, j-i+1); //최대는 첫/끝이 같아야함 
							break;
						}
					}
				}
			}
			if(flag==false) {
				System.out.println(-1);
			}else {
				System.out.println(min+" "+max);
			}
		}
	}

}
