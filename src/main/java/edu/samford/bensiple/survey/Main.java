package edu.samford.bensiple.survey;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author desip
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to COSC 210");
    //1. create the survey
    Survey survey = new Survey(9);
    
    //2. add all the questions to the survey
    survey.addQuestion("How familiar are you with NetBeans");
    survey.addQuestion("How well do you understand the difference between Classes, Objects, and Types");
    survey.addQuestion("How well do you understand creating and using methods?");
    survey.addQuestion("How well can you formulate mathamathical or logical questions? (ex. If statements)");
    survey.addQuestion("How famillar are you with control flow statements such as if, while, for, switch");
    survey.addQuestion("How famillar are you with Arrays?");
    survey.addQuestion("How good are you at reading from/writing to files?");
    survey.addQuestion("How famillar are you with the concept of packages?");
    survey.addQuestion("How comforatable are you with designing, coding, testing, and debugging software");
    
    
    //3. conduct the survey
    SurveyResponse response = survey.conduct();
    
    //4. write the survey results out to a file
    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now();
    String fileName = date + time.toString().replace(':', '_') + ".txt";
    
    
    response.save(fileName);
    
    
    }
    
}
