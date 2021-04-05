/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.posl.organizer.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class storer details about stored contact
 * @author Ewelina
 * @version 2.0
 */
public class Contact {
    private int telephone;
    private String address;
    private String email;
    private static String regex="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private static Pattern pattern=Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    private Matcher matcher;
/**
 * Default constructor
 */
    public Contact() {
        this.telephone = 0;
        this.address="";
        this.email="";
    }
/**
 * Constructor with parameters
 * @param telephone integer storer telephone number
 * @param address
 * @param email 
 */
    public Contact(int telephone, String address, String email) {
        this.telephone = telephone;
        this.address = address;
        this.email = email;
    }
/**
 * Function setting new value of telephone number
 * @param telephone new telephone number
 */
    public void setTelephone(int telephone) {
        if(telephone<0)
            this.telephone = 0;
        else
        this.telephone = telephone;
    }
/**
 * Function setting new adress
 * @param address new address
 */
    public void setAddress(String address) {
        this.address = address;
    }
/**
 * Function setting new e-mail address
 * @param email new e-mail
 */
    public void setEmail(String email) {
        try{
              this.validate(email);// chceck if date String is in correct format
        }catch(OwnException e)// if not catch exception
        {
           e.getMessage();
            return;// this uncorrect value doesn't be inserted into single contact
        }
        this.email = email;
    }
/**
 * Function returning telephone number
 * @return telephone number
 */
    public int getTelephone() {
        return telephone;
    }
/**
 * Function returning address
 * @return String represent address
 */
    public String getAddress() {
        return address;
    }
/**
 * Function returning e-mail
 * @return String represent e-mail
 */
    public String getEmail() {
        return email;
    }
 /**
     * Function check correctness of date inserted into contact
     * @param check String that will be check
     * @throws OwnException exception displaying some message
     */
    public void validate(String check) throws OwnException 
     {
         matcher=pattern.matcher(check);
         if(!matcher.matches())// if String doesn't match to regex pattern exception will be served
             throw new OwnException();
     }
    
}
