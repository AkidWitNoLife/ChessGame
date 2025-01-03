import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;

public class roughchess extends Applet implements ActionListener {
    private static final int ROWS = 8;
    private static final int COLS = 8;

    private Panel p_card;
    private CardLayout cdLayout = new CardLayout();
    private JButton[] squares = new JButton[ROWS * COLS];
    private char[][] piece = {
	{'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'}, 
	{'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
	{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, 
	{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, 
	{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	{'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'}, 
	{'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'}
    };

    private JLabel turnpic;
    private char turn = 'w';
    private int last = -1;

    
    public void init() {
	p_card = new Panel();
	p_card.setLayout(cdLayout);
	setupGameScreen();
	resize(580, 650);
	setLayout(new BorderLayout());
	add("Center", p_card);
    }

    private void setupGameScreen() {
	Panel gamePanel = new Panel();
	gamePanel.setBackground(Color.WHITE);

	// Add control buttons
	JButton wSurnderButton = createButton("White Concede", "wsurndr", Color.WHITE, Color.BLACK);
	JButton bSurnderButton = createButton("Black Concede", "bsurndr", Color.BLACK, Color.WHITE);
	JButton resetButton = createButton("Reset", "resetbtn", Color.BLACK, Color.WHITE);

	turnpic = new JLabel(createImageIcon("kwbu.png"));
	gamePanel.add(turnpic);

	// Set up the chess board
	Panel boardPanel = new Panel(new GridLayout(ROWS, COLS));
	for (int i = 0; i < ROWS * COLS; i++) {
	    squares[i] = new JButton();
	    squares[i].setPreferredSize(new Dimension(64, 64));
	    squares[i].addActionListener(this);
	    squares[i].setActionCommand(String.valueOf(i));
	    boardPanel.add(squares[i]);
	}
	gamePanel.add(boardPanel);

	// Add game controls
	gamePanel.add(wSurnderButton);
	gamePanel.add(bSurnderButton);
	gamePanel.add(resetButton);

	p_card.add("game", gamePanel);
	cdLayout.show(p_card, "game");
    }

    private JButton createButton(String text, String actionCommand, Color bg, Color fg) {
	JButton button = new JButton(text);
	button.setBackground(bg);
	button.setForeground(fg);
	button.setActionCommand(actionCommand);
	button.addActionListener(this);
	return button;
    }

    private ImageIcon createImageIcon(String path) {
	java.net.URL imgURL = FinalGame_Chess.class.getResource(path);
	if (imgURL != null) {
	    return new ImageIcon(imgURL);
	} else {
	    System.err.println("Couldn't find file: " + path);
	    return null;
	}
    }

    private void redraw() {
	for (int i = 0; i < ROWS * COLS; i++) {
	    int x = i / COLS;
	    int y = i % COLS;
	    String imagePath = String.valueOf(piece[x][y]) + ".png";
	    squares[i].setIcon(createImageIcon(imagePath));
	}
    }

    private void resetGame() {
	piece = new char[][] {
	    {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'}, 
	    {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, 
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, 
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'}, 
	    {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'}
	};
	turn = 'w';
	last = -1;
	redraw();
    }

    
    public void actionPerformed(ActionEvent e) {
	String command = e.getActionCommand();

	if ("resetbtn".equals(command)) {
	    resetGame();
	    return;
	}

	int index = Integer.parseInt(command);
	int x = index / COLS;
	int y = index % COLS;

	if (last == -1) {
	    // Select a piece to move
	    if (Character.isUpperCase(piece[x][y]) && turn == 'w' || Character.isLowerCase(piece[x][y]) && turn == 'b') {
		last = index;
		highlightMoves(x, y);
	    }
	} else {
	    // Move the piece
	    int lastX = last / COLS;
	    int lastY = last % COLS;
	    if (isValidMove(lastX, lastY, x, y)) {
		movePiece(lastX, lastY, x, y);
		switchTurn();
	    }
	    last = -1;
	    clearHighlights();
	}

	redraw();
    }

    private void highlightMoves(int x, int y) {
	// Implement move highlighting logic
    }

    private void clearHighlights() {
	// Implement highlight clearing logic
    }

    private boolean isValidMove(int fromX, int fromY, int toX, int toY) {
	// Implement move validation logic
	return true; // Placeholder
    }

    private void movePiece(int fromX, int fromY, int toX, int toY) {
	piece[toX][toY] = piece[fromX][fromY];
	piece[fromX][fromY] = 'x';
    }

    private void switchTurn() {
	turn = (turn == 'w') ? 'b' : 'w';
	String turnImage = (turn == 'w') ? "kwbu.png" : "kbbu.png";
	turnpic.setIcon(createImageIcon(turnImage));
    }
}
