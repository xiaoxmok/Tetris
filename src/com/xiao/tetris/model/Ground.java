package com.xiao.tetris.model;

import java.awt.Color;
import java.awt.Graphics;

import com.xiao.tetris.util.Global;

public class Ground {

	private int[][] obstacles = new int[Global.WIDTH][Global.HELGHT];
	//����ͼ��
	public void accept(Shape shape){
		System.out.println("Ground's accept");
		for (int x = 0; x < 4; x++){
			for (int y = 0; y < 4; y++){
				if (shape.isMember(x, y, false)){
					obstacles[shape.getLeft() + x][shape.getTop() + y] = 1;
				}
			}
		}
		deleteFullLine();
	}
	//��ʾͼ��
	public void drawMe(Graphics g){
		System.out.println("Ground's drawMe");
		//�����ϰ������ɫ
		g.setColor(Color.GRAY);
		for (int x = 0; x < Global.WIDTH; x++){
			for (int y = 0; y < Global.HELGHT; y++){
				if (obstacles[x][y] == 1){
					g.fill3DRect(x * Global.CELL_SIZE, y * Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
				}
			}
		}
	}
	
	//����
	private void deleteFullLine(){
		//�����һ�п�ʼѭ��
		for (int y = Global.HELGHT - 1; y >= 0; y--){
			boolean full = true;
			//�ж�ÿһ�е�ÿһ���Ƿ����ϰ���
			
			for (int x = 0; x < Global.WIDTH; x++){
				if (obstacles[x][y] == 0){
					full = false;
				}
			}
			if (full){
				deleteLine(y);
				y = y + 1;
				Global.TOTAL = Global.TOTAL + 100;
				System.out.println("��ǰ�ɼ�Ϊ��" + Global.TOTAL);
			}
		}
		
	}
	
	private void deleteLine(int lineNum){
		//���е���һ����������
		for (int y = lineNum; y > 0; y--){
			for (int x = 0; x < Global.WIDTH; x++){
				obstacles[x][y] = obstacles[x][y - 1];
			}
		}
		for (int x = 0; x < Global.WIDTH; x++){
			obstacles[x][0] = 0; 
		}
		
	}
	
	//�ж�ͼ���Ƿ���ƶ�
	public boolean isMoveable(Shape shape, int action){
		int left = shape.getLeft();
		int top = shape.getTop();
		switch(action){
		case Shape.LEFT:
			left--;
			break;
		case Shape.RIGHT:
			left++;
			break;
		case Shape.DOWN:
			top++;
			break;
		}
		//�ж��Ƿ񳬳��߽�
		for (int x = 0; x < 4; x++){
			for (int y = 0; y < 4; y++){
				if (shape.isMember(x, y, action == Shape.ROTATE)){
					if (top + y >= Global.HELGHT||left + x < 0||left + x >= Global.WIDTH||obstacles[left + x][top +y] == 1)
						return false;
				}
			}
		}
		return true;
	}
	
	public boolean isFull(){
		//�жϵ�һ���Ƿ����ϰ�������ʾ�������ˣ���Ϸ��Ҫ����
		for (int x = 0; x < Global.WIDTH; x++){
			if (obstacles[x][0] == 1){
				return true;
			}
		}
		return false;
	}
}
