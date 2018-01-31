package specials;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Sacrifice {
	protected Image sacrifice;
	protected Image perso;
	protected int milieux = 400;//milieu de l'image de fond sur l'axe des x
	protected int milieuy = 300;//milieu de l'image de fond sur l'axe des y
	protected float x;
	protected float y;
	protected float[] rayon = {0,0,0,0,0,0,0,0,0,0};
	protected int lumiere = 0;
	
	public Sacrifice() throws SlickException {
		
		sacrifice = new Image("fondecran/vitesse.png");
		perso = new Image("spritesVaisseaux/TheEclipse.png");
	}
	public void afficher(Graphics g) {
		
		if(lumiere == 1) {
			g.drawImage(sacrifice,0,0);//affichage de l'image de fond
			g.setColor(Color.white);
			g.setLineWidth(2f);
			g.drawLine(milieux, milieuy, x, y);
			g.setColor(Color.blue);
			for(int i=0;i<rayon.length;i++) {
				g.drawOval(milieux-rayon[i],milieuy-rayon[i] ,2*rayon[i] ,2*rayon[i] );//affiche les 9 rayons
			}
			perso.draw(milieux-395*0.002f*rayon[0],milieuy-360*0.002f*rayon[0],0.002f*rayon[0]);// le premier rayon etant le plus long a arriver, on fait varier la taille du vaisseau sans depasser le premier cercle
			//0,002 a ete choisit arbitrairement il permet de limiter la taille de l'image du vaisseau
		}
		
		
	
	}
	
	public void animer(GameContainer gc, StateBasedGame sbg, int delta) {
		
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_SPACE)) {
			
			// Concernant les traits
			x = (float)Math.random()*(800);
			y = (float)Math.random()*(600);
			// Concernant les cercles
			for(int k=0;k<rayon.length;k++) {
				rayon[k] = (rayon[k]+(k+1)*0.1f);//on affecte à chaque update notre rayon + sa variation on met k+1 car sinon on a le premier rayon a 0 et il ne varie pas
				if (rayon[2]> 250) {
					rayon[2] = 450;
				}
				if (rayon[1]> 250) { //Ces trois conditions concernent les 3 derniers cercles afin de donner l'impression d'un impact
					rayon[1] = 400;
				}
				if (rayon[0]> 150) {
					rayon[0] = 350;
				}
			}
			lumiere = 1;
		}else {lumiere = 0;}

	
		
		
		

	}
	
	
}
