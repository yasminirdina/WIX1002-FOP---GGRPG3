package ggrpg3.states;

import java.awt.Graphics;

import ggrpg3.Game;
import ggrpg3.GetEverything;


public abstract class State {

	private static State currentState = null;
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	//CLASS
	
	protected GetEverything everything;
	
	public State(GetEverything everything){
		this.everything = everything;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
