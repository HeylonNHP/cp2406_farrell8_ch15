import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jc300556 on 4/10/17.
 */
public class JVowelConsonant extends JFrame implements ActionListener{
    Random randomGenerator = new Random();
    JButton[] buttons = new JButton[26];

    JPanel panel1 = new JPanel(new FlowLayout());
    JPanel panel2 = new JPanel(new FlowLayout());
    JPanel panel3 = new JPanel(new FlowLayout());

    JLabel label1 = new JLabel("Some label");

    public JVowelConsonant(){
        super("Educational program");
        generateButtons();
        setLayout(new GridLayout(2,2));
        setSize(new Dimension(350,350));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(panel1);
        add(panel2);
        add(panel3);

        panel3.add(label1);

        randomlyPlaceButtons();
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        ArrayList<JButton> currentlyDisplayedButtons = new ArrayList<JButton>();
        for(Component button: panel1.getComponents()){
            currentlyDisplayedButtons.add((JButton) button);
        }

        for(Component button: panel2.getComponents()){
            currentlyDisplayedButtons.add((JButton) button);
        }

        int randomButtonIndex = randomGenerator.nextInt(buttons.length);
        while (currentlyDisplayedButtons.contains(buttons[randomButtonIndex])){
            randomButtonIndex = randomGenerator.nextInt(buttons.length);
        }

        JButton newButtonToDisplay = buttons[randomButtonIndex];
        JButton thisButton = (JButton) e.getSource();

        System.out.println(String.format("Clicked: %s", thisButton.getText()));

        //Replace the button that was just clicked by the user
        int panelNum = -1;

        boolean found = false;

        if(!found){
            for(Component button: panel1.getComponents()){
                if(button == thisButton){
                    found = true;
                }
            }
            panel1.remove(thisButton);
            panel1.add(newButtonToDisplay);
        }

        if(!found){
            for(Component button: panel2.getComponents()){
                if(button == thisButton){
                    found = true;
                }
            }
            panel2.remove(thisButton);
            panel2.add(newButtonToDisplay);
        }

        //Set label
        String letter = thisButton.getText();
        if(letter.equals("A") || letter.equals("E") || letter.equals("I") || letter.equals("O") || letter.equals("U")){
            label1.setText("Vowel");
        }else {
            label1.setText("Consonant");
        }

        invalidate();
        validate();
        repaint();
    }

    private void generateButtons(){
        for(int i = 0; i < buttons.length; ++i){
            char buttonChar = (char)(i+65);
            buttons[i] = new JButton(String.valueOf(buttonChar));
            buttons[i].addActionListener(this);
        }
    }

    private void randomlyPlaceButtons(){
        ArrayList<JButton> selectedButtons = new ArrayList<>();

        for(int i = 0; i < 8; ++i){
            int randomButtonIndex = randomGenerator.nextInt(buttons.length);
            while (selectedButtons.contains(buttons[randomButtonIndex])){
                randomButtonIndex = randomGenerator.nextInt(buttons.length);
            }
            selectedButtons.add(buttons[randomButtonIndex]);
        }

        //Add four buttons to panel1
        for(int i = 0; i < 4; ++i){
            panel1.add(selectedButtons.get(i));
        }

        //Add four buttons to panel2
        for(int i = 4; i < 8; ++i){
            panel2.add(selectedButtons.get(i));
        }
    }

    public static void main(String[] args){
        new JVowelConsonant();
    }
}
