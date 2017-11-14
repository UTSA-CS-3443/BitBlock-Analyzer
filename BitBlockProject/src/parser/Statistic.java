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
	HashSet<String> uniqToken = new HashSet<String>();
	private List<TokenizedPixel> pixelList = new ArrayList<TokenizedPixel>();
	HashSet<String> uniqPixel = new HashSet<String>();
	
	
	public void setTokenList(List<String> tokenList)
	{
		this.tokenList = tokenList;
	}
	
	public void setPixelList(List<TokenizedPixel> pixelList)
	{
		this.pixelList = pixelList;
	}
	
	public int countToken()
	{
		return tokenList.size();
	}
	
	public int countUniqToken()
	{
		HashSet<String> uniqToken = new HashSet<String>();
		uniqToken.addAll(tokenList);
		return uniqToken.size();
	}
	
	public int countUniqPixel()
	{
		HashSet<String> uniqPixel = new HashSet<String>();
		uniqPixel.addAll(tokenList);
		return uniqPixel.size();
	}
	
	public int getFreq(String token)
	{
		int count = 0;
		for (int i=0; i < tokenList.size(); i++)
		{
			if (tokenList.get(i).equals(token))
				count ++;
		}
		
		return 0;
	}
	
	
}
