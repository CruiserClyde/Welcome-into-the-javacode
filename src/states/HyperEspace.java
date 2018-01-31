package states;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class HyperEspace extends BasicGameState {

	protected Image hyperspace;
	protected Image perso;
	protected int milieux = 400;
	protected int milieuy = 300;
	protected float x;
	protected float y;
	protected float[] rayon = {0,0,0,0,0,0,0,0,0,0};
	
	public HyperEspace() throws SlickException {
		
	}
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// INIT HyperEspace
		
		hyperspace = new Image("fondecran/vitesse.png");
		perso = new Image("spritesVaisseaux/FatalError.png");
	}
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// AFFICHAGE HyperEspace
		
			g.drawImage(hyperspace,0,0);
			g.setColor(Color.white);
			g.setLineWidth(2f);
			g.drawLine(milieux, milieuy, x, y);
			g.setColor(Color.blue);
			for(int i=0;i<rayon.length;i++) {
				g.drawOval(milieux-rayon[i],milieuy-rayon[i] ,2*rayon[i] ,2*rayon[i] );
			}				   						
			perso.draw(milieux-400*0.003f*rayon[0],milieuy-100*0.003f*rayon[0],0.003f*rayon[0]);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// UPDATE HyperEspace
		
			// Concernant les traits
		
			x = (float)Math.random()*(800);
			y = (float)Math.random()*(600);
			
			// Concernant les cercles
			
			for(int k=0;k<rayon.length;k++) {
				rayon[k] = (rayon[k]+(k+1)*0.1f);  //on affecte à chaque update notre rayon + sa variation on met k+1 car sinon on a le premier rayon a 0 et il ne varie pas
				if (rayon[2]> 250) {
					rayon[2] = 450;
				}
				if (rayon[1]> 250) {      //Ces trois conditions concernent les 3 derniers cercles afin de donner l'impression d'un impact
					rayon[1] = 400;
				}
				if (rayon[0]> 150) {
					rayon[0] = 350;
					sbg.enterState(5);
				}
			}
	}

	@Override
	public int getID() {
		// NUM ID HyperEspace
		return 3;
	}

}
