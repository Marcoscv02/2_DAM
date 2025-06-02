package marcos.psp.examen.trivialQuiz.model.report;

import marcos.psp.examen.trivialQuiz.model.Result;

public class QuestionReport {
    private Result question;
    private Boolean acertada;

    public QuestionReport() {
    }

    public QuestionReport(Result question, Boolean acertada) {
        this.question = question;
        this.acertada = acertada;
    }

    public Result getQuestion() {
        return question;
    }

    public void setQuestion(Result question) {
        this.question = question;
    }

    public Boolean getAcertada() {
        return acertada;
    }

    public void setAcertada(Boolean acertada) {
        this.acertada = acertada;
    }
}
