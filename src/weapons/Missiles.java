package weapons;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Missiles {
	
	
	public Missiles() throws SlickException{
		chargImageMiss();
	}
	
	public abstract void chargImageMiss() throws SlickException;
	public abstract void avancer(GameContainer gc, StateBasedGame sbg, int delta);
	
}

