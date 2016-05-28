package com.shadowcoder.theme;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.shadowcoder.ui.BioFrame;

/**
 * The umbrella logic for the people in the game.
 * This holds all of the information that is common
 * to all of the characters.
 *
 * @author Levester Chaney
 * @version 2010
 *
 */
public abstract class Person
{
	public static Color BROWN = new Color(96, 64, 32);
	
	
	private JPanel profile;
	private String name;
	private ImageIcon pic;
	private boolean eliminated = false;
	
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			if(arg0.getActionCommand().equals("info"))
			{
				//int x = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 8;
				new BioFrame(getCharacter());
			}
		}
	}
	
	protected Person(String n, String i)
	{
		name = n;
		pic = new ImageIcon(i);
		build();
	}
	
	private void build()
	{
		JButton image = new JButton(pic);
		image.setPreferredSize(new Dimension(75, 100));
		image.addActionListener(new ButtonListener());
		image.setActionCommand("info");
		profile = new JPanel();
		profile.setOpaque(false);
		profile.setLayout(new FlowLayout(FlowLayout.CENTER));
		profile.setPreferredSize(new Dimension(75, 125));
		profile.add(image);
		profile.add(new JLabel(name));
	}
	
	private Person getCharacter()
	{
		return this;
	}
	
	public JPanel getProfile()
	{
		return profile;
	}
	
	public void setImage(String str)
	{
		pic = new ImageIcon(str);
		eliminated = true;
		profile.removeAll();
		profile.add(new JLabel(pic));
		profile.add(new JLabel(name));
	}
	
	protected boolean equals(Person other)
	{
		return name.equalsIgnoreCase(other.name);
	}
	
	public String toString()
	{
		return name;
	}
	
	public boolean isEliminated()
	{
		return eliminated;
	}
}	