import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanGUI extends JFrame implements ActionListener {
    private JTextField textField;
    private JLabel wordLabel;
    private String word;
    private StringBuilder guessedWord;
    private int guessesLeft;

    public HangmanGUI() {
        setTitle("HANGMAN");
        setSize(400, 200);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        guessedWord = new StringBuilder();
        guessesLeft = 6;

        JPanel panel = new JPanel();
        panel.setOpaque(false);

        panel.setLayout(new GridLayout(4, 2));

        wordLabel = new JLabel("Word: ");
        panel.add(wordLabel);

        textField = new JTextField();
        textField.addActionListener(this);
        panel.add(textField);

        add(panel);
        setVisible(true);

        startGame();
    }

    private void startGame() {
        word = JOptionPane.showInputDialog("Enter a word: ");
        word = word.toLowerCase();
        while (!isValidInput(word)) {
            word = JOptionPane.showInputDialog("Invalid input! Enter a word");
            word = word.toLowerCase();
        }
        guessedWord.setLength(0);
        guessesLeft = 6;

        for (int i = 0; i < word.length(); i++) {
            if (Character.isLetter(word.charAt(i))) {
                guessedWord.append("_");
            } else {
                guessedWord.append(word.charAt(i));
            }
        }
        updateWordLabel();
    }

    private void updateWordLabel() {
        wordLabel.setText("Word: " + guessedWord.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String guess = textField.getText().toLowerCase();
        textField.setText("");
        if (guess.length() != 1 || !Character.isLetter(guess.charAt(0))) {
            JOptionPane.showMessageDialog(this, "Please enter a single letter", "invalid guess",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        char letter = guess.charAt(0);
        if (word.contains(Character.toString(letter))) {
            JOptionPane.showMessageDialog(this, "Character " + letter + " exists in the word");
            updateGuessedWord(letter);

            if (!guessedWord.toString().contains("_")) {

                JOptionPane.showMessageDialog(this, "Congratulations!, You guessed the word " + word);
                startGame();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Character " + letter + " does not exist in the word");
            guessesLeft--;
            if (guessesLeft == 0) {
                JOptionPane.showMessageDialog(this, "Sorry you're out of moves, word:" + word);
                startGame();
            }
        }
        updateWordLabel();
    }

    private void updateGuessedWord(char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.toLowerCase(word.charAt(i)) == letter) {
                guessedWord.setCharAt(i, letter);
            }
        }
    }

    private boolean isValidInput(String word) {
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (!Character.isLetter(letter) || letter == ' ') {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HangmanGUI());

    }
}
