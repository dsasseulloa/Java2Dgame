package dev.daniel.jogo;

import dev.daniel.jogo.display.Display;
import dev.daniel.jogo.gfx.Assets;
import dev.daniel.jogo.gfx.CarregadorImagens;
import dev.daniel.jogo.gfx.SpriteSheet;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Jogo implements Runnable{
	private Display display;
	public int largura, altura;
	public String titulo;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	

	
	public Jogo(String titulo, int largura, int altura){
		this.largura = largura;
		this.altura = altura;
		this.titulo = titulo;
	}
	private void init(){
		display = new Display(titulo, largura, altura);
		Assets.init();
	}
	int x = 0;
	
	private void tick(){
		x += 1;
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();

		g.clearRect(0, 0, largura, altura);

		
		g.drawImage(Assets.grass, x, 10, null);
		

		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}	
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
