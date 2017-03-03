package com.xjtu.gui.frame;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//GUI编程
public class Demo1 {
	public static void main(String[] args) {
		
		//创建一个不可见的窗体
		Frame frame = new Frame("我的窗体");
		
		//设置窗体的大小
		frame.setSize(200,250);
		
		//设置显示的位置
		frame.setLocation(300,200);
		
		//将窗体显示出来
		frame.setVisible(true);
		
		//为窗体添加事件[事件监听器监听事件源]
		frame.addWindowListener(new MyWindowListener());
		
	}
}
//事件监听器[扩展WindowAdapter适配器]
class MyWindowListener extends WindowAdapter{
	//重写父类相关的方法
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
	//事件处理程序,由监听器自动调用
	public void windowClosing(WindowEvent e) {
		//取得事件源
		Frame frame = (Frame) e.getSource();
		//将事件源隐藏
		frame.setVisible(false);
		//将JVM强行中止
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

