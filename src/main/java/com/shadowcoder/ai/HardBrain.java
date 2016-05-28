package com.shadowcoder.ai;

import com.shadowcoder.theme.Disney;
import com.shadowcoder.theme.Original;
import com.shadowcoder.theme.Person;
import com.shadowcoder.theme.StarWars;
import com.shadowcoder.ui.MainFrame;


/**
 * The most difficult difficulty. This AI asks questions
 * that it knows will eliminate characters. Tries to get
 * as many people eliminated as possible before it guesses
 * the user.
 *
 * @author Levester Chaney
 * @version 2010
 *
 */
public class HardBrain extends Brain
{
	private int index;
	private int omitted;
	private Person user;
	
	public HardBrain(MainFrame f, Person comp, Person user2)
	{
		super(f, comp);
		user = user2;
		omitted = 0;
	}
	
	public void ask()
	{
		do{
			index = (int)(Math.random() * questions.length);
		}while(questions[index] == null);
		
		if(environment.getVersion() == 0)
			askOriginal();
		else if(environment.getVersion() == 1)
			askDisney();
		else
			askStar();
	}
	
	private void guess()
	{
		guessing = true;
		environment.output("Is your person " + user + "?");
		guess = user;
	}
	
	private void askOriginal()
	{
		System.out.println(questions.length);
		System.out.println(omitted);
		System.out.println(questions[index]);
		if(size < 5)
		{
			guess();
		}
		else
		{
			omitted++;
			if(questions[index].contains("female"))
			{
				if(((Original)user).isFemale() && !female)
				{
					ask(index);
					female = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("male"))
			{
				if(((Original)user).isMale() && !male)
				{
					ask(index);
					male = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("bald"))
			{
				if(((Original)user).isBald())
				{
					ask(index);
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("brown hair"))
			{
				if(((Original)user).hasBrownHair() && !hair)
				{
					ask(index);
					hair = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("black hair"))
			{
				if(((Original)user).hasBlackHair() && !hair)
				{
					ask(index);
					hair = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("blonde hair"))
			{
				if(((Original)user).hasBlondeHair() && !hair)
				{
					ask(index);
					hair = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("red hair"))
			{
				if(((Original)user).hasRedHair() && !hair)
				{
					ask(index);
					hair = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("white hair"))
			{
				if(((Original)user).hasWhiteHair() && !hair)
				{
					ask(index);
					hair = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("brown eyes"))
			{
				if(((Original)user).hasBrownEyes() && !eyes)
				{
					ask(index);
					eyes = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("blue eyes"))
			{
				if(((Original)user).hasBlueEyes() && !eyes)
				{
					ask(index);
					eyes = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("glasses"))
			{
				if(((Original)user).hasGlasses() && !glasses)
				{
					ask(index);
					glasses = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("hat"))
			{
				if(((Original)user).hasHat() && !hat)
				{
					ask(index);
					hat = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("mustache"))
			{
				if(((Original)user).hasMustache() && !mustache)
				{
					ask(index);
					mustache = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("beard"))
			{
				if(((Original)user).hasBeard() && !beard)
				{
					ask(index);
					beard = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
		}
	}
	
	private void askDisney()
	{
		System.out.println(questions.length);
		System.out.println(omitted);
		System.out.println(questions[index]);
		if(size < 5)
		{
			guess();
		}
		else
		{
			omitted++;
			if(questions[index].contains("human"))
			{
				if(((Disney)user).isHuman())
				{
					ask(index);
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("female"))
			{
				if(!((Disney)user).isMale() && !male)
				{
					ask(index);
					male = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("male"))
			{
				if(((Disney)user).isMale() && !male)
				{
					ask(index);
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("good"))
			{
				if(((Disney)user).isGood() && !good)
				{
					ask(index);
					good = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("evil"))
			{
				if(!((Disney)user).isGood() && !good)
				{
					ask(index);
					good = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("brown hair"))
			{
				if(((Disney)user).hasBrownHair() && !hair)
				{
					ask(index);
					hair = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("black hair"))
			{
				if(((Disney)user).hasBlackHair() && !hair)
				{
					ask(index);
					hair = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("red hair"))
			{
				if(((Disney)user).hasRedHair() && !hair)
				{
					ask(index);
					hair = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("white hair"))
			{
				if(((Disney)user).hasWhiteHair() && !hair)
				{
					ask(index);
					hair = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("hat"))
			{
				if(((Disney)user).hasHat())
				{
					ask(index);
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
		}
	}
	
	private void askStar()
	{
		System.out.println(questions.length);
		System.out.println(omitted);
		System.out.println(questions[index]);
		if(size < 6)
		{
			guess();
		}
		else
		{
			omitted++;
			if(questions[index].contains("human"))
			{
				if(((StarWars)user).isHuman() || 
					user.toString().equalsIgnoreCase("C-3PO") ||
					user.toString().equalsIgnoreCase("Chewbacca") ||
					user.toString().equalsIgnoreCase("R2-D2") ||
					user.toString().equalsIgnoreCase("Grievous"))
				{
					ask(index);
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("female"))
			{
				if(((StarWars)user).isFemale() && !male)
				{
					ask(index);
					male = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("male"))
			{
				if(((StarWars)user).isMale() && !male)
				{
					ask(index);
					male = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("jedi"))
			{
				if(((StarWars)user).isJedi() && !jedi)
				{
					ask(index);
					jedi = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("sith"))
			{
				if(((StarWars)user).isSith() && !jedi)
				{
					ask(index);
					jedi = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("rebel"))
			{
				if(((StarWars)user).isRebel() && !rebel)
				{
					ask(index);
					rebel = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
			else if(questions[index].contains("empire"))
			{
				if(((StarWars)user).isEmpire() && !rebel)
				{
					ask(index);
					rebel = true;
				}
				else
				{
					questions[index] = null;
					ask();
				}
			}
		}
	}
}