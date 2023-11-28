package learnibf;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TackeRandomString {
  
	public static void main(String [] args){
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()){
			int n=scanner.nextInt();
			int [] arr=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=scanner.nextInt();
			}
			soultion(arr,n);
		}
		
		
	}
	public static void soultion(int [] arr,int n){
		if(n==0||arr==null){
			return;
		}
		Set<Integer> set=new TreeSet<>();
	    for(int i=0;i<n;i++){
	    	set.add(arr[i]);
	    }
	    int [] result=new int[set.size()];
		Iterator<Integer> iterator=set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
}
