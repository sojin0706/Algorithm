package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_22252_��������ȣ�� {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		
		Map<String, PriorityQueue<Integer>> map=new HashMap<>();
		long sum=0;
		for(int i=0;i<N;i++) {
			tokens=new StringTokenizer(br.readLine());
			int K=Integer.parseInt(tokens.nextToken()); //1���� 2����?
			//K�� 1�̸� map�� �����Ѵ�.
			String name=tokens.nextToken(); //�̸�
			if(K==1) {
				
				int t=Integer.parseInt(tokens.nextToken());
				
				for(int j=0;j<t;j++) {
					if(!map.containsKey(name)) {
						PriorityQueue<Integer>queue=new PriorityQueue<>(Collections.reverseOrder());
						int a=Integer.parseInt(tokens.nextToken());
						queue.offer(a);
						map.put(name, queue);
					}else {
						int a=Integer.parseInt(tokens.nextToken());
						map.get(name).add(a);
					}
				}
					
			}else if(K==2) {
				//map�� �� �̸��� ������ �������� ��� ���� 
//				if(map.containsKey(name)) {
//					int a=Integer.parseInt(tokens.nextToken());
//					if(map.get(name).size()>=a) {
//						for(int z=0;z<a;z++) {
//							sum+=map.get(name).poll();
//						}
//					}else if(map.get(name).size()<a) {
//						//map�� �����ŭ �� ��� 
//						for(int z=0;z<map.size();z++) {
//							sum+=map.get(name).poll();
//						}
//					}
//					
//				}else {
//					continue;
//				}
				
				if(map.containsKey(name)) {
					int n=Integer.parseInt(tokens.nextToken());
					while(map.get(name).size()>0&&n!=0) {
						sum+=map.get(name).poll();
						n--;
					}
					
				}
				
			}
		}
		System.out.println(sum);
	}
	
}
