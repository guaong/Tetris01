package com.guaong.tetris.rule;

import com.guaong.tetris.ui.DrawBlock;
import com.guaong.tetris.ui.GameWindow;

/**
 * 
 * ��ת����
 * @author ��ͩ
 * д������ĵ�һ�����򣬲��ֹ����Ʊ�������ǰ�ڿ��ǲ�����ȫ���¹��򲻺ö���
 */
/**
 * ����
 * �ѿ����ڲ���
 * �۾�����
 * ����ʱ��Ȼ����֮ǰ��һ��©��
 * ����Ϊ����ˣ��ڶ���ʱ�����߼����ԣ������޸�
 * ����ԭ��
 * һ�������ܷ���ת��Ҫ����Ԥ�еģ�Ȼ��һ��ʱ�����ı����ĸ��������ܵ����������赲�ķ���
 * �������赲�ķ�����Ȼ������ת�����ͼ�α���
 * �������ֺ��޸�
 * 
 */
public class TurnRule {
	/**
	 * 
	 * ��ת��������������ش���
	 * 1 ���ֵ���תһ����������ֻ���ĳһ�̶�λ�ó���һ�����飬����ʼ���䣬��һ��λ�ú���ʧ
	 * 2 �����ʹ��a��������ͼ�α任
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
	//�ֽ���ǰλ�ô�������
	private void restore(int i){
		num1[i]=GameWindow.blockx[i];
		num2[i]=GameWindow.blocky[i];
	}
	//��ת������λ��
	private void turn(int i){
		a=GameWindow.blockx[0]-GameWindow.blockx[i];
		b=GameWindow.blocky[0]-GameWindow.blocky[i];
		GameWindow.blockx[i]=GameWindow.blockx[0]+(b);
		GameWindow.blocky[i]=GameWindow.blocky[0]-(a);
	}
	//�޸���ؾ���״̬��Ϣ
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
	//��ԭ���з��鵽��һ��
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
	//����Ƿ񵽵ף���������Ӧ���޸ģ���˼�ǣ���һ�����鵽���ǣ��ڱ��ο��ܳ����ױߣ����Ҳ��Ҫ��ԭ����һ��
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