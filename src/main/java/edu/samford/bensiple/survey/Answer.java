package edu.samford.bensiple.survey;

import java.util.Scanner;

/**
 * represents an answer to a survey question
 *
 * @author desip
 */
public class Answer {

    // Attributes
    protected Question q; //reference to question being answered
    protected int scaleResponse;  //user enters selected response should be within q's range
    protected String addtionalResponse; //user comments

    /**
     * Convience constructor that provides some meaningful defaults
     */
    public Answer(Question q) {
        this.q = q;
        this.scaleResponse = scaleResponse;
        this.addtionalResponse = addtionalResponse;

    }

    /**
     * Retrieve the answer to the scale question from stdin ie the keyboard and
     * store that answer in the scaleResponse attribute.
     *
     * @param stdin
     */
    public void getScaleResponse(Scanner stdin) {
        // 1. get the user response for the scale prompt
        // 2. check therspons to make sure it is withing the question's range
        // 3. if not dispay error message and return to step one
        do {
            scaleResponse = Integer.parseInt(stdin.nextLine());
            if (!q.checkResponse(scaleResponse)) {
                System.out.println("Please try again.  Outside valid range.");
            }

        } while (!q.checkResponse(scaleResponse));
    }

    public void getSecondResponse(Scanner stdin) {
        addtionalResponse = stdin.nextLine(); 
    }


}
