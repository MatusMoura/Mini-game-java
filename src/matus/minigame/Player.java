package matus.minigame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle{

	public int speed = 5;//velocidade do jogador
	public boolean right, up, down, left;//possiveis movimentos do player
	
	//metodo construtor
	public Player(int x, int y) {
		super(x,y,32,32);
	
	}
    //logica de movimentação do player
	public void spin() {
		if(right && World.isFree(x+speed, y)) {
			x += speed;
		}else if(left && World.isFree(x-speed, y)){
			x -= speed;
		}
		if(up && World.isFree(x, y-speed)) {
			y -= speed;
		}else if(down && World.isFree(x, y+speed)){
			y += speed;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}
}
