package com.kkb.mybatis.sqlsession;

import com.kkb.mybatis.config.Configuration;

/**
 * @author 灭霸詹
 *
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

	//注入Configuration对象
	private Configuration configuration;

	public DefaultSqlSessionFactory(Configuration configuration) {
		this.configuration = configuration;
	}

	@Override
	public SqlSession openSession() {
		return new DefaultSqlSession(configuration);
	}

}
