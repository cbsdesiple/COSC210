
package edu.samford.bensiple.survey;
/**
 * Represents a question in our survey
 * @author desiple
 */

public class Question {
//attributes
    protected String prompt;        //The message displayed to the user whent he question is asked
    protected int minScale;         //The minimum repsonse valuse inclusive
    protected int maxScale;         //The maximum response value inclusive
    protected String secondPrompt;  //The prompt in from of the open ended section of the question
//constructor
    /**
     * Initialize to some meaningful defaults
     */
public Question() {
    prompt = "Please say something.";
    minScale = 1;
    maxScale = 2;
    secondPrompt = "Additional comments:";
}    

/**
 * Use the given prompt with all other default attributes
*/
public Question (String prompt){
    this();
    this.prompt = prompt;
    }
/**
 * Constructs a questions with these specific attributes
 * 
 */

public Question (String prompt, int minScale, int maxScale, String secondPrompt){
    this.prompt = prompt;
    this.minScale = minScale;
    this.maxScale = maxScale;
    this.secondPrompt = secondPrompt;

}
/**
* displays the prompt for the main question
*/
public void display (){
    System.out.println(prompt + " (" + minScale + "-" + maxScale + ")");
}

public void displaySecond (){
    System.out.println(secondPrompt);
}
}
