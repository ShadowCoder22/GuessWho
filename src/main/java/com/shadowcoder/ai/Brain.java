package com.shadowcoder.ai;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.shadowcoder.ui.MainFrame;
import com.shadowcoder.theme.*;
import com.shadowcoder.theme.Person;

/**
 * The umbrella logic for the AI. All of the common
 * logic is lifted up into this class.
 *
 * @author Levester Chaney
 * @version 2010
 *
 */
public abstract class Brain
{
	private String[] taunt = {"I am getting closer, aren't I?\n",
							  "You are no match for my skills.\n",
							  "It's only a matter of time before I win.\n"};
	
	protected MainFrame environment;
	protected Person[] set;
	protected int size;
	protected String[] questions;
	protected String ques;
	protected boolean guessing = false;
	protected Person guess;
	private Person own;
	private Scanner in1;
	private Scanner in2;
	
	
	// belief set for what user's person is
	protected boolean male = false;
	protected boolean female = false;
	protected boolean hat = false;
	protected boolean glasses = false;
	protected boolean mustache = false;
	protected boolean beard = false;
	protected boolean eyes = false;
	protected boolean hair = false;
	protected boolean good = false;
	protected boolean jedi = false;
	protected boolean rebel = false;
	
	protected Brain(MainFrame f, Person c)
	{
		environment = f;
		set = new Person[24];
		questions = new String[14];
		own = c;
		load();
		
		//eliminate own person
		for(int i = 0; i < set.length; i++)
		{
			if(own.equals(set[i]))
			{
				set[i] = null;
				size--;
			}
		}
	}
	
	public boolean update(boolean ans)
	{
		boolean end = false;
		
		if(!guessing)
		{
			if(environment.getVersion() == 0)
			{
				if(ques.contains("female"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Original)set[i]).isFemale())
							{
								set[i] = null;
								size--;
							}	
						}
					}
					else
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Original)set[i]).isFemale())
							{
								set[i] = null;
								size--;
							}	
						}
					}
				}
				else if(ques.contains("male"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Original)set[i]).isMale())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Original)set[i]).isMale())
							{
								set[i] = null;
								size--;
							}	
						}
					}
				}
				else if(ques.contains("bald"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Original)set[i]).isBald())
							{
								set[i] = null;
								size--;
							}	
						}
					}
					else
					{
						hair = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Original)set[i]).isBald())
							{
								set[i] = null;
								size--;
							}	
						}
					}
				}
				else if(ques.contains("brown hair"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Original)set[i]).hasBrownHair())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						hair = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Original)set[i]).hasBrownHair())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("black hair"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Original)set[i]).hasBlackHair())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						hair = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Original)set[i]).hasBlackHair())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("blonde hair"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Original)set[i]).hasBlondeHair())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						hair = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Original)set[i]).hasBlondeHair())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("red hair"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Original)set[i]).hasRedHair())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						hair = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Original)set[i]).hasRedHair())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("white hair"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Original)set[i]).hasWhiteHair())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						hair = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Original)set[i]).hasWhiteHair())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("brown eyes"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Original)set[i]).hasBrownEyes())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						eyes = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Original)set[i]).hasBrownEyes())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("blue eyes"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Original)set[i]).hasBlueEyes())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						eyes = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Original)set[i]).hasBlueEyes())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("glasses"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Original)set[i]).hasGlasses())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						glasses = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Original)set[i]).hasGlasses())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("hat"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Original)set[i]).hasHat())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						hat = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Original)set[i]).hasHat())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("mustache"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Original)set[i]).hasMustache())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						mustache = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Original)set[i]).hasMustache())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("beard"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Original)set[i]).hasBeard())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						beard = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Original)set[i]).hasBeard())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
			}
			else if(environment.getVersion() == 1)
			{
				if(ques.contains("human"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Disney)set[i]).isHuman())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Disney)set[i]).isHuman())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("female"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Disney)set[i]).isMale())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Disney)set[i]).isMale())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("male"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Disney)set[i]).isMale())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Disney)set[i]).isMale())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("good"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Disney)set[i]).isGood())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						good = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Disney)set[i]).isGood())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("evil"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Disney)set[i]).isGood())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						good = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Disney)set[i]).isGood())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("brown hair"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Disney)set[i]).hasBrownHair())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						hair = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Disney)set[i]).hasBrownHair())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("black hair"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Disney)set[i]).hasBlackHair())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						hair = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Disney)set[i]).hasBlackHair())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("red hair"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Disney)set[i]).hasRedHair())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						hair = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Disney)set[i]).hasRedHair())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("white hair"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Disney)set[i]).hasWhiteHair())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						hair = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Disney)set[i]).hasWhiteHair())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("hat"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((Disney)set[i]).hasHat())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						hat = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((Disney)set[i]).hasHat())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
			}
			else
			{
				if(ques.contains("human"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((StarWars)set[i]).isHuman())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((StarWars)set[i]).isHuman())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("female"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((StarWars)set[i]).isFemale())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						male = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((StarWars)set[i]).isFemale())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("male"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((StarWars)set[i]).isMale())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						male = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((StarWars)set[i]).isMale())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("jedi"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((StarWars)set[i]).isJedi())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						jedi = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((StarWars)set[i]).isJedi())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("sith"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((StarWars)set[i]).isSith())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						jedi = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((StarWars)set[i]).isSith())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("rebel"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((StarWars)set[i]).isRebel())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						rebel = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((StarWars)set[i]).isRebel())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
				else if(ques.contains("empire"))
				{
					if(!ans)
					{
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && ((StarWars)set[i]).isEmpire())
							{
								set[i] = null;
								size--;
							}
						}
					}
					else
					{
						rebel = true;
						for(int i = 0; i < set.length; i++)
						{
							if(set[i] != null && !((StarWars)set[i]).isEmpire())
							{
								set[i] = null;
								size--;
							}
						}
					}
				}
			}
			
			// Trash talk user if cpu has more than five people less than user
			if(size < (environment.getLeft() - 5))
				environment.write(taunt[(int)(Math.random() * taunt.length)] +
						"Your turn.");
			
		}
		else
		{
			// Computer has decided to start guessing user's person
			if(ans)
			{
				System.out.println("Computer wins");
				for(int i = 0; i < set.length; i++)
				{
					if(set[i] != null)
					{
						set[i] = null;
						size--;
					}
				}
				environment.write("Yay!! I won.\nMy person was " + own + ".");
				end = true;
			}
			else
			{
				guessing = false;
				
				//	eliminate computer's wrong guess from options
				for(int i = 0; i < set.length; i++)
				{
					if(set[i] != null && set[i].equals(guess))
					{
						set[i] = null;
						size--;
					}
				}
				
				if(size == 0)		// if no options left, user cheated
				{
					environment.write("You are a cheater!!\nThere are no options left.");
					end = true;
				}
				else
				{
					environment.write("Your turn.");
				}
			}
		}
		
		System.out.println("left in set: " + size);
		for(Person c : set)
		{
			if(c != null)
				System.out.println("   " + c);
		}
		
		return end;
	}
	
	public abstract void ask();
	
	public void ask(int index)
	{
		environment.output(questions[index]);
		ques = questions[index];
		questions[index] = null;
	}
	
	public String intro()
	{
		return "Hello. Let's play.\n" + 
			"You can have the first question.";
	}
	
	public boolean wasGuessed(Person c)
	{
		for(Person pers : set)
		{
			if(pers != null && pers.equals(c))
			{
				return false;
			}
		}
		
		return true;
	}
	
	private void load()
	{
		try{
			if(environment.getVersion() == 0)
			{
				in1 = new Scanner(new File("original/data.gw"));
				in2 = new Scanner(new File("original/questions.gw"));
			}
			else if(environment.getVersion() == 1)
			{
				in1 = new Scanner(new File("disney/data.gw"));
				in2 = new Scanner(new File("disney/questions.gw"));
			}
			else
			{
				in1 = new Scanner(new File("starwars/data.gw"));
				in2 = new Scanner(new File("starwars/questions.gw"));
			}
			String name, image;
			char c;
			boolean b1, b2, b3, b4, b5;
			Color c1, c2;
			int i = 0, j = 0;;
			
			// Read in all patron data
			while(in1.hasNext())
			{
				if(environment.getVersion() == 0)
				{
					String line = in1.nextLine();
					StringTokenizer t = new StringTokenizer(line);
					name = t.nextToken();
					image = t.nextToken();
					c = t.nextToken().charAt(0);
					b1 = !t.nextToken().equalsIgnoreCase("f");
					b2 = !t.nextToken().equalsIgnoreCase("f");
					b3 = !t.nextToken().equalsIgnoreCase("f");
					b4 = !t.nextToken().equalsIgnoreCase("f");
					String s1 = t.nextToken();
					if(s1.equalsIgnoreCase("bl"))
						c1 = Color.BLACK;
					else if(s1.equalsIgnoreCase("br"))
						c1 = Person.BROWN;
					else if(s1.equalsIgnoreCase("y"))
						c1 = Color.YELLOW;
					else if(s1.equalsIgnoreCase("w"))
						c1 = Color.WHITE;
					else
						c1 = Color.RED;
					b5 = !t.nextToken().equalsIgnoreCase("f");
					c2 = t.nextToken().equalsIgnoreCase("bl") ? Color.BLUE : Person.BROWN;
					
					set[i++] = new Original(name, image, c, b1, b2, b3, b4, b5, c1, c2);
				}
				else if(environment.getVersion() == 1)
				{
					String line = in1.nextLine();
					StringTokenizer t = new StringTokenizer(line);
					name = t.nextToken();
					image = "disney/" + t.nextToken();
					c = t.nextToken().charAt(0);
					b1 = !t.nextToken().equalsIgnoreCase("f");
					b2 = !t.nextToken().equalsIgnoreCase("f");
					b3 = !t.nextToken().equalsIgnoreCase("f");
					String s1 = t.nextToken();
					if(s1.equalsIgnoreCase("bl"))
						c1 = Color.BLACK;
					else if(s1.equalsIgnoreCase("br"))
						c1 = Person.BROWN;
					else if(s1.equalsIgnoreCase("w"))
						c1 = Color.WHITE;
					else if(s1.equalsIgnoreCase("r"))
						c1 = Color.RED;
					else if(s1.equalsIgnoreCase("b"))
						c1 = Color.BLUE;
					else
						c1 = Color.PINK;
					
					set[i++] = new Disney(name, image, c, b1, b2, b3, c1);
				}
				else
				{
					String line = in1.nextLine();
					StringTokenizer t = new StringTokenizer(line);
					name = t.nextToken();
					image = "starwars/" + t.nextToken();
					c = t.nextToken().charAt(0);
					b1 = !t.nextToken().equalsIgnoreCase("f");
					b2 = !t.nextToken().equalsIgnoreCase("f");
					b3 = !t.nextToken().equalsIgnoreCase("f");
					b4 = !t.nextToken().equalsIgnoreCase("f");
					
					set[i++] = new StarWars(name, image, c, b1, b2, b3, b4);
				}
			}
			
			// Read in appropriate question set
			while(in2.hasNext())
			{
				questions[j++] = in2.nextLine();
			}
			
			size = set.length;
			in1.close();
			in2.close();
		}
		catch(FileNotFoundException e)
		{
			throw new RuntimeException("Could not find the data/questions file.");
		}
	}
}
