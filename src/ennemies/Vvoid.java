package ennemies;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Vvoid extends Ennemy{
	
	protected Image vvoid;
	protected float hasard;
	protected int choisithasard;
	protected float Xenn ;
	protected float Yenn ;
	protected float VXenn = 2000;
	protected float VYenn; //ils vont tous a une vitesse comprise entre 10 et 80 qui varie a chaque update
	protected float VYdefilement = 50;
	protected float degat;
	protected float vie = 75;
	protected float vieOrigine = 75;
	
	public Vvoid() throws SlickException {
		
	}
	
	public  void chargerImage() throws SlickException{
		vvoid = new Image("spritesVaisseaux/ennemi1mod.png");	
	}
	
	public void afficher(Graphics g){
		vvoid.draw(Xenn,Yenn);  
	}
	
	public  void deplacement(int delta) {
		VYenn = (float)(10+Math.random()*(20)) + VYdefilement;
		hasard = (float)Math.random()*(2);
		if (hasard>1) {
			choisithasard = 1;
		}else {choisithasard = 0;}
				
		if(choisithasard == 1) {
			if (Xenn < 680) Xenn = Xenn + delta*VXenn/1000f;		//le vaisseau ne doit pas sortir de l'écran
				
		}else {
		if(choisithasard == 0){
			if(Xenn>-5) Xenn = Xenn - delta*VXenn/1000f;
			}
		}
		vvoid.rotate(0.5f);
		Yenn = Yenn + delta*VYenn/1000f;
	}
	
	public  void tir(GameContainer gc, StateBasedGame sbg, int delta) {
	}
	public void afftir(Graphics g) {
		
	}
	
	
	public  float getVieOrigine() {
		return vieOrigine;
	}
	
	public boolean hitbox(float xtir, float ytir) {// les coordonnées du tir du vaisseau
		
		if(xtir>Xenn) {
			if(xtir<Xenn + 120) {
				if(ytir>Yenn) {
					if(ytir<Yenn + 120) {
						return true;
					}
				}
			}
		}
		return false;
		
	}
	
	public float getvie() {
		return vie;
	}
	public void setvie(float vie) {
		this.vie = vie;
	}
	public void setXenn(float Xenn) {
		this.Xenn = Xenn;
	}
	public void setYenn(float Yenn) {
		this.Yenn = Yenn;
	}
	public float getXenn() {
		return(Xenn);
	}
	public float getYenn() {
		return(Yenn);
	}

	@Override
	public float getXennMiss() {
		
		return 0;
	}

	@Override
	public float getYennMiss() {
		
		return 0;
	}

	@Override
	public float getEnnDegatmiss() {
		
		return 0;
	}

	

	


}
