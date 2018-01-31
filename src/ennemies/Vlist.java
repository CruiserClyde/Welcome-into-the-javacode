package ennemies;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import weapons.OutRange;

public class Vlist extends Ennemy {
	
	protected Image vlist;
	protected float Xenn ;
	protected float Yenn ;
	protected float VXenn = 200 ; 
	protected float VYenn;
	protected float VYdefilement = 50;
	protected float degat;
	protected float vie = 150;
	protected float vieOrigine = 150;
	protected OutRange missOut;
	
	public Vlist() throws SlickException {
		// TODO Auto-generated constructor stub
		missOut = new OutRange();
		
	}
	public  void chargerImage() throws SlickException{
		vlist = new Image("spritesVaisseaux/ennemi2.png");
	}
	public void afficher(Graphics g) {
		vlist.draw(Xenn,Yenn);
	}
	public void afftir(Graphics g) {
		if(Yenn>0) {
		missOut.affichMissileOutRange(g);
		}
	}
	
	public  void deplacement(int delta) {
			
			if( Yenn<0) {
				Yenn = Yenn + VYdefilement*delta/1000f;
			}
			if(Yenn<0 && Yenn>-1) {
				Yenn = 0;
			}
			
			if (Xenn<0) {
				Xenn = 0;
			}
			
			if (Xenn >= 0 && Xenn<740 && Yenn >= 0 && Yenn <1) {
				VYenn = 0;
				Xenn = Xenn + delta*VXenn/1000f;
			}
			
			if(Xenn >= 740 && Xenn>0 && Yenn<200 ) {
				VYenn = 200;
				Yenn = Yenn + delta*VYenn/1000f;
			}
			
			if( Xenn >0 && Yenn >= 200 ) {	
				VYenn = 0;
				Xenn = Xenn - delta*VXenn/1000f;
			}
			if( Xenn <= 0 && Yenn >= 0 ) {	
				VYenn = 200;
				Yenn = Yenn - delta*VYenn/1000f;
				
			}
			
			
	}
	public  void tir(GameContainer gc, StateBasedGame sbg, int delta) {
		
		if(Yenn>=0) {
		
		if(missOut.getymissOutR()>600) {//condition de tir
			missOut.setxmissOutR(Xenn +28 );
			missOut.setymissOutR(Yenn+85);
		}
		missOut.avancer(gc, sbg, delta);
		}	
	}
	public  void vie() {
		
	}
	
	public boolean hitbox(float xtir, float ytir) {
		if(xtir>Xenn) {
			if(xtir<Xenn + 60) {
				if(ytir>Yenn) {
					if(ytir<Yenn + 83) {
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
		return missOut.getxmissOutR();
	}
	public float getYennMiss() {
		return missOut.getymissOutR();
	}
	public float getEnnDegatmiss() {
		return missOut.getDegatmissOutR();	
	}
	
}
