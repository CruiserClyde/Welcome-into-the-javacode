package states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import main.Game;

public class Win extends BasicGameState {
	protected UnicodeFont police;
	protected Music retourMenu;
	public Win() {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// INIT
		
		retourMenu = Game.musics[0];
		police = new UnicodeFont("police/tron.ttf",15,false,false);
		police.addAsciiGlyphs();
		police.getEffects().add(new ColorEffect());
		police.loadGlyphs();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// RENDER
		g.setColor(Color.green);
		police.drawString(350,300,"BRAVO !!! VOUS AVEZ GAGNE",Color.green);
		police.drawString(50,450,"Appuyez sur entrer pour revenir au menu principal",Color.green);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// UPDATE
		
		Input input = gc.getInput();
		if (input.isKeyPressed(Input.KEY_ENTER)){
			sbg.enterState(0);
			retourMenu.play();
		}
	}

	@Override
	public int getID() {
		// ID
		return 5;
	}

}
