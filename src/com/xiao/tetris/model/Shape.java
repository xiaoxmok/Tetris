package com.xiao.tetris.model;

import java.awt.Color;
import java.awt.Graphics;

import com.xiao.tetris.listener.ShapeListener;
import com.xiao.tetris.util.Global;

public class Shape {
	
	public static final int ROTATE = 0;
	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	public static final int DOWN = 3;
	
	private int[][] body;
	private int status;
	private int left = 5;
	private int top = -1;
	
	//监听器
	private ShapeListener listener;
	
	public void moveLeft(){
		System.out.println("Shape's moveLeft");
		left--;
	}
	public void moveRight(){
		System.out.println("Shape's moveRight");
		left++;
	}
	public void moveDown(){
		System.out.println("Shape's moveDown");
		top++;
	}
	public void rotate(){
		System.out.println("Shape's rotate");
		status = (status + 1) % body.length;
	}
	public void drawMe(Graphics g){
		System.out.println("Shape's drawMe");
		//设置图形颜色
		g.setColor(Color.blue);
		for (int x = 0; x < 4; x++){
			for (int y = 0; y < 4; y++){
				if (getFlagByPoint(x, y)){
					g.fill3DRect((left + x) * Global.CELL_SIZE, (top + y) * Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
				}
			}
		}
	}
	
	private boolean getFlagByPoint(int x, int y){
		return body[status][y * 4 + x] == 1;
	}
	//获取当前坐标点
	public boolean isMember(int x, int y, boolean rotate){
		int tempStatus = status;
		if (rotate){
			tempStatus = (status + 1) % body.length;
		}
		return body[tempStatus][y * 4 +x] == 1;
		
	}
	
	private class ShapeDriver implements Runnable{
			//调用线程不断调用moveDown，以实现图形不断下落，
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(listener.isShapeMoveDownable(Shape.this)){
				moveDown();
				listener.shapeMoveDown(Shape.this);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//控制图下落的线程启动
	public Shape(){
		new Thread(new ShapeDriver()).start();
	}
	
	//注册监听器
	public void addShapeListener(ShapeListener l){
		if (l != null){
			this.listener = l;
		}
	}
	
	public void setBody(int body[][]){
		this.body = body;
	}
	public void setStatus(int status){
		this.status = status;
	}
	public int getTop(){
		return top;
	}
	public int getLeft(){
		return left;
	}
}
