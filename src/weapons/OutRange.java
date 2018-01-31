package weapons;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class OutRange extends Missiles{
	private float degat = 5/100f;
	protected float xmissOutR;
	protected float ymissOutR;
	protected float vxmissOutR;
	protected float vymissOutR = 300;
	protected Image OutR;
	

	public OutRange() throws SlickException{
		
		chargImageMiss(); //On charge l'image du missile
	}

	public void chargImageMiss() throws SlickException {
		OutR = new Image("armes/OutOfRange.png");
	}
	
	public void affichMissileOutRange(Graphics g) {
		OutR.draw(xmissOutR,ymissOutR);
	}

	public void avancer(GameContainer gc, StateBasedGame sbg, int delta) {
		
		ymissOutR = ymissOutR + delta*vymissOutR/1000f;
		
	}
	
	public void setxmissOutR(float xmissOutR) {
		this.xmissOutR = xmissOutR;
	}
	public void setymissOutR(float ymissOutR) {
		this.ymissOutR = ymissOutR;
	}
	public float getymissOutR() {
		return(ymissOutR);
	}
	public float getxmissOutR() {
		return(xmissOutR);
	}
	public float getDegatmissOutR() {
		return(degat);
	}




}
