import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessingGame extends JFrame {
    private final JTextField txtGuess;
    private final JLabel lblOutput;
    JButton btnPlayAgain;
    private int theNumber;
    private int numberOfTries = 1;
    JButton btnNewButton;



    public void checkGuess() {
        String guessText = txtGuess.getText();
        String message = "";
        try {
            int guess = Integer.parseInt(guessText);
            if (guess < theNumber) {
                message = guess + " is too low. Try again.";
                numberOfTries += 1;
            }
            else if (guess > theNumber) {
                message = guess + " is too high. Try again.";
                numberOfTries += 1;
            }
            else {
                message = guess + " is correct. You win after: " + numberOfTries + " tries!" + " Let's play again!";
                //newGame();
                btnPlayAgain.setVisible(true);
                btnNewButton.setBounds(85, 145, 89, 23);
            }
        }   catch (Exception e) {
            message = "Enter a whole number between 1 and 100, and try again.";
    } finally {
            lblOutput.setText(message);
            txtGuess.requestFocus();
            txtGuess.selectAll();
        }
    }
    public void newGame() {
        theNumber = (int)(Math.random() * 100 + 1);
        lblOutput.setText("Enter a number above and click Guess!");
        //message = "Guess a number between 1 and 100:";
        numberOfTries = 1;
        btnPlayAgain.setVisible(false);
        btnNewButton.setBounds(172, 145, 89, 23);

    }
    public GuessingGame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hi-Lo Guessing Game");
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Hi-Lo Guessing Game");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 39, 414, 14);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100:");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1.setBounds(10, 92, 298, 14);
        getContentPane().add(lblNewLabel_1);

        txtGuess = new JTextField();
        txtGuess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        txtGuess.setBounds(313, 89, 26, 20);
        getContentPane().add(txtGuess);
        txtGuess.setColumns(10);

        btnNewButton = new JButton("Guess!");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        //txtGuess.addActionListener(e -> checkGuess());
        btnNewButton.setBounds(172, 145, 89, 23);
        getContentPane().add(btnNewButton);

        btnPlayAgain = new JButton("Play Again");
        btnPlayAgain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newGame();
            }
        });
        btnPlayAgain.setBounds(259, 145, 95, 23);
        getContentPane().add(btnPlayAgain);
        /*

        JButton btnPlayAgain = new JButton("New game");
        btnPlayAgain.setVisible(false);
        btnPlayAgain.addActionListener(e -> newGame());
        btnPlayAgain.setBounds(259, 145, 89, 23);
        getContentPane().add(btnPlayAgain);

         */

        lblOutput = new JLabel("Enter a number above and click Guess!");
        lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
        lblOutput.setBounds(10, 207, 414, 14);
        getContentPane().add(lblOutput);

    }

    public static void main(String[] args) {
        GuessingGame theGame = new GuessingGame();
        theGame.newGame();
        theGame.setSize(new Dimension(450,300));
        theGame.setVisible(true);
    }
}
