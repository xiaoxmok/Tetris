package com.xiao.tetris.listener;

import com.xiao.tetris.model.Shape;

public interface ShapeListener {

	void shapeMoveDown(Shape shape);
	
	//�ж�ͼ���Ƿ��������
	boolean isShapeMoveDownable(Shape shape);  
}
