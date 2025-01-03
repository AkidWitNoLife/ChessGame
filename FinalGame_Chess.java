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
    Panel card1, card2, card3, card4, card5, card6, card7; //the two screens
    CardLayout cdLayout = new CardLayout ();

    //turn
    JLabel turnpic;
    char turn = 'w';
    int last = -1;

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


    char m[] [] = {{'r', 'n', 'b', 'k', 'q', 'b', 'n', 'r'}, {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'}, {'r', 'n', 'b', 'k', 'q', 'b', 'n', 'r'}};


    char n[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}, {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}, {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}};

    boolean hasMoved[] [] = new boolean [row] [col]; // Track if pieces have moved



    public void init ()
    {
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	screen1 ();
	screen2 ();
	screen3 ();
	screen4 ();
	screen5 ();
	screen6 ();
	screen7 ();
	resize (580, 650);
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

	//white forfiet
	JButton wsurndr = new JButton ("White concede?");
	wsurndr.setBackground (Color.white);
	wsurndr.setForeground (Color.black);
	wsurndr.addActionListener (this);
	wsurndr.setActionCommand ("wsurndr");
	add (wsurndr);

	//black forfiet
	JButton bsurndr = new JButton ("Black concede?");
	bsurndr.setBackground (Color.black);
	bsurndr.setForeground (Color.white);
	bsurndr.addActionListener (this);
	bsurndr.setActionCommand ("bsurndr");
	add (bsurndr);

	//turn
	turnpic = new JLabel (createImageIcon ("kwbu.png"));
	JButton next = new JButton ("Next");
	next.setActionCommand ("s4");
	next.addActionListener (this);



	//reset button
	JButton resetbtn = new JButton ("Reset?");
	resetbtn.setBackground (Color.black);
	resetbtn.setForeground (Color.white);
	resetbtn.addActionListener (this);
	resetbtn.setActionCommand ("resetbtn");
	add (resetbtn);


	//Set up grid
	Panel p = new Panel (new GridLayout (row, col));
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		a [move] = new JButton (createImageIcon (piece [i] [j] + "" + colour [i] [j] + "" + bg [i] [j] + "" + select [i] [j] + ".png"));
		a [move].setPreferredSize (new Dimension (64, 64));
		a [move].addActionListener (this);
		a [move].setActionCommand ("" + move);
		p.add (a [move]);
		move++;
	    }
	}
	card3.add (title);
	card3.add (wsurndr);
	card3.add (turnpic);
	card3.add (bsurndr);
	card3.add (p);
	card3.add (next);
	card3.add (resetbtn);
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



    public void screen6 ()
    { //screen 6 is set up.
	card6 = new Panel ();
	card6.setBackground (new Color (255, 255, 255));
	JLabel title = new JLabel ("Bowser wins. Mario conceded.");
	JButton next = new JButton ("Back to Introduction?");
	next.setActionCommand ("s1");
	next.addActionListener (this);
	JButton end = new JButton ("Quit?");
	end.setActionCommand ("s7");
	end.addActionListener (this);
	card6.add (title);
	card6.add (next);
	card6.add (end);
	p_card.add ("6", card6);
    }


    public void screen7 ()
    { //screen 7 is set up.
	card7 = new Panel ();
	card7.setBackground (new Color (255, 255, 255));
	JLabel title = new JLabel ("Mario wins. Bowser conceded.");
	JButton next = new JButton ("Back to Introduction?");
	next.setActionCommand ("s1");
	next.addActionListener (this);
	JButton end = new JButton ("Quit?");
	end.setActionCommand ("s8");
	end.addActionListener (this);
	card7.add (title);
	card7.add (next);
	card7.add (end);
	p_card.add ("7", card7);
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
		a [move].setIcon (createImageIcon (piece [i] [j] + "" + colour [i] [j] + "" + bg [i] [j] + "" + select [i] [j] + ".png"));
		move++;
	    }
	}
    }


    public void reset ()
    { //copy every element of r into b
	//that sets it back to the original
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		piece [i] [j] = m [i] [j];
		colour [i] [j] = n [i] [j];
		select [i] [j] = 'u';
		hasMoved [i] [j] = false; // Reset the hasMoved array
	    }
	}
	//call redraw to update b on the screen
	redraw ();
    }


  /*  public void score ()
    {
	int countb = 0;
	int countw = 0;

	for (i = 0 ; i < row ; i++)
	    for (j = 0 ; j < col ; j++)
		if (colour [i] [j] == 'b' && piece [i] [j] == 'p'
			countb++ ;

		}

*/

	public void selectPawn (int x, int y)
	{

	    //first move 2 spaces pawns
	    if (colour [x] [y] == 'b' && x == 6)
	    {
		select [x - 1] [y] = 's';
		select [x - 2] [y] = 's';
	    }
	    else if (colour [x] [y] == 'w' && x == 1)
	    {
		select [x + 1] [y] = 's';
		select [x + 2] [y] = 's';
	    }

	    // pawn moves

	    else if (x - 1 >= 0 && colour [x] [y] == 'b' && colour [x - 1] [y] == 'x')
	    {
		select [x - 1] [y] = 's';
	    }
	    else if (x + 1 < row && colour [x] [y] == 'w' && colour [x + 1] [y] == 'x')
	    {
		select [x + 1] [y] = 's';
	    }

	    //black pawn kills

	    if (x - 1 >= 0 && y - 1 >= 0 && colour [x] [y] == 'b' && colour [x - 1] [y - 1] == 'w')
	    {
		select [x - 1] [y - 1] = 's';
	    }

	    if (x - 1 >= 0 && y + 1 < col && colour [x] [y] == 'b' && colour [x - 1] [y + 1] == 'w')
	    {
		select [x - 1] [y + 1] = 's';
	    }

	    //white pawn kills
	    if (x + 1 < row && y - 1 >= 0 && colour [x] [y] == 'w' && colour [x + 1] [y - 1] == 'b')
	    {
		select [x + 1] [y - 1] = 's';
	    }

	    if (x + 1 < row && y + 1 < col && colour [x] [y] == 'w' && colour [x + 1] [y + 1] == 'b')
	    {
		select [x + 1] [y + 1] = 's';
	    }
	}


	public void selectKing (int x, int y)
	{
	    // King moves
	    if (x - 1 >= 0 && y - 1 >= 0 && colour [x - 1] [y - 1] != turn)
		select [x - 1] [y - 1] = 's';

	    if (x - 1 >= 0 && colour [x - 1] [y] != turn)
		select [x - 1] [y] = 's';

	    if (x - 1 >= 0 && y + 1 < col && colour [x - 1] [y + 1] != turn)
		select [x - 1] [y + 1] = 's';

	    if (y - 1 >= 0 && colour [x] [y - 1] != turn)
		select [x] [y - 1] = 's';

	    if (y + 1 < col && colour [x] [y + 1] != turn)
		select [x] [y + 1] = 's';

	    if (x + 1 < row && y - 1 >= 0 && colour [x + 1] [y - 1] != turn)
		select [x + 1] [y - 1] = 's';

	    if (x + 1 < row && colour [x + 1] [y] != turn)
		select [x + 1] [y] = 's';

	    if (x + 1 < row && y + 1 < col && colour [x + 1] [y + 1] != turn)
		select [x + 1] [y + 1] = 's';

	    // Castling logic
	    if (!hasMoved [x] [y])
	    {
		// Kingside castling
		if (canCastle (x, y, 0))
		{
		    select [x] [y + 2] = 's';
		}
		// Queenside castling
		if (canCastle (x, y, 1))
		{
		    select [x] [y - 2] = 's';
		}
	    }
	}


	public boolean canCastle (int kingX, int kingY, int side)
	{
	    // Kingside castling
	    if (side == 0)
	    {
		if (kingY + 3 < col && piece [kingX] [kingY + 3] == 'r' && !hasMoved [kingX] [kingY + 3])
		{
		    for (int i = kingY + 1 ; i < kingY + 3 ; i++)
		    {
			if (piece [kingX] [i] != 'x' || isSquareUnderAttack (kingX, i))
			{
			    return false;
			}
		    }
		    return true;
		}
	    }
	    // Queenside castling
	    else if (side == 1)
	    {
		if (kingY - 4 >= 0 && piece [kingX] [kingY - 4] == 'r' && !hasMoved [kingX] [kingY - 4])
		{
		    for (int i = kingY - 1 ; i > kingY - 4 ; i--)
		    {
			if (piece [kingX] [i] != 'x' || isSquareUnderAttack (kingX, i))
			{
			    return false;
			}
		    }
		    return true;
		}
	    }
	    return false;
	}


	public boolean isSquareUnderAttack (int x, int y)
	{
	    // Logic to check if a square is under attack by any opponent's pieces
	    // Placeholder implementation
	    return false;
	}


	public void movePiece (int fromX, int fromY, int toX, int toY)
	{
	    // Perform castling if it's a castling move
	    if (piece [fromX] [fromY] == 'k' && Math.abs (fromY - toY) == 2)
	    {
		// Kingside castling
		if (toY == 6)
		{
		    piece [fromX] [5] = piece [fromX] [7];
		    piece [fromX] [7] = 'x';
		}
		// Queenside castling
		else if (toY == 2)
		{
		    piece [fromX] [3] = piece [fromX] [0];
		    piece [fromX] [0] = 'x';
		}
	    }

	    // Move the piece
	    piece [toX] [toY] = piece [fromX] [fromY];
	    piece [fromX] [fromY] = 'x';

	    // Mark the pieces as moved
	    hasMoved [toX] [toY] = true;
	    hasMoved [fromX] [fromY] = true;
	}


	public void selectKnight (int x, int y)
	{
	    if (x - 2 >= 0 && y - 1 >= 0 && colour [x - 2] [y - 1] != turn)
		select [x - 2] [y - 1] = 's';

	    if (x - 2 >= 0 && y + 1 < col && colour [x - 2] [y + 1] != turn)
		select [x - 2] [y + 1] = 's';

	    if (x - 1 >= 0 && y - 2 >= 0 && colour [x - 1] [y - 2] != turn)
		select [x - 1] [y - 2] = 's';

	    if (x - 1 >= 0 && y + 2 < col && colour [x - 1] [y + 2] != turn)
		select [x - 1] [y + 2] = 's';

	    if (x + 1 < row && y + 2 < col && colour [x + 1] [y + 2] != turn)
		select [x + 1] [y + 2] = 's';

	    if (x + 1 < row && y - 2 >= 0 && colour [x + 1] [y - 2] != turn)
		select [x + 1] [y - 2] = 's';

	    if (x + 2 < row && y - 1 >= 0 && colour [x + 2] [y - 1] != turn)
		select [x + 2] [y - 1] = 's';

	    if (x + 2 < row && y + 1 < col && colour [x + 2] [y + 1] != turn)
		select [x + 2] [y + 1] = 's';
	}


	public void selectRook (int x, int y)
	{
	    //UP-------------------------------
	    int cx1 = x - 1;
	    while (cx1 >= 0 && colour [cx1] [y] == 'x')
	    {
		select [cx1] [y] = 's';
		cx1--;
	    }
	    if (cx1 >= 0 && colour [cx1] [y] != turn && colour [cx1] [y] != 'x')
		select [cx1] [y] = 's';

	    //DOWN-----------------------------
	    cx1 = x + 1;
	    while (cx1 < row && colour [cx1] [y] == 'x')
	    {
		select [cx1] [y] = 's';
		cx1++;
	    }
	    if (cx1 < row && colour [cx1] [y] != turn && colour [cx1] [y] != 'x')
		select [cx1] [y] = 's';

	    //LEFT-----------------------------
	    int cy1 = y - 1;
	    while (cy1 >= 0 && colour [x] [cy1] == 'x')
	    {
		select [x] [cy1] = 's';
		cy1--;
	    }
	    if (cy1 >= 0 && colour [x] [cy1] != turn && colour [x] [cy1] != 'x')
		select [x] [cy1] = 's';

	    //Right-----------------------------
	    cy1 = y + 1;
	    while (cy1 < col && colour [x] [cy1] == 'x')
	    {
		select [x] [cy1] = 's';
		cy1++;
	    }
	    if (cy1 < col && colour [x] [cy1] != turn && colour [x] [cy1] != 'x')
		select [x] [cy1] = 's';
	}


	public void selectBishop (int x, int y)
	{
	    //NE -- x-1  y+1  -------------------------------
	    int cx1 = x - 1;
	    int cy1 = y + 1;
	    while (cx1 >= 0 && cy1 < col && colour [cx1] [cy1] == 'x')
	    {
		select [cx1] [cy1] = 's';
		cx1--;
		cy1++;
	    }
	    if (cx1 >= 0 && cy1 < col && colour [cx1] [cy1] != turn && colour [cx1] [cy1] != 'x')
		select [cx1] [cy1] = 's';

	    //NW-----------------------------
	    cx1 = x + 1;
	    cy1 = y + 1;
	    while (cx1 < row && cy1 < col && colour [cx1] [cy1] == 'x')
	    {
		select [cx1] [cy1] = 's';
		cx1++;
		cy1++;
	    }
	    if (cx1 < row && cy1 < col && colour [cx1] [cy1] != turn && colour [cx1] [cy1] != 'x')
		select [cx1] [cy1] = 's';

	    //SE-----------------------------
	    cx1 = x - 1;
	    cy1 = y - 1;
	    while (cx1 >= 0 && cy1 >= 0 && colour [cx1] [cy1] == 'x')
	    {
		select [cx1] [cy1] = 's';
		cx1--;
		cy1--;
	    }
	    if (cx1 >= 0 && cy1 >= 0 && colour [cx1] [cy1] != turn && colour [cx1] [cy1] != 'x')
		select [cx1] [cy1] = 's';

	    //SW-----------------------------
	    cx1 = x + 1;
	    cy1 = y - 1;
	    while (cx1 < row && cy1 >= 0 && colour [cx1] [cy1] == 'x')
	    {
		select [cx1] [cy1] = 's';
		cx1++;
		cy1--;
	    }
	    if (cx1 < row && cy1 >= 0 && colour [cx1] [cy1] != turn && colour [cx1] [cy1] != 'x')
		select [cx1] [cy1] = 's';


	}





	public void selectQueen (int x, int y)
	{
	    selectBishop (x, y);
	    selectRook (x, y);
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
		cdLayout.show (p_card, "6");
	    else if (e.getActionCommand ().equals ("s7"))
		cdLayout.show (p_card, "7");
	    else if (e.getActionCommand ().equals ("s8"))
		System.exit (0);
	    else if (e.getActionCommand ().equals ("wsurndr"))
		cdLayout.show (p_card, "6");
	    else if (e.getActionCommand ().equals ("bsurndr"))
		cdLayout.show (p_card, "7");
	    else if (e.getActionCommand ().equals ("resetbtn"))
		reset ();
	    else
	    { //code to handle the game
		int n = Integer.parseInt (e.getActionCommand ());
		int x = n / col;
		int y = n % col;
		showStatus ("(" + x + ", " + y + ")");

		if (turn != colour [x] [y] && last == -1)
		    showStatus ("It is not your move...");
		else if (last == -1 && turn == colour [x] [y])
		{
		    if (piece [x] [y] == 'p')
			selectPawn (x, y);
		    else if (piece [x] [y] == 'k')
			selectKing (x, y);
		    else if (piece [x] [y] == 'n')
			selectKnight (x, y);
		    else if (piece [x] [y] == 'r')
			selectRook (x, y);
		    else if (piece [x] [y] == 'b')
			selectBishop (x, y);
		    else if (piece [x] [y] == 'q')
			selectQueen (x, y);


		    last = n;
		}
		else
		{
		    int lastx = last / col;
		    int lasty = last % col;
		    //move
		    if (select [x] [y] == 's')
		    {
			//move
			piece [x] [y] = piece [lastx] [lasty];
			piece [lastx] [lasty] = 'x';
			colour [x] [y] = colour [lastx] [lasty];
			colour [lastx] [lasty] = 'x';
			//switch turn
			if (turn == 'b')
			{
			    turn = 'w';
			    turnpic.setIcon (createImageIcon ("kwbu.png"));
			}
			else
			{
			    turn = 'b';
			    turnpic.setIcon (createImageIcon ("kbbu.png"));
			}

		    } //move done

		    //reset select
		    for (int i = 0 ; i < row ; i++)
		    {
			for (int j = 0 ; j < col ; j++)
			{
			    select [i] [j] = 'u';
			}
		    }
		    last = -1;
		}
		{
		    if (piece [x] [y] == 'p')
			showStatus ("pawn selected...");
		    else if (piece [x] [y] == 'k')
			showStatus ("King selected...");
		    else if (piece [x] [y] == 'n')
			showStatus ("Knight selected...");
		    else if (piece [x] [y] == 'r')
			showStatus ("Rook selected...");
		    else if (piece [x] [y] == 'b')
			showStatus ("bishop selected...");
		    else if (piece [x] [y] == 'q')
			showStatus ("Queen selected...");

		}


	    }
	    redraw ();
	}
    }


