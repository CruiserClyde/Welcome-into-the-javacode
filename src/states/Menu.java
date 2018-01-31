package states;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import main.Game;

public class Menu extends BasicGameState {
	
	protected UnicodeFont police1;
	protected static Music mus2;
	protected static Music mus3;
	protected int entrerjeu = 0;
	protected int entrercomm = 0; 
	protected int curseur = 100;
	protected Image decor;
	protected Image jouer;
	protected Image commande;
	protected int xjouer = 40;
	protected int yjouer = 100;
	protected int xcomm = 40;
	protected int ycomm = 200;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// INITIALISATION DU MENU
		
		mus2 = Game.musics[1];
		mus3 = Game.musics[2];
		decor = new Image("fondecran/javacode.png");
		jouer = new Image("fondecran/jouer.png");
		commande = new Image("fondecran/commandes.png");
		police1 = new UnicodeFont("police/tron.ttf",20,false,false);
		police1.addAsciiGlyphs();
		police1.getEffects().add(new ColorEffect());
		police1.loadGlyphs();
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// AFFICHAGE DU MENU
		
		decor.draw(0,0);
		jouer.draw(xjouer,yjouer);
		commande.draw(xcomm,ycomm);
		g.setColor(Color.white);
		police1.drawString(300,275,"Welcome into the javacode",Color.white);
		g.drawString("JOUER", xjouer + 100, yjouer + 35);
		g.drawString("COMMANDES",xcomm + 80,ycomm + 30);
		
		if(curseur == yjouer) {
			g.setColor(Color.green);
			g.drawString("JOUER", xjouer + 100, yjouer + 35);// on veut que la couleur change uniquement lorsque le curseur est sur le bon bouton
			g.setColor(Color.white);
		}
		else {
			if(curseur == ycomm) {
				g.setColor(Color.green);
				g.drawString("COMMANDES",xcomm + 80,ycomm + 30);
				g.setColor(Color.white);
			}
		}
		
	}
	

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// UPDATE DU MENU
		
		Input input = gc.getInput();
		if (input.isKeyPressed(Input.KEY_UP)){ // gestion de la fl�che du haut
			
			if(curseur <= yjouer) {
			curseur = yjouer;
			}else {curseur = curseur - 100;}
			
		}
		
		if (input.isKeyPressed(Input.KEY_DOWN)){ // gestion de la fl�che du bas
			
			if(curseur >=ycomm) {
			curseur = ycomm;
			}else {curseur = curseur + 100;}
			
		}
		
		if(input.isKeyPressed(Input.KEY_ENTER)) {
			
			if(curseur == yjouer) {
				entrerjeu = 1;
				sbg.enterState(1);
				mus3.play();
				mus3.loop();
				
			}else {
				
				if(curseur == ycomm) {
					entrercomm = 1;
					sbg.enterState(2);
					mus2.play();
					mus2.loop();
				}
			}
		
		}
		
		
	}

	@Override
	public int getID() {
		// Id du menu
		return 0;
	}

}
