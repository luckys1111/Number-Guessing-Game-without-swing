import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class f extends Frame implements ActionListener {
	Label l1;
	TextField t1;
	Button b1, b2;
	int tryCount = 0;
	Random rand = new Random();
	int randomNumber = 1+rand.nextInt(100);
	public f() {
		setTitle("Number Guessing Game");
		setLayout(null);
		setVisible(true);
		l1 = new Label("Guess Number (1-100):");
		t1 = new TextField();
		b1 = new Button("Guess");
		b1.setBackground(Color.BLUE);
	    b1.setForeground(Color.WHITE);

		b2 = new Button();
		b2.setLabel("New Game");
		b2.setBackground(Color.RED);
	    b2.setForeground(Color.WHITE);

		l1.setBounds(20, 50, 230, 30);

		t1.setBounds(130, 100, 150, 30);

		b1.setBounds(100, 150, 80, 30);

		b2.setBounds(215, 150, 80, 30);

		add(l1);
		add(t1);
		add(b1);
		add(b2);
		setSize(400, 300);
		b1.addActionListener(this);
		b2.addActionListener(this);
	    this.addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
	}

	public void actionPerformed(ActionEvent e) {
		String s1 = t1.getText();
		int playerGuess = Integer.parseInt(s1);
		if (e.getSource() == b1) {
			while (true) {

				tryCount++;

				if ( randomNumber==playerGuess) {
					System.out.println("Correct! You Win!");
					System.out.println("It took you " + tryCount + " tries");
					break;
				} else if (randomNumber < playerGuess) {
					System.out.println("Nope! The number is higher. Guess again.");
					break;
				} else {
					System.out.println("Nope! The number is lower. Guess again.");
					break;
				}
			}

		}
		if (e.getSource() == b2) {
			//Random rand = new Random();
			randomNumber = rand.nextInt(100) + 1;
			t1.setText("");

		}
	}

}

class GuessNumber{
	public static void main(String[] args) {
		f kit = new f();

	}
}