package com.shadowcoder.ai;

import com.shadowcoder.theme.Person;
import com.shadowcoder.ui.MainFrame;


/**
 * The middle difficulty and average AI. Asks questions
 * without repetition and tries to ask questions that
 * help it get closer to guessing the user's person.
 *
 * @author Levester Chaney
 * @version 2010
 *
 */
public class AverageBrain extends Brain
{
	private int index;
	
	public AverageBrain(MainFrame f, Person comp)
	{
		super(f, comp);
		index = 0;
	}
	
	public void ask()
	{
		if(environment.getVersion() == 0)
			askOriginal();
		else if(environment.getVersion() == 1)
			askDisney();
		else
			askStar();
	}
	
	private void askOriginal()
	{
		if(size == 23)
		{
			do{
				index = (int)(Math.random() * questions.length);
			}while(!questions[index].contains("hair"));
			ask(index);
		}
		else if(size > 5)
		{
			bestQuestion();
			ask(index);
		}
		else
		{
			guess();
		}
	}
	
	private void askDisney()
	{
		if(size > 8)
		{
			bestQuestion();
			ask(index);
		}
		else
		{
			guess();
		}
	}
	
	private void askStar()
	{
		if(size > 5)
		{
			bestQuestion();
			ask(index);
		}
		else
		{
			guess();
		}	
	}
	
	private void guess()
	{
		guessing = true;
		do
		{
			index = (int)(Math.random() * 24);
			if(set[index] != null)
			{
				environment.output("Is your person " + set[index] + "?");
				guess = set[index];
			}
		}while(set[index] == null);
	}
	
	private void bestQuestion()
	{
		for(int i = 0; i < questions.length; i++)
		{
			if(questions[i] != null)
			{
				if(questions[i].contains("hair"))
				{
					if(hair)
					{
						questions[i] = null;
					}
					else
					{
						index = i;
						break;
					}
				}
				else if(questions[i].contains("female"))
				{
					if(male)
						questions[i] = null;
				}
				else if(questions[i].contains("male"))
				{
					if(female)
						questions[i] = null;
				}
				else if(questions[i].contains("eyes"))
				{
					if(eyes)
					{
						questions[i] = null;
					}
					else
					{
						index =i;
						break;
					}
				}
				else if(questions[i].contains("good") ||questions[i].contains("evil"))
				{
					if(good)
					{
						questions[i] = null;
					}
					else
					{
						index =i;
						break;
					}
				}
				else
				{
					index = i;
					break;
				}
			}
		}
	}
}
