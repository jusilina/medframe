/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package medframe.view;

import medframe.ProjectProperties;
import medframe.PropertyNames;
import medframe.Storage;
import user.Visit;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import user.Category;

/**
 *
 * @author Julia
 */
public class CreateFrame extends javax.swing.JFrame implements PropertyNames
{
    private static Logger log = Logger.getLogger(CreateFrame.class.getName());

    private Map properiesMap = new HashMap();
    private Storage storage;
    private Visit visit = new Visit();
    ProjectProperties props = ProjectProperties.getProperties();

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
                        professionField.setVisible(true);
                    }
                    else
                    {
                        stressComboBox.setVisible(false);
                        professionField.setVisible(false);
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

        emotionMainBox.addItemListener(new ItemListener()
        {

            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    if (e.getItem().equals(N))
                    {
                        emotionViolationBox.setVisible(false);
                    }
                    else
                    {
                        emotionViolationBox.setVisible(true);
                    }
                }

            }
        });

        coordinationMainBox.addItemListener(new ItemListener()
        {

            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    if (e.getItem().equals(DISBALANCE))
                    {
                        coordinationPanel.setVisible(true);
                    }
                    else
                    {
                        coordinationPanel.setVisible(false);
                    }
                }

            }
        });

        sensitivityMainBox.addItemListener(new ItemListener()
        {

            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    if (e.getItem().equals(DISBALANCE))
                    {
                        sensitivityDisbalanceBox.setVisible(true);
                    }
                    else
                    {
                        sensitivityDisbalanceBox.setVisible(false);
                    }
                }

            }
        });

        nervousTensionMainBox.addItemListener(new ItemListener()
        {

            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    if (e.getItem().equals(THESE_IS))
                    {
                        nervousTensionBox.setVisible(true);
                    }
                    else
                    {
                        nervousTensionBox.setVisible(false);
                    }
                }

            }
        });
        pReflexesMainBox.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    if (e.getItem().equals(THESE_IS))
                    {
                        pReflexesPanel.setVisible(true);
                    }
                    else
                    {
                        pReflexesPanel.setVisible(false);
                    }
                }
            }
        });
        
        aReflexesMainBox.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    if (e.getItem().equals(THESE_IS))
                    {
                        aReflexesBox.setVisible(true);
                    }
                    else
                    {
                        aReflexesBox.setVisible(false);
                    }
                }
            }
        });
//        CheckCombo checkCombo = new CheckCombo();
//        checkCombo.addItem(new CheckComboStore("Item-A", true));
//        checkCombo.addItem(new CheckComboStore("Item-B", true));
//        checkCombo.addItem(new CheckComboStore("Item-C", true));
        //  dreamPanel.add(checkCombo);  
        // dreamComboBox = checkCombo;
        // dreamComboBox.addItem(new CheckComboStore("Item-A", true));
        //dreamComboBox.repaint();
        //dreamComboBox.revalidate();
        //  getContentPane().add(dreamPanel, BorderLayout.NORTH);  
        //   setDefaultCloseOperation(EXIT_ON_CLOSE);  
        // setSize(650, 250);  
//    dreamPanel.setVisible(true);  
//    
//    dreamPanel.revalidate();
//    dreamPanel.repaint();
        //  dreamComboBox.add(this)
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

        for (String categoryName : props.getCategoriesNames()) {
            JMenuItem categoryItem = new JMenuItem(categoryName);

            categoryItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    categoryItemActionPerformed(evt);
                }

            });
            categories.add(categoryItem);

        }
        // add panel to panel
//        JPanel panel = new complaintsJPanel();
//      int width = panel.getWidth();
//        System.out.println("size"+width);
//        Dimension dim = new Dimension(750, 300);
//        SpringLayout layout = new SpringLayout();
// 
//        dreamPanel.setLayout(layout);
//        dreamPanel.add(panel);
//       dreamPanel.setPreferredSize(dim);
//       dreamPanel.setMinimumSize(dim);
//
//        
//        pack();

    }

    private void categoryItemActionPerformed(ActionEvent evt)
    {
        String categoryName = evt.getActionCommand();
        for(Category cat:props.getCategories())
        {
            if (cat.getName().equals(categoryName))
            {
                diagnosisArea.setText(cat.getDiagnosis());
                break;
            }
        }
        
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    private void savePDF()
//    {
//        // Document document = new Document(PageSize.A4);
//        populateVisit();
//        String fileName = "C:\\ITextTest.pdf";
//        File file = new File(fileName);
//        storage.savePDF(file, visit);
//    }

    private Visit populateVisit()
    {
        visit.setName(nameField.getText());
        visit.setDate(dateChooser.getDate());
        visit.setComplaine(complaineArea.getText());
        visit.setSocialAnamnesis(jobComboBox.getSelectedItem().toString());
        visit.setProfission(professionField.getText());
        visit.setStress(stressComboBox.getSelectedItem().toString());
        visit.setAnamnesis(anamnesisArea.getText());
        visit.setConscious(consciousBox.getSelectedItem().toString());
        visit.setConsciousAdd(consciousText.getText());
        visit.setEpileptic(epiText.getText());
        if (emotionMainBox.getSelectedIndex()==0)
        {
            visit.addEmotion(N);
        }
        else
        {
             Object[] emotions = emotionViolationBox.getSelectedObjects();
             System.out.println(emotions);
            visit.setEmotion(new ArrayList<>(Arrays.asList(emotions)));
        }
        if(dreamComboBox.getSelectedItem().equals(NORM))
        {
            visit.addDream(NORM);
        }
        else
        {
            Object[] dreamDisbalances = dreamDisbalanceBox.getSelectedObjects();
            System.out.println(dreamDisbalances);
             visit.setDream(new LinkedList(Arrays.asList(dreamDisbalances)));
             visit.addDream(DISBALANCE);
        }
        
        
        Object[] cranicalNerveList = cranicalNerveBox.getSelectedObjects();
        visit.setCranicalNerve(new ArrayList<>(Arrays.asList(cranicalNerveList)));
        
        
         if(sensitivityMainBox.getSelectedItem().equals(NORM))
        {
            visit.addSensitivity(NORM);
        }
        else
        {
            Object[] sensitivityList = sensitivityDisbalanceBox.getSelectedObjects();
             visit.setSensitivity(new ArrayList<>(Arrays.asList(sensitivityList)));
        }
         
        if(nervousTensionMainBox.getSelectedItem().equals(NORM))
        {
            visit.addNervousTension(NORM);
        }
        else
        {
            Object[] nervousTensionList = nervousTensionBox.getSelectedObjects();
            visit.setNervousTension(new ArrayList<>(Arrays.asList(nervousTensionList)));
        }
        
        visit.setReflexes(new ArrayList<>(Arrays.asList(upperDSLimbsBox.getSelectedItem(), lowerDSLimbsBox.getSelectedItem())));
        
        if(pReflexesMainBox.getSelectedItem().equals(NO))
        {
            visit.addPReflexes(NO);
        }
        else
        {
            ArrayList pReflexes = new ArrayList();
            Object[] pReflexesList = pReflexesHandBox.getSelectedObjects();
//            pReflexes.add(Arrays.asList(pReflexesList));
            visit.setpReflexesHand(new ArrayList<>(Arrays.asList(pReflexesList)));
            
            pReflexesList = pReflexesLegBox.getSelectedObjects();
//            pReflexes.add(Arrays.asList(pReflexesList));

            visit.setpReflexesLeg(new ArrayList<>(Arrays.asList(pReflexesList)));
//            visit.setpReflexes(pReflexes);
        }
        
                if(aReflexesMainBox.getSelectedItem().equals(NO))
        {
            visit.addAReflexes(NO);
        }
        else
        {
            Object[] aReflexesList = aReflexesBox.getSelectedObjects();
            visit.setaReflexes(new ArrayList<>(Arrays.asList(aReflexesList)));
        }
                
        visit.setMotionType(motionTypeBox.getSelectedItem().toString());
        visit.setMotion(new ArrayList<>(Arrays.asList(motionBox.getSelectedObjects())));
        
        visit.setMuscle(new ArrayList<>(Arrays.asList(muscleBox.getSelectedObjects())));
        
        

            visit.setCoordination(coordinationMainBox.getSelectedItem().toString());
//        }
//        else
//        {
         //   Object[] aReflexesList = aReflexesBox.getSelectedObjects();
            visit.setRomberg(new ArrayList<>(Arrays.asList(rombergBox.getSelectedObjects())));
            ArrayList coordinationTest = new ArrayList();
            coordinationTest.add(new ArrayList(Arrays.asList(coordinationTestBoxDS.getSelectedItem(), coordinationTestBoxSN.getSelectedItem())));
            coordinationTest.add(new ArrayList(Arrays.asList(coordinationTestBox.getSelectedObjects())));
            visit.setCoordinationTest(coordinationTest);
            
//        }
        
            visit.setNervousSystem(new ArrayList<>(Arrays.asList(nervousSystemBox.getSelectedObjects())));
            
            visit.setPelvicOrgan(pelvicOrganField.getText());
            visit.setDiagnosis(diagnosisArea.getText());
            
            visit.setRecommendations(new ArrayList<>(Arrays.asList(recommendationBox.getSelectedObjects())));
            visit.setRecommendationsAdd(recommendationText.getText());
            
            visit.setTherapy(new ArrayList<>(Arrays.asList(therapyBox.getSelectedObjects())));
        
           

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

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        consciousLabel = new javax.swing.JLabel();
        complaintsTextPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        complaineArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        anamnesisArea = new javax.swing.JTextArea();
        epiLabel = new javax.swing.JLabel();
        consciousBox = new javax.swing.JComboBox();
        consciousText = new javax.swing.JTextField();
        int enotionBoxSize = props.getEmotionViolations().size();
        JCheckBox[] emotionBox = new JCheckBox[enotionBoxSize];

        for(int i=0; i<enotionBoxSize; i++)
        {
            String name = props.getEmotionViolations().get(i);
            emotionBox[i]= new JCheckBox(name);
        }
        emotionViolationBox = new JComboCheckBox(emotionBox);
        emotionMainBox = new javax.swing.JComboBox();
        epiText = new javax.swing.JTextField();
        professionField = new javax.swing.JTextField();
        stressComboBox = new javax.swing.JComboBox();
        jobComboBox = new javax.swing.JComboBox();
        jobLabel = new javax.swing.JLabel();
        anamnesisLabel = new javax.swing.JLabel();
        emotionLabel = new javax.swing.JLabel();
        complaineLabel = new javax.swing.JLabel();
        //JCheckBox box1 = new JCheckBox("1");
        //        JCheckBox box2 = new JCheckBox("2");
        //        JCheckBox box3 = new JCheckBox("3");
        int size = props.getDisturbed_sleepList().size();
        JCheckBox[] box = new JCheckBox[size];

        for(int i=0; i<size; i++)
        {
            String name = props.getDisturbed_sleepList().get(i);
            box[i]= new JCheckBox(name);
        }
        dreamDisbalanceBox = new JComboCheckBox(box);
        dreamComboBox = new javax.swing.JComboBox();
        dreamLabel = new javax.swing.JLabel();
        List <String> nervousSystemList = props.getNervousSystemList();
        int nervousSystemSize = nervousSystemList.size();
        JCheckBox[] nervousSystemBoxSource = new JCheckBox[nervousSystemSize];

        for(int i=0; i<nervousSystemSize; i++)
        {
            String name = nervousSystemList.get(i);
            //System.out.println(name);
            nervousSystemBoxSource[i]= new JCheckBox(name);
        }
        nervousSystemBox = new JComboCheckBox(nervousSystemBoxSource);
        gaitLabel = new javax.swing.JLabel();
        pelvicOrganField = new javax.swing.JTextField();
        reflexesLabel = new javax.swing.JLabel();
        cranicalNerveLabel = new javax.swing.JLabel();
        sensitivityLabel = new javax.swing.JLabel();
        nervousLabel = new javax.swing.JLabel();
        coordinationLabel = new javax.swing.JLabel();
        pReflexesLabelLabel = new javax.swing.JLabel();
        aReflexesLabelLabel = new javax.swing.JLabel();
        int cranicalNerveSize = props.getCranicalNerveViolations().size();
        JCheckBox[] cranicalNerveBoxSource = new JCheckBox[cranicalNerveSize];

        for(int i=0; i<cranicalNerveSize; i++)
        {
            String name = props.getCranicalNerveViolations().get(i);
            cranicalNerveBoxSource[i]= new JCheckBox(name);
        }
        cranicalNerveBox = new JComboCheckBox(cranicalNerveBoxSource);
        pelvicOrganLabel = new javax.swing.JLabel();
        addDrugButton = new javax.swing.JButton();
        diagnosisLabel = new javax.swing.JLabel();
        recommendationLabel = new javax.swing.JLabel();
        therapyLabel = new javax.swing.JLabel();
        drugsPanel = new javax.swing.JPanel();
        dreamPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        coordinationMainBox = new javax.swing.JComboBox();
        coordinationPanel = new javax.swing.JPanel();
        rombergLabel = new javax.swing.JLabel();
        List <String> rombergList = props.getRombergList();
        int rombergListSize = rombergList.size();
        JCheckBox[] rombergBoxSource = new JCheckBox[rombergListSize];

        for(int i=0; i<rombergListSize; i++)
        {
            String name = rombergList.get(i);
            //System.out.println(name);
            rombergBoxSource[i]= new JCheckBox(name);
        }
        rombergBox = new JComboCheckBox(rombergBoxSource);
        coordinationTestLabel = new javax.swing.JLabel();
        coordinationTestD = new javax.swing.JLabel();
        coordinationTestBoxDS = new javax.swing.JComboBox();
        coordinationTestS = new javax.swing.JLabel();
        coordinationTestBoxSN = new javax.swing.JComboBox();
        coordinationTestN = new javax.swing.JLabel();
        List <String> coordinationTestList = props.getCoordinationTest();
        int coordinationTestListSize = coordinationTestList.size();
        JCheckBox[] coordinationTestSource = new JCheckBox[coordinationTestListSize];

        for(int i=0; i<coordinationTestListSize; i++)
        {
            String name = coordinationTestList.get(i);
            coordinationTestSource[i]= new JCheckBox(name);
        }
        coordinationTestBox = new JComboCheckBox(coordinationTestSource);
        sensitivityMainBox = new javax.swing.JComboBox();
        List <String> sensitivityDisbalanceList = props.getSensitivityDisbalanceList();
        int sensitivityDisbalanceListSize = sensitivityDisbalanceList.size();
        JCheckBox[] sensitivityDisbalanceSource = new JCheckBox[sensitivityDisbalanceListSize];

        for(int i=0; i<sensitivityDisbalanceListSize; i++)
        {
            String name = sensitivityDisbalanceList.get(i);
            //System.out.println(name);
            sensitivityDisbalanceSource[i]= new JCheckBox(name);
        }
        sensitivityDisbalanceBox = new JComboCheckBox(sensitivityDisbalanceSource);
        nervousTensionLabel = new javax.swing.JLabel();
        nervousTensionMainBox = new javax.swing.JComboBox();
        List <String> nervousTensionList = props.getNervousTensionList();
        int nervousTensionListSize = nervousTensionList.size();
        JCheckBox[] nervousTensionSource = new JCheckBox[nervousTensionListSize];

        for(int i=0; i<nervousTensionListSize; i++)
        {
            String name = nervousTensionList.get(i);
            nervousTensionSource[i]= new JCheckBox(name);
        }
        nervousTensionBox = new JComboCheckBox(nervousTensionSource);
        limbsLabel = new javax.swing.JLabel();
        upperLimbsLabel = new javax.swing.JLabel();
        dLabel = new javax.swing.JLabel();
        sLabel = new javax.swing.JLabel();
        sLabel1 = new javax.swing.JLabel();
        dLabel1 = new javax.swing.JLabel();
        lowerLimbsLabel = new javax.swing.JLabel();
        upperDSLimbsBox = new javax.swing.JComboBox();
        lowerDSLimbsBox = new javax.swing.JComboBox();
        pReflexesMainBox = new javax.swing.JComboBox();
        aReflexesMainBox = new javax.swing.JComboBox();
        pReflexesPanel = new javax.swing.JPanel();
        pReflexesHandLabel = new javax.swing.JLabel();
        List <String> pReflexesHandList = props.getpReflexesHand();
        int pReflexesHandListSize = pReflexesHandList.size();
        JCheckBox[] pReflexesHandSource = new JCheckBox[pReflexesHandListSize];

        for(int i=0; i<pReflexesHandListSize; i++)
        {
            String name = pReflexesHandList.get(i);
            pReflexesHandSource[i]= new JCheckBox(name);
        }
        pReflexesHandBox = new JComboCheckBox(pReflexesHandSource);
        pReflexesLegLabel = new javax.swing.JLabel();
        List <String> pReflexesLegList = props.getpReflexesLeg();
        int pReflexesLegListSize = pReflexesLegList.size();
        JCheckBox[] pReflexesLegSource = new JCheckBox[pReflexesLegListSize];

        for(int i=0; i<pReflexesLegListSize; i++)
        {
            String name = pReflexesLegList.get(i);
            pReflexesLegSource[i]= new JCheckBox(name);
        }
        pReflexesLegBox = new JComboCheckBox(pReflexesLegSource);
        List <String> aReflexesList = props.getaReflexesList();
        int aReflexesListSize = aReflexesList.size();
        JCheckBox[] aReflexesSource = new JCheckBox[aReflexesListSize];

        for(int i=0; i<aReflexesListSize; i++)
        {
            String name = aReflexesList.get(i);
            aReflexesSource[i]= new JCheckBox(name);
        }
        aReflexesBox = new JComboCheckBox(aReflexesSource);
        javax.swing.JComboBox gaitBox = new javax.swing.JComboBox();
        motionTypeBox = new javax.swing.JComboBox();
        motionLabel = new javax.swing.JLabel();
        muscleLabel = new javax.swing.JLabel();
        List <String> muscleList = props.getMuscleToneList();
        int muscleSize = muscleList.size();
        JCheckBox[] muscleBoxSource = new JCheckBox[muscleSize];

        for(int i=0; i<muscleSize; i++)
        {
            String name = muscleList.get(i);
            //System.out.println(name);
            muscleBoxSource[i]= new JCheckBox(name);
        }
        muscleBox = new JComboCheckBox(muscleBoxSource);
        List <String> motionList = props.getMotionList();
        int motionListSize = motionList.size();
        JCheckBox[] motionBoxSource = new JCheckBox[motionListSize];

        for(int i=0; i<motionListSize; i++)
        {
            String name = motionList.get(i);
            motionBoxSource[i]= new JCheckBox(name);
        }
        motionBox = new JComboCheckBox(motionBoxSource);
        jScrollPane4 = new javax.swing.JScrollPane();
        diagnosisArea = new javax.swing.JTextArea();
        List <String> recommendationList = props.getRecommendationList();
        int recommendationSize = recommendationList.size();
        JCheckBox[] recommendationBoxSource = new JCheckBox[recommendationSize];

        for(int i=0; i<recommendationSize; i++)
        {
            String name = recommendationList.get(i);
            recommendationBoxSource[i]= new JCheckBox(name);
        }
        recommendationBox = new JComboCheckBox(recommendationBoxSource);
        recommendationText = new javax.swing.JTextField();
        List <String> therapyList = props.getTherapy();
        int therapySize = therapyList.size();
        JCheckBox[] therapyBoxSource = new JCheckBox[therapySize];

        for(int i=0; i<therapySize; i++)
        {
            String name = therapyList.get(i);
            therapyBoxSource[i]= new JCheckBox(name);
        }
        therapyBox = new JComboCheckBox(therapyBoxSource);
        jMenuBar1 = new javax.swing.JMenuBar();
        categories = new javax.swing.JMenu();
        createForm = new javax.swing.JMenu();
        editProperties = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        exportItem = new javax.swing.JMenuItem();
        importItem = new javax.swing.JMenuItem();
        javax.swing.JMenuItem savePDFItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));

        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 700));

        nameLabel.setText(PropertyNames.NAME);

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleLabel.setText(TITLE);

        jLabel2.setText(PropertyNames.DATE);

        consciousLabel.setText(CONSCIOUS);

        complaineArea.setColumns(20);
        complaineArea.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        complaineArea.setRows(5);
        jScrollPane1.setViewportView(complaineArea);

        javax.swing.GroupLayout complaintsTextPanelLayout = new javax.swing.GroupLayout(complaintsTextPanel);
        complaintsTextPanel.setLayout(complaintsTextPanelLayout);
        complaintsTextPanelLayout.setHorizontalGroup(
            complaintsTextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complaintsTextPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
        );
        complaintsTextPanelLayout.setVerticalGroup(
            complaintsTextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complaintsTextPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        anamnesisArea.setColumns(20);
        anamnesisArea.setRows(5);
        jScrollPane2.setViewportView(anamnesisArea);

        epiLabel.setText(EPILEPTIC_SEIZURE);

        consciousBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { CONSCIOUS_CLEAR, CONSCIOUS_OBNUBILATION }));

        emotionViolationBox.setVisible(false);

        emotionMainBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { N, DISBALANCE}));

        epiText.setText(NEG);

        professionField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                professionFieldActionPerformed(evt);
            }
        });

        stressComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {PropertyNames.EXERCISE_STRESS, PropertyNames.STATIC_LOAD}));

        jobComboBox.setModel(new DefaultComboBoxModel(new String[] { PropertyNames.WORKING, PropertyNames.NOT_WORKING, PropertyNames.PENSIONER, PropertyNames.CRIPPLE }));

        jobLabel.setText(PropertyNames.SOCIAL_ANAMNESIS);

        anamnesisLabel.setText(PropertyNames.ANAMNESIS);
        anamnesisLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        emotionLabel.setText(PropertyNames.EMOTION);

        complaineLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        complaineLabel.setText(PropertyNames.COMPLAINE);

        dreamDisbalanceBox.setVisible(false);

        dreamComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {NORM, DISBALANCE}));

        dreamLabel.setText(PropertyNames.DREAM);

        gaitLabel.setText(GAIT);

        pelvicOrganField.setText(N);

        reflexesLabel.setText(REFLEXES);

        cranicalNerveLabel.setText(PropertyNames.CRANIAL_NERVE);

        sensitivityLabel.setText(PropertyNames.SENSITIVITY);

        nervousLabel.setText(NERVOUS_SYSTEM);

        coordinationLabel.setText(COORDINATION);

        pReflexesLabelLabel.setText(P_REFLEXES);

        aReflexesLabelLabel.setText(A_REFLEXES);

        cranicalNerveBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cranicalNerveBoxActionPerformed(evt);
            }
        });

        pelvicOrganLabel.setText(PELVIC_ORGAN);

        addDrugButton.setText("Добавить лекарство");
        addDrugButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addDrugButtonActionPerformed(evt);
            }
        });

        diagnosisLabel.setText(DIAGNOSIS);

        recommendationLabel.setText(RECOMMENDATIONS);

        therapyLabel.setText(THERAPY);

        javax.swing.GroupLayout drugsPanelLayout = new javax.swing.GroupLayout(drugsPanel);
        drugsPanel.setLayout(drugsPanelLayout);
        drugsPanelLayout.setHorizontalGroup(
            drugsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        drugsPanelLayout.setVerticalGroup(
            drugsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        dreamPanel.setMinimumSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dreamPanelLayout = new javax.swing.GroupLayout(dreamPanel);
        dreamPanel.setLayout(dreamPanelLayout);
        dreamPanelLayout.setHorizontalGroup(
            dreamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dreamPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(326, Short.MAX_VALUE))
        );
        dreamPanelLayout.setVerticalGroup(
            dreamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dreamPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        coordinationMainBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { NORM, DISBALANCE }));

        coordinationPanel.setVisible(false);

        rombergLabel.setText(ROMBERG_MANEUVER);

        coordinationTestLabel.setText(COORDINATION_TESTS);

        coordinationTestD.setText("D");

        coordinationTestBoxDS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "=", ">", "<", " " }));

        coordinationTestS.setText("S");

        coordinationTestBoxSN.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "=", ">", "<" }));

        coordinationTestN.setText("N");

        javax.swing.GroupLayout coordinationPanelLayout = new javax.swing.GroupLayout(coordinationPanel);
        coordinationPanel.setLayout(coordinationPanelLayout);
        coordinationPanelLayout.setHorizontalGroup(
            coordinationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coordinationPanelLayout.createSequentialGroup()
                .addComponent(rombergLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rombergBox, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coordinationTestLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coordinationTestD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coordinationTestBoxDS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(coordinationTestS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coordinationTestBoxSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coordinationTestN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coordinationTestBox, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        coordinationPanelLayout.setVerticalGroup(
            coordinationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coordinationPanelLayout.createSequentialGroup()
                .addGroup(coordinationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rombergLabel)
                    .addComponent(rombergBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coordinationTestLabel)
                    .addComponent(coordinationTestD)
                    .addComponent(coordinationTestBoxDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coordinationTestS)
                    .addComponent(coordinationTestBoxSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coordinationTestN)
                    .addComponent(coordinationTestBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sensitivityMainBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { NORM,DISBALANCE}));

        sensitivityDisbalanceBox.setVisible(false);

        nervousTensionLabel.setText(NERVOUS_TENSION);

        nervousTensionMainBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { NO, THESE_IS }));

        nervousTensionBox.setVisible(false);

        limbsLabel.setText(LIMBS);

        upperLimbsLabel.setText(UPPER);

        dLabel.setText("D");

        sLabel.setText("S");

        sLabel1.setText("S");

        dLabel1.setText("D");

        lowerLimbsLabel.setText(LOWER);

        upperDSLimbsBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "=", ">", "<" }));

        lowerDSLimbsBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "=", ">", "<" }));

        pReflexesMainBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { NO, THESE_IS}));

        aReflexesMainBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { NO, THESE_IS }));

        pReflexesPanel.setVisible(false);

        pReflexesHandLabel.setText(HAND);

        pReflexesLegLabel.setText(LEG);

        javax.swing.GroupLayout pReflexesPanelLayout = new javax.swing.GroupLayout(pReflexesPanel);
        pReflexesPanel.setLayout(pReflexesPanelLayout);
        pReflexesPanelLayout.setHorizontalGroup(
            pReflexesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pReflexesPanelLayout.createSequentialGroup()
                .addComponent(pReflexesHandLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pReflexesHandBox, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pReflexesLegLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pReflexesLegBox, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );
        pReflexesPanelLayout.setVerticalGroup(
            pReflexesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pReflexesPanelLayout.createSequentialGroup()
                .addGroup(pReflexesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pReflexesHandLabel)
                    .addComponent(pReflexesHandBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pReflexesLegLabel)
                    .addComponent(pReflexesLegBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gaitBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { N, ANTALGIC }));

        motionTypeBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ACTIVE, PASSIVE }));

        motionLabel.setText(MOTION);

        muscleLabel.setText(MUSCLE_TONE);

        muscleBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                muscleBoxActionPerformed(evt);
            }
        });

        diagnosisArea.setColumns(20);
        diagnosisArea.setRows(5);
        jScrollPane4.setViewportView(diagnosisArea);

        recommendationText.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                recommendationTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nervousTensionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nervousTensionMainBox, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nervousTensionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(motionTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(motionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(motionBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(muscleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(muscleBox, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pelvicOrganLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(228, 228, 228))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(emotionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(emotionMainBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emotionViolationBox, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(anamnesisLabel)
                                    .addGap(24, 24, 24)
                                    .addComponent(jScrollPane2))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jobLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jobComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(professionField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(stressComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(115, 115, 115))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(consciousLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(consciousBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(consciousText, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(epiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(epiText, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(complaintsTextPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(complaineLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dreamLabel)
                                .addGap(31, 31, 31)
                                .addComponent(dreamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dreamDisbalanceBox, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cranicalNerveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cranicalNerveBox, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nervousLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pelvicOrganField, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nervousSystemBox, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(coordinationLabel)
                                    .addComponent(sensitivityLabel)
                                    .addComponent(reflexesLabel)
                                    .addComponent(aReflexesLabelLabel)
                                    .addComponent(gaitLabel)
                                    .addComponent(pReflexesLabelLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(sensitivityMainBox, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sensitivityDisbalanceBox, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(373, 373, 373)
                                        .addComponent(dreamPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(aReflexesMainBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 43, Short.MAX_VALUE)
                                            .addComponent(pReflexesMainBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pReflexesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(aReflexesBox, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(limbsLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(upperLimbsLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(upperDSLimbsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)
                                        .addComponent(sLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lowerLimbsLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lowerDSLimbsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sLabel1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(gaitBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(coordinationMainBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 108, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(coordinationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(drugsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(addDrugButton))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(recommendationLabel)
                                        .addComponent(therapyLabel))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(therapyBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(recommendationBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(recommendationText, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(diagnosisLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(complaineLabel)
                .addGap(12, 12, 12)
                .addComponent(complaintsTextPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobLabel)
                    .addComponent(jobComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(professionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stressComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(anamnesisLabel)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consciousLabel)
                    .addComponent(consciousBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consciousText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(epiLabel)
                    .addComponent(epiText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emotionLabel)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(emotionMainBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(emotionViolationBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dreamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dreamDisbalanceBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(dreamLabel)))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cranicalNerveLabel)
                    .addComponent(cranicalNerveBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensitivityLabel)
                        .addComponent(sensitivityMainBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensitivityDisbalanceBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dreamPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nervousTensionLabel)
                    .addComponent(nervousTensionMainBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nervousTensionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reflexesLabel)
                    .addComponent(limbsLabel)
                    .addComponent(upperLimbsLabel)
                    .addComponent(dLabel)
                    .addComponent(sLabel)
                    .addComponent(dLabel1)
                    .addComponent(sLabel1)
                    .addComponent(lowerLimbsLabel)
                    .addComponent(lowerDSLimbsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upperDSLimbsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pReflexesLabelLabel)
                        .addComponent(pReflexesMainBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pReflexesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aReflexesLabelLabel)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(aReflexesMainBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(aReflexesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gaitLabel)
                    .addComponent(gaitBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(motionTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(motionLabel)
                    .addComponent(motionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(muscleLabel)
                    .addComponent(muscleBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(coordinationLabel)
                        .addComponent(coordinationMainBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(coordinationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nervousLabel)
                    .addComponent(nervousSystemBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pelvicOrganLabel)
                    .addComponent(pelvicOrganField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(diagnosisLabel)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recommendationLabel)
                    .addComponent(recommendationBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recommendationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(therapyLabel)
                    .addComponent(therapyBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(drugsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addDrugButton))
                .addGap(30, 30, 30))
        );

        aReflexesBox.setVisible(false);

        jScrollPane3.setViewportView(jPanel1);

        categories.setText(CATEGORY);
        jMenuBar1.add(categories);

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
        importItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                importItemActionPerformed(evt);
            }
        });
        jMenu2.add(importItem);

        savePDFItem.setText("save PDF");
        savePDFItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                savePDFItemActionPerformed(evt);
            }
        });
        jMenu2.add(savePDFItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
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

    private void exportItemActionPerformed(java.awt.event.ActionEvent evt)
    {
        JFileChooser exportFile = new JFileChooser();
        //  exportFile.setCurrentDirectory(new File("testTest.xml"));
        if (exportFile.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            File file = exportFile.getSelectedFile();
            System.out.println(file.getPath());
            populateVisit();
            storage.exportFile(file, visit);
        }

//        File file = new File("c:\\test.xml");
//
//        System.out.println("exportItemActionPerformed");
        //  Visit visit = new Visit();
        //    visit.setName(nameField.getText());
        //  visit.setDate(new Date());

    }


    private void addDrugButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addDrugButtonActionPerformed
    {//GEN-HEADEREND:event_addDrugButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addDrugButtonActionPerformed

    private void cranicalNerveBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cranicalNerveBoxActionPerformed
    {//GEN-HEADEREND:event_cranicalNerveBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cranicalNerveBoxActionPerformed

    private void professionFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_professionFieldActionPerformed
    {//GEN-HEADEREND:event_professionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_professionFieldActionPerformed

    private void importItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_importItemActionPerformed
    {//GEN-HEADEREND:event_importItemActionPerformed
         JFileChooser importFile = new JFileChooser();

        if (importFile.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            File file = importFile.getSelectedFile();
            System.out.println(file.getPath());

            Visit importVisit = storage.importFile(file);
        }
    }//GEN-LAST:event_importItemActionPerformed

    private void savePDFItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_savePDFItemActionPerformed
    {//GEN-HEADEREND:event_savePDFItemActionPerformed
        log.info("savePDFItemActionPerformed");
        JFileChooser pdfFile = new JFileChooser();
        if (pdfFile.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            populateVisit();            
            File file = pdfFile.getSelectedFile();
            
            storage.savePDF(file, visit);
        }
    }//GEN-LAST:event_savePDFItemActionPerformed

    private void muscleBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_muscleBoxActionPerformed
    {//GEN-HEADEREND:event_muscleBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_muscleBoxActionPerformed

    private void recommendationTextActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_recommendationTextActionPerformed
    {//GEN-HEADEREND:event_recommendationTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recommendationTextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox aReflexesBox;
    private javax.swing.JLabel aReflexesLabelLabel;
    private javax.swing.JComboBox aReflexesMainBox;
    private javax.swing.JButton addDrugButton;
    private javax.swing.JTextArea anamnesisArea;
    private javax.swing.JLabel anamnesisLabel;
    private javax.swing.JMenu categories;
    private javax.swing.JTextArea complaineArea;
    private javax.swing.JLabel complaineLabel;
    private javax.swing.JPanel complaintsTextPanel;
    private javax.swing.JComboBox consciousBox;
    private javax.swing.JLabel consciousLabel;
    private javax.swing.JTextField consciousText;
    private javax.swing.JLabel coordinationLabel;
    private javax.swing.JComboBox coordinationMainBox;
    private javax.swing.JPanel coordinationPanel;
    private javax.swing.JComboBox coordinationTestBox;
    private javax.swing.JComboBox coordinationTestBoxDS;
    private javax.swing.JComboBox coordinationTestBoxSN;
    private javax.swing.JLabel coordinationTestD;
    private javax.swing.JLabel coordinationTestLabel;
    private javax.swing.JLabel coordinationTestN;
    private javax.swing.JLabel coordinationTestS;
    private javax.swing.JComboBox cranicalNerveBox;
    private javax.swing.JLabel cranicalNerveLabel;
    private javax.swing.JMenu createForm;
    private javax.swing.JLabel dLabel;
    private javax.swing.JLabel dLabel1;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JTextArea diagnosisArea;
    private javax.swing.JLabel diagnosisLabel;
    private javax.swing.JComboBox dreamComboBox;
    private javax.swing.JComboBox dreamDisbalanceBox;
    private javax.swing.JLabel dreamLabel;
    private javax.swing.JPanel dreamPanel;
    private javax.swing.JPanel drugsPanel;
    private javax.swing.JMenu editProperties;
    private javax.swing.JLabel emotionLabel;
    private javax.swing.JComboBox emotionMainBox;
    private javax.swing.JComboBox emotionViolationBox;
    private javax.swing.JLabel epiLabel;
    private javax.swing.JTextField epiText;
    private javax.swing.JMenuItem exportItem;
    private javax.swing.JLabel gaitLabel;
    private javax.swing.JMenuItem importItem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox jobComboBox;
    private javax.swing.JLabel jobLabel;
    private javax.swing.JLabel limbsLabel;
    private javax.swing.JComboBox lowerDSLimbsBox;
    private javax.swing.JLabel lowerLimbsLabel;
    private javax.swing.JComboBox motionBox;
    private javax.swing.JLabel motionLabel;
    private javax.swing.JComboBox motionTypeBox;
    private javax.swing.JComboBox muscleBox;
    private javax.swing.JLabel muscleLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nervousLabel;
    private javax.swing.JComboBox nervousSystemBox;
    private javax.swing.JComboBox nervousTensionBox;
    private javax.swing.JLabel nervousTensionLabel;
    private javax.swing.JComboBox nervousTensionMainBox;
    private javax.swing.JComboBox pReflexesHandBox;
    private javax.swing.JLabel pReflexesHandLabel;
    private javax.swing.JLabel pReflexesLabelLabel;
    private javax.swing.JComboBox pReflexesLegBox;
    private javax.swing.JLabel pReflexesLegLabel;
    private javax.swing.JComboBox pReflexesMainBox;
    private javax.swing.JPanel pReflexesPanel;
    private javax.swing.JTextField pelvicOrganField;
    private javax.swing.JLabel pelvicOrganLabel;
    private javax.swing.JTextField professionField;
    private javax.swing.JComboBox recommendationBox;
    private javax.swing.JLabel recommendationLabel;
    private javax.swing.JTextField recommendationText;
    private javax.swing.JLabel reflexesLabel;
    private javax.swing.JComboBox rombergBox;
    private javax.swing.JLabel rombergLabel;
    private javax.swing.JLabel sLabel;
    private javax.swing.JLabel sLabel1;
    private javax.swing.JComboBox sensitivityDisbalanceBox;
    private javax.swing.JLabel sensitivityLabel;
    private javax.swing.JComboBox sensitivityMainBox;
    private javax.swing.JComboBox stressComboBox;
    private javax.swing.JComboBox therapyBox;
    private javax.swing.JLabel therapyLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JComboBox upperDSLimbsBox;
    private javax.swing.JLabel upperLimbsLabel;
    // End of variables declaration//GEN-END:variables

}
