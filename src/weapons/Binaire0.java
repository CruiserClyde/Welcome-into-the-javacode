package weapons;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Binaire0 extends Missiles {
	private float degat0 = 15/100f;
	protected Image zero;
	protected float xmiss0;
	protected float ymiss0;
	protected float vxmiss0;
	protected float vymiss0 = 1400;// valeur arbitraire

	public Binaire0() throws SlickException {
		chargImageMiss(); // on charge l'image du missile
	}
	public void chargImageMiss() throws SlickException {
		zero = new Image("armes/zero.png");
	}
	
	public void affichMissile0(Graphics g) {
		zero.draw(xmiss0,ymiss0);
	}	
	
	public void avancer(GameContainer gc, StateBasedGame sbg, int delta) {
		ymiss0 = ymiss0 - delta*vymiss0/1000f;
	}
	
	public void setxmiss0(float xmiss0) {
		this.xmiss0 = xmiss0;
	}
	public void setymiss0(float ymiss0) {
		this.ymiss0 = ymiss0;
	}
	public float getymiss0() {
		return(ymiss0);
	}
	public float getxmiss0() {
		return(xmiss0);
	}
	public float getDegatmiss0() {
		return(degat0);
	}
	public void setaZeroVymiss0() {
		this.vymiss0 = 0;
	}
	
	
	
	

}
