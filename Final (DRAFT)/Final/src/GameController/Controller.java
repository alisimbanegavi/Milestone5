package GameController;

import GameModel.Action;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    List<Observer> observers;

    public Controller(){
        observers = new ArrayList<>();
    }

    public void attach(Observer observer){observers.add(observer);}

    public void promptAction(){

    }

    public boolean validate(Action act){}

    public void execute(Action act){
        notifyObservers();
    }

    public void notifyObservers(){}
}
