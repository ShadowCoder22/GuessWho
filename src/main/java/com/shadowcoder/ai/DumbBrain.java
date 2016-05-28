package com.shadowcoder.ai;

import com.shadowcoder.theme.Person;
import com.shadowcoder.ui.MainFrame;


/**
 * The simplest AI and easiest difficulty. Blindly
 * asks questions in hopes of getting the user's
 * exact person. Has no memory of what was asked
 * and what isnt helpful.
 *
 * @author Levester Chaney
 * @version 2010
 *
 */
public class DumbBrain extends Brain
{
	
	public DumbBrain(MainFrame f, Person comp)
	{
		super(f, comp);
	}
	
	public void ask()
	{
		if(size > 1)
		{
			int index;
			do{
				index = (int)(Math.random() * questions.length);
			}while(questions[index] == null);
			environment.output(questions[index]);
			ques = questions[index];
			questions[index] = null;
		}
		else
		{
			guessing = true;
			for(Person c : set)
			{
				if(c != null)
					environment.output("Is your person " + c + "?");
			}
		}
	}
}
