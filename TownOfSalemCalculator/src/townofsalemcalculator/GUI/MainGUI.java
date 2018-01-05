package townofsalemcalculator.GUI;

import javax.swing.JFrame;

/**
 * The Main GUI determines what happens with the GUI
 * @author Multifacio
 * @version 1.0
 * @since 2018-1-5
 */
public class MainGUI {
    private static MainGUI instance = null;
    private JFrame currentFrame;
    
    private MainGUI() {
        class Multithread implements Runnable {
            @Override
            public void run() {
                currentFrame = new StartFrame();
                currentFrame.setVisible(true);
            } 
        }
        //Create the Start Frame with multithreading
        Multithread mt = new Multithread();
        Thread t = new Thread(mt);
        t.start();
    }
    
    /**
     * Get the only instance of Main GUI
     * @return The only instance of Main GUI
     */
    public static MainGUI getInstance() {
        if (instance == null) {
            instance = new MainGUI();
        }
        return instance;
    }
}
