package parser;

import javafx.scene.paint.Color;

/**
 * a class object designed to hold a token and it's corresponding color, 
 * creating a whole pixel of the BitBlock. 
 * Relationship: BitBlock class has-a TokenizedPixel.
 * @author Triston Scallan
 *
 */
public class TokenizedPixel {
	
		/**	the string token of the source code*/
	private String token = "";
		/**	the color pertaining to the token*/
	private Color color;
	
	
	public TokenizedPixel(String token, Color color) {
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
	public Color getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
