package states;
import java.util.ArrayList;
import java.util.Arrays;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import allier.EclipseCruiser;
import ennemies.Ennemy;
import ennemies.FatalError;
import ennemies.Vbin;
import ennemies.Vlist;
import ennemies.Vvoid;
import main.Game;

@SuppressWarnings("unused")
public class Etat extends BasicGameState {
	
	protected   Music musorigine;
	protected   Music HypEsp;
	protected   Music Perdre;
	protected Image carte;
	protected Image SpriteVie;
	protected Image SpriteHyperEsp;
	
	protected int CptVieJoueur = 3;
	
	protected float ScoreVvoid = 0;
	protected float ScoreVlist = 0;
	protected float ScoreVbin = 0;
	protected float ScoreBoss = 0;
	protected float Score = 0;
	protected boolean Droit; // droit de passer en hyperespace
	
	protected Ennemy fantome7; //vlist
	protected Ennemy fantome8; //vbin
	protected Ennemy fantome9; //vvoid
	protected Ennemy fantome10; //boss
	
	protected Ennemy enn1;//vvoid
	protected Ennemy enn2;//vvoid
	protected Ennemy enn3;//vvoid
	protected Ennemy enn4;//vvoid
	protected Ennemy enn5;//vvoid
	protected Ennemy enn6;//vvoid
	
	protected Ennemy enn7;//vlist
	protected Ennemy enn8;//vlist
	protected Ennemy enn9;//vlist
	protected Ennemy enn10;//vlist
	protected Ennemy enn11;//vlist
	protected Ennemy enn12;//vlist
	protected Ennemy enn13; //Vlist
	protected Ennemy enn14; //Vlist
	
	protected Ennemy enn15; //Vbin
	protected Ennemy enn16; //Vbin
	protected Ennemy enn17; //Vbin
	protected Ennemy enn18; //Vbin
	protected Ennemy enn19; //Vbin
	protected Ennemy enn20; //Vbin
	protected Ennemy enn21; //Vbin
	protected Ennemy enn22; //Vbin
	
	protected Ennemy boss; //boss du niveau
	
	protected ArrayList<Vvoid> Lvvoid;
	protected ArrayList<Vlist> Lvlist;
	protected ArrayList<Vbin> Lvbin;
	protected ArrayList<FatalError> Lboss;
	
	
	protected EclipseCruiser joueur;
	
	public Etat() {
		// TODO Auto-generated constructor stub
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// INIT
		
		musorigine = Game.musics[0];
		HypEsp = Game.musics[4];
		Perdre = Game.musics[3];
		carte = new Image("fondecran/fonbase.png");
		SpriteVie = new Image("spriteObjet/vie.png");
		SpriteHyperEsp = new Image("spriteObjet/hyperespace.png");
		
		joueur = new EclipseCruiser();
		
		fantome7 = new Vlist();
		fantome8 = new Vbin();
		fantome9 = new Vvoid();
		fantome10 = new FatalError();
		
		
		enn1 = new Vvoid();
		enn2 = new Vvoid();
		enn3 = new Vvoid();
		enn4 = new Vvoid();
		enn5 = new Vvoid();
		enn6 = new Vvoid();
		
		enn7 = new Vlist();
		enn8 = new Vlist();
		enn9 = new Vlist();
		enn10 = new Vlist();
		enn11 = new Vlist();
		enn12 = new Vlist();
		enn13 = new Vlist();
		enn14 = new Vlist();
		
		enn15 = new Vbin();
		enn16 = new Vbin();
		enn17 = new Vbin();
		enn18 = new Vbin();
		enn19 = new Vbin();
		enn20 = new Vbin();
		enn21 = new Vbin();
		enn22 = new Vbin();
		
		boss = new FatalError();
		
		Lvvoid = new ArrayList();
		Lvlist = new ArrayList();
		Lvbin = new ArrayList();
		Lboss = new ArrayList();
		
		Lvvoid.add((Vvoid) enn1);
		Lvvoid.add((Vvoid)enn2);
		Lvvoid.add((Vvoid) enn3);
		Lvvoid.add((Vvoid)enn4);
		Lvvoid.add((Vvoid) enn5);
		Lvvoid.add((Vvoid)enn6);
		
		Lvlist.add((Vlist)enn7);
		Lvlist.add((Vlist)enn8);
		Lvlist.add((Vlist)enn9);
		Lvlist.add((Vlist)enn10);
		Lvlist.add((Vlist)enn11);
		Lvlist.add((Vlist)enn12);
		Lvlist.add((Vlist)enn13);
		Lvlist.add((Vlist)enn14);
		
		Lvbin.add((Vbin)enn15);
		Lvbin.add((Vbin)enn16);
		Lvbin.add((Vbin)enn17);
		Lvbin.add((Vbin)enn18);
		Lvbin.add((Vbin)enn19);
		Lvbin.add((Vbin)enn20);
		Lvbin.add((Vbin)enn21);
		Lvbin.add((Vbin)enn22);
		
		Lboss.add((FatalError)boss);
		
		
		
		//Placement des ennemis
		
		for(int i = 0;i<Lvvoid.size();i++) {
			Lvvoid.get(i).setXenn((float)(-5+Math.random()*680));
			Lvvoid.get(i).setYenn((float)(-200+Math.random()*-800));
		}
		
		for(int i=0;i<Lvlist.size();i++) {
			Lvlist.get(i).setXenn(i*100);
			Lvlist.get(i).setYenn(-1100);
		}
		
		for(int i=0;i<Lvbin.size();i++) {
			Lvbin.get(0).setXenn(0);
			Lvbin.get(0).setYenn(-1900);
			
			Lvbin.get(1).setXenn(400);
			Lvbin.get(1).setYenn(-2000);
			
			Lvbin.get(2).setXenn(200);
			Lvbin.get(2).setYenn(-2300);
			
			Lvbin.get(3).setXenn(500);
			Lvbin.get(3).setYenn(-2300);
			
			Lvbin.get(4).setXenn(0);
			Lvbin.get(4).setYenn(-2500);
			
			Lvbin.get(5).setXenn(400);
			Lvbin.get(5).setYenn(-2500);
			
			Lvbin.get(6).setXenn(300);
			Lvbin.get(6).setYenn(-2850);
			
			Lvbin.get(7).setXenn(600);
			Lvbin.get(7).setYenn(-2850);
		}
		
		for(int i=0;i<Lboss.size();i++) {
			Lboss.get(0).setXenn(0);
			Lboss.get(0).setYenn(-4800);
		}
		
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// AFFICHAGE
		
		carte.draw(-140,-4);	//On dessine la carte de fond
		joueur.affvaisseau(g);
		joueur.afftir(g);
		
		for(int i = 0;i<Lvvoid.size();i++) {
			Lvvoid.get(i).afficher(g);
		}
		
		for(int i=0;i<Lvlist.size();i++) {
			Lvlist.get(i).afficher(g);
			Lvlist.get(i).afftir(g);
		}
		
		for(int i=0;i<Lvbin.size();i++) {
			Lvbin.get(i).afficher(g);
			Lvbin.get(i).afftir(g);
		}
		
		for(int i=0;i<Lboss.size();i++) {
			Lboss.get(i).afficher(g);
			Lboss.get(i).afftir(g);
		}
		g.setColor(Color.white);
		g.drawString("SCORE : " + Score, 650, 570);
		g.drawString("VIE : " + joueur.getpv(), 650, 550);
		
		if (CptVieJoueur == 1) {
			SpriteVie.draw(650,530);
		}else {
			if(CptVieJoueur == 2) {
				SpriteVie.draw(650,530);
				SpriteVie.draw(680,530);
			}
			if(CptVieJoueur == 3) {
				SpriteVie.draw(650,530);
				SpriteVie.draw(680,530);
				SpriteVie.draw(710,530);
			}
		}
		
		g.drawString("VIES RESTANTES : "  , 650, 510);
		
		if(Lboss.get(0).getYenn()>= 0 && Lboss.get(0).getYenn()<600) {
		g.setColor(Color.red);
		g.drawString("VIE DU BOSS : " +boss.getvie(),300,0);
		}
		
		if(Droit == true) {
			g.setColor(Color.white);
			SpriteHyperEsp.draw(0,540);
			g.drawString("VOUS AVEZ DEBLOQUE : ", 0, 500);
			g.drawString("HYPERESPACE", 0, 520);
		}
		
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// UPDATE
		
		Input input = gc.getInput();
		if(input.isKeyPressed(Input.KEY_ESCAPE)) {	// pour retourner au menu principal
			sbg.enterState(0);
			musorigine.play();
		}
		
		if(Droit == true) {
			if(input.isKeyPressed(Input.KEY_SPACE)) {	// pour aller en hyperEspace
				sbg.enterState(3);
				HypEsp.play();
				CptVieJoueur = 3;
				
			}
		}
		
		//UPDATE DU VAISSEAU DU JOUEUR
		
		joueur.deplvaisseau(gc, sbg, delta);
		joueur.tirer(gc, sbg, delta);
		
		//UPDATE DES ENNEMIS
		
		for(int i = 0;i<Lvvoid.size();i++) {
			Lvvoid.get(i).deplacement(delta);
			
			//D�gats engendr�s par le joueur
			
			if(Lvvoid.get(i).hitbox(joueur.getXcruisermiss0(), joueur.getYcruisermiss0()) == true) {
				Lvvoid.get(i).setvie(Lvvoid.get(i).getvie()-joueur.getCruiserDegatmiss0()); 		//baisse la vie de l'ennemi si on fait des degats
			}
			if(Lvvoid.get(i).hitbox(joueur.getXcruisermiss1(), joueur.getYcruisermiss1()) == true) {
				Lvvoid.get(i).setvie(Lvvoid.get(i).getvie()-joueur.getCruiserDegatmiss1()); 
			}
			if(Lvvoid.get(i).getvie() <= 0) { 														//Si il est mort, on l'enleve de la liste d'origine
				ScoreVvoid += Lvvoid.get(i).getVieOrigine();
				Lvvoid.set(i,(Vvoid)fantome9);
				fantome9.setYenn(4000);																// Il faut que le vvoid disparaisse del'�cran
			}
			if(joueur.hitbox(Lvvoid.get(i).getXenn(), Lvvoid.get(i).getYenn()) == true) {	
				joueur.setpv(joueur.getpv()-joueur.getPvOrigine());// On perd une vie
				Lvvoid.get(i).setvie(Lvvoid.get(i).getvie()-Lvvoid.get(i).getVieOrigine());
			}
			
		}
		
		for(int i=0;i<Lvlist.size();i++) {
			Lvlist.get(i).deplacement(delta);
			Lvlist.get(i).tir(gc,sbg,delta);
			
			//D�gats engendr�s par le joueur
			
			if(Lvlist.get(i).hitbox(joueur.getXcruisermiss0(), joueur.getYcruisermiss0()) == true) {
				Lvlist.get(i).setvie(Lvlist.get(i).getvie()-joueur.getCruiserDegatmiss0());
			}
			if(Lvlist.get(i).hitbox(joueur.getXcruisermiss1(), joueur.getYcruisermiss1()) == true) {
				Lvlist.get(i).setvie(Lvlist.get(i).getvie()-joueur.getCruiserDegatmiss1());
			}
			if(Lvlist.get(i).getvie() <=0 ) {
				ScoreVlist += Lvlist.get(i).getVieOrigine();
				Lvlist.set(i,(Vlist)fantome7);
				fantome7.setYenn(1000000); 								//Soit 5000 secondes avant que l'ennemi r�apparaisse sous forme de fant�me
				System.out.println(Lvlist);
			}
			
			//D�gat fournis au joueur
			
			if(joueur.hitbox(Lvlist.get(i).getXennMiss(), Lvlist.get(i).getYennMiss()) == true) {
				joueur.setpv(joueur.getpv()-Lvlist.get(i).getEnnDegatmiss());
			}
			
		}
		
		
		for(int i=0;i<Lvbin.size();i++) {
			Lvbin.get(i).deplacement(delta);
			Lvbin.get(i).tir(gc,sbg,delta);
			
			if(Lvbin.get(i).hitbox(joueur.getXcruisermiss0(), joueur.getYcruisermiss0()) == true) {
				Lvbin.get(i).setvie(Lvbin.get(i).getvie()-joueur.getCruiserDegatmiss0());
			}
			
			if(Lvbin.get(i).hitbox(joueur.getXcruisermiss1(), joueur.getYcruisermiss1()) == true) {
				Lvbin.get(i).setvie(Lvbin.get(i).getvie()-joueur.getCruiserDegatmiss1());
			}
			
			if(Lvbin.get(i).getvie() <=0 ) {
				ScoreVbin += Lvbin.get(i).getVieOrigine();
				Lvbin.set(i,(Vbin)fantome8);
				fantome8.setYenn(4000);											// Il faut juste qu'il disparaisse de l'�cran
			}
			
			//Degats fournis au joueur
			
			if(joueur.hitbox(Lvbin.get(i).getXennMiss(), Lvbin.get(i).getYennMiss()) == true) {
				joueur.setpv(joueur.getpv()-Lvbin.get(i).getEnnDegatmiss());
			}
			if(joueur.hitbox(Lvbin.get(i).getXenn()+40, Lvbin.get(i).getYenn()+28) == true) {// il peut y avoir collision avec un vbin
				joueur.setpv(joueur.getpv()-joueur.getPvOrigine());// On perd une vie
				Lvbin.get(i).setvie(Lvbin.get(i).getvie()-Lvbin.get(i).getVieOrigine());
			}
			
			
			
		}
		
		for(int i=0;i<Lboss.size();i++) {
			Lboss.get(i).deplacement(delta);
			Lboss.get(i).tir(gc,sbg,delta);
			
			if(Lboss.get(i).hitbox(joueur.getXcruisermiss0(), joueur.getYcruisermiss0()) == true) {
				Lboss.get(i).setvie(Lboss.get(i).getvie()-joueur.getCruiserDegatmiss0());
			}
			if(Lboss.get(i).hitbox(joueur.getXcruisermiss1(), joueur.getYcruisermiss1()) == true) {
				Lboss.get(i).setvie(Lboss.get(i).getvie()-joueur.getCruiserDegatmiss1());
			}
			if(Lboss.get(i).getvie() <=0 ) {
				ScoreBoss += Lboss.get(i).getVieOrigine();
				Lboss.set(i,(FatalError)fantome10);
				fantome10.setYenn(1000000);
			}
			//Degats fournis au joueur
			if(joueur.hitbox(Lboss.get(i).getXennMiss()+60, Lboss.get(i).getYennMiss()+120) == true) {//permet de d�placer le point de d�gat du tir au milieu (bas)
				joueur.setpv(joueur.getpv()-Lboss.get(i).getEnnDegatmiss());
			}
			
		}
		
		
		// CONDITIONS SUR LES ETATS:
		
		if(joueur.getpv() <= 0) {
			CptVieJoueur -= 1;
			joueur.setpv(joueur.getPvOrigine());
		}
		if(CptVieJoueur == 0) {
			sbg.enterState(4);
			CptVieJoueur = 3;
			Perdre.play();
			
		}
		if (boss.getvie() <= 0) {
			sbg.enterState(5);
			CptVieJoueur = 3;
		}
		if(Score >= 2000 && Lboss.get(0).getYenn()>= 0 && Lboss.get(0).getYenn()<600) {//Si le score est sup a 200 et que le boss est l� on d�bloque l'hyperespace
			Droit = true;
		}else {Droit = false;}
		
		Score = ScoreVvoid + ScoreVlist + ScoreVbin + ScoreBoss;
		
	}

	@Override
	public int getID() {
		// ID DE L'ETAT
		
		return 1;
		
	}

}
