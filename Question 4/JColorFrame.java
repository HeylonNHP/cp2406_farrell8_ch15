import javax.swing.*;
import java.awt.*;

public class JColorFrame extends JFrame {
    public JColorFrame(){
        super("Yay, colours!");
        setSize(new Dimension(300,300));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BorderLayout newLayout = new BorderLayout();
        setLayout(newLayout);



        JButton actionButton = new JButton("Make magic happen");
        add(actionButton, BorderLayout.CENTER);
        actionButton.getParent().setBackground(Color.GREEN);
        remove(actionButton);

        add(new JLabel("Test"), BorderLayout.NORTH);

        /*IMPOSSIBRU!!!!!!!!!!111*/

        setVisible(true);
    }

    public static void main(String[] stuff){
        new JColorFrame();
    }
}
