package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_1475_방번호 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception{
		int[]arr=new int[10];
		
		String str=br.readLine();
		
		for(int i=0;i<str.length();i++) {
			arr[str.charAt(i)-'0']++; //개수 세주기 
		}
		int temp=arr[6]+arr[9];
		if(temp%2==0) {
			arr[6]=temp/2;
			arr[9]=temp/2;
		}else {
			arr[6]=temp/2+1;
			arr[9]=temp/2+1;
		}
		int max=0;
		for(int i=0;i<arr.length;i++) {
			if(max<arr[i]) {
				max=arr[i];
			}
		}
	
		System.out.println(max);
		
	}

}
