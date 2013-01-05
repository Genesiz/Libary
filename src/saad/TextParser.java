package saad;

import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class TextParser {
	 String regularExp = "((BOOK)|(MUSIC))\\s*(\\w)\\s*(\\w)\\s*(\\w)\\s*(\\d+)\\s*(\\f+)";
	
	public TextParser (Scanner scanner){
		if (scanner.hasNext()){
			Pattern keyword = Pattern.compile(regularExp);
		if (scanner.findInLine(keyword) != null){
			MatchResult result = scanner.match();
		String type = result.group(1);
		String title = result.group(2);
		String author = result.group(3);
		String genre = result.group(4);
		int rating = Integer.parseInt(result.group(5));
		double length = Double.parseDouble(result.group(6));
		}
		
		}
	}


	}


