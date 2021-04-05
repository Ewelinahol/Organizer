/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pl.posl.organizer.model.Contact;
import pl.posl.organizer.model.Contacts;

/**
 * Class for testing method from Contacts class
 * @author Ewelina
 * @version 2.0
 */
public class ContactsTest {
    private Contacts contacts= new Contacts();
   
@Test 
public void searchTest()
{
    Contact task= new Contact(1,"sample","sample@gm.com");
    contacts.add(task);
    Contact task1=new Contact(1,"notsample","ojj@ww.pl");
    contacts.add(task1);
    contacts.search(1).stream().
            forEachOrdered(e->{
            assertEquals(1,e.getTelephone());// check if searched object has value 1
            });
    
 }
    
    
}
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

