//Name:
//Date:
//Purpose: Chess Starter Code

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;

public class FinalGame_Chess extends Applet implements ActionListener
{
    Panel p_card;  //to hold all of the screens
    Panel card1, card2, card3, card4, card5; //the two screens
    CardLayout cdLayout = new CardLayout ();

    //grid
    int row = 8;
    int col = 8;
    JButton a[] = new JButton [row * col];
    char piece[] [] = {{'r', 'n', 'b', 'k', 'q', 'b', 'n', 'r'}, {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'}, {'r', 'n', 'b', 'k', 'q', 'b', 'n', 'r'}};

    char select[] [] = {{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
	    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
	    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
	    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}};

    char colour[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}, {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}, {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}};

    char bg[] [] = {{'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
	    {'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
	    {'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
	    {'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'}};


    public void init ()
    {
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	screen1 ();
	screen2 ();
	screen3 ();
	screen4 ();
	screen5 ();
	resize (630, 700);
	setLayout (new BorderLayout ());
	add ("Center", p_card);
    }


    public void screen1 ()
    { //screen 1 is set up.
	card1 = new Panel ();
	card1.setBackground (new Color (255, 255, 255));
	JLabel title = new JLabel ("Welcome");
	JButton next = new JButton ("Next");
	next.setActionCommand ("s2");
	next.addActionListener (this);
	card1.add (title);
	card1.add (next);
	p_card.add ("1", card1);
    }


    public void screen2 ()
    { //screen 2 is set up.
	card2 = new Panel ();
	card2.setBackground (new Color (255, 255, 255));
	JLabel title = new JLabel ("Instructions");
	JButton next = new JButton ("Next");
	next.setActionCommand ("s3");
	next.addActionListener (this);
	card2.add (title);
	card2.add (next);
	p_card.add ("2", card2);
    }


    public void screen3 ()
    { //screen 3 is set up.
	card3 = new Panel ();
	card3.setBackground (new Color (255, 255, 255));
	JLabel title = new JLabel ("Game");
	JButton next = new JButton ("Next");
	next.setActionCommand ("s4");
	next.addActionListener (this);

	//Set up grid
	Panel p = new Panel (new GridLayout (row, col));
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    { a [move] = new JButton(createImageIcon (piece [i] [j] + "" + colour [i] [j] + "" + bg [i] [j] + "" + select [i] [j] + ".jpg"));
		a [move].setPreferredSize (new Dimension (75, 75));
		a [move].addActionListener (this);
		a [move].setActionCommand ("" + move);
		p.add (a [move]);
		move++;
	    }
	}
	card3.add (title);
	card3.add (p);
	card3.add (next);
	p_card.add ("3", card3);
    }


    public void screen4 ()
    { //screen 4 is set up.
	card4 = new Panel ();
	card4.setBackground (new Color (255, 255, 255));
	JLabel title = new JLabel ("You Win!");
	JButton next = new JButton ("Next");
	next.setActionCommand ("s5");
	next.addActionListener (this);
	card4.add (title);
	card4.add (next);
	p_card.add ("4", card4);
    }


    public void screen5 ()
    { //screen 5 is set up.
	card5 = new Panel ();
	card5.setBackground (new Color (255, 255, 255));
	JLabel title = new JLabel ("You Lose.");
	JButton next = new JButton ("Back to Introduction?");
	next.setActionCommand ("s1");
	next.addActionListener (this);
	JButton end = new JButton ("Quit?");
	end.setActionCommand ("s6");
	end.addActionListener (this);
	card5.add (title);
	card5.add (next);
	card5.add (end);
	p_card.add ("5", card5);
    }


    protected static ImageIcon createImageIcon (String path)
    { //change the red to your class name
	java.net.URL imgURL = FinalGame_Chess.class.getResource (path);
	if (imgURL != null)
	{
	    return new ImageIcon (imgURL);
	}
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }


    public void redraw ()
    {
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		a [move].setIcon (createImageIcon (piece [i] [j] + "" + colour [i] [j] + "" + bg [i] [j] + "" + select [i] [j] + ".jpg"));
		move++;
	    }
	}
    }


    public void actionPerformed (ActionEvent e)
    { //moves between the screens
	if (e.getActionCommand ().equals ("s1"))
	    cdLayout.show (p_card, "1");
	else if (e.getActionCommand ().equals ("s2"))
	    cdLayout.show (p_card, "2");
	else if (e.getActionCommand ().equals ("s3"))
	    cdLayout.show (p_card, "3");
	else if (e.getActionCommand ().equals ("s4"))
	    cdLayout.show (p_card, "4");
	else if (e.getActionCommand ().equals ("s5"))
	    cdLayout.show (p_card, "5");
	else if (e.getActionCommand ().equals ("s6"))
	    System.exit (0);
	else
	{ //code to handle the game
	    int n = Integer.parseInt (e.getActionCommand ());
	    int x = n / col;
	    int y = n % col;
	    showStatus ("(" + x + ", " + y + ")");

	}
    }
}
