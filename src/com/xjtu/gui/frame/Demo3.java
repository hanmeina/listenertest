package com.xjtu.gui.frame;

import java.sql.SQLException;

import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import com.xjtu.dao.SystemDao;


//课程练习1
public class Demo3 {	
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new YouTimerTask(),0,5*1000);
	}
}
//线程任务
class YouTimerTask extends TimerTask{
	public void run() {
		try {
			SystemDao systemDao = new SystemDao();
			systemDao.init("systemInit",UUID.randomUUID().toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
/*
drop table if exists systemInit;
create table if not exists systemInit(
	id varchar(40) primary key,
    curr_time timestamp not null
);
*/



