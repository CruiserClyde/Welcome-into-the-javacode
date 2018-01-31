package weapons;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class TirQuant extends Missiles {
	
	private float degat = 0.5f;// très gros dégats
	protected float xmissQ;
	protected float ymissQ;
	protected float vxmissQ;
	protected float vymissQ = 400;// Un peu plus lent que les autres
	protected Image Quant;

	public TirQuant() throws SlickException {
	
		chargImageMiss(); //On charge l'image du missile
	}
	
	
	public void chargImageMiss() throws SlickException {
		Quant = new Image("armes/tirQuantique.png");
	}
	
	public void affichMissileQ(Graphics g) {
		Quant.draw(xmissQ,ymissQ);
	}

	public void avancer(GameContainer gc, StateBasedGame sbg, int delta) {
		
		ymissQ = ymissQ + delta*vymissQ/1000f;
		Quant.rotate(11);
		
	}
	
	
	public void setxmissQ(float xmissQ) {
		this.xmissQ = xmissQ;
	}
	public void setymissQ(float ymissQ) {
		this.ymissQ = ymissQ;
	}
	public float getymissQ() {
		return(ymissQ);
	}
	public float getxmissQ() {
		return(xmissQ);
	}
	public float getDegatmissQ() {
		return(degat);
	}

}
