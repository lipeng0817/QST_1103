package No4;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReducerOfIPFilter {
	public static void main(String[] args){
		Set<String> set = new HashSet();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			String line = scanner.nextLine();
			String pattern = "(\\d+.\\d+.\\d+.\\d+)\t(.*)";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(line);
			if(m.find()){
			 set.add(m.group(1));
			} 
		}
		System.out.println(set.size());	
	}	
}
