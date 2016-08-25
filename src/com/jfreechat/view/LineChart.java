package com.jfreechat.view;

import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart extends JPanel{

	
	public LineChart(){
		this.add(jpanel());
		this.setVisible(true);
	}
	
	// 生成显示图表的面板
		 public static JPanel jpanel() {
		  JFreeChart jfc = jfreeChart(getDataset());
			 //JFreeChart jfc = jfreeChart2(getDataset());
		  return new ChartPanel(jfc);
		 } 

		 // 生成（折线图）图表主对象JFreeChart
		 public static JFreeChart jfreeChart(DefaultCategoryDataset linedataset) {
				  //定义图表对象
				  JFreeChart chart = ChartFactory.createLineChart(
					"折线图", // chart title
				    "时间", // domain axis label
				    "销售额(百万)", // range axis label
				    linedataset, // data
				    PlotOrientation.VERTICAL, // orientation
				    true, // include legend
				    true, // tooltips
				    false // urls
				    );
				  CategoryPlot plot = chart.getCategoryPlot();
				  // customise the range axis...
				  
				  
				  NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
				  rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
				  rangeAxis.setAutoRangeIncludesZero(true);
				  rangeAxis.setUpperMargin(0.20);
				  rangeAxis.setLabelAngle(Math.PI / 2.0); 
			
				  return chart;
		 } 
		 
		
		 //生成数据
		 public static DefaultCategoryDataset getDataset() {
			 
				  DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
				  //  各曲线名称
				  String series1 = "冰箱";
				  String series2 = "彩电";
				  String series3 = "洗衣机"; 
			
				  //    横轴名称(列名称)
				  String type1 = "1月";
				  String type2 = "2月";
				  String type3 = "3月"; 
			
				  linedataset.addValue(0.0, series1, type1);
				  linedataset.addValue(4.2, series1, type2);
				  linedataset.addValue(3.9, series1, type3); 
			
				  linedataset.addValue(1.0, series2, type1);
				  linedataset.addValue(5.2, series2, type2);
				  linedataset.addValue(7.9, series2, type3); 
			
				  linedataset.addValue(2.0, series3, type1);
				  linedataset.addValue(9.2, series3, type2);
				  linedataset.addValue(8.9, series3, type3); 
			
				  return linedataset;
		 }
}
