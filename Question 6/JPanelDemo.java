import javax.swing.*;
import java.awt.*;

public class JPanelDemo extends JFrame {
    public JPanelDemo(){
        super("Hi");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,2));

        JFlexiblePanel panel1 = new JFlexiblePanel(Color.BLUE,Color.ORANGE,Font.getFont("Arial"),"HI");
        JFlexiblePanel panel2 = new JFlexiblePanel(Color.PINK,Color.BLUE,Font.getFont("Arial"),"Bye");
        JFlexiblePanel panel3 = new JFlexiblePanel(Color.magenta,Color.cyan,Font.getFont("Arial"),"Heylon");
        JFlexiblePanel panel4 = new JFlexiblePanel(Color.red,Color.green,Font.getFont("Arial"),"White");
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);

        setSize(new Dimension(250,150));
        setVisible(true);
    }

    public static void main(String[] args){
        new JPanelDemo();
    }
}
