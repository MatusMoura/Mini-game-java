package matus.minigame;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/*
 * Nessa classe temos a janela do nosso game com a 
 * interface Runnable e a classe Canvas e a classe 
 * Canvas do pacote awt.
 * 
 * Depois temos um looping infinito onde vai ser reinderizado 
 * o nosso jogo para isso usaremos o metodo Thread
 */
public class Game extends Canvas implements Runnable{
	
	//tamanho da tela
	public static int WIDTH = 480, HEIGHT = 480;
	
	//metodo construtor.
	public Game() {
		
		//Com a classe setPreferredSize eu defino .
		//a tela com o tamanho das variaveis anteriores.
		this.setPreferredSize(new Dimension(WIDTH , HEIGHT));
	
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
		System.out.println("looping");	
		}
		
	}
	
	
}
