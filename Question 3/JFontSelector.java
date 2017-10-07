import javafx.scene.text.Font;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JFontSelector extends JFrame {
    Random random = new Random();
    JLabel outputTextLabel = new JLabel("Some text");
    final int bigFontSize = 25;
    final int smallFontSize = 12;
    public JFontSelector(){
        super("Font selector");
        setSize(new Dimension(400,200));
        setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        List<String> fonts = Font.getFamilies();
        ArrayList<JButton> buttons = new ArrayList<>();

        for(int i = 0; i < 5; ++i){
            int fontIndex = random.nextInt(fonts.size());

            while (buttonExists(fonts.get(fontIndex), buttons)){
                fontIndex = random.nextInt(fonts.size());
            }
            JButton newButton = new JButton(fonts.get(fontIndex));
            java.awt.Font buttonFont = new java.awt.Font(newButton.getText(), java.awt.Font.BOLD,smallFontSize);
            newButton.setFont(buttonFont);
            newButton.addActionListener((actionEvent) -> {outputTextLabel.setFont(buttonFont);});
            buttons.add(newButton);
            add(newButton);
        }

        JButton sizeChangeButton = new JButton("Change font size");
        sizeChangeButton.addActionListener((actionEvent) -> {
            java.awt.Font font = outputTextLabel.getFont();
            int newSize = 0;
            if(font.getSize() == smallFontSize){
                newSize = bigFontSize;
            }else {
                newSize = smallFontSize;
            }
            java.awt.Font newFont = new java.awt.Font(font.getFamily(), font.getStyle(),newSize);
            outputTextLabel.setFont(newFont);
        });
        add(sizeChangeButton);

        add(outputTextLabel);
        setVisible(true);
    }

    public boolean buttonExists(String buttonString, ArrayList<JButton> buttonList){
        for(JButton button:buttonList){
            if(button.getText().equals(buttonString)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        new JFontSelector();
    }
}
