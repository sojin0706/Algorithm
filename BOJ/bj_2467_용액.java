

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2467_용액 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int[]map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N=Integer.parseInt(br.readLine());
		tokens=new StringTokenizer(br.readLine());
		map=new int[N];
		
		for(int i=0;i<N;i++) {
			map[i]=Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(map); //일단 정렬하기 
		
		//투포인터 사용하기
		int start=0;
		int end=N-1;
		int store1=0;
		int store2=0;
		int min=Integer.MAX_VALUE;
		while(start<end) {
			int a=map[start]+map[end];
			int b=Math.abs(a);
			if(min>b) {
				min=b;
				store1=map[start];
				store2=map[end];
			}
			
			if(a<0) {
				//0보다 작으면 a를 늘린다.(더 키워야함)
				start++;
				
			}else if(a>0) {
				//0보다 크면 a를 줄인다
				end--;
			}else if(a==0) {
				break;//0이면 더이상갈이유가 없음
			}
			
		}
		System.out.println(store1+" "+store2);
		
		
	}

}
