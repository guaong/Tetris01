package com.guaong.tetris.rule;

import com.guaong.tetris.ui.GameWindow;

/**
 * 
 * 下落规则
 * @author 关桐
 * 总觉得规则写的有点多，左右可合并
 */
/**
 * 二更
 * DownRule和TurnRule是最难改的两个类
 * 在二更中本来想将三个方法重复的地方用一个方法写出，
 * 然而发现java该如何在方法中传递不同的方法呢
 * 百度谷歌之后也没发现想要的结果，于是暂时不进行修改
 * 如果谁有该解决方法可告知
 *
 */
public class DownRule {

	//到底规则
	public boolean bottomRule(){
		boolean flag = true;
		for(int i=0;i<4;i++){
			if(GameWindow.blocky[i]==550){
				flag = false;
				break;
			}
		}
		return flag;
	}

	//判断是否下面有方块
	public boolean otherRule(){
		boolean flag = true;
		for(int i=0;i<4;i++){
			int count=0;
			for(int j=0;j<12;j++){
				for(int k=0;k<18;k++){
					if(GameWindow.blockx[i]==GameWindow.drawx[j]&&GameWindow.blocky[i]==GameWindow.drawy[k]){
						count=k+1;
						if(GameWindow.clear[j][count]){
							flag = false;
						}
					}
				}
			}
			
		}
		return flag;
	}
	//判断左边是否有方块
	public boolean leftRule(){
		boolean flag = true;
		for(int i=0;i<4;i++){
			int count=0;
			for(int j=0;j<12;j++){
				for(int k=0;k<18;k++){
					if(GameWindow.blockx[i]==GameWindow.drawx[j]&&GameWindow.blocky[i]==GameWindow.drawy[k]){
						count=j-1;
						if(GameWindow.clear[count][k]){
							flag = false;
						}
					}
				}
			}
			
		}
		return flag;
	}
	//判断右边是否有方块
	public boolean rightRule(){
		boolean flag = true;
		for(int i=0;i<4;i++){
			int count=0;
			for(int j=0;j<12;j++){
				for(int k=0;k<18;k++){
					if(GameWindow.blockx[i]==GameWindow.drawx[j]&&GameWindow.blocky[i]==GameWindow.drawy[k]){
						count=j+1;
						if(GameWindow.clear[count][k]){
							flag = false;
						}
					}
				}
			}
			
		}
		return flag;
	}

}
