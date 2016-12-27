package com.guaong.tetris.ui;


/**
 * 
 * 
 * 该程序是对国庆节写的程序的修改
 * 基本修改了所有我认为不太合理的地方
 * 但是对于实现的基本思想没有进行修改
 * 发现一个bug，翻转是三个以上组成的方块会因为旁边有阻挡而发生变形
 * 问题已解决
 * @author 关桐
 * 二更之后还是有很多地方没有处理完，待三更进行进一步修改
 * 
 *
 */
public class Start {
	public static void main(String[] args) {
		new GameWindow();
	}
}
