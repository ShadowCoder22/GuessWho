package com.shadowcoder.ui;
import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * The help frame for the Guess Who game. It acts
 * as the instruction manual for the game; telling the
 * user how to play and where to find everything.
 *
 * @author Levester Chaney
 * @version 2010
 *
 */
@SuppressWarnings("serial")
public class HelpFrame extends JFrame
{
	protected HelpFrame()
	{
		super("Guess Who: Help");
		setIconImage(Toolkit.getDefaultToolkit().getImage("support/guess.jpg"));
		add(build());
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();
	}
	
	private JPanel build()
	{
		JPanel pane = new JPanel();
		
		try{
			Scanner in = new Scanner(new File("support/help.gw"));
			
			pane.setPreferredSize(new Dimension(600, 300));
			
			JTextArea text = new JTextArea();
			text.setPreferredSize(new Dimension(600, 1000));
			text.setFont(new Font("Arial", Font.PLAIN, 14));
			text.setEditable(false);
			while(in.hasNext())
			{
				text.append(in.nextLine() + "\n");
			}
			text.setCaretPosition(0);
			JScrollPane subpane = new JScrollPane(text);
			subpane.setPreferredSize(new Dimension(600, 300));
			subpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			subpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			pane.add(subpane);
		}
		catch(FileNotFoundException e)
		{
			throw new RuntimeException("Could not locate the help file");
		}
		return pane;
	}
}