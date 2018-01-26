package com.xiao.tetris.model;

import java.util.Random;

import com.xiao.tetris.listener.ShapeListener;

public class ShapeFactory {
	
	private int shapes[][][] = new int[][][]{
		{
			{	1, 0, 0, 0,	
				1, 0, 0, 0,	
				1, 1, 0, 0,	
				0, 0, 0, 0	},
			{	0, 0, 1, 0,	
				1, 1, 1, 0,	
				0, 0, 0, 0,	
				0, 0, 0, 0	},
			{	1, 1, 0, 0,	
				0, 1, 0, 0,	
				0, 1, 0, 0,	
				0, 0, 0, 0	},
			{	1, 1, 1, 0,	
				1, 0, 0, 0,	
				0, 0, 0, 0,	
				0, 0, 0, 0	}
		},
		{
			{	0, 1, 0, 0,	
				0, 1, 0, 0,	
				1, 1, 0, 0,	
				0, 0, 0, 0	},
			{	1, 0, 0, 0,	
				1, 1, 1, 0,	
				0, 0, 0, 0,	
				0, 0, 0, 0	},
			{	1, 1, 0, 0,	
				1, 0, 0, 0,	
				1, 0, 0, 0,	
				0, 0, 0, 0	},
			{	1, 1, 1, 0,	
				0, 0, 1, 0,	
				0, 0, 0, 0,	
				0, 0, 0, 0	}
		},
		{
			{	0, 1, 0, 0,	
				1, 1, 1, 0,	
				0, 0, 0, 0,	
				0, 0, 0, 0	},
			{	1, 0, 0, 0,	
				1, 1, 0, 0,	
				1, 0, 0, 0,	
				0, 0, 0, 0	},
			{	1, 1, 1, 0,	
				0, 1, 0, 0,	
				0, 0, 0, 0,	
				0, 0, 0, 0	},
			{	0, 1, 0, 0,	
				1, 1, 0, 0,	
				0, 1, 0, 0,	
				0, 0, 0, 0	}
		},
		{
			{	1, 1, 1, 1,	
				0, 0, 0, 0,	
				0, 0, 0, 0,	
				0, 0, 0, 0	},
			{	1, 0, 0, 0,	
				1, 0, 0, 0,	
				1, 0, 0, 0,	
				1, 0, 0, 0	},
		},
		{
			{	1, 1, 0, 0,	
				0, 1, 1, 0,	
				0, 0, 0, 0,	
				0, 0, 0, 0	},
			{	0, 1, 0, 0,	
				1, 1, 0, 0,	
				1, 0, 0, 0,	
				0, 0, 0, 0	},
		},
		{
			{	0, 1, 1, 0,	
				1, 1, 0, 0,	
				0, 0, 0, 0,	
				0, 0, 0, 0	},
			{	1, 0, 0, 0,	
				1, 1, 0, 0,	
				0, 1, 0, 0,	
				0, 0, 0, 0	},
		},
		{
			{	1, 1, 0, 0,	
				1, 1, 0, 0,	
				0, 0, 0, 0,	
				0, 0, 0, 0	}
		}
	};

	//Éú²úÍ¼ÐÎ
	public Shape getShape(ShapeListener listener){
		System.out.println("ShapeFactory's getShape");
		Shape shape = new Shape();
		shape.addShapeListener(listener);
		int type = new Random().nextInt(shapes.length);
		shape.setBody(shapes[type]);
		shape.setStatus(0);
		return shape;
	}

}
