package dev.daniel.jogo;

import dev.daniel.jogo.display.Display;

public class Launcher {
	
	public static void main(String[] args){
		Jogo jogo = new Jogo("Jogo", 640, 360);
		jogo.start();
	}
	
	
}
