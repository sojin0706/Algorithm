package SILVER?Öå?ä§?ä∏Ï§?Îπ?;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//?àú?ó¥Î°? ?à´?ûê ?†ï?†¨?õÑ ?ã§ ?ï¥Î≥¥Í∏∞ 
public class bj_10819_Ï∞®Ïù¥Î•ºÏµú??Î°? {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int[]map;
	static int max=Integer.MIN_VALUE;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N=Integer.parseInt(br.readLine());
		map=new int[N];
		tokens=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			map[i]=Integer.parseInt(tokens.nextToken());
		}//?ûÖ?†•?ôÑÎ£?
		makePermutation(N,new int[N],new boolean[N]);
		System.out.println(max);
	}
	static void makePermutation(int toChoose,int[]choosed,boolean[]visited) {
		if(toChoose==0) {
			//?ù¥?ïå ÏµúÎ??ù∏Ïß? Ï≤¥ÌÅ¨ 
			int ans=check(choosed);
			max=Math.max(max, ans);
			return;
		}
		for(int i=0;i<map.length;i++) {
			if(!visited[i]) {
				visited[i]=true;
				choosed[choosed.length-toChoose]=map[i];
				makePermutation(toChoose-1,choosed,visited);
				visited[i]=false;
			}
		}
	}
	static int check(int[]choosed) {
		int ans=0;
		for(int i=1;i<N;i++) {
			ans+=Math.abs(choosed[i-1]-choosed[i]);
		}
		return ans;
	}
}
