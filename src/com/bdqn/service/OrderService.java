package com.bdqn.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bdqn.dao.OrderDao;
import com.bdqn.dao.impl.OrderDaoImpl;
import com.bdqn.pojo.Order;
import com.bdqn.util.DoDate;
import com.bdqn.util.MybatisUtil;
import com.bdqn.util.Page;
import com.bdqn.util.Week;

public class OrderService {
	OrderDaoImpl o = new OrderDaoImpl();
	
	private OrderDao mapper;
	
	public OrderService(){
		SqlSession session = MybatisUtil.getSqlSession();
		mapper = session.getMapper(OrderDao.class);
	}
	//搜索
	public Page<Order> check(Order order,int currentPage,int pageSize){
		//没有解决日期在数据库中去比较，只能变成字符串传进去
		String start = DoDate.datetostr(order.getStarttime());
		String end = DoDate.datetostr(order.getEndtime());
		String book = DoDate.datetostr(order.getBooktime());
		
		int first = (currentPage-1)*pageSize;
		
		List<Order> list = mapper.check(order, start, end, book,first,pageSize);
		//System.out.println(list);
		
		int totle = mapper.check(order, start, end, book, -1, -1).size();
		int totlePage = totle%pageSize==0?totle/pageSize:totle/pageSize+1;
		Page<Order> page = new Page<Order>(currentPage, totlePage, totle, pageSize, list);
		return page;
	}
	
	//分页
	public Page<Order> paging(int currentPage,int pageSize) {
		List<Order> list = o.Paging(currentPage, pageSize);
		int totle = o.getTotle().size();
		int totlePage = totle%pageSize==0?totle/pageSize:totle/pageSize+1;
		Page<Order> page = new Page<Order>(currentPage, totlePage, totle, pageSize, list);
		return page;
	}
	
	public Week getWeekFromDay(Date date) {
		List<Order> list = o.getalldata();
		int[] thisweek = new int[7];
		int[] previousweek = new int[7];
		String[] weekname = new String[7];
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		for (int i = 0; i < 14; i++) {
			int price = 0;
			calendar.add(Calendar.DATE, -1);
			Date dd =calendar.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d;
			try {
				d = sdf.parse(sdf.format(dd));
				for(Order o:list) {
					if(o.getEndtime().compareTo(d)==0) {
						price = price + o.getEprice();
					}
				}
				if(i<7) {
					thisweek[i] = price;
					int n = calendar.get(Calendar.DAY_OF_WEEK);
					switch(n) {
					case 1:
						weekname[i] = "Sun";
						break;
					case 2:
						weekname[i] = "Mon";
						break;
					case 3:
						weekname[i] = "Tue";
						break;
					case 4:
						weekname[i] = "Wed";
						break;
					case 5:
						weekname[i] = "Thu";
						break;
					case 6:
						weekname[i] = "Fri";
						break;
					case 7:
						weekname[i] = "Sat";
						break;
					}
				}else if(i>=7) {
					previousweek[i-7]=price;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		Week week = new Week(thisweek, previousweek,weekname);
		return week;
	}
	public Order queryById(int oid) {
		return o.queryById(oid);
	}
	public boolean add(Order order) {
		return o.add(order);
	}
	public boolean deletById(int oid) {
		return o.deletById(oid);
	}
	public boolean updateById(int id,Order order) {
		return o.updateById(id, order);
	}
	public int getAllprice() {
		return o.getAllprice();
	}
	public int getPriceFromMorW(int mw,String type) {
		return o.getPriceFromMorW(mw, type);
	}
	//两个日期之间的天数
	public int numOfDay(Date start,Date end) {
		Calendar c = Calendar.getInstance();
		c.setTime(start);
		int count = 0;
		while(c.getTime().compareTo(end)!=0) {
			c.add(Calendar.DATE, 1);
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		OrderService os = new OrderService();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date d;
//		try {
//			d = sdf.parse("2019-4-2");
//			Week w = os.getWeekFromDay(new Date());
//			System.out.println(Arrays.toString(w.getThisweek()));
//			System.out.println(Arrays.toString(w.getPreviousweek()));
//			System.out.println(Arrays.toString(w.getWeekname()));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
//		Order order = new Order();
//		order.setBooktime(DoDate.strtodate("2019-3-03"));
//		os.check(order, 1, 2);
		
//		Order order = new Order(0, 0, 0, 0, null, null, 200, null, null, null);
//		Page<Order> page = os.check(order, 1, 5);
//		System.out.println(page.getTotlePage());
		
		//计算填入数据每单的总价格
//		List<Order> list = os.o.getTotle();
//		for(Order or :list) {
//			Date s = or.getStarttime();
//			Date e = or.getEndtime();
//			int i = os.numOfDay(s, e);
//			int price = i*or.getEprice();
//			int oid = or.getOid();
//			or.setEprice(price);
//			
//			os.updateById(oid, or);						
//		}
		
	}
}
