package com.jfreechat.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class WindowChart extends JFrame implements ActionListener{
	
	private JPanel jp1,jp2,jp3;
	private JButton jb1,jb2,jb3;
	private JLabel jl1;
	private CardLayout card;
	
	
	public static void main(String[] args) {
		WindowChart fjc = new WindowChart();
		//fjc.pack();
		
	}

	public WindowChart() {
		//工具栏
		jp1=new JPanel(new FlowLayout(new FlowLayout().CENTER));
		jb1=new  JButton("折线图");
		jb1.addActionListener(this);
		jb2=new JButton("时间走势图");
		jb2.addActionListener(this);
		jb3=new JButton("柱状图");
		jb3.addActionListener(this);
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		//状态栏
		jp2=new JPanel(new FlowLayout(new FlowLayout().LEFT));
		Timer t=new Timer(1000, this);//每隔一秒触发ActonEvent
		jl1=new JLabel();
		t.start();
		jp2.add(jl1);
		//jp2.setBackground());
		//图表栏
		card=new CardLayout();
		jp3=new JPanel(card);
		
		LineChart line=new LineChart();
		jp3.add(line,"0");		
		SqlLineChart sqlline=new SqlLineChart();
		jp3.add(sqlline,"1");
		BarChart bar=new BarChart();
		jp3.add(bar,"2");

		this.setLayout(new BorderLayout());
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp3);
		this.add(jp2,BorderLayout.SOUTH);
		//setContentPane(jpanel());
		//RefineryUtilities.centerFrameOnScreen(this);
		this.setVisible(true);
		this.setSize(800, 600);
	}

	

	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.jl1.setText("当前时间："+Calendar.getInstance().getTime().toLocaleString()+"   ");
		if(e.getSource()==jb1){
			this.card.show(jp3,"0");
		}else if(e.getSource()==jb2){
			//JOptionPane.showMessageDialog(this, "welcome");
			this.card.show(jp3,"1");
		}else if(e.getSource()==jb3){
			this.card.show(jp3,"2");
		}
	} 

}
