package com.jfreechat.view;

import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;
import com.jfreechat.model.ChartModel;

public class SqlLineChart extends JPanel{
	ChartModel cm;
	
	
	public SqlLineChart(){
		this.add(jpanel());
		this.setVisible(true);
	}
	// 生成显示图表的面板
		 public static JPanel jpanel() {
		  JFreeChart jfc = jfreeChart(getData());			
		  return new ChartPanel(jfc);
		 } 

	
		 
		 //生成柱状图
		 public static JFreeChart jfreeChart(XYDataset xydataset) 
		 {
			 //JFreeChart chart = ChartFactory.createBarChart3D(
			 JFreeChart chart = ChartFactory.createTimeSeriesChart(
					 "走势图",
					 "时间",
					 "值",
					xydataset,
					 true,
					 true,
					 true
					 );
					 chart.setBackgroundPaint(Color.white);//设置曲线图背景色

					XYPlot plot = (XYPlot) chart.getPlot();
					XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer)plot.getRenderer();
					plot.setBackgroundPaint(Color.white);//设置网格背景颜色
					plot.setDomainGridlinePaint(Color.pink);//设置网格竖线颜色
					plot.setRangeGridlinePaint(Color.pink);//设置网格横线颜色
					plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 10D));//设置曲线图与xy轴的距离
					xylineandshaperenderer.setBaseShapesVisible(true);//设置曲线是否显示数据点

			return chart;
		 }
		 
		 
		 //生成数据
		 public static XYDataset getData() {
			 
				  //DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
				
			     
			      String[]params={"1"};
				  String sql="select tem,hum,smo,time from jfreechart where 1=?";
				  ChartModel cm=new ChartModel();
				  return cm.getData(sql, params);
				 
		 }
}
