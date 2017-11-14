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
}
