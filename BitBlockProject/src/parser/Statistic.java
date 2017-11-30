package parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
	
	/**
	 * set the token array list
	 */
	
	public Statistic(List<TokenizedPixel> pixelList)
	{
		//set pixelList
		setPixelList(pixelList);
		//extract tokens from pixelList and set tokenList
		List<String> tokenList = new ArrayList<String>();
		for(TokenizedPixel pixel : pixelList) {
			String token = pixel.getToken();
			tokenList.add(token);
		}
		setTokenList(tokenList);
	}
	
	 
	public Statistic() {
		
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
		HashSet<String> uniqToken = new HashSet<String>();
		uniqToken.addAll(tokenList);
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
	 * @return token of the mode of the list (i.e. most appearing token)
	 */
	public String getMode() { //TODO: set up the mode functions
		String token = null;
		String lastToken = null;
		int max = 0;
		int count = 0;
		tokenList.sort((String r1, String r2) -> r1.compareTo(r2));
		Object[] result = new Object[] {"null", max};
		for(String word: this.tokenList) {
			System.out.println(word);
			//test if it's an "overly common" token, like alphanumerics or delimiters
			if (word.matches("^[\\(\\);\\.\\w]$")) {
				lastToken = word;
				continue;
			}
			//mode counting tests
			if (word.equals(lastToken)) { //if this token is the same as the last one
				count++;
			} else {
				if (max < count) {
					max = count;
					count = 0;
					result = new Object[] {token, max};;
				}
			}
			lastToken = word;
		}
		
		return token = (String) result[0];
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
	 * @return array of unique token
	 */
	public HashSet<String> getUniqToken()
	{
		return uniqToken;
	}
	
}
