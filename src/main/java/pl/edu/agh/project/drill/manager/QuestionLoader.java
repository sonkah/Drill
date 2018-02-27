package pl.edu.agh.project.drill.manager;

import java.util.Collections;
import java.util.List;

import pl.edu.agh.project.drill.model.Answer;
import pl.edu.agh.project.drill.model.Question;

public class QuestionLoader extends Loader {

    public void setQuestions(List<Question> questions) {
        if(shufflingQuestions){
            Collections.shuffle(questions);
        }
        this.questions = questions;
    }


    public List<Answer> getAnswers() {
        if(shufflingAnswers){
            List<Answer> answers = currentQuestion.getAnswers();
            Collections.shuffle(answers);
            return answers;
        }
        else return currentQuestion.getAnswers();
    }
}
