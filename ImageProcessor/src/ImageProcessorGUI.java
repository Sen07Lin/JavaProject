import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import edu.gatech.cs1331.image.ImageProcessor;
import edu.gatech.cs1331.image.Pic;
/**
 * This class defines ImageProcessorGUI and extends JFrame class.
 * @author Sen Lin
 * @version 1.0
 *
 */
public class ImageProcessorGUI extends JFrame {
    /**
     * instance of ImageProcessorGUI class.
     */
    private ImageProcessor image;
    /**
     * instance of Pic class.
     */
    private Pic bufferImage;
    /**
     * instance of JLabel class.
     */
    private JLabel imaLabel = new JLabel();
    /**
     * This is the constructor for ImageProcessorGUI.
     * It sets the layout and JMenuBar, and adds JPanel
     */
    public ImageProcessorGUI() {
        super("Image Processor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(new FlowLayout());
        add(createJpanel());
        JMenuBar menuBar = createJMenuBar();
        setJMenuBar(menuBar);
    }
    /**
     * helper class to create an instance of JPanel.
     * @return return an instance of JPanel
     */
    private JPanel createJpanel() {
        JPanel imgJPanel = new JPanel();
        imgJPanel.add(imaLabel);
        return imgJPanel;
    }
    /**
     * helper class to create an instance of JMenuBar.
     * @return return an instance of JMenuBar
     */
    private JMenuBar createJMenuBar() {
        JMenuItem noChangeMeItem = new JMenuItem("No Change");
        JMenuItem grayScaleMeItem = new JMenuItem("Grayscale");
        JMenuItem invertMeItem = new JMenuItem("Invert");
        JMenuItem redMeItem = new JMenuItem("Only Red");
        JMenuItem greenMeItem = new JMenuItem("Only Green");
        JMenuItem blueMeItem = new JMenuItem("Only Blue");
        JMenuItem pMeItem = new JMenuItem("Posterize");
        JMenuItem overlayMeItem = new JMenuItem("Overlay");
        JMenuItem openMeItem = new JMenuItem("Open");
        JMenuItem saveMeItem = new JMenuItem("Save As...");
        openMeItem.addActionListener(new ActionListener() {
            /**
             * The method for the anonymous inner class of 'OpenListener'.
             * @param e ActionEvent type, give the direction to the listener
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int x = chooser.showOpenDialog(null);
                if (x == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    try {
                        image = new ImageProcessor(file);
                        bufferImage = image.noChange();
                        imaLabel.setIcon(new ImageIcon(bufferImage.getImage()));
                        pack();
                    } catch (NullPointerException e3) {
                        JOptionPane.showMessageDialog(null, "Error open file",
                                "Error", 3);
                    }
                }
            }
        });
        saveMeItem.addActionListener(new ActionListener() {
            /**
             * The method for the anonymous inner class of 'SaveListener'.
             * @param e ActionEvent type, give the direction to the listener
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int x = chooser.showSaveDialog(null);
                if (x == JFileChooser.APPROVE_OPTION) {
                    File outputfile = chooser.getSelectedFile();
                    try {
                        ImageIO.write(bufferImage.getImage(),
                                "png", outputfile);
                    } catch (IOException e1) {
                        System.out.println("IOException Error when save");
                    }
                }
            }
        });
        noChangeMeItem.addActionListener(new ActionListener() {
            /**
             * The method for the anonymous inner class of 'NoChangeListener'.
             * @param e ActionEvent type, give the direction to the listener
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                bufferImage = image.noChange();
                ImageIcon icon = new ImageIcon(bufferImage.getImage());
                imaLabel.setIcon(icon);
            }
        });
        grayScaleMeItem.addActionListener(new ActionListener() {
            /**
             * The method for the anonymous inner class of 'GrayScaleListener'.
             * @param e ActionEvent type, give the direction to the listener
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                bufferImage = image.grayscale();
                imaLabel.setIcon(new ImageIcon(bufferImage.getImage()));
            }
        });
        invertMeItem.addActionListener(new ActionListener() {
            /**
             * The method for the anonymous inner class of 'InvertListener'.
             * @param e ActionEvent type, give the direction to the listener
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                bufferImage = image.invert();
                imaLabel.setIcon(new ImageIcon(bufferImage.getImage()));
            }
        });
        redMeItem.addActionListener(new ActionListener() {
            /**
             * The method for the anonymous inner class of 'RedListener'.
             * @param e ActionEvent type, give the direction to the listener
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                bufferImage = image.onlyRed();
                imaLabel.setIcon(new ImageIcon(bufferImage.getImage()));
            }
        });
        greenMeItem.addActionListener(new ActionListener() {
            /**
             * The method for the anonymous inner class of 'GreenListener'.
             * @param e ActionEvent type, give the direction to the listener
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                bufferImage = image.onlyGreen();
                imaLabel.setIcon(new ImageIcon(bufferImage.getImage()));
            }
        });
        blueMeItem.addActionListener(new ActionListener() {
            /**
             * The method for the anonymous inner class of 'BlueListener'.
             * @param e ActionEvent type, give the direction to the listener
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                bufferImage = image.onlyBlue();
                imaLabel.setIcon(new ImageIcon(bufferImage.getImage()));
            }
        });
        pMeItem.addActionListener(new ActionListener() {
            /**
             * The method for the anonymous inner class of 'PosterizeListener'.
             * @param e ActionEvent type, give the direction to the listener
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                bufferImage = image.posterize();
                imaLabel.setIcon(new ImageIcon(bufferImage.getImage()));
            }
        });
        overlayMeItem.addActionListener(new ActionListener() {
            /**
             * The method for the anonymous inner class of 'OverlayListener'.
             * @param e ActionEvent type, give the direction to the listener
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int x = chooser.showOpenDialog(null);
                if (x == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    try {
                        bufferImage = image.overlay(file);
                        imaLabel.setIcon(new ImageIcon(bufferImage.getImage()));
                    } catch (NullPointerException e2) {
                        JOptionPane.showMessageDialog(null, "Error open file",
                                "Error", 3);
                    }
                }
            }
        });
        JMenu edit = new JMenu("Edit");
        JMenu file = new JMenu("File");
        edit.add(noChangeMeItem);
        edit.add(grayScaleMeItem);
        edit.add(invertMeItem);
        edit.add(redMeItem);
        edit.add(greenMeItem);
        edit.add(blueMeItem);
        edit.add(pMeItem);
        edit.add(overlayMeItem);
        file.add(openMeItem);
        file.add(saveMeItem);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(file);
        menuBar.add(edit);
        return menuBar;
    }
    /**
     * The main method.
     */
    public static void main(String[] args) {
        ImageProcessorGUI ip = new ImageProcessorGUI();
        ip.pack();
        ip.setVisible(true);
    }
}
