/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package medframe;

import java.io.IOException;
import java.util.logging.LogManager;

import medframe.view.CreateFrame;

/**
 * @author Julia
 */
public class MedFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//         try {
//            LogManager.getLogManager().readConfiguration(
//                    MedFrame.class.getResourceAsStream("/logging.properties"));
//        } catch (IOException e) {
//            System.err.println("Could not setup logger configuration: " + e.toString());
//        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateFrame().setVisible(true);
            }
        });
    }
}
