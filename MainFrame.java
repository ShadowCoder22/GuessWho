import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.sound.midi.*;

/**
 * The main GUI frame of the Guess Who game. Everything is
 * drawn here. This frame also runs a portion of the logic
 * and eliminates characters for the user.
 *
 * @author Levester Chaney
 * @version 2010
 *
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
	private static final int PERSON_COUNT = 24;
	
	private JPanel window;
	private JPanel side;
	private JPanel board;
	private JPanel userQuestion;
	private JPanel compQuestion;
	private JPanel userGuess;
	private JMenuBar bar;
	private JComboBox menu;
	private JComboBox list;
	private JTextArea display;
	private JTextField inquiry;
	private ButtonGroup response;
	private JCheckBox yes;
	private JCheckBox no;
	private JButton ask;
	private JButton answer;
	private JButton guess;
	
	private int difficulty;
	private int version;
	private Scanner in;
	private Character[] people;
	private Character user;
	private Character comp;
	private String ques;
	private String who;
	private Brain cpu;
	private Sequencer seq;
	private boolean change = false;
	private boolean mute = false;
	
	private class MenuListener implements java.awt.event.ItemListener
	{
		public void itemStateChanged(ItemEvent arg0)
		{
				ques = arg0.getItem().toString();
				who = arg0.getItem().toString();
		}
	}
	
	private class ButtonListener implements java.awt.event.ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			if(arg0.getActionCommand().equals("ask"))
			{
				if(version == 0)
				{
					if(ques.contains("male"))
					{
						if(!((Original)comp).isMale())
						{
							write("No, my person is not male.");
							for(Character c : people)
							{
								if(((Original)c).isMale())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person is male.");
							for(Character c : people)
							{
								if(!((Original)c).isMale())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("female"))
					{
						if(!((Original)comp).isFemale())
						{
							write("No, my person is not female");
							for(Character c : people)
							{
								if(((Original)c).isFemale())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person is female");
							for(Character c : people)
							{
								if(!((Original)c).isFemale())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("bald"))
					{
						if(!((Original)comp).isBald())
						{
							write("No, my person is not balding.");
							for(Character c : people)
							{
								if(((Original)c).isBald())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person is balding.");
							for(Character c : people)
							{
								if(!((Original)c).isBald())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("brown hair"))
					{
						if(!((Original)comp).hasBrownHair())
						{
							write("No, my person does not have brown hair.");
							for(Character c : people)
							{
								if(((Original)c).hasBrownHair())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person does have brown hair.");
							for(Character c : people)
							{
								if(!((Original)c).hasBrownHair())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("black hair"))
					{
						if(!((Original)comp).hasBlackHair())
						{
							write("No, my person does not have black hair.");
							for(Character c : people)
							{
								if(((Original)c).hasBlackHair())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person does have black hair.");
							for(Character c : people)
							{
								if(!((Original)c).hasBlackHair())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("blonde hair"))
					{
						if(!((Original)comp).hasBlondeHair())
						{
							write("No, my person does not have blonde hair.");
							for(Character c : people)
							{
								if(((Original)c).hasBlondeHair())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person does have blonde hair.");
							for(Character c : people)
							{
								if(!((Original)c).hasBlondeHair())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("red hair"))
					{
						if(!((Original)comp).hasRedHair())
						{
							write("No, my person does not have red hair.");
							for(Character c : people)
							{
								if(((Original)c).hasRedHair())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person does have red hair.");
							for(Character c : people)
							{
								if(!((Original)c).hasRedHair())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("white hair"))
					{
						if(!((Original)comp).hasWhiteHair())
						{
							write("No, my person does not have white hair.");
							for(Character c : people)
							{
								if(((Original)c).hasWhiteHair())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person does have white hair.");
							for(Character c : people)
							{
								if(!((Original)c).hasWhiteHair())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("brown eyes"))
					{
						if(!((Original)comp).hasBrownEyes())
						{
							write("No, my person does not have brown eyes.");
							for(Character c : people)
							{
								if(((Original)c).hasBrownEyes())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person does have brown eyes.");
							for(Character c : people)
							{
								if(!((Original)c).hasBrownEyes())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("blue eyes"))
					{
						if(!((Original)comp).hasBlueEyes())
						{
							write("No, my person does not have blue eyes.");
							for(Character c : people)
							{
								if(((Original)c).hasBlueEyes())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person does have blue eyes.");
							for(Character c : people)
							{
								if(!((Original)c).hasBlueEyes())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("glasses"))
					{
						if(!((Original)comp).hasGlasses())
						{
							write("No, my person does not wear glasses.");
							for(Character c : people)
							{
								if(((Original)c).hasGlasses())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person does wear glasses.");
							for(Character c : people)
							{
								if(!((Original)c).hasGlasses())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("hat"))
					{
						if(!((Original)comp).hasHat())
						{
							write("No, my person does not wear a hat.");
							for(Character c : people)
							{
								if(((Original)c).hasHat())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person does wear a hat.");
							for(Character c : people)
							{
								if(!((Original)c).hasHat())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("mustache"))
					{
						if(!((Original)comp).hasMustache())
						{
							write("No, my person does not have a mustache.");
							for(Character c : people)
							{
								if(((Original)c).hasMustache())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person does have a mustache.");
							for(Character c : people)
							{
								if(!((Original)c).hasMustache())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("beard"))
					{
						if(!((Original)comp).hasBeard())
						{
							write("No, my person does not have a beard.");
							for(Character c : people)
							{
								if(((Original)c).hasBeard())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person does have a beard.");
							for(Character c : people)
							{
								if(!((Original)c).hasBeard())
									eliminate(c);
							}
						}
					}
					else
					{
						System.out.println("Phantom question was asked.");
					}
				}
				else if(version == 1)
				{
					if(ques.contains("human"))
					{
						if(!((Disney)comp).isHuman())
						{
							write("No, my person is not human.");
							for(Character c : people)
							{
								if(((Disney)c).isHuman())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person is human.");
							for(Character c : people)
							{
								if(!((Disney)c).isHuman())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("female"))
					{
						if(((Disney)comp).isMale())
						{
							write("No, my person is not female.");
							for(Character c : people)
							{
								if(!((Disney)c).isMale())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person is female.");
							for(Character c : people)
							{
								if(((Disney)c).isMale())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("male"))
					{
						if(!((Disney)comp).isMale())
						{
							write("No, my person is not male.");
							for(Character c : people)
							{
								if(((Disney)c).isMale())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person is male.");
							for(Character c : people)
							{
								if(!((Disney)c).isMale())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("good"))
					{
						if(!((Disney)comp).isGood())
						{
							write("No, my person is not good.");
							for(Character c : people)
							{
								if(((Disney)c).isGood())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person is good.");
							for(Character c : people)
							{
								if(!((Disney)c).isGood())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("evil"))
					{
						if(((Disney)comp).isGood())
						{
							write("No, my person is not evil.");
							for(Character c : people)
							{
								if(!((Disney)c).isGood())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person is evil.");
							for(Character c : people)
							{
								if(((Disney)c).isGood())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("hat"))
					{
						if(!((Disney)comp).hasHat())
						{
							write("No, my person does not wear a hat.");
							for(Character c : people)
							{
								if(((Disney)c).hasHat())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person does wear a hat.");
							for(Character c : people)
							{
								if(!((Disney)c).hasHat())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("black hair"))
					{
						if(!((Disney)comp).hasBlackHair())
						{
							write("No, my person does not have black hair.");
							for(Character c : people)
							{
								if(((Disney)c).hasBlackHair())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person does have black hair.");
							for(Character c : people)
							{
								if(!((Disney)c).hasBlackHair())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("brown hair"))
					{
						if(!((Disney)comp).hasBrownHair())
						{
							write("No, my person does not have brown hair.");
							for(Character c : people)
							{
								if(((Disney)c).hasBrownHair())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person does have brown hair.");
							for(Character c : people)
							{
								if(!((Disney)c).hasBrownHair())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("white hair"))
					{
						if(!((Disney)comp).hasWhiteHair())
						{
							write("No, my person does not have white hair.");
							for(Character c : people)
							{
								if(((Disney)c).hasWhiteHair())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person does have white hair.");
							for(Character c : people)
							{
								if(!((Disney)c).hasWhiteHair())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("red hair"))
					{
						if(!((Disney)comp).hasRedHair())
						{
							write("No, my person does not have red hair.");
							for(Character c : people)
							{
								if(((Disney)c).hasRedHair())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person does red hair.");
							for(Character c : people)
							{
								if(!((Disney)c).hasRedHair())
									eliminate(c);
							}
						}
					}
					else
					{
						System.out.println("Phantom question asked.");
					}
				}
				else
				{
					if(ques.contains("human"))
					{
						if(!((StarWars)comp).isHuman())
						{
							write("No, my person is not human.");
							for(Character c : people)
							{
								if(((StarWars)c).isHuman())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person is human.");
							for(Character c : people)
							{
								if(!((StarWars)c).isHuman())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("female"))
					{
						if(!((StarWars)comp).isFemale())
						{
							write("No, my person is not female.");
							for(Character c : people)
							{
								if(((StarWars)c).isFemale())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person is female.");
							for(Character c : people)
							{
								if(!((StarWars)c).isFemale())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("male"))
					{
						if(!((StarWars)comp).isMale())
						{
							write("No, my person is not male.");
							for(Character c : people)
							{
								if(((StarWars)c).isMale())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person is male.");
							for(Character c : people)
							{
								if(!((StarWars)c).isMale())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("jedi"))
					{
						if(!((StarWars)comp).isJedi())
						{
							write("No, my person is not a jedi.");
							for(Character c : people)
							{
								if(((StarWars)c).isJedi())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person is a jedi.");
							for(Character c : people)
							{
								if(!((StarWars)c).isJedi())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("sith"))
					{
						if(!((StarWars)comp).isSith())
						{
							write("No, my person is not a sith.");
							for(Character c : people)
							{
								if(((StarWars)c).isSith())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person is a sith.");
							for(Character c : people)
							{
								if(!((StarWars)c).isSith())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("rebel"))
					{
						if(!((StarWars)comp).isRebel())
						{
							write("No, my person is not a rebel.");
							for(Character c : people)
							{
								if(((StarWars)c).isRebel())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person is a rebel.");
							for(Character c : people)
							{
								if(!((StarWars)c).isRebel())
									eliminate(c);
							}
						}
					}
					else if(ques.contains("empire"))
					{
						if(!((StarWars)comp).isEmpire())
						{
							write("No, my person is not with the empire.");
							for(Character c : people)
							{
								if(((StarWars)c).isEmpire())
									eliminate(c);
							}
						}
						else
						{
							write("Yes, my person is with the empire.");
							for(Character c : people)
							{
								if(!((StarWars)c).isEmpire())
									eliminate(c);
							}
						}
					}
				}
				update();
				ask.setEnabled(false);
				guess.setEnabled(false);
				answer.setEnabled(true);
				writeAdd("My turn.");
				cpu.ask();
			}
			else if(arg0.getActionCommand().equals("answer"))
			{
				if(yes.isSelected())
				{
					if(cpu.update(true))
					{
						gameOver();
					}
					else
					{
						ask.setEnabled(true);
						guess.setEnabled(true);
						answer.setEnabled(false);
					}
				}
				else
				{
					if(cpu.update(false))
					{
						gameOver();
					}
					else
					{
						ask.setEnabled(true);
						guess.setEnabled(true);
						answer.setEnabled(false);
					}
				}
			}
			else if(arg0.getActionCommand().equals("guess"))
			{
				if(comp.toString().equalsIgnoreCase(who))
				{
					if(!cpu.wasGuessed(user))
					{
						System.out.println("You win.");
						write("Congratulations!! You beat me.");
						writeAdd("My person was " + comp + ".");
						gameOver();
					}
					else
					{
						System.out.println("You cheated.");
						write("You guessed correct but you cheated.\nYour person was already eliminated.");
						gameOver();
					}
				}
				else
				{
					for(Character c : people)
					{
						if(c.toString().equalsIgnoreCase(who))
						{
							eliminate(c);
						}
					}
					update();
					ask.setEnabled(false);
					guess.setEnabled(false);
					answer.setEnabled(true);
					write("My turn");
					cpu.ask();
				}
			}
			else if(arg0.getActionCommand().equals("new"))
			{
				startNewGame();
			}
			else if(arg0.getActionCommand().equals("easy"))
			{
				difficulty = 0;
				startNewGame();
			}
			else if(arg0.getActionCommand().equals("medium"))
			{
				difficulty = 1;
				startNewGame();
			}
			else if(arg0.getActionCommand().equals("hard"))
			{
				difficulty = 2;
				startNewGame();
			}
			else if(arg0.getActionCommand().equals("original"))
			{
				if(version == 1 || version == 2)
					change = true;
				version = 0;
				startNewGame();
			}
			else if(arg0.getActionCommand().equals("disney"))
			{
				if(version == 0 || version == 2)
					change = true;
				version = 1;
				startNewGame();
			}
			else if(arg0.getActionCommand().equals("star"))
			{
				if(version == 0 || version == 1)
					change = true;
				version = 2;
				startNewGame();
			}
			else if(arg0.getActionCommand().equals("info"))
			{
				//int x = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 8;
				new BioFrame(user);
			}
			else if(arg0.getActionCommand().equals("prof"))
			{
				new BioFrame();
			}
			else if(arg0.getActionCommand().equals("mute"))
			{
				mute = !mute;
				if(mute)
					seq.stop();
				else
					seq.start();
			}
			else if(arg0.getActionCommand().equals("game"))
			{
				new HelpFrame();
			}
			else if(arg0.getActionCommand().equals("exit"))
			{
				System.exit(0);
			}
		}
	}

	protected MainFrame(int diff, int vers)
	{
		super("Guess Who");
		setIconImage(Toolkit.getDefaultToolkit().getImage("support/guess.jpg"));
		
		people = new Character[PERSON_COUNT];
		version = vers;
		loadCharacters();
		user = people[(int)(Math.random() * PERSON_COUNT)];
		do{
			comp = people[(int)(Math.random() * PERSON_COUNT)];
		}while(user.equals(comp));
		
		if((difficulty = diff) == 0)
			cpu = new DumbBrain(this, comp);
		else if((difficulty = diff) == 1)
			cpu = new AverageBrain(this, comp);
		
		System.out.println("User: " + user);
		System.out.println("Comp: " + comp);
		
		build();
		write(cpu.intro());
		setJMenuBar(bar);
		add(window);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setPreferredSize(new Dimension(710, 740));
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		try {
			seq = MidiSystem.getSequencer();
			File midiFile = new File("audio/bluesnight.mid");
			seq.setSequence(MidiSystem.getSequence(midiFile));
			seq.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			seq.open();
	        seq.start();
		} catch (Exception e) {
	     	System.err.println("MidiPlayer: " + e);
		}
	}
	
	public static void main(String[] args)
	{
		// Start game with medium difficulty and original images
		new MainFrame(1, 0);
	}
	
	private void build()
	{
		drawMenu();
		drawFlap();
		drawBoard();
		drawUserQuestion();
		drawCompQuestion();
		drawGuess();
		
		display = new JTextArea();
		display.setPreferredSize(new Dimension(500, 50));
		display.setBorder(new LineBorder(Color.BLACK));
		display.setFont(new Font("Courier", Font.PLAIN, 16));
		display.setEditable(false);
		
		JPanel space1 = new JPanel();
		space1.setOpaque(false);
		space1.setPreferredSize(new Dimension(50, 500));
		JPanel space2 = new JPanel();
		space2.setOpaque(false);
		space2.setPreferredSize(new Dimension(50, 500));
		
		window = new JPanel()
		{
			ImageIcon icon = new ImageIcon("support/sky.jpg");
			
			protected void paintComponent(Graphics g)
			{
				//  Display image at at full size
				g.drawImage(icon.getImage(), 0, 0, null);
				super.paintComponent(g);
			}
		};
		window.setOpaque(false);
		window.setPreferredSize(new Dimension(700, 670));
		window.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		window.add(space1);
		window.add(side);
		window.add(space2);
		window.add(board);
		window.add(userQuestion);
		window.add(userGuess);
		window.add(compQuestion);
		window.add(display);
	}
	
	private void drawBoard()
	{
		board = new JPanel();
		board.setOpaque(false);
		board.setPreferredSize(new Dimension(500, 500));
		board.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		for(Character c : people)
			board.add(c.getProfile());
	}
	
	private void drawFlap()
	{
		side = new JPanel();
		side.setOpaque(false);
		side.setPreferredSize(new Dimension(100, 500));
		JPanel prof = new JPanel();
		prof.setOpaque(false);
		prof.setPreferredSize(new Dimension(75, 200));
		prof.add(new JLabel("Your Person:"));
		JButton image;
		if(version == 0)
			image = new JButton(new ImageIcon("original/" + user.toString() + ".jpg"));
		else if(version == 1)
			image = new JButton(new ImageIcon("disney/" + user.toString() + ".jpg"));
		else
			image = new JButton(new ImageIcon("starwars/" + user.toString() + ".jpg"));
		image.setPreferredSize(new Dimension(75, 100));
		image.addActionListener(new ButtonListener());
		image.setActionCommand("info");
		prof.add(image);
		prof.add(new JLabel(user.toString()));
		JPanel fill = new JPanel();
		fill.setOpaque(false);
		fill.setPreferredSize(new Dimension(75, 300));
		side.add(fill);
		side.add(prof);
	}
	
	private void drawUserQuestion()
	{
		createMenu();
		createButton();
		
		userQuestion = new JPanel();
		userQuestion.setOpaque(false);
		userQuestion.setPreferredSize(new Dimension(600, 40));
		userQuestion.setLayout(new FlowLayout(FlowLayout.LEFT));
		userQuestion.add(menu);
		userQuestion.add(ask);
	}
	
	private void drawGuess()
	{
		userGuess = new JPanel();
		userGuess.setOpaque(false);
		userGuess.setPreferredSize(new Dimension(600, 40));
		userGuess.setLayout(new FlowLayout(FlowLayout.LEFT));
		userGuess.add(list);
		userGuess.add(guess);
	}
	
	private void drawCompQuestion()
	{
		createInquiry();
		createResponse();
		
		compQuestion = new JPanel();
		compQuestion.setOpaque(false);
		compQuestion.setPreferredSize(new Dimension(540, 50));
		compQuestion.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JPanel pane = new JPanel();
		pane.setOpaque(false);
		pane.setPreferredSize(new Dimension(500, 80));
		pane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pane.add(inquiry);
		pane.add(yes);
		pane.add(no);
		pane.add(answer);
		compQuestion.add(pane);
	}
	
	private void drawMenu()
	{
		bar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu options = new JMenu("Options");
		JMenu difficulty = new JMenu("Difficulty");
		JMenu version = new JMenu("Version");
		JMenu help = new JMenu("Help");
		JMenu audio = new JMenu("Audio");
		
		JMenuItem game = new JMenuItem("New Game");
		game.setActionCommand("new");
		game.addActionListener(new ButtonListener());
		JMenuItem exit = new JMenuItem("Exit");
		exit.setActionCommand("exit");
		exit.addActionListener(new ButtonListener());
		JMenuItem easy = new JMenuItem("Easy");
		easy.setActionCommand("easy");
		easy.addActionListener(new ButtonListener());
		JMenuItem medium = new JMenuItem("Medium");
		medium.setActionCommand("medium");
		medium.addActionListener(new ButtonListener());
		JMenuItem hard = new JMenuItem("Hard");
		hard.setActionCommand("hard");
		hard.addActionListener(new ButtonListener());
		JMenuItem original = new JMenuItem("Original");
		original.setActionCommand("original");
		original.addActionListener(new ButtonListener());
		JMenuItem disney = new JMenuItem("Disney");
		disney.setActionCommand("disney");
		disney.addActionListener(new ButtonListener());
		JMenuItem star = new JMenuItem("Star Wars");
		star.setActionCommand("star");
		star.addActionListener(new ButtonListener());
		JMenuItem mute = new JMenuItem("Mute");
		mute.setActionCommand("mute");
		mute.addActionListener(new ButtonListener());
		JMenuItem gameHelp = new JMenuItem("Game Help");
		gameHelp.setActionCommand("game");
		gameHelp.addActionListener(new ButtonListener());
		JMenuItem prof = new JMenuItem("Profiles");
		prof.setActionCommand("prof");
		prof.addActionListener(new ButtonListener());

		file.add(game);
		file.addSeparator();
		file.add(exit);
		difficulty.add(easy);
		difficulty.add(medium);
		difficulty.add(hard);
		version.add(original);
		version.add(disney);
		version.add(star);
		audio.add(mute);
		options.add(difficulty);
		options.add(version);
		options.add(audio);
		help.add(gameHelp);
		help.add(prof);
		
		bar.add(file);
		bar.add(options);
		bar.add(help);
	}
	
	private void loadCharacters()
	{
		try{
			if(version == 0)
				in =  new Scanner(new File("original/data.gw"));
			else if(version == 1)
				in = new Scanner(new File("disney/data.gw"));
			else
				in = new Scanner(new File("starwars/data.gw"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("The set up file was not found.");
			throw new RuntimeException("Could not find the data file.");
		}
		
		if(version == 0)
		{
			String name, image;
			char c;
			boolean b1, b2, b3, b4, b5;
			Color c1, c2;
			
			for(int i = 0; i < PERSON_COUNT; i++)
			{
				String line = in.nextLine();
				StringTokenizer t = new StringTokenizer(line);
				name = t.nextToken();
				image = "original/" + t.nextToken();
				c = t.nextToken().charAt(0);
				b1 = t.nextToken().equalsIgnoreCase("t");
				b2 = t.nextToken().equalsIgnoreCase("t");
				b3 = t.nextToken().equalsIgnoreCase("t");
				b4 = t.nextToken().equalsIgnoreCase("t");
				String s1 = t.nextToken();
				if(s1.equalsIgnoreCase("bl"))
					c1 = Color.BLACK;
				else if(s1.equalsIgnoreCase("br"))
					c1 = Character.BROWN;
				else if(s1.equalsIgnoreCase("y"))
					c1 = Color.YELLOW;
				else if(s1.equalsIgnoreCase("w"))
					c1 = Color.WHITE;
				else
					c1 = Color.RED;
				b5 = !t.nextToken().equalsIgnoreCase("f");
				c2 = t.nextToken().equalsIgnoreCase("bl") ? Color.BLUE : Character.BROWN;
				
				people[i] = new Original(name, image, c, b1, b2, b3, b4, b5, c1, c2);
			}
		}
		else if(version == 1)
		{
			String name, image;
			char c;
			boolean b1, b2, b3;
			Color c1;
			
			for(int i = 0; i < PERSON_COUNT;  i++)
			{
				String line = in.nextLine();
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
					c1 = Character.BROWN;
				else if(s1.equalsIgnoreCase("w"))
					c1 = Color.WHITE;
				else if(s1.equalsIgnoreCase("r"))
					c1 = Color.RED;
				else if(s1.equalsIgnoreCase("b"))
					c1 = Color.BLUE;
				else
					c1 = Color.PINK;
				
				people[i] = new Disney(name, image, c, b1, b2, b3, c1);
			}
		}
		else
		{
			String name, image;
			char c;
			boolean b1, b2, b3, b4;
			
			for(int i = 0; i < PERSON_COUNT;  i++)
			{
				String line = in.nextLine();
				StringTokenizer t = new StringTokenizer(line);
				name = t.nextToken();
				image = "starwars/" + t.nextToken();
				c = t.nextToken().charAt(0);
				b1 = !t.nextToken().equalsIgnoreCase("f");
				b2 = !t.nextToken().equalsIgnoreCase("f");
				b3 = !t.nextToken().equalsIgnoreCase("f");
				b4 = !t.nextToken().equalsIgnoreCase("f");
				
				people[i] = new StarWars(name, image, c, b1, b2, b3, b4);
			}
		}
		in.close();
	}
	
	private void createMenu()
	{
		try{
			if(version == 0)
				in =  new Scanner(new File("original/questions.gw"));
			else if(version == 1)
				in = new Scanner(new File("disney/questions.gw"));
			else
				in = new Scanner(new File("starwars/questions.gw"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("The set up file was not found.");
			throw new RuntimeException("Could not find the questions file.");
		}
		menu = new JComboBox();
		menu.setPreferredSize(new Dimension(300, 20));
		menu.addItem(" - Select your question - ");
		while(in.hasNext())
			menu.addItem(in.nextLine());
		menu.addItemListener(new MenuListener());
		ques = "";
		
		list = new JComboBox();
		list.setPreferredSize(new Dimension(300, 20));
		list.addItem(" - Select a person - ");
		for(Character c : people)
		{
			if(!c.isEliminated())
				list.addItem(c.toString());
		}
		who = "";
		list.addItemListener(new MenuListener());
	}
	
	private void createButton()
	{
		ask = new JButton("ASK");
		ask.setActionCommand("ask");
		ask.addActionListener(new ButtonListener());
		guess = new JButton("GUESS");
		guess.setActionCommand("guess");
		guess.addActionListener(new ButtonListener());
		answer = new JButton("ANSWER");
		answer.setActionCommand("answer");
		answer.addActionListener(new ButtonListener());
		answer.setEnabled(false);
	}
	
	private void createInquiry()
	{
		inquiry = new JTextField();
		inquiry.setPreferredSize(new Dimension(300, 20));
		inquiry.setEditable(false);
	}
	
	private void createResponse()
	{
		response = new ButtonGroup();
		yes = new JCheckBox("Yes", false);
		yes.setOpaque(false);
		no = new JCheckBox("No", true);
		no.setOpaque(false);
		response.add(yes);
		response.add(no);
	}
	
	private void update()
	{
		window.removeAll();

		JPanel space1 = new JPanel();
		space1.setOpaque(false);
		space1.setPreferredSize(new Dimension(50, 500));
		JPanel space2 = new JPanel();
		space2.setOpaque(false);
		space2.setPreferredSize(new Dimension(50, 500));
		drawMenu();
		drawFlap();
		drawBoard();
		drawUserQuestion();
		drawCompQuestion();
		drawGuess();
		window.add(space1);
		window.add(side);
		window.add(space2);
		window.add(board);
		window.add(userQuestion);
		window.add(userGuess);
		window.add(compQuestion);
		window.add(display);
		validate();
	}
	
	private void eliminate(Character c)
	{
		for(int i = 0; i < PERSON_COUNT; i++)
		{
			if(people[i].equals(c))
				people[i].setImage("support/eliminated.jpg");
		}
	}
	
	protected int getVersion()
	{
		return version;
	}
	
	protected void output(String msg)
	{
		inquiry.setText(msg);
	}
	
	protected Character getUser()
	{
		return user;
	}
	
	protected void gameOver()
	{
		ask.setEnabled(false);
		answer.setEnabled(false);
		guess.setEnabled(false);
		validate();
	}
	
	protected void write(String msg)
	{
		display.setText(msg);
	}
	protected void writeAdd(String msg)
	{
		display.append("\n" + msg);
	}
	
	protected int getLeft()
	{
		int count = 0;
		
		for(Character c : people)
		{
			if(!c.isEliminated())
				count++;
		}
		
		return count;
	}
	
	private void startNewGame()
	{
		people = new Character[PERSON_COUNT];
		loadCharacters();
		user = people[(int)(Math.random() * PERSON_COUNT)];
		do{
			comp = people[(int)(Math.random() * PERSON_COUNT)];
		}while(user.equals(comp));
		
		if(difficulty == 0)
		{
			cpu = new DumbBrain(this, comp);
		}
		else if(difficulty == 1)
		{
			cpu = new AverageBrain(this, comp);
		}
		else if(difficulty == 2)
		{
			cpu = new HardBrain(this, comp, user);
		}
		
		System.out.println("User: " + user);
		System.out.println("Comp: " + comp);
		
		update();
		write(cpu.intro());
		
		try {
			if(change)
			{
				seq.close();
				seq = MidiSystem.getSequencer();
				File midiFile1;
				if(version == 0)
				{
					midiFile1 = new File("audio/bluesnight.mid");
				}
				else if(version == 1)
				{
					midiFile1 = new File("audio/wishstar.mid");
				}
				else
				{
					midiFile1 = new File("audio/cantina.mid");
				}
				seq.setSequence(MidiSystem.getSequence(midiFile1));
				seq.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
				seq.open();
		        if(!mute && change)
		        	seq.start();
				change = false;
			}
	     } catch (Exception e) {
	     	System.err.println("MidiPlayer: " + e);
	     }
	}
}
