package ennemies;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
public abstract class Ennemy {
	
	// Methodes communes à toutes les classes filles
	
	public Ennemy() throws SlickException {
		chargerImage(); //On charge l'image de l'ennemi
	}
	public abstract void afficher(Graphics g); 
	
	
	public abstract void chargerImage() throws SlickException; //sera definie dans la classe fille
	public abstract void deplacement(int delta);
	public abstract void tir(GameContainer gc, StateBasedGame sbg, int delta);
	public abstract void afftir(Graphics g);
	public abstract float getvie();
	public abstract void setvie(float f);
	public abstract float getVieOrigine();
	public abstract void setXenn(float Xvvoid);
	public abstract void setYenn(float Yvvoid);
	public abstract float getXenn();
	public abstract float getYenn();
	public abstract boolean hitbox(float xtir, float ytir);
	

	public abstract float getXennMiss();
	public abstract float getYennMiss();
	public abstract float getEnnDegatmiss(); 
	

}
