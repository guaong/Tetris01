package com.guaong.tetris.ui;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * 二更
 * 虽然我认为这个用弹窗JOptionPane比较合适
 * 但是确实不想改了
 * 都差不多
 * 而且后面窗口此时并不会用任何操作和弹窗效果差不多
 * @author 关桐
 *
 */

public class GradeFrame extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button again;
	private Button exit;
	private Label label;
	
	public GradeFrame(){
		again = new Button("再次");
		exit = new Button("退出");
		label= new Label("失败",Label.CENTER);
		buildFrame();
	}
	//界面绘制
	public void buildFrame(){
		setSize(300,200);
		setLocation(500, 200);
		setResizable(false);
		setAlwaysOnTop(true);
		add(again);
		add(exit);
		add(label);
		label.setFont(new Font("楷体", Font.BOLD, 26));
		again.setBounds(70, 150, 50, 30);
		exit.setBounds(180, 150, 50, 30);
		again.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("再次")){
					GameWindow.a=2;
					for(int i=0;i<12;i++){
						for(int j=0;j<18;j++){
							GameWindow.clear[i][j]=false;
						}
					}
					dispose();
				}
			}
		});
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("退出")){
					System.exit(0);
				}
			}
		});
		setVisible(true);
	}
		
}
