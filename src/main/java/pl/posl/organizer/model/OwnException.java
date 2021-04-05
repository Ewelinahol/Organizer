/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.posl.organizer.model;

/**
 * Class handling exception 
 * @author Ewelina
 * verion 1.0
 */
public class OwnException extends Exception{
/**
 * Default constructor
 */
    public OwnException() {
    }
/**
 * Function displaying exception message
 * @param message 
 */
    public OwnException(String message) {
        super(message);
    }
    
}
