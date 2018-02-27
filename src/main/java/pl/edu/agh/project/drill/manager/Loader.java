package pl.edu.agh.project.drill.manager;

import pl.edu.agh.project.drill.model.Answer;
import pl.edu.agh.project.drill.model.Question;

import java.util.List;

public abstract class Loader implements Iterator {
    protected Question currentQuestion;
    private int questionPointer = -1; // wskazanie na obecnie przetwarzany question
    protected List<Question> questions;

    protected boolean shufflingAnswers;
    protected boolean shufflingQuestions;
    protected boolean replayingQuestions;

    public abstract void setQuestions(List<Question> questions);
    public abstract List<Answer> getAnswers();

    public void setOptions(boolean sa, boolean sq, boolean rq){
        this.shufflingAnswers = sa;
        this.shufflingQuestions = sq;
        this.replayingQuestions = rq;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    @Override
    public void next() {
        currentQuestion = questions.get(++questionPointer);
    }

    @Override
    public boolean hasNext(){
        return (questions.size() > this.questionPointer + 1);
    }
}
