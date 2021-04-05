/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.posl.organizer.model.Contact;
import pl.posl.organizer.model.OwnException;

/**
 * Class testing method from Contact class
 * @author Ewelina
 * @version 2.0
 */
public class ContactTest {
    private Contact contact= new Contact();
    public ContactTest() {
    }

    @Test
    public void testSetTelphone()// testing negative number
    { 
        contact.setTelephone(-8);
        assertEquals(contact.getTelephone(),0);
    }
     @ParameterizedTest
    @ValueSource(strings={"qqq","qqq@","qq@dddd","WW@ffg."}) 
    public void testEmail(String sample)// testing wrong email
    { 
        contact.setEmail(sample);
        assertEquals(contact.getEmail(),"");// compare value with default""
    }
     @Test
    public void testValidate()// testing exception in function validate
    {
        try{
            contact.validate("tt");
           fail("Exception should be thrown in this place");
        }catch(OwnException e)
        {
        }
        try{
            contact.validate("tt@");
           fail("Exception should be thrown in this place");
        }catch(OwnException e)
        {
        }
       try{
            contact.validate("t@.sd");
           fail("Exception should be thrown in this place");
        }catch(OwnException e)
        {
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
