package com.shadowcoder.ui;

import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

import com.shadowcoder.theme.Person;

/**
 * The biography frame for the Guess Who game. It
 * displays Character Bios for people that the user
 * may not know very well.
 *
 * @author Levester Chaney
 * @version 2010
 *
 */
@SuppressWarnings("serial")
public class BioFrame extends JFrame
{
	private Scanner read;
	
	protected BioFrame()
	{
		super("Guess Who: Bio Frame");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.RESOURCE_DIR+"support/guess.jpg"));
		
		try{
			read = new Scanner(new File(MainFrame.RESOURCE_DIR+"support/stats.gw"));
			JTextArea text = new JTextArea();
			text.setPreferredSize(new Dimension(600, 6750));
			text.setFont(new Font("Arial", Font.PLAIN, 14));
			text.setEditable(false);
			while(read.hasNext())
				text.append(read.nextLine() + "\n");
			text.setCaretPosition(0);
			JScrollPane window = new JScrollPane(text);
			window.setPreferredSize(new Dimension(600, 300));
			window.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			window.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			add(window);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setVisible(true);
			setLocationRelativeTo(null);
			pack();
		}
		catch(FileNotFoundException e)
		{
			throw new RuntimeException("Could not locate that profile.");
		}
	}
	
	public BioFrame(Person c)
	{
		super("Guess Who: " + c.toString() + "'s Bio");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.RESOURCE_DIR+"support/guess.jpg"));
		JTextArea text = new JTextArea();
		text.setPreferredSize(new Dimension(600, 300));
		text.setFont(new Font("Arial", Font.PLAIN, 14));
		text.setEditable(false);
		
		try{
			read = new Scanner(new File(MainFrame.RESOURCE_DIR+"profiles/" + c.toString() + ".prof"));
			while(read.hasNext())
				text.append(read.nextLine() + "\n");
		}
		catch(FileNotFoundException e)
		{
			text.setText("  There is no profile on this person.");
		}
		text.setCaretPosition(0);
		JPanel window = new JPanel();
		window.setPreferredSize(new Dimension(600, 300));
		window.add(text);
		add(window);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		pack();
	}
}