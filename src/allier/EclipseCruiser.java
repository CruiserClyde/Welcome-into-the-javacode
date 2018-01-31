package allier;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import weapons.Binaire0;
import weapons.Binaire1;

public class EclipseCruiser {
	
	protected Image vaisseau; 
	protected float xvaiss ;
	protected float yvaiss = 528;//ne change jamais
	protected float vxvaiss;
	protected float pv = 300;
	protected float pvOrigine = 300;

	protected Binaire0 bin0; //arme 0
	protected Binaire1 bin1; //arme 1
	
	protected int veriftir ;
	
	public EclipseCruiser() throws SlickException {
		vaisseau = new Image("spritesVaisseaux/TheEclipse.png");
	
		bin0 = new Binaire0();
		bin1 = new Binaire1();               //chargement de l'arme 
		bin1.setxmiss1(xvaiss + 380 + 22 );  // le 22 eme pixel  du vaisseau est la position de depart du missile 1
		bin1.setymiss1(yvaiss - 10);
		
	}
	public void affvaisseau(Graphics g) {
		vaisseau.draw(xvaiss+380,yvaiss,0.1f);
		
	}
	public void afftir(Graphics g) {
		
			bin0.affichMissile0(g);
			bin1.affichMissile1(g);
	}
	
	public void deplvaisseau(GameContainer gc, StateBasedGame sbg, int delta) {
		
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_LEFT) && xvaiss>-380)xvaiss--;
		if(input.isKeyDown(Input.KEY_RIGHT) && xvaiss<341) xvaiss++;
	}
	public  void tirer(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_T) ) {
						
					if(bin0.getymiss0()<0) { 
						
						bin0.setxmiss0(xvaiss + 380 + 47 );
						bin0.setymiss0(yvaiss-10);
					}
				
					if(bin1.getymiss1()<0) { 
						bin1.setxmiss1(xvaiss + 380 + 22 );
						bin1.setymiss1(yvaiss-10);
				}
		}
	
		bin0.avancer(gc, sbg, delta);
		bin1.avancer(gc,sbg,delta);	
	}

	public boolean hitbox(float xtir, float ytir) {// les coordonnées du tir du vaisseau
		if(xtir>xvaiss+380) {
			if(xtir<xvaiss+380+79.1f) {
				if(ytir>yvaiss) {
					if(ytir<yvaiss + 72) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void score() {
		
	}
	public float getpv() {
		return pv;
	}
	public float getPvOrigine() {
		return pvOrigine;
	}
	public void setpv(float pv) {
		this.pv = pv;
	}
	public float getXcruisermiss0(){
			return bin0.getxmiss0();
	}
	public float getYcruisermiss0() {
		return bin0.getymiss0();
	}
	public float getXcruisermiss1(){
		return bin1.getxmiss1();
	}
	public float getYcruisermiss1() {
		return bin1.getymiss1();
	}
	public float getCruiserDegatmiss0() {
		return bin0.getDegatmiss0();
	}
	public float getCruiserDegatmiss1() {
		return bin1.getDegatmiss1();
	}
	public void setCruiseraZeroVymiss0() {
		 bin0.setaZeroVymiss0();
	}
	
	
}
