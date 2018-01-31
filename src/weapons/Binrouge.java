package weapons;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Binrouge extends Missiles {
	
	private float degat = 0.1f;
	protected float xmissBR;
	protected float ymissBR;
	protected float vxmissBR = 200;
	protected float vymissBR ;
	protected Image Binrouge;
	
	public Binrouge() throws SlickException {
		chargImageMiss();
	}
	public void chargImageMiss() throws SlickException {
		Binrouge = new Image("armes/binrouge.png");
	}
	public void affichMissileBR(Graphics g) {
		Binrouge.draw(xmissBR,ymissBR);
	}
	public void avancer(GameContainer gc, StateBasedGame sbg, int delta) {
		xmissBR = xmissBR + delta*vxmissBR/1000f;
	}
	
	public void setxmissBR(float xmissBR) {
		this.xmissBR = xmissBR;
	}
	public void setymissBR(float ymissBR) {
		this.ymissBR = ymissBR;
	}
	public float getymissBR() {
		return(ymissBR);
	}
	public float getxmissBR() {
		return(xmissBR);
	}
	public float getDegatmissBR() {
		return(degat);
	}

}
