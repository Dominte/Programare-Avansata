import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
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
    JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    
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
            fileChooser.setDialogTitle("Load image ");
            fileChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and JPG images", "png", "jpg");
            fileChooser.addChoosableFileFilter(filter);

            int value = fileChooser.showOpenDialog(null);

            if (value == JFileChooser.APPROVE_OPTION) {

                File file = fileChooser.getSelectedFile();
                frame.canvas.image = ImageIO.read(file);
                frame.canvas.graphics = frame.canvas.image.createGraphics();
                frame.repaint();
            }

            }catch(IOException ex){
            System.err.println(ex);
        }
    }

    private void save(ActionEvent actionEvent) {
        try {
            fileChooser.setDialogTitle("Select an image");
            fileChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and JPG images", "png", "jpg");
            fileChooser.addChoosableFileFilter(filter);
            int value = fileChooser.showOpenDialog(null);
            if(value == JFileChooser.APPROVE_OPTION) {
                ImageIO.write(frame.canvas.image, "JPG", new File(fileChooser.getSelectedFile().getPath()));
                frame.repaint();
            }
        } catch (IOException ex) { System.err.println(ex); }
    }

}
