package edu.samford.bensiple.survey;

import java.io.FileNotFoundException;

/**
 * This program depends on the order of the answers being know.
 *
 * @author desip
 */
public class MainResponses {

    public static void main(String[] args) throws FileNotFoundException {
        //1. Create the Survey and add all the questions.
        Survey survey = new Survey(9);
        survey.addQuestion("How familiar are you with NetBeans");
    survey.addQuestion("How well do you understand the difference between Classes, Objects, and Types");
    survey.addQuestion("How well do you understand creating and using methods?");
    survey.addQuestion("How well can you formulate mathamathical or logical questions? (ex. If statements)");
    survey.addQuestion("How famillar are you with control flow statements such as if, while, for, switch");
    survey.addQuestion("How famillar are you with Arrays?");
    survey.addQuestion("How good are you at reading from/writing to files?");
    survey.addQuestion("How famillar are you with the concept of packages?");
    survey.addQuestion("How comforatable are you with designing, coding, testing, and debugging software");
        //2. create and empty survey results object
SurveyResults results = new SurveyResults(survey);        
//3. Loop through the directory containing all the responses and read each on into their own survey response object
        //(also add the survey results to Survey Response
        //this is done internally
        
        results.readResponses("results");
        results.processResponses();
    }

}
