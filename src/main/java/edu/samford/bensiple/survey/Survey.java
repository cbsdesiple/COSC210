package edu.samford.bensiple.survey;

import java.util.Scanner;

/**
 * Represents a survey of questions.
 *
 * @author desip
 */
public class Survey {

    //Attributes
    protected Question[] questions;
    protected int numQuestions;

    //contructors
    public Survey() {
        this(10);//defaults to a survey with room for 10 questions
    }

    public Survey(int size) {
        this.numQuestions = 0;
        questions = new Question[size];
    }

    /**
     * Adds a new question to our array of questions using the given prompt and
     * all other defaults for a question
     *
     * @param Prompt
     */
    public void addQuestion(String prompt) {
        //1. Create the question
        Question q = new Question(prompt);

        //2. Add the question to the end of our array
        questions[numQuestions++] = q;

    }

    /**
     * Ask all the questions in the survey gets all the answers Puts all the
     * answers into a new SurveyResponse object with all the answers
     *
     * @return
     */
    public SurveyResponse conduct() {
        //1. Create the new empy Survey Response
        SurveyResponse response = new SurveyResponse(this.questions.length); //2.  Repeate the following
        //1.5 Go ahead and create the scanner object we will use to get the answer
        Scanner stdin = new Scanner(System.in);
        //   a. Ask the Question
        //   b. Get both responses 
        //   c. Add the answer to the Survey Response
        for (int i = 0; i < numQuestions; i++) {
            Question question = questions[i];
            question.display();
            Answer answer = new Answer(question);
            answer.getScaleResponse(stdin);
            question.displaySecond();
            answer.getSecondResponse(stdin);
            response.addAnswer(answer);
        }
            //3. Return the now completed Survey Response
            return response;
        

    }
}
