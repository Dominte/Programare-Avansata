import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("Van Gogh's canvas");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        configPanel=new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);

        add(canvas, BorderLayout.CENTER);
        add(controlPanel,BorderLayout.SOUTH);
        add(configPanel,BorderLayout.NORTH);

        pack();
    }

}
