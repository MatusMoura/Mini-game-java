package matus.minigame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {
	
	//Arrey para a colocação de varios blocos no mapa
	public static List<Blocks> blocks = new ArrayList<Blocks>();
	Random ran = new Random();
	int numRan;
	//Adicionando blocos de forma dinamica
	public World() {
		for(int xx = 0; xx < 15; xx++) {//blocos superiores
			blocks.add(new Blocks(xx * 32, 0));
		}
		for(int xx = 0; xx < 15; xx++) {//blocos inferiores
			blocks.add(new Blocks(xx * 32, 480-32));
		}
		for(int x = 0; x < 15; x++) {//lado esquerdo
			blocks.add(new Blocks(0,x * 32));
		}
		for(int x = 0; x < 15; x++) {//lado direito
			blocks.add(new Blocks(480-32,x * 32));
		}
		for(int y = 0; y < 15; y++) {//blocos randomicos
			numRan = ran.nextInt(480);
			blocks.add(new Blocks(numRan-32,y * 32));
		}
	}
	public static boolean isFree(int x, int y) {
		for(int i = 0; i < blocks.size(); i++) {
			Blocks currentBlocks = blocks.get(i);
			if(currentBlocks.intersects(new Rectangle(x,y,32,32))) {
				return false;
			}
		}return true;
	}

	public void render (Graphics g) {
		for(int i = 0; i < blocks.size(); i++) {
			blocks.get(i).render(g);
		}
	}
}
