/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package medframe.view;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import medframe.PropertyNames;
import medframe.SAXHandler;
import medframe.Storage;
import org.xml.sax.SAXException;
import user.Visit;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julia
 */
public class CreateFrame extends javax.swing.JFrame implements PropertyNames
{

    private Map properiesMap = new HashMap();
    private Storage storage;
    private Visit visit = new Visit();

    /**
     * Creates new form CreateFrame
     */
    public CreateFrame()
    {
        storage = new Storage();

        initComponents();
        initMyComponents();
    }

    private void initMyComponents()
    {
        dateChooser.setDate(new Date());

        jobComboBox.addItemListener(new ItemListener()
        {

            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    if (e.getItem().equals(PropertyNames.WORKING))
                    {
                        stressComboBox.setVisible(true);
                    }
                    else
                    {
                        stressComboBox.setVisible(false);
                    }
                }

            }
        });
        dreamComboBox.addItemListener(new ItemListener()
        {

            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    if (e.getItem().equals(DISBALANCE))
                    {
                        dreamDisbalanceBox.setVisible(true);
                    }
                    else
                    {
                        dreamDisbalanceBox.setVisible(false);
                    }
                }

            }
        });
        
        JCheckBox[] featuresList = new JCheckBox[2];
        featuresList[0] = new JCheckBox("One");
        featuresList[1] = new JCheckBox("two");
        
      //  dreamComboBox.add(this)


//        exportPatient.addMouseListener(new MouseListener()
//        {
//
//            @Override
//            public void mouseClicked(MouseEvent e)
//            {
//                File file = new File("c:\\test.xml");
//
//                System.out.println("exportPropertiesActionPerformed");
//                Visit visit = new Visit();
//                visit.setName(nameField.getText());
//                visit.setDate(new Date());     //TODO: update to dateChooser
//
//                //  properiesMap.put("name", nameField.getText());
//                //properiesMap.put("date", dateChooser.getDateFormatString());
//                storage.exportFile(file, visit);
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e)
//            {
//                //  throw new UnsupportedOperationException("Not supported yet.");
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e)
//            {
//                //   throw new UnsupportedOperationException("Not supported yet.");
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e)
//            {
//                //   throw new UnsupportedOperationException("Not supported yet.");
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e)
//            {
//                //   throw new UnsupportedOperationException("Not supported yet.");
//            }
//
//        });

        createForm.addMouseListener(new MouseListener()
        {

            @Override
            public void mouseClicked(MouseEvent e)
            {
                //      createPanel.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                // throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                //   throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                //   throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                //   throw new UnsupportedOperationException("Not supported yet.");
            }
        });

    }

    private void savePDF()
    {
        // Document document = new Document(PageSize.A4);
        populateVisit();
        String fileName = "C:\\ITextTest.pdf";
        File file = new File(fileName);
        storage.savePDF(file, visit);
    }

    private Visit populateVisit()
    {
      //  Map visitMap = new HashMap();
        visit.setName(nameField.getText());
        visit.setDate(dateChooser.getDate());

        return visit;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jButton1 = new javax.swing.JButton();
        jobComboBox = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        anamnesisLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        dreamLabel = new javax.swing.JLabel();
        cranicalNerveLabel = new javax.swing.JLabel();
        sensitivityLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        complaintsTextPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        reflexesLabel = new javax.swing.JLabel();
        gaitLabel = new javax.swing.JLabel();
        coordinationLabel = new javax.swing.JLabel();
        nervousLabel = new javax.swing.JLabel();
        diagnosisLabel = new javax.swing.JLabel();
        recommendationLabel = new javax.swing.JLabel();
        therapyLabel = new javax.swing.JLabel();
        professionField = new javax.swing.JTextField();
        stressComboBox = new javax.swing.JComboBox();
        dreamComboBox = new javax.swing.JComboBox();
        dreamDisbalanceBox = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        createForm = new javax.swing.JMenu();
        editProperties = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        exportItem = new javax.swing.JMenuItem();
        importItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 700));
        setPreferredSize(new java.awt.Dimension(800, 568));
        setResizable(false);

        jButton1.setText("Сохранить PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jobComboBox.setModel(new DefaultComboBoxModel(new String[] { PropertyNames.WORKING, PropertyNames.NOT_WORKING, PropertyNames.PENSIONER, PropertyNames.CRIPPLE }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        anamnesisLabel.setText(PropertyNames.ANAMNESIS);
        anamnesisLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel8.setText(PropertyNames.SOCIAL_ANAMNESIS);

        jLabel2.setText(PropertyNames.DATE);

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleLabel.setText(TITLE);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText(PropertyNames.COMPLAINE);

        jLabel1.setText(PropertyNames.EMOTION);

        dreamLabel.setText(PropertyNames.DREAM);

        cranicalNerveLabel.setText(PropertyNames.CRANIAL_NERVE);

        sensitivityLabel.setText(PropertyNames.SENSITIVITY);

        nameLabel.setText(PropertyNames.NAME);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout complaintsTextPanelLayout = new javax.swing.GroupLayout(complaintsTextPanel);
        complaintsTextPanel.setLayout(complaintsTextPanelLayout);
        complaintsTextPanelLayout.setHorizontalGroup(
            complaintsTextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complaintsTextPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 77, Short.MAX_VALUE))
        );
        complaintsTextPanelLayout.setVerticalGroup(
            complaintsTextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        reflexesLabel.setText(REFLEXES);

        gaitLabel.setText(GAIT);

        coordinationLabel.setText(COORDINATION);

        nervousLabel.setText(NERVOUS_SYSTEM);

        diagnosisLabel.setText(DIAGNOSIS);

        recommendationLabel.setText(RECOMMENDATIONS);

        therapyLabel.setText(THERAPY);

        professionField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                professionFieldActionPerformed(evt);
            }
        });

        stressComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {PropertyNames.EXERCISE_STRESS, PropertyNames.STATIC_LOAD}));

        dreamComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {NORM, DISBALANCE}));

        dreamDisbalanceBox.setVisible(false);

        jMenu1.setText(CATEGORY);

        jMenuItem1.setLabel("Другая категория");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        createForm.setText("Create Form");
        jMenuBar1.add(createForm);
        createForm.getAccessibleContext().setAccessibleName("Create form");

        editProperties.setText("Edit");
        jMenuBar1.add(editProperties);

        jMenu2.setText("Import/Export");

        exportItem.setText("Export");
        exportItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exportItemActionPerformed(evt);
            }
        });
        jMenu2.add(exportItem);

        importItem.setText("Import");
        jMenu2.add(importItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(complaintsTextPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(therapyLabel)
                    .addComponent(coordinationLabel)
                    .addComponent(nervousLabel)
                    .addComponent(diagnosisLabel)
                    .addComponent(recommendationLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(dreamLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(dreamComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jobComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anamnesisLabel)
                            .addComponent(cranicalNerveLabel)
                            .addComponent(sensitivityLabel)
                            .addComponent(reflexesLabel)
                            .addComponent(gaitLabel))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(professionField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(dreamDisbalanceBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(20, 20, 20)
                        .addComponent(stressComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(461, 461, 461))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(complaintsTextPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jobComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(professionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stressComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(anamnesisLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dreamLabel)
                    .addComponent(dreamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dreamDisbalanceBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cranicalNerveLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sensitivityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reflexesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gaitLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coordinationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nervousLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(diagnosisLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recommendationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(therapyLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void savePDFMenuSelected(javax.swing.event.MenuEvent evt)//GEN-FIRST:event_savePDFMenuSelected
    {//GEN-HEADEREND:event_savePDFMenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_savePDFMenuSelected

    private void savePDFActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_savePDFActionPerformed
    {//GEN-HEADEREND:event_savePDFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_savePDFActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        savePDF();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void professionFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_professionFieldActionPerformed
    {//GEN-HEADEREND:event_professionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_professionFieldActionPerformed

  /* private void exportPropertiesActionPerformed(java.awt.event.ActionEvent evt)                                                 
    {                                                     
        System.out.println("exportPropertiesActionPerformed");
        //  properiesMap.put("name", nameField.getText());
        //properiesMap.put("date", dateChooser.getDateFormatString());
        //    Storage s = new Storage();
        File file = new File("C:\\doc.xml");
        storage.exportFile(file, visit);
    }                                                 
	*/

    private void exportItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exportItemActionPerformed
    {//GEN-HEADEREND:event_exportItemActionPerformed
        File file = new File("c:\\test.xml");

        System.out.println("exportItemActionPerformed");
      //  Visit visit = new Visit();
    //    visit.setName(nameField.getText());
      //  visit.setDate(new Date());     //TODO: update to dateChooser

        populateVisit();
        storage.exportFile(file, visit);
    }//GEN-LAST:event_exportItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem1ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem1ActionPerformed
     //   jTextArea1.setVisible(false);
        
        JPanel otherPanel = new complaintsJPanel();
        complaintsTextPanel.remove(jTextArea1);
        complaintsTextPanel.add(otherPanel);
        complaintsTextPanel.revalidate();
      //  complaintsTextPanel.repaint();
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anamnesisLabel;
    private javax.swing.JPanel complaintsTextPanel;
    private javax.swing.JLabel coordinationLabel;
    private javax.swing.JLabel cranicalNerveLabel;
    private javax.swing.JMenu createForm;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel diagnosisLabel;
    private javax.swing.JComboBox dreamComboBox;
    private javax.swing.JComboBox dreamDisbalanceBox;
    private javax.swing.JLabel dreamLabel;
    private javax.swing.JMenu editProperties;
    private javax.swing.JMenuItem exportItem;
    private javax.swing.JLabel gaitLabel;
    private javax.swing.JMenuItem importItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox jobComboBox;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nervousLabel;
    private javax.swing.JTextField professionField;
    private javax.swing.JLabel recommendationLabel;
    private javax.swing.JLabel reflexesLabel;
    private javax.swing.JLabel sensitivityLabel;
    private javax.swing.JComboBox stressComboBox;
    private javax.swing.JLabel therapyLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

}
