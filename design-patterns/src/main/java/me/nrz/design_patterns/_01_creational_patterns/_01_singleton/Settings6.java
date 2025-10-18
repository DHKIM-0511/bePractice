package me.nrz.design_patterns._01_creational_patterns._01_singleton;

public enum Settings6 {
    INSTANCE;

    private int number;

    public int getNumber(){
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
