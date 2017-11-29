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
	
	public Statistic(List<String> tokenList, List<TokenizedPixel> pixelList)
	{
		this.tokenList = tokenList;
		uniqToken.addAll(tokenList);
		
		this.pixelList = pixelList;
		uniqPixel.addAll(pixelList);
	}
	
	/**
	 
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
	*/
	
	/**
	 * @return count all token
	 */
	public int countToken()
	{
		return tokenList.size();
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
	
	
}
