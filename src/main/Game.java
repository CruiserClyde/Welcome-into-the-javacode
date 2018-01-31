package main;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import states.Commande;
import states.Etat;
import states.HyperEspace;
import states.Lose;
import states.Menu;
import states.Win;

public class Game extends StateBasedGame {
	
	public static Music[] musics;
	
	public Game(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		addState(new Menu());//on ajoute l'etat menu
		addState(new Etat());
		addState(new Commande());
		addState(new HyperEspace());
		addState(new Lose());
		addState(new Win());
		
		// remarque d�finit la musique pour tout les etats il faut faire mieux
		musics = new Music[5];
		musics[0] = new Music("Musique/musique1.ogg");// Peut poser des problèmes à l'import
		musics[1] = new Music("Musique/musique2.ogg");
		musics[2] = new Music("Musique/musiqueEtat.ogg");// Peut poser des problèmes à l'import
		musics[3] = new Music("Musique/perdre.ogg");
		musics[4] = new Music("Musique/SonHyperEsp.ogg");
	}
	
	@Override
	public void enterState(int id) {
		try {
			getState(id).init(getContainer(), this); //on initialise a chaque fois les etats suivants leurs id
		} catch (SlickException e) {
			e.printStackTrace();
		}
		super.enterState(id);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppGameContainer app;
		try{
			app  =new AppGameContainer(new Game("inside the javacode"));
			app.setDisplayMode(800, 600,false);
			app.setShowFPS(false);
			app.start();
			
		} catch(SlickException e) {
			e.printStackTrace();
		}
	}

}
