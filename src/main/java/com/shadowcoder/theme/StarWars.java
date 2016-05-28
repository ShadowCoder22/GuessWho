package com.shadowcoder.theme;

/**
 * A star wars character in the game of Guess Who.
 * This contains all of the characteristics and
 * functions needed to identify the person.
 *
 * @author Levester Chaney
 * @version 2010
 *
 */
public class StarWars extends Person
{
	private char gender;
	private boolean human;
	private boolean jedi;
	private boolean sith;
	private boolean rebel;
	
	public StarWars(String n, String i, char g, boolean h, boolean j, boolean s, boolean r)
	{
		super(n, i);
		gender = g;
		human = h;
		jedi = j;
		sith = s;
		rebel = r;
	}
	
	public boolean isMale()
	{
		return gender == 'm';
	}
	
	public boolean isFemale()
	{
		return gender == 'f';
	}
	
	public boolean isHuman()
	{
		return human;
	}
	
	public boolean isJedi()
	{
		return jedi;
	}
	
	public boolean isSith()
	{
		return sith;
	}
	
	public boolean isRebel()
	{
		return rebel;
	}
	
	public boolean isEmpire()
	{
		return !rebel;
	}
}
