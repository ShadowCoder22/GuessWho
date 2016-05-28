package com.shadowcoder.theme;

import java.awt.*;

/**
 * This represents a disney character in the game
 * of Guess Who. It harbors all of their characteristics
 * and functionality.
 *
 * @author Levester Chaney
 * @version 2010
 *
 */
public class Disney extends Person
{
	private char gender;
	private boolean human;
	private boolean good;
	private boolean hat;
	private Color hair;
	
	
	public Disney(String s, String i, char c, boolean h, boolean g, boolean h1, Color h2)
	{
		super(s, i);
		gender = c;
		human = h;
		good = g;
		hat = h1;
		hair = h2;
	}
	
	public boolean isMale()
	{
		return gender == 'm';
	}
	
	public boolean isHuman()
	{
		return human;
	}
	
	public boolean isGood()
	{
		return good;
	}
	
	public boolean hasHat()
	{
		return hat;
	}
	
	public boolean hasHair()
	{
		return !hair.equals(Color.PINK);
	}
	
	public boolean hasRedHair()
	{
		return hair.equals(Color.RED);
	}
	
	public boolean hasWhiteHair()
	{
		return hair.equals(Color.WHITE);
	}
	
	public boolean hasBlackHair()
	{
		return hair.equals(Color.BLACK);
	}
	
	public boolean hasBrownHair()
	{
		return hair.equals(BROWN);
	}
}