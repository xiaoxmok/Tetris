package com.xiao.tetris.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.xiao.tetris.model.Ground;
import com.xiao.tetris.model.Shape;
import com.xiao.tetris.util.Global;

public class GamePanel extends JPanel {

	private Ground ground;
	private Shape shape;
	
	public void display(Ground ground, Shape shape){
		System.out.println("GamePanel's display");
		this.ground = ground;
		this.shape = shape;
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		//重新显示
		g.setColor(new Color(0xcfcfcf));
		g.fillRect(0, 0, Global.WIDTH * Global.CELL_SIZE, Global.HELGHT * Global.CELL_SIZE);
		if (shape != null && ground != null){
			shape.drawMe(g);
			ground.drawMe(g);
		}
		
	}
	
	//设置图形大小
	public GamePanel(){
		this.setSize(Global.WIDTH * Global.CELL_SIZE, Global.HELGHT * Global.CELL_SIZE);
	}
}
