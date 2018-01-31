package ennemies;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import weapons.TirQuant;

public class FatalError extends Ennemy {

	protected Image FatalError;
	protected float Xenn ;
	protected float Yenn ;
	protected float VXenn = 100 ; 
	protected float VYenn; 
	protected float VYdefilement = 50;
	protected float degat;
	protected float vie = 30000;
	protected float vieOrigine = 30000;
	protected TirQuant missQuant;

	public FatalError() throws SlickException {
		missQuant = new TirQuant();
	}
	public  void chargerImage() throws SlickException{
		FatalError = new Image("spritesVaisseaux/FatalError.png");
	}
	public void afficher(Graphics g) {
		FatalError.draw(Xenn,Yenn);
	}
	public void afftir(Graphics g) {
		
		if(Yenn>0) {
		missQuant.affichMissileQ(g);
		}
		
	}
	
	public  void deplacement(int delta) {
		
			if(Yenn<0) {
			Yenn = Yenn + delta*VYdefilement/1000f;//On fait avancer le boss
			}
			
			if (Xenn >= -340 && Xenn<360 && Yenn >= 0 && Yenn <1) { 
				Xenn = Xenn + delta*VXenn/1000f;
			}
			if(Xenn >= 360 && Yenn >= 0 ) { 
				Yenn = 1;
			}
			if( Xenn >-340 && Yenn == 1 ) {	
				Xenn = Xenn - delta*VXenn/1000f;
			}
			if( Xenn <= -340 && Yenn == 1 ) {
				Xenn = -340;
				Yenn = 0;
			}	
	}
	
	public  void tir(GameContainer gc, StateBasedGame sbg, int delta) {
		
		if(Yenn>=0) {
		if(missQuant.getymissQ()>600) {
			missQuant.setxmissQ(Xenn +340 );
			missQuant.setymissQ(Yenn+35);
			}
			missQuant.avancer(gc, sbg, delta);
		}
	}
	
	public boolean hitbox(float xtir, float ytir) {
		
		if(xtir>Xenn) {
			if(xtir<Xenn + 800) {
				if(ytir>Yenn) {
					if(ytir<Yenn + 200) {
						return true;
					}
				}
			}
		}
		return false;		
	}
	
	public float getVieOrigine() {
		return vieOrigine;
	}
	public  float getvie() {
		return vie;
	}
	public  void setvie(float vie) {
		this.vie = vie;
	}
	public  void setXenn(float Xenn) {
		this.Xenn = Xenn;
	}
	public  void setYenn(float Yenn) {
		this.Yenn = Yenn;
	}
	public  float getXenn() {
		return(Xenn);
	}
	public  float getYenn() {
		return(Yenn);
	}
	
	// getteur et setteurs spéciaux
	
	public float getXennMiss() {
		return missQuant.getxmissQ();
	}
	public float getYennMiss() {
		return missQuant.getymissQ();
	}
	public float getEnnDegatmiss() {
		return missQuant.getDegatmissQ();	
	}
	

}