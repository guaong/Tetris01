package com.guaong.tetris.rule;

import com.guaong.tetris.ui.GameWindow;

/**
 * 
 * ��������
 * @author ��ͩ
 * ˼·ֻҪ��һ��Ϊtrue����
 *
 */
public class DieRule {
	
	public static boolean toDie(){
		boolean flag=false;
		for(int i=0;i<12;i++){
			if(GameWindow.clear[i][2]){
				flag=true;
			}
		}
		
		return flag;
	}
}
