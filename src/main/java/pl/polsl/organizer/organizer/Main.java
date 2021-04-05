/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.organizer.organizer;


import javax.swing.JFrame;
import pl.polsl.organizer.view.MainPanel;


/**
 * Main class in program, sets frame
 * @author Ewelina
 * version 1.0
 */
public class Main {
    /**
     * Main method creting new frame
     * @param args program call parameters 
     */
    public static void main(String args[])
    {   
        JFrame mainWindow= new JFrame("Organiser");// setting new frame 
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// frame will close after pressing cross
        mainWindow.setBounds(100, 100, 900, 600);// setting dimension of frame
        mainWindow.setContentPane(new MainPanel());  //setting pane in frame    
         mainWindow.setVisible(true);// frame will display
    }
    
}
