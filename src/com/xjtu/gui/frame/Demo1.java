package com.xjtu.gui.frame;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//GUI���
public class Demo1 {
	public static void main(String[] args) {
		
		//����һ�����ɼ��Ĵ���
		Frame frame = new Frame("�ҵĴ���");
		
		//���ô���Ĵ�С
		frame.setSize(200,250);
		
		//������ʾ��λ��
		frame.setLocation(300,200);
		
		//��������ʾ����
		frame.setVisible(true);
		
		//Ϊ��������¼�[�¼������������¼�Դ]
		frame.addWindowListener(new MyWindowListener());
		
	}
}
//�¼�������[��չWindowAdapter������]
class MyWindowListener extends WindowAdapter{
	//��д������صķ���
	public void windowClosing(WindowEvent e) {
		Frame frame = (Frame) e.getSource();
		frame.setVisible(false);
		System.exit(1);
	}
}



















/*
class MyWindowListener implements WindowListener{
	public void windowActivated(WindowEvent e) {
	}
	public void windowClosed(WindowEvent e) {
	}
	//�¼��������,�ɼ������Զ�����
	public void windowClosing(WindowEvent e) {
		//ȡ���¼�Դ
		Frame frame = (Frame) e.getSource();
		//���¼�Դ����
		frame.setVisible(false);
		//��JVMǿ����ֹ
		System.exit(1);
	}
	public void windowDeactivated(WindowEvent e) {
	}
	public void windowDeiconified(WindowEvent e) {
	}
	public void windowIconified(WindowEvent e) {
	}
	public void windowOpened(WindowEvent e) {
	}
}
*/

