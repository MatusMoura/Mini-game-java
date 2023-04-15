package matus.minigame;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class World {
	
	//Arrey para a colocação de varios blocos no mapa
	public List<Blocks> blocks = new ArrayList<Blocks>();
	
	//Adicionando blocos de forma dinamica
	public World() {
		for(int xx = 0; xx < 15; xx++) {
			blocks.add(new Blocks(xx * 32, 0));
		}
	}

	public void render (Graphics g) {
		for(int i = 0; i < blocks.size(); i++) {
			blocks.get(i).render(g);
		}
	}
}
