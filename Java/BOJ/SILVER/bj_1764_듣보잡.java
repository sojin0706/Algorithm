package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj_1764_�躸�� {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M;
	static ArrayList<String>list;
	public static void main(String[] args) throws IOException {
		//��+��
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken()); //�赵����x
		M=Integer.parseInt(tokens.nextToken()); //�������� x
		list=new ArrayList<>();
		HashSet<String>nosee=new HashSet<>();
		
		for(int i=0;i<N;i++) {
			nosee.add(br.readLine());
		}
		
		for(int i=0;i<M;i++) {
			String str=br.readLine();
			if(nosee.contains(str)) {
				list.add(str);
			}
		}
	
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		
		}
		
	}
