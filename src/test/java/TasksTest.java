/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pl.posl.organizer.model.Task;
import pl.posl.organizer.model.Tasks;
import org.hamcrest.MatcherAssert;




/**
 * Class testing method from Tasks class
 * @author Ewelina
 * @version 2.0
 */
public class TasksTest {
    private Tasks tasks=new Tasks();
    public TasksTest() {
    }
    @Test 
    public void testAddNullTask()
    {
         tasks.add(null);
        assertNull(tasks.getTask(0));
    }
    @Test
    public void testAddTask()
    {
       
        tasks.add(new Task("desc","zle","zle","rano","wieczor"));
        assertEquals(tasks.getTask(0).getStartDate(),null);// wrong start date won't be write in tasks object
        assertEquals(tasks.getTask(0).getEndDate(),null);//wrong end date won't be write too
    }
    @Test
    public void testDeleteTask() 
    {
        tasks.add(new Task("des","2020-11-18","2020-11-18","8 rano","10"));
        Task temp=tasks.getTask(0);
        tasks.deleteTask(temp);
        assertNotNull(tasks.getTasks());//after correct delete there no task, but list doesn't be null 
       
    }
    @Test
    public void testDeleteNullTask() 
    {
         tasks.add(new Task("ooo","2020-11-18","2020-11-19","8 rano","10"));
         tasks.deleteTask(null);
        assertNotNull(tasks.getTasks());// in list still is one task
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}
