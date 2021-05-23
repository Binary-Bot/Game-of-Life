package life;

public class GoLController {
    private GoLView view;
    private GameLogic game;

    public GoLController(GoLView view, GameLogic game) {
        this.view = view;
        this.game = game;
        game.setUniverse(view.getCellViews());
        this.view.addController(this);
        this.game.addController(this);
    }

    public void update(Cell[][] universe, int genNum, int aliveCells) {
        view.setCellViews(universe);
        view.setGenerationNum(genNum);
        view.setAliveNum(aliveCells);
    }

    public void toggle(boolean state) {
        game.setRunning(state);
    }

    public void reset() {
        game.setNewUniverse();
    }
}
