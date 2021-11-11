package com.kkb.mybatis.sqlsession;

import java.io.InputStream;
import java.io.Reader;

import com.kkb.mybatis.config.Configuration;
import com.kkb.mybatis.config.XMLConfigBuilder;

/**
 * 使用构建者模式去创建SqlSessionFactory
 * 
 * @author 灭霸詹
 *
 */
public class SqlSessionFactoryBuilder {
	private Configuration configuration;

	public SqlSessionFactory build(InputStream inputStream) {
		// 执行解析流程
		XMLConfigBuilder configBuilder = new XMLConfigBuilder();
		configuration = configBuilder.parse(inputStream);

		return build();
	}

	public SqlSessionFactory build(Reader reader) {
		return null;
	}
	
	private SqlSessionFactory build() {
		return new DefaultSqlSessionFactory(configuration);
	}

}
