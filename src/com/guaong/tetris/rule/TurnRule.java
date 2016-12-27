package com.guaong.tetris.rule;

import com.guaong.tetris.ui.DrawBlock;
import com.guaong.tetris.ui.GameWindow;

/**
 * 
 * 旋转规则
 * @author 关桐
 * 写的最戳的的一个规则，不怪规则定制本身，而是前期考虑不够周全导致规则不好定制
 */
/**
 * 二更
 * 已哭晕在厕所
 * 累觉不爱
 * 二更时竟然发现之前有一个漏洞
 * 本以为解决了，在二更时发现逻辑不对，进行修改
 * 具体原因
 * 一更方块能否旋转是要进行预判的，然而一更时仅仅改变了四个方块中受到其他方块阻挡的方块
 * 而不受阻挡的方块依然可以旋转，造成图形变形
 * 二更发现后修改
 * 
 */
public class TurnRule {
	/**
	 * 
	 * 翻转规则出现两个严重错误
	 * 1 出现当旋转一定次数后出现会在某一固定位置出现一个方块，并开始下落，到一定位置后消失
	 * 2 如果我使用a，则会出现图形变换
	 * @return
	 */
	private int num1[]=new int[4];
	private int num2[]=new int[4];
	private int a;
	private int b;
	private boolean flag=false;
	
	public void getTurn(){
		if(((DrawBlock.q==3||DrawBlock.q==4||DrawBlock.q==5||DrawBlock.q==7)&&
				GameWindow.blockx[0]!=20&&GameWindow.blockx[0]!=350)||
				(DrawBlock.q==2&&GameWindow.blockx[1]!=20&&GameWindow.blockx[0]!=350)){
			turnAll();
			restoreAll();
			checkBottom();
			flag=false;
		}
	}
	private void turnAll(){
		for(int i=1;i<4;i++){
			if(GameWindow.blockx[i]!=0&&GameWindow.blocky[i]!=0){
				restore(i);
				turn(i);
				changeAll(i);
			}
		}
	}
	//现将当前位置存入数组
	private void restore(int i){
		num1[i]=GameWindow.blockx[i];
		num2[i]=GameWindow.blocky[i];
	}
	//翻转后坐标位置
	private void turn(int i){
		a=GameWindow.blockx[0]-GameWindow.blockx[i];
		b=GameWindow.blocky[0]-GameWindow.blocky[i];
		GameWindow.blockx[i]=GameWindow.blockx[0]+(b);
		GameWindow.blocky[i]=GameWindow.blocky[0]-(a);
	}
	//修改相关矩阵状态信息
	private void changeAll(int i){
		for(int j=0;j<12;j++){
			for(int k=0;k<18;k++){
				if(GameWindow.blockx[i]==GameWindow.drawx[j]&&GameWindow.blocky[i]==GameWindow.drawy[k]){
					if(GameWindow.clear[j][k]){
						flag=true;
					}
				}
			}
		}
	}
	//还原所有方块到上一步
	private void restoreAll(){
		if(flag){
			for(int i=1;i<4;i++){
				if(GameWindow.blockx[i]!=0&&GameWindow.blocky[i]!=0){
					GameWindow.blockx[i]=num1[i];
					GameWindow.blocky[i]=num2[i];
				}
			}
		}
	}
	//检查是否到底，并作出相应的修改，意思是，当一个方块到底是，在变形可能超出底边，因此也需要还原到上一步
	private void checkBottom(){
		for(int j=1;j<4;j++){
			if(GameWindow.blocky[j]>=580){
				for(int k=1;k<4;k++){
					if(GameWindow.blockx[k]!=0&&GameWindow.blocky[k]!=0){
						GameWindow.blockx[k]=num1[k];
						GameWindow.blocky[k]=num2[k];
					}
				}
			}
		}
	}
}