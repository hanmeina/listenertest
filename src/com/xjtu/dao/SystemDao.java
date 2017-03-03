package com.xjtu.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.xjtu.util.JdbcUtil;


public class SystemDao {
	//删除表
	public void dropTable(String tableName) throws SQLException{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "drop table if exists " + tableName;
		runner.update(sql);
	}
	
	//创建表
	public void createTable(String tableName) throws SQLException{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "create table if not exists "+tableName+"(id varchar(40) primary key,curr_time timestamp not null)";
		runner.update(sql);
	}
	
	//初始化数据
	public void init(String tableName,String id) throws SQLException{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "insert into "+tableName+"(id) values(?)";
		runner.update(sql,id);
	}
}



