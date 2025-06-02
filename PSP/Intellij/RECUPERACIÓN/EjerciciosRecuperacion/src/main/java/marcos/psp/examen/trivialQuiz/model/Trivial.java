package marcos.psp.examen.trivialQuiz.model;

import java.util.List;

public class Trivial {
    private Integer resposeCode;
    private List<Result>questions;


    public Trivial() {
    }
    public Trivial(Integer resposeCode, List<Result> questions) {
        this.resposeCode = resposeCode;
        this.questions = questions;
    }


    public Integer getResposeCode() {
        return resposeCode;
    }
    public void setResposeCode(Integer resposeCode) {
        this.resposeCode = resposeCode;
    }


    public List<Result> getQuestions() {
        return questions;
    }
    public void setQuestions(List<Result> questions) {
        this.questions = questions;
    }


    @Override
    public String toString() {
        return "Trivial{" +
                "resposeCode:" + resposeCode +"\n"+
                "questions\n\t" + questions + "\n";
    }
}
