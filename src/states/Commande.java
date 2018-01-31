package states;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

public class Commande extends BasicGameState {
	
	protected Image engrenage1;
	protected Image engrenage2;
	protected Image engrenage3;
	protected Image fondcommande;
	protected Image horizontal;
	protected Image vertical;
	protected Image ech;
	protected Image valider;
	protected Image T;
	protected Image spaceb;
	protected UnicodeFont police1;
	protected UnicodeFont police2;
	
	public Commande() {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// INITIALISTAION
		police1 = new UnicodeFont("police/tron.ttf",50,false,false);
		police1.addAsciiGlyphs();
		police1.getEffects().add(new ColorEffect());
		police1.loadGlyphs();
		
		police2 = new UnicodeFont("police/tron.ttf",16,false,true);
		police2.addAsciiGlyphs();
		police2.getEffects().add(new ColorEffect());
		police2.loadGlyphs();
		
		engrenage1 = new Image("spritesComm/eng1.png");
		engrenage2 = new Image("spritesComm/eng2.png");
		engrenage3 = new Image("spritesComm/eng2.png");
		fondcommande = new Image("fondecran/fondcom.png");
		horizontal = new Image("spritesComm/droitegauche.png");
		vertical = new Image("spritesComm/hautbas.png");
		ech = new Image("spritesComm/echap.png");
		valider = new Image("spritesComm/entrer.png");
		T = new Image("spritesComm/T.png");
		spaceb = new Image("spritesComm/spacebar.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// RENDER
		fondcommande.draw(0,0);
		horizontal.draw(0,15,0.5f);
		vertical.draw(50,150,0.5f);
		ech.draw(45,260,0.1f);
		valider.draw(50,350,0.5f);
		T.draw(50,450,1.1f);
		spaceb.draw(50,525);
		engrenage1.draw(400,300);
		engrenage2.draw(650,-10);
		engrenage3.draw(60,-10);
		
		police1.drawString(150,-20,"COMMANDES",Color.blue);
		police2.drawString(200 ,90,"--Deplacement lateral du vaisseau--",Color.red );
		police2.drawString(200 ,190,"--Deplacement dans le menu--",Color.red );
		police2.drawString(200 ,285,"--Revenir au menu principal--",Color.red );
		police2.drawString(200 ,380,"--Valider--",Color.red );
		police2.drawString(200 ,460,"--Tirer--",Color.red );
		police2.drawString(320 ,530,"--Hyper espace--",Color.red );
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int g) throws SlickException {
		// UPDATE
		Input input = gc.getInput();
		if(input.isKeyPressed(Input.KEY_ESCAPE)) { //pour revenir au menu principal
			sbg.enterState(0);
		}
		engrenage1.rotate(5);
		engrenage2.rotate(5);
		engrenage3.rotate(5);

	}

	@Override
	public int getID() {
		// ID
		return 2;
	}

}
