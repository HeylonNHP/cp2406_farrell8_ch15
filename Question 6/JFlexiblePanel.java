import javax.swing.*;
import java.awt.*;

public class JFlexiblePanel extends JPanel{
    public JFlexiblePanel(Color bg, Color fg, Font font, String text){
        super(new FlowLayout());
        setBackground(bg);
        setForeground(fg);
        setFont(font);
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(fg);
        add(label);
    }
}
