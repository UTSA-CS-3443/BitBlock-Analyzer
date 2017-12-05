package parser;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * Produce statistic from a token list
 * @author Anthony Hoang
 */
public class Statistic {
	
	
	private List<String> tokenList = new ArrayList<String>();
	private List<TokenizedPixel> pixelList = new ArrayList<TokenizedPixel>();
	
	// store token and pixel as hashset, to count unique
	private HashSet<String> uniqToken = new HashSet<String>();
	private HashSet<TokenizedPixel> uniqPixel = new HashSet<TokenizedPixel>();
	
	private Map<String, Integer> mapToken = new HashMap<String, Integer>();

	/**
	 * set the token array list
	 */
	public Statistic(List<TokenizedPixel> pixelList)
	{
		//set pixelList
		setPixelList(pixelList);
		
		//extract tokens from pixelList and set tokenList
		for(TokenizedPixel pixel : pixelList) {
			String token = pixel.getToken();
			tokenList.add(token);
		}
		setTokenList(tokenList);
		uniqToken.addAll(tokenList);
	}

	public void setTokenList(List<String> tokenList)
	{
		this.tokenList = tokenList;
		uniqToken.addAll(tokenList);
	}
	
	public void setPixelList(List<TokenizedPixel> pixelList)
	{
		this.pixelList = pixelList;
		uniqPixel.addAll(pixelList);
	}

	/**
	 * @return count all token
	 */
	public int countToken()
	{
		return tokenList.size();
	}
	
	/**
	 * @return count all token
	 */
	public int countPixel()
	{
		return pixelList.size();
	}
	
	/**
	 * @return number of unique token
	 */
	public int countUniqToken()
	{

		return uniqToken.size();
	}
	
	/**
	 * @return number of unique pixel
	 */
	public int countUniqPixel()
	{
		return uniqPixel.size();
	}
	
	/**
	 * @param String token
	 * @return the turn the number of times specific token appears
	 */
	public int getFreq(String token)
	{
		int count = 0;
		for (int i=0; i < tokenList.size(); i++)
			if (tokenList.get(i).equals(token))
				count ++;
		
		return count;
	}
	
	/**
	 * @return token of the mode of the list 
	 * 		   but ignore overly commong token
	 */
	public String getUmode() { //TODO: set up the mode functions
		
		// put token list in HashMap in form of {token: value}
		for (int i = 0; i < tokenList.size(); i++) {
			if (mapToken.get(tokenList.get(i)) == null) {
				mapToken.put(tokenList.get(i), 1);
			} else {
				mapToken.put(tokenList.get(i), mapToken.get(tokenList.get(i)) + 1);
			}
		}

		int maxCount = 0;
		String commonToken = null;

		for (Entry<String, Integer> entry : mapToken.entrySet()) {

			String key = entry.getKey();
			int value = entry.getValue();

			if ((value > maxCount) & (!key.matches("^[\\(\\) \\*;\\.\\w]$"))) {
				maxCount = value;
				commonToken = key;
			}
		}
		System.out.println("most common token: " + commonToken);
		return commonToken;
	}
		
	/**
	 * @return most appearing token
	 * 	
	 */
	public String getCmode() { //TODO: set up the mode functions
		
		// put token list in HashMap in form of {token: value}
		for (int i = 0; i < tokenList.size(); i++) {
			if (mapToken.get(tokenList.get(i)) == null) {
				mapToken.put(tokenList.get(i), 1);
			} else {
				mapToken.put(tokenList.get(i), mapToken.get(tokenList.get(i)) + 1);
			}
		}

		int maxCount = 0;
		String commonToken = null;

		for (Entry<String, Integer> entry : mapToken.entrySet()) {

			String key = entry.getKey();
			int value = entry.getValue();

			if (value > maxCount) {
				maxCount = value;
				commonToken = key;
			}
		}
		System.out.println("most common token: " + commonToken);
		return commonToken;
	}
	
	
	/**
	 * @return  the number of loop in the source
	 */
	public int countLoop()
	{
		int count = 0;
		for (int i=0; i < tokenList.size(); i++)
		{
			if (tokenList.get(i).equals("for") || tokenList.get(i).equals("while"))
				count ++;
		}
		
		return count;
	}
	
	/**
	 * @return histogram
	 */
	public String getHist()
	{		
		
		String histogram = "========================\n";
		histogram += "Frequency\t Count      Token \n";
		histogram += "========================\n";
		
		for (String tmp: uniqToken)
		{
			
			int iCount = getFreq(tmp);
			double iPercent = (getFreq(tmp)*100.0)/tokenList.size();
			
			String sCount = Integer.toString(iCount);
			String sPercent = String.format("%.02f", iPercent);
			
			// pad the percentage on display
			if (iPercent < 10)
				sPercent = "0"+sPercent+"%";
			
			// pad the Count on display
			if (iCount <10)
				sCount = "___" + sCount;
			else if (iCount < 100)
				sCount = "__" + sCount;
			else if (iCount < 1000)
				sCount = "_" + sCount;
			
			// extrac padding
			sCount = "   " + sCount;
			
			// histogram
			histogram += "[" + sPercent + "]\t\t" + sCount + "       " + tmp + "\n";
			
		}
		histogram += "========================\n";
		return histogram;
	}
	
	
}
