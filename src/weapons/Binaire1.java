package weapons;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Binaire1 extends Missiles {
	private float degat1 = 30/100f;
	protected float xmiss1;
	protected float ymiss1;
	protected float vxmiss1;
	protected float vymiss1 = 1400;
	protected Image un;

	public Binaire1() throws SlickException {
		chargImageMiss(); //On charge l'image du missile
	}
	
	public void chargImageMiss() throws SlickException {
		un = new Image("armes/un.png");
	}
	
	public void affichMissile1(Graphics g) {
		un.draw(xmiss1,ymiss1);
	}

	public void avancer(GameContainer gc, StateBasedGame sbg, int delta) {
		
		ymiss1 = ymiss1 - delta*vymiss1/1000f;
	}
	
	public void setxmiss1(float xmiss1) {
		this.xmiss1 = xmiss1;
	}
	public void setymiss1(float ymiss1) {
		this.ymiss1 = ymiss1;
	}
	public float getymiss1() {
		return(ymiss1);
	}
	public float getxmiss1() {
		return(xmiss1);
	}
	public float getDegatmiss1() {
		return(degat1);
		
	}

	
	
	
	

}