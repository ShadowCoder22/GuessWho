package com.shadowcoder.theme;
import java.awt.*;

/**
 * The original people of guess who. This represents
 * one of the plain old people of guess who and all of
 * the characteristics that they have. 
 *
 * @author Levester Chaney
 * @version 2010
 *
 */
public class Original extends Person
{

	private char gender;
	private boolean glasses;
	private boolean hat;
	private boolean mustache;
	private boolean beard;
	private boolean bald;
	private Color hair;
	private Color eyes;
	
	public Original(String str, String image, char ch, boolean g, boolean h, boolean m, boolean b, boolean a, Color c, Color e)
	{
		super(str, image);
		gender = ch;
		glasses = g;
		hat = h;
		mustache = m;
		beard = b;
		bald = a;
		hair = c;
		eyes = e;
	}
	
	public boolean isMale()
	{
		return gender == 'm';
	}
	
	public boolean isFemale()
	{
		return gender == 'f';
	}
	
	public boolean hasGlasses()
	{
		return glasses;
	}
	
	public boolean hasHat()
	{
		return hat;
	}
	
	public boolean hasMustache()
	{
		return mustache;
	}
	
	public boolean hasBeard()
	{
		return beard;
	}
	
	public boolean isBald()
	{
		return bald;
	}
	
	public boolean hasRedHair()
	{
		return hair.equals(Color.RED);
	}
	
	public boolean hasWhiteHair()
	{
		return hair.equals(Color.WHITE);
	}
	
	public boolean hasBrownHair()
	{
		return hair.equals(BROWN);
	}
	
	public boolean hasBlackHair()
	{
		return hair.equals(Color.BLACK);
	}
	
	public boolean hasBlondeHair()
	{
		return hair.equals(Color.YELLOW);
	}
	
	public boolean hasBrownEyes()
	{
		return eyes.equals(BROWN);
	}
	
	public boolean hasBlueEyes()
	{
		return eyes.equals(Color.BLUE);
	}
}