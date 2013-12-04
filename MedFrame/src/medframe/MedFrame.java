/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package medframe;

import medframe.view.CreateFrame;

/**
 *
 * @author Julia
 */
public class MedFrame
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new CreateFrame().setVisible(true);
            }
        });
    }
}
