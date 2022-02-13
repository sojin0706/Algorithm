package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14719_���� {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R,C;
	static int[]arr;
	public static void main(String[] args) throws Exception{
		tokens=new StringTokenizer(br.readLine());
		R=Integer.parseInt(tokens.nextToken());
		C=Integer.parseInt(tokens.nextToken());
		arr=new int[C];
		
		tokens=new StringTokenizer(br.readLine());
		
		for(int i=0;i<C;i++) {
			arr[i]=Integer.parseInt(tokens.nextToken());
		}

		
		//���̴� ������ �����̴�.
		//���ʿ��� ���� ������, �����ʿ��� ���� ������ ���ϰ� �� �ε����߿��� �� �����κ��� ���̷� ģ��. 
		int cnt=0;
		
		for(int i=1;i<C-1;i++) {
			
			int right=0;
			int left=0;
			
			for(int t=0;t<i;t++) {
				if(left<arr[t]) {
					left=arr[t];
				}
			}
			
			for(int k=i;k<C;k++) {
				if(right<arr[k]) {
					right=arr[k];
				}
			}
			
			//left�� 4 right�� 3�� ������
			int min=Math.min(left, right);
			
			if(arr[i]<min) {
				cnt+=min-arr[i];
			}
			
		}
		System.out.println(cnt);
		
		
		
		
		
	}

}
