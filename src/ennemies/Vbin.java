package ennemies;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import weapons.Binrouge;

public class Vbin extends Ennemy {
	protected Image vbin;
	protected float Xenn;
	protected float Yenn;
	protected float VXenn = 200 ; 
	protected float VYenn; 
	protected float VYdefilement = 50;
	protected float degat;
	protected float vie = 200;
	protected float vieOrigine = 200;
	protected Binrouge missBR;
	
	
	public Vbin() throws SlickException {
		missBR = new Binrouge();
	}
	
	public  void chargerImage() throws SlickException{
		vbin = new Image("spritesVaisseaux/ennemi3.png");
	}
	public void afficher(Graphics g) {
		vbin.draw(Xenn,Yenn);
	}
	public void afftir(Graphics g) {
		if(Yenn>0){
		missBR.affichMissileBR(g);
		}
	}
	
	public  void deplacement(int delta) {
		Yenn = Yenn + VYdefilement/1000f;
			
	}
	
	public  void tir(GameContainer gc, StateBasedGame sbg, int delta) {
		
		if(missBR.getxmissBR()>800) {
			missBR.setxmissBR(Xenn +85 );
			missBR.setymissBR(Yenn+20);
	}
		missBR.avancer(gc, sbg, delta);
		
	}
	
	public boolean hitbox(float xtir, float ytir) {
		
		if(xtir>Xenn) {
			if(xtir<Xenn + 90) {
				if(ytir>Yenn) {
					if(ytir<Yenn + 58) {
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
		return missBR.getxmissBR();
	}
	public float getYennMiss() {
		return missBR.getymissBR();
	}
	public float getEnnDegatmiss() {
		return missBR.getDegatmissBR();	
	}

}
