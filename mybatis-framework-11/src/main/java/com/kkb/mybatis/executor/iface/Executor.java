package com.kkb.mybatis.executor.iface;

import java.util.List;

import com.kkb.mybatis.config.Configuration;
import com.kkb.mybatis.config.MappedStatement;

public interface Executor {
	
	/**
	 * 
	 * @param mappedStatement 获取SQL语句和入参出参类型信息
	 * @param configuration	获取数据源连接处信息
	 * @param param	获取入参类型
	 * @return
	 */
	<T> List<T> query(MappedStatement mappedStatement,Configuration configuration,Object param);

}
