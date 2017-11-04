/**
 * 
 */
package parser;

/**
 * a class object designed to hold a token and it's corresponding color, 
 * creating a whole pixel of the BitBlock. 
 * Relationship: BitBlock class has-a TokenizedPixel.
 * @author Triston Scallan
 *
 */
public class TokenizedPixel {
	
	private String token = ""; 	//the string token of the source code
	private String color = "";	//the string containing the color pertaining to the token
	
	public TokenizedPixel(String token, String color) {
		this.token = token;
		this.color = color;
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
