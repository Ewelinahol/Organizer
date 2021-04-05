/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.organizer.view;


import javax.swing.table.AbstractTableModel;
import pl.posl.organizer.model.OwnException;
import pl.posl.organizer.model.Tasks;

/**
 * Class handle task tables display in form 
 * @author Ewelina
 * @version 2.0
 */
public class TasksTable extends AbstractTableModel  {
private final Tasks tasks;
/**
 * Constructor
 * @param tasks list of task
 */
    public TasksTable(Tasks tasks) {
        this.tasks = tasks;
    }
/**
 * Function returning size of tasks list
 * @return tasks list size
 */
    @Override
    public int getRowCount() {
        return tasks.size();
    }
/**
 * Function returning number of columns used in table
 * @return number of columns
 */
    @Override
    public int getColumnCount() {
        return 5;
    }
/**
 * Function display details information in task table at specifying cell 
 * @param rowIndex single task in list of tasks
 * @param columnIndex index pointed to specifying information in single task 
 * @return Object which details will be displayed
 */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return tasks.getTask(rowIndex).getContents();// return description of task specified by rowIndex like a String
            case 1: return tasks.getTask(rowIndex).getStartDate();
            case 2: return tasks.getTask(rowIndex).getEndDate();
            case 3: return tasks.getTask(rowIndex).getStartTime();
            case 4: return tasks.getTask(rowIndex).getEndTime();
            default: return "";
        }
    }
    /**
     * Function displaying columns name in task table
     * @param column index sepcifying columns name
     * @return String suitable to column in table 
     */
      @Override
     public String getColumnName(int column)
     {
         switch(column)
         {
             case 0: return "Description";// return column name
             case 1: return "Date to Start";
             case 2: return "Ending date";
             case 3: return "Starting time";
             case 4: return "Ending time";
         }
         return null;
     }
     /**
      * Function setting all cells in table editable
      * @param rowIndex row index in table
      * @param columnIndex column index in table
      * @return true
      */
     @Override
     public boolean isCellEditable(int rowIndex, int columnIndex)
     {
         return true;// all cell will be editable
     }
     /**
      * Function setting sepcifying value into tasks list with exception handling
      * @param aValue  value which is inserted to one element of list
      * @param rowIndex  index determinig element in list
      * @param columnIndex index determining which component of single element of list will be inserted
      */
     @Override 
     public void setValueAt(Object aValue,int rowIndex, int columnIndex)
     {
        
         switch(columnIndex)
         {
             case 0: tasks.getTask(rowIndex).setDescription((String) aValue);
             break;
             case 1: tasks.getTask(rowIndex).setStartDate( (String)aValue);   
             break;
             case 2: tasks.getTask(rowIndex).setEndDate((String) aValue);
             break;
             case 3: tasks.getTask(rowIndex).setStartTime((String) aValue);
             break;
             case 4: tasks.getTask(rowIndex).setEndTime((String) aValue);
             break;
         }
         
         fireTableCellUpdated(rowIndex, columnIndex);// function updated tasks table
     }
    
}
