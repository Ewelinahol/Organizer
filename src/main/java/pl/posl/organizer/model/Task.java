/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.posl.organizer.model;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class storer details of single task
 * @author Ewelina
 * @version 2.0
 */
public class Task {
    private String startTime;
    private String endTime;
    private String startDate;
    private String endDate;
    private String description;
    private static String regex="^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$" 
      + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
      + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$" 
      + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$";// string representing correct regex for date format
    private static Pattern pattern=Pattern.compile(regex);
    private Matcher matcher;
    /**
     * Constructor with parameters
     * @param startTime String representing start time of task
     * @param endTime  String representing end time of task
     * @param startDate String representing start date of task
     * @param endDate String representing end date of task
     * @param description String representing descritpion of task
     */
    
     public Task(String description, String startDate, String endDate, String startTime, String endTime) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
         try{
              this.validate(startDate);// chceck if date String is in correct format
        }catch(OwnException e)// if not catch exception
        {
           e.getMessage();
            return;// this uncorrect value doesn't be inserted into single task
        }
          try{
              this.validate(endDate);// chceck if date String is in correct format
        }catch(OwnException e)// if not catch exception
        {
           e.getMessage();
            return;// this uncorrect value doesn't be inserted into single task
        } 
        this.startDate=startDate;
        this.endDate = endDate;
       
    }
/**
 * Default contructor
 */
    public Task() {
        this.startTime = "";
        this.endTime = "";
        this.startDate = "";
        this.endDate = "";
        this.description ="" ;
  }
/**
 * Function setting start time of task
 * @param startTime String representing start time
 * 
 */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
/**
 * Function setting end time of task
 * @param endTime String representing end time
 */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
/**
 * Function setting start date of task 
 * @param startDate String representing start date
 */  
    public void setStartDate(String startDate) {
       try{
              this.validate(startDate);// chceck if date String is in correct format
        }catch(OwnException e)// if not catch exception
        {
           e.getMessage();
            return;// this uncorrect value doesn't be inserted into single task
        }
            this.startDate=startDate;
    }
/**
 * Function setting end date of task 
 * @param endDate String representing end date
 */
    public void setEndDate(String endDate) {
         try{
              this.validate(endDate);
        }catch(OwnException e)
        {
           e.getMessage();
            return;
        }
        this.endDate = endDate;
    }
/**
 * Function setting description of task 
 * @param description String representing task description
 */
    public void setDescription(String description) {
        this.description = description;
    }
/**
 * Function getting start time of task 
 * @return startTime String representing start time
 */
    public String getStartTime() {
        return startTime;
    }
/**
 * Function getting end time of task 
 * @return endTime String representing end time
 */
    public String getEndTime() {
        return endTime;
    }
/**
 *  Function getting start date of task 
 * @return startDate String representing start time
 */
    public String getStartDate() {
        return startDate;
    }
/**
 * Function getting end date of task 
 * @return endDate String representing end time
 */
    public String getEndDate() {
        return endDate;
    }
/**
 * Function getting description of task 
 * @return description 
 */
    public String getContents() {
        return description;
    }
    /**
     * Function check correctness of date inserted into task
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
