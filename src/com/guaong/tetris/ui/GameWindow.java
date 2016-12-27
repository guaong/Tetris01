package com.guaong.tetris.ui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.guaong.tetris.rule.BorderRule;
import com.guaong.tetris.rule.ClearRule;
import com.guaong.tetris.rule.DieRule;
import com.guaong.tetris.rule.DownRule;
import com.guaong.tetris.rule.TurnRule;

/**
 * 
 * ����ʱ�����һ����
 * ��������
 * @author ��ͩ
 * �ں��ڵ�ʹ���п����ٸ������һ���÷ֵ��������һ��Ԥ����һ��Ҫ��ʲô�����
 * �ڷ�����ɫ����״����Ҳ�����޸ģ���Ȼ����������awt�Ľ���û�н����κ��޸�
 * �ܱ�
 * ��ǰ�ڿ��ǲ��ܵ���ֻ���ǵ�draw��block�����ºܶ��������ʵ��
 * �����Ʒ���д���뵽��һ��boolean�Ͷ�ά���飬��ȷ�����Ƿ�ǰλ���з���
 * д�ú��з�����һ�����⵱���䵽��֮���ж����Ƿ��ܼ������䣬�ָ�clear���һ�У���Ϊ�ж�
 * Ȼ��������д��ת����ʱ�����ֵ�һ��ͼ������ʱ��ת�ᳬ����Ļ����ʱ���clear�����������д��ת����ʱҲ�����׺ܶ�
 * Ҳ�����ڳ��ַ�ת����д�Ĺ��ָ���
 * �ڴ�����ɺ��ּ���˫����������������
 * 
 */
/**
 * 
 * ����
 * ֻ�ǽ�����һЩ�򵥵��޸�
 * �����н�Ϊ���ҵ�һ���ֽ������޸�
 * 
 *
 */
public class GameWindow extends Frame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//����
	public static int downx[] = new int[12];
	public static int downy[] = new int[18];
	//�滭
	public static int drawx[] = new int[12];
	public static int drawy[] = new int[18];
	//���,��ν���Ҳ�������Ϊ���˴����ڷ���ʱ����Ϊtrue��Ϊʲô��19�أ�����Ϊ������ʱ����ʱ���ж������Ƿ��з���
	//�������±�һ����������û�ж�����˶��һ�������ж���
	public static boolean clear[][] = new boolean[12][19];
	//����
	public static int blockx[] = new int[4];
	public static int blocky[] = new int[4];
	
	public final int BLOCK_HEIGHT = 30;
	public final int BLOCK_WIDTH = 30;
	private int time=400;
	//������������Ϊһ����ʶ��ʹ�ã������ж��Ƿ����¿�ʼ
	public static int a=1;
	
	private DrawBlock d;
	private BorderRule b;
	private DownRule r;
	private ClearRule c;
	private TurnRule t;
	
	public GameWindow(){
		d = new DrawBlock();
		b=new BorderRule();
		r =new DownRule();
		c= new ClearRule();
		t =new TurnRule();
		buildWindow();
	}
	private void buildWindow(){
		setSize(400,600);
		setLocation(450, 100);
		setResizable(false);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		addKeyListener(new DirectionAdapter());
		getValue();
		ChangeBlock();
		//�߳̽������Ĳ���ִ��
		new MyThread().start();
	}
	class DirectionAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key== 37){  //left
				if(b.getLeft()){
					if(r.leftRule()){
						for(int i=0;i<4;i++){
							blockx[i]-=30;
						}
					}
				}
			}
			else if(key== 39){  //right
				if(b.getRight()){
					if(r.rightRule()){
						for(int i=0;i<4;i++){
							blockx[i]+=30;
						}
					}
				}
			}
			else if(key == 38){  //up
				t.getTurn();
			}
			else if(key == 40){  //down
				time=10;
			}
		}
	}
	//��ֵ���룬��ʼ��ֵ
	private void getValue(){
		int flag1=20;
		int flag2=40;
		for(int i=0;i<12;i++){
			downx[i]=flag1;
			drawx[i]=flag1;
			clear[i][18]=true;
			flag1+=30;
		}
		for(int j=0;j<18;j++){
			downy[j]=flag2;
			drawy[j]=flag2;
			flag2+=30;
		}
	}
	
	public void paint(Graphics g){
		if(a==1){
			initDraw(g);
			drawBlock(g);
			drawHave(g);
			
		}else{
			initDraw(g);
			a=1;
		}
	}
	//��ʼ��ͼ�����
	private void initDraw(Graphics g){
		g.setColor(Color.white);
		g.fillRect(20, 40, 360, 540);
		g.setColor(Color.black);
		g.drawRect(20, 40, 360, 540);
		g.setColor(Color.red);
		g.drawLine(20,130,380,130);
	}
	//���Ƴ�����clearΪtrue�ķ��飬��Ȼ����Ͳ�������ʮ���У������������¹��ķ���
	private void drawHave(Graphics g){
		c.useClear();
		for(int j=0;j<12;j++){
			for(int k =0;k<18;k++){
				if(clear[j][k]){
					g.setColor(Color.black);
					g.fillRect(drawx[j], drawy[k],BLOCK_HEIGHT, BLOCK_WIDTH);
					g.setColor(Color.white);
					g.drawRect(drawx[j], drawy[k],BLOCK_HEIGHT, BLOCK_WIDTH);
				}

			}
		}
	}
	//������
	private void drawBlock(Graphics g){
		if(r.otherRule()){
			for(int i=0;i<4;i++){
				if(blockx[i]!=0&&blocky[i]!=0){
					g.setColor(Color.black);
					g.fillRect(blockx[i], blocky[i],BLOCK_HEIGHT , BLOCK_WIDTH);
					g.setColor(Color.white);
					g.drawRect(blockx[i], blocky[i],BLOCK_HEIGHT , BLOCK_WIDTH);
					blocky[i]+=30;
				}
			} 
		}
		else{
			d.DrawAll();
			ChangeBlock();
			time=400;
		}
	}

	//˫����
	//˫�����õ��Ķ�����ʱû����⣬��Ϊ�˽���������ػ����ٶȲ�ƥ������ֵ��������������д�÷������Զ������
	private Image offScreenImage = null;
	public void update(Graphics g){
		if(offScreenImage == null){
			offScreenImage = this.createImage(400,600);
		}
		Graphics gOff=offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	//�߳̿����ػ�
	class MyThread extends Thread{
		public void run(){
			while(true){
				if(DieRule.toDie()){
					new GradeFrame();
					while(a==1){
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
						
						}
					}
				}
				else{
					repaint();
				}
				try {
					sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//���ѡ�����䷽��
	//�����������DrawBlock���Ҹо���low��������������
	//Ȼ�����е��ֶ�Χ�Ƹý���
	private void ChangeBlock(){
		int count=0;
		count = (int)(Math.random()*7)+1;
		switch(count){
		case 1 : d.Block1();;break;
		case 2 : d.Block2();break;
		case 3 : d.Block3();break;
		case 4 : d.Block4();break;
		case 5 : d.Block5();break;
		case 6 : d.Block6();break;
		case 7 : d.Block7();break;
		}
	}
	
}
