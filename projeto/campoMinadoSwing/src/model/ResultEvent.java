package projeto.campoMinadoSwing.src.model;

public class ResultEvent {

    private final boolean won;

    public ResultEvent(boolean won) {
        this.won = won;
    }

    public boolean hasWon() {
        return won;
    }
    
}
