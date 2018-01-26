package com.xiao.tetris.listener;

import com.xiao.tetris.model.Shape;

public interface ShapeListener {

	void shapeMoveDown(Shape shape);
	
	//判断图形是否可以下落
	boolean isShapeMoveDownable(Shape shape);  
}
