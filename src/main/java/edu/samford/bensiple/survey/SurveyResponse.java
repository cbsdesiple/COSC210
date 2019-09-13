
package edu.samford.bensiple.survey;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SurveyResponse {
// Attributes
    protected Answer[] answers;
    protected int numAnswers;
    
    public SurveyResponse(int size) {
    this.numAnswers = 0;
            this.answers = new Answer [size];
    }

    public void addAnswer(Answer answer) {
       answers[numAnswers++] = answer;
    }

    /**
     * Writes the survey response out answers to a file in this format
     * 7|I know this topic pretty well
     * 1|I have no idea what this is
     * 10|I have written a bunch of programs that use File I/O
     * @param fileName
     * @throws FileNotFoundException 
     */
    public void save(String fileName) throws FileNotFoundException {
        File f = new File(fileName);
        PrintWriter out = new PrintWriter(f);
        for (int i = 0; i < numAnswers; i++) {
            Answer answer = answers[i];
            out.println(answer.scaleResponse + "|" + answer.additionalResponse);
        }
        out.close();
    }
    
}
