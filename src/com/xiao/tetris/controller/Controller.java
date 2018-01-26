package com.xiao.tetris.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.xiao.tetris.listener.ShapeListener;
import com.xiao.tetris.model.Ground;
import com.xiao.tetris.model.Shape;
import com.xiao.tetris.model.ShapeFactory;
import com.xiao.tetris.view.GamePanel;

public class Controller extends KeyAdapter implements ShapeListener{

	private Shape shape;
	private Ground ground;
	private ShapeFactory shapeFactory;
	private GamePanel gamePanel;
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			if (ground.isMoveable(shape, Shape.ROTATE))
				shape.rotate();
			break;
		case KeyEvent.VK_DOWN:
			if (isShapeMoveDownable(shape))
				shape.moveDown();
			break;
		case KeyEvent.VK_LEFT:
			if (ground.isMoveable(shape, Shape.LEFT))
				shape.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			if (ground.isMoveable(shape, Shape.RIGHT))
				shape.moveRight();
			break;
		}
		gamePanel.display(ground, shape);
	}

	
	
	@Override
	public synchronized boolean isShapeMoveDownable(Shape shape) {
		// TODO Auto-generated method stub
		
		if (this.shape != shape){
			//解决一直按下落键的bug
			return false;
		}
		boolean result = ground.isMoveable(shape, Shape.DOWN);
		if (ground.isMoveable(shape, Shape.DOWN))
			return true;
		ground.accept(shape);
		if(!ground.isFull()){
			this.shape = shapeFactory.getShape(this);
		}
		return false;
	}

	@Override
	public void shapeMoveDown(Shape shape) {
		// TODO Auto-generated method stub
		gamePanel.display(ground, shape);
	}

	//开始新游戏
	public void newGame(){
		shape = shapeFactory.getShape(this);
	}
	
	public Controller(ShapeFactory shapeFactory, Ground ground, GamePanel gamePanel){
		this.shapeFactory = shapeFactory;
		this.ground = ground;
		this.gamePanel = gamePanel;
	}
}
