package matus.minigame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/*Nessa classe teremos a logica dos blocos que irão compor o senario*/
public class Blocks extends Rectangle{

	//dimenção dos blocos
	public Blocks(int x, int y) {
		super( x, y, 32, 32);
		
	}
	//renderização dos blocos
	public void render (Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);//Borda dos blocos
	}
	
}
