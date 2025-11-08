package me.nrz.design_patterns._03_behavioral_patterns._14_command._02_after;


import me.nrz.design_patterns._03_behavioral_patterns._14_command._01_before.Game;

public class GameStartCommand implements Command {

    private Game game;

    public GameStartCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.start();
    }

    @Override
    public void undo() {
        new GameEndCommand(this.game).execute();
    }
}
