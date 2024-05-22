# Hangman Game with GUI

This Hangman game is a graphical user interface (GUI) implementation in Java. It allows players to enter a word and guess characters one by one to reveal the hidden word. The GUI provides a user-friendly interface for an engaging gaming experience.

## Features

- **Interactive GUI**: The game is presented using Swing components, providing an intuitive interface for players to interact with.
- **Word Input**: Players can enter a word at the start of each game. The input word is case-insensitive and can contain alphabets only.
- **Visual Feedback**: The GUI displays the current state of the guessed word, informing players about their progress.
- **Error Handling**: The game validates player input, ensuring that only single alphabetic characters are accepted for guessing.
- **Game Over Handling**: When the player runs out of guesses, the game ends, and a new game can be started.

## How to Play

1. **Run the Program**: Compile and run the `HangmanGUI.java` file.
2. **Enter a Word**: At the start of each game, enter a word when prompted.
3. **Guess a Character**: Input a single letter into the text field and press Enter to guess.
4. **Outcome**: After each guess, the game provides feedback on whether the guessed character exists in the word or not. Keep guessing until you reveal the entire word or run out of guesses.

## Implementation Details

- **Swing Components**: The game uses Swing components such as JFrame, JLabel, and JTextField to create the GUI.
- **Event Handling**: ActionListeners are used to handle user input and trigger appropriate actions based on player interactions.
- **Word Validation**: Input validation ensures that only valid alphabetic characters are accepted for guessing.
- **Hangman Logic**: The game logic handles updating the guessed word, tracking incorrect guesses, and determining the game outcome.

## Note

- This version of Hangman doesn't limit the number of guesses explicitly but sets a default of 6 guesses. Players can start a new game after running out of guesses.
- Feel free to modify and expand upon this code to add more features, such as limiting the number of incorrect guesses, adding graphics for the Hangman figure, or implementing difficulty levels.
