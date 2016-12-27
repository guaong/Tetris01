package com.guaong.tetris.ui;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * ����
 * ��Ȼ����Ϊ����õ���JOptionPane�ȽϺ���
 * ����ȷʵ�������
 * �����
 * ���Һ��洰�ڴ�ʱ���������κβ����͵���Ч�����
 * @author ��ͩ
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
		again = new Button("�ٴ�");
		exit = new Button("�˳�");
		label= new Label("ʧ��",Label.CENTER);
		buildFrame();
	}
	//�������
	public void buildFrame(){
		setSize(300,200);
		setLocation(500, 200);
		setResizable(false);
		setAlwaysOnTop(true);
		add(again);
		add(exit);
		add(label);
		label.setFont(new Font("����", Font.BOLD, 26));
		again.setBounds(70, 150, 50, 30);
		exit.setBounds(180, 150, 50, 30);
		again.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("�ٴ�")){
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
				if(e.getActionCommand().equals("�˳�")){
					System.exit(0);
				}
			}
		});
		setVisible(true);
	}
		
}
