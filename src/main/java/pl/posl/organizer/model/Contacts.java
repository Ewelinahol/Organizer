/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.posl.organizer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Class storer list of contact
 * @author Ewelina
 * @version 2.0
 */
public class Contacts {
    private List<Contact>contacts;
/**
 * Default contructor
 */
    public Contacts() {
        this.contacts = new ArrayList<>();
    }
/**
 * Function returning contact list
 * @return list of contact
 */
    public List<Contact> getContacts() {
        return contacts;
    }
    /**
     * Function adding new contact to list
     * @param contact object added to list
     */
    public void add(Contact contact)
    {
        this.contacts.add(contact);
    }
    /**
     * Function removing specifying element of list
     * @param contact object removed from list
     */
    public void deleteContact(Contact contact)
    {
        this.contacts.remove(contact);
    }
    /**
     * Function returning single contact from specifying place of list
     * @param index index of single contact
     * @return contact from list
     */
    public Contact getContact(int index)
    {
        return contacts.get(index);
    }
    /**
     * Function returning number of element in list
     * @return size of contacts list
     */
    public int size()
    {
        return contacts.size();
    }
    /**
     * Function for searching contact by phone number
     * @param number integer representing phone number by which function search contact
     * @return new list which contains filtrated contact
     */
     public List<Contact> search(int number)
     {
         List<Contact> temp=new ArrayList<>();
        contacts.stream()//stream 
                .filter(g->g.getTelephone()==number)// filtration condition
                .forEach(temp::add);//adding contact to list
        
        return temp;
        
     }
}
