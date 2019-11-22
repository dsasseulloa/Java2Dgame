package dev.daniel.jogo.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

	
public class CarregadorImagens {


	public static BufferedImage CarregarImagem(String path){
		try {
			return ImageIO.read(CarregadorImagens.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
