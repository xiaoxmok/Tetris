package com.xiao.tetris.test;

import javax.swing.JFrame;

import com.xiao.tetris.controller.Controller;
import com.xiao.tetris.model.Ground;
import com.xiao.tetris.model.ShapeFactory;
import com.xiao.tetris.view.GamePanel;

public class MyGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeFactory shapeFactory = new ShapeFactory();
		Ground ground = new Ground();
		GamePanel gamePanel = new GamePanel();
		
		Controller controller = new Controller(shapeFactory, ground, gamePanel);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(gamePanel.getSize().width + 15, gamePanel.getSize().height + 39);
		frame.add(gamePanel);
		gamePanel.addKeyListener(controller);
		frame.addKeyListener(controller);
		frame.setVisible(true);
		controller.newGame();
	}

}
