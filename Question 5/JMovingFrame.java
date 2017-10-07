import javax.swing.*;
import java.awt.*;

public class JMovingFrame extends JFrame {
    public JMovingFrame(){
        super("Moving stuff");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel panel1 = new JPanel(new FlowLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        Dimension panelSize = new Dimension(150, 120);
        Color bgColour = Color.ORANGE;
        panel1.setPreferredSize(panelSize);
        panel1.setBackground(bgColour);
        panel2.setPreferredSize(panelSize);
        panel2.setBackground(bgColour);


        add(panel1);
        add(panel2);

        JLabel label1 = new JLabel("Hi");
        panel1.add(label1);

        JButton button1 = new JButton("Move the label");

        button1.addActionListener((actionEvent) -> {
            boolean moved = false;
            for(Component label:panel1.getComponents()){
                if(label == label1){
                    System.out.println("Found it");
                    panel1.remove(label1);
                    panel2.add(label1);
                    moved = true;
                }
            }
            if(!moved){
                for(Component label:panel2.getComponents()){
                    if(label == label1){
                        panel2.remove(label1);
                        panel1.add(label1);
                    }
                }
            }
            invalidate();
            validate();
            repaint();
        });
        add(button1);

        setVisible(true);
        pack();
    }

    public static void main(String[] whateverMan){
        new JMovingFrame();
    }
}
