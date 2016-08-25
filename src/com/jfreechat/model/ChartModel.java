package com.jfreechat.model;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import com.jfreechart.db.SqlHelper;

public class ChartModel{
	static ResultSet rs=null;

	@SuppressWarnings("deprecation")
	public static XYDataset getData(String sql, String []params) {	
		  //设置曲线，共三条曲线
		  TimeSeries timeseries = new TimeSeries("冰箱",Day.class);//时间的最小单位为分，线值名是“平均”
		  TimeSeries timeseries1 = new TimeSeries("彩电",Day.class);
		  TimeSeries timeseries2 = new TimeSeries("洗衣机",Day.class);
          
		  SqlHelper help=new SqlHelper();
		  rs=help.queryExecute(sql, params);
		  //从数据库中取值，数据和时间
		  try {
			while(rs.next())
			   {
			   float y0=rs.getFloat("tem");
			   float y1=rs.getFloat("hum");
			   float y2=rs.getFloat("smo");
			   String s=rs.getString("time");
			   //从yyyyMMddHHmm时间格式的char中取出年月日小时分设为int值
			   int x=Integer.parseInt(s.substring(0,4));
			   int y=Integer.parseInt(s.substring(4,6));
			   int z=Integer.parseInt(s.substring(6,8));		   

			   //timeseries.add();
			   timeseries.add(new Day(z,y,x),y0);
			   timeseries1.add(new Day(z,y,x),y1);
			   timeseries2.add(new Day(z,y,x),y2);

			  }
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  //连接曲线
		  TimeSeriesCollection dataset = new TimeSeriesCollection();
		   dataset.addSeries(timeseries);
		   dataset.addSeries(timeseries1);
		   dataset.addSeries(timeseries2);
		   dataset.setDomainIsPointsInTime(true);

		  //设置曲线图
		  XYDataset xydataset = (XYDataset) dataset;

	
		  return xydataset;
     }

	

}
