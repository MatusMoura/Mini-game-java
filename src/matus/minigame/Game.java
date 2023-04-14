package matus.minigame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

/*Nessa classe temos a janela do nosso game com a 
 * interface Runnable e a classe Canvas e a classe 
 * Canvas do pacote awt.
 * 
 * Depois temos um looping infinito onde vai ser reinderizado 
 * o nosso jogo para isso usaremos o metodo Thread */

public class Game extends Canvas implements Runnable{
	
	//tamanho da tela
	public static int WIDTH = 480, HEIGHT = 480;
	
	//metodo construtor.
	public Game() {
		
		//Com a classe setPreferredSize eu defino .
		//a tela com o tamanho das variaveis anteriores.
		this.setPreferredSize(new Dimension(WIDTH , HEIGHT));
	}
	
	/*metodo onde acontece a logica da gameplay
	 * cada loopin (fps) é um spin
	 */
	public void spin() {
		
	}
	
	//metodo onde será reinderizado os graficos do game
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);//otimização grafica
			return;
		}
		
		Graphics g = bs.getDrawGraphics();//obijeto responsavel por reinderizar graficos
		
		//pintando toda a janela
		g.setColor(Color.green);
		g.fillRect(0, 0,HEIGHT, WIDTH);
		
		//nosso primeiro retangulo
		g.setColor(Color.blue);
		g.fillRect(5, 5,25, 25);
		
		bs.show();
	}
	
	public static void main(String[] args) {
		
		/*De maneira recusiva instanciamos 
		 * a classe gameno metodo principal.*/
		Game game = new Game();
		JFrame frame = new JFrame();//instancia da classe JFrame do pacote swing.
		
		frame.add(game);//adicionando o game a classe frame.
		frame.setTitle("Mini Game");//titulo da janela.
		frame.pack();//basicamente empacota tudo e poe tudo do tamanho certo.
		frame.setLocationRelativeTo(null);//Para a janela ficar sentralizada.
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Assim quando eu feixar a janela o processo da jdk tambem é finalizado
	    
		frame.setVisible(true);//Para a ganela aparecer.
		
		new Thread(game).start();//iniciando looping
	}
	/*
	 * metodo trazido da interface Runnable 
	 * onde o nosso looping acontece.
	 */
	@Override
	public void run() {
		while(true) {
			spin();
			render();
			
			//logica para que o jogo rode a 60fps
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
