import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame){
        this.frame=frame;
        init();
    }

    private void init(){
        setLayout(new GridLayout(1, 4));

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void exit(ActionEvent actionEvent) {
        frame.dispose();
    }

    private void reset(ActionEvent actionEvent) {
            frame.canvas.graphics.setColor(Color.LIGHT_GRAY); //backgrund-ul
            frame.canvas.graphics.fillRect(0, 0, frame.canvas.W, frame.canvas.H);
            frame.repaint();
    }

    private void load(ActionEvent actionEvent) {
        try {
            File file = new File("h:/test.jpg");
            frame.canvas.image=ImageIO.read(file);
            frame.canvas.graphics = frame.canvas.image.createGraphics();
            frame.repaint();
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void save(ActionEvent actionEvent) {
        try {
            ImageIO.write(frame.canvas.image, "JPG", new File("h:/test.jpg"));
            frame.repaint();
        } catch (IOException ex) { System.err.println(ex); }
    }

}
