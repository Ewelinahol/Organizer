/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.posl.organizer.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class storer list of task
 * @author Ewelina
 * @version 2.0
 */
public class Tasks {
    private  List<Task>tasks;
    public Tasks() {
        this.tasks= new ArrayList<>();
    }
/**
 * Function adding new elemnt to list of tasks
 * @param task new task added to list
 */
   public void add(Task task)
   {
       this.tasks.add(task);
   }
/**
 * Function getting sinlge task from tasks list
 * @return task element of list
 */
   public Task getTask(int index)
   {
       return tasks.get(index);
   }
   /**
    * Function getting all list
    * @return tasks list of task
    */
    public List<Task> getTasks() {
        return tasks;
    }
    /**
     * Function removing single task from tasks list
     * @param task object which will be removed from list
     */
    public void deleteTask(Task task)
    {
        tasks.remove(task);
    }
    /**
     * Function returning size of tasks list
     * @return tasks size
     */
   public int size()
   {
       return tasks.size();
   }

}
