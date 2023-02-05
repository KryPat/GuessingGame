import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GuessingGame extends JFrame {
    private final JTextField txtGuess;
    private final JLabel lblOutput;
    private int theNumber;
    private int numberOfTries = 1;
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
                newGame();
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
        txtGuess.setBounds(313, 89, 26, 20);
        getContentPane().add(txtGuess);
        txtGuess.setColumns(10);

        JButton btnNewButton = new JButton("Guess!");
        btnNewButton.addActionListener(e -> checkGuess());
        txtGuess.addActionListener(e -> checkGuess());
        btnNewButton.setBounds(172, 145, 89, 23);
        getContentPane().add(btnNewButton);

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
