package dev.daniel.tilegame.entities.statics;

import dev.daniel.tilegame.entities.Entity;
import dev.daniel.tilegame.tilegame.Handler;

public abstract class StaticEntity extends Entity {
	
	public StaticEntity(Handler handler, float x, float y, int width, int height){
		super(handler, x, y, width, height);
	}

}
