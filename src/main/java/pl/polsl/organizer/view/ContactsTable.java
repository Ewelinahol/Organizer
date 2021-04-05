/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.organizer.view;

import static java.lang.Integer.parseInt;
import javax.swing.table.AbstractTableModel;
import pl.posl.organizer.model.Contacts;

/**
 * Class handle contact tables display in form 
 * @author Ewelina
 * @version 2.0
 */
public class ContactsTable extends AbstractTableModel{
private final Contacts contacts;
private enum ColumnName{telephone(0), address(1),email(2);
 private final int value;
    private ColumnName(int value) {
        this.value = value;
    }

     public int getValue() {
        return value;
    }
}

/**
 * Constructor setting list of contact
 * @param contacts list of contact 
 */
    public ContactsTable(Contacts contacts) {
        this.contacts = contacts;
    }
/**
 * Function returning number of element in list of contact
 * @return integer representing amount of elelment in contacts list
 */
    @Override
    public int getRowCount() {
        return contacts.size();
    }
/**
 * Function which return amount of columns existing in contact table
 * @return 3, because contact table has 3 columns
 */
    @Override
    public int getColumnCount() {
        return 3;
    }
/**
 * Function, which display name of columns in contact table
 * @param column index specifying columns name
 * @return String suitable to column in table 
 */
    @Override
     public String getColumnName(int column)
     {
         
            if(column==ColumnName.telephone.getValue())
             return ColumnName.telephone.toString();// column at index 0 will have telephone name
            else if(column==ColumnName.address.getValue())
              return ColumnName.address.toString();
            else if(column==ColumnName.email.getValue())
             return ColumnName.email.toString();
            
        
         return null;
     }
     /**
      * Function setting all cell editable
      * @param rowIndex
      * @param columnIndex
      * @return true
      */
     @Override
     public boolean isCellEditable(int rowIndex, int columnIndex)
     {
         return true;// all cell will be editable
     }
     /**
      * Function display contact details in table
      * @param rowIndex index determining displaying contact
      * @param columnIndex index determining in which column information will be displayed
      * @return Object which details will be displayed
      */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return contacts.getContact(rowIndex).getTelephone();// return telephone number from single contact of contacts list
            case 1: return contacts.getContact(rowIndex).getAddress();
            case 2: return contacts.getContact(rowIndex).getEmail();
            default: return "";
        }
        
    }
    /**
     * Function setting specific value in contacts list
     * @param aValue information which will be inserted into element of contatcts list
     * @param rowIndex index determining element in list
     * @param columnIndex index determing which component will be inserted in one of contact
     */
    @Override 
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        switch(columnIndex)
        {
            case 0: contacts.getContact(rowIndex).setTelephone(parseInt(aValue.toString()));// set telephone number like a int to a single contatct
            break;
            case 1: contacts.getContact(rowIndex).setAddress((String) aValue);// set adrress like a string to a single contact 
            break;
            case 2: contacts.getContact(rowIndex).setEmail((String) aValue);
            break;
        }
         fireTableCellUpdated(rowIndex, columnIndex);// display updated cell on table
    }
    
    
}
