/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medframe.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Julia
 */
public class JComboCheckBox extends JComboBox {
  private JCheckBox[] items;
  public JComboCheckBox() { addStuff(); }

    public JComboCheckBox(JCheckBox[] items)
    {
        super(items);
        this.items = items;
        addStuff();
    }
  public JComboCheckBox(Vector items) { super(items); addStuff(); }
  public JComboCheckBox(ComboBoxModel aModel) { super(aModel); addStuff(); }
  private void addStuff() {
    setRenderer(new ComboBoxRenderer());
    addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) { itemSelected(); }
    });
  }
  private void itemSelected() {
    if (getSelectedItem() instanceof JCheckBox) {
      JCheckBox jcb = (JCheckBox)getSelectedItem();
      jcb.setSelected(!jcb.isSelected());
    }
  }
  
  @Override
  public Object[] getSelectedObjects() {
      ArrayList items = new ArrayList();
      int size = this.dataModel.getSize();
      for(int i=0;i<size; i++)
      {
          JCheckBox elem = (JCheckBox) this.dataModel.getElementAt(i);
          if(elem.isSelected())
          {
              items.add(elem.getText());
          }
      }
      return items.toArray();
//        Object selectedObject = getSelectedItem();
//        if ( selectedObject == null )
//            return new Object[0];
//        else {
//            Object result[] = new Object[1];
//            result[0] = selectedObject;
//            return result;
//        }
    }

   public void setSelectedObjects(List <String> objects)
   {
       //Deselect already selected objects
       Object [] selectedObjects = this.getSelectedObjects();
       for(Object o : selectedObjects)
       {
           for (JCheckBox item : items)
           {
               if(item.getText().equals(o))
               {
                   System.out.println("Selected item "+o.toString());
                   this.setSelectedItem(item);
               }
           }
       }

       //Select new objects
       for (String text : objects)
       {
           for (JCheckBox item : items)
           {
               if(item.getText().equals(text))
               {
//                   System.out.println("Select item "+item.toString());
                   this.setSelectedItem(item);
               }
           }

       }
   }
  
  class ComboBoxRenderer implements ListCellRenderer {
    private JLabel defaultLabel;
    public ComboBoxRenderer() { setOpaque(true); }
    public Component getListCellRendererComponent(JList list, Object value, int index,
    		    boolean isSelected, boolean cellHasFocus) {
      if (value instanceof Component) {
        Component c = (Component)value;
        if (isSelected) {
          c.setBackground(list.getSelectionBackground());
          c.setForeground(list.getSelectionForeground());
        } else {
          c.setBackground(list.getBackground());
          c.setForeground(list.getForeground());
        }
        return c;
      } else {
        if (defaultLabel==null) defaultLabel = new JLabel(value.toString());
        else defaultLabel.setText(value.toString());
        return defaultLabel;
      }
    }
  }
}
