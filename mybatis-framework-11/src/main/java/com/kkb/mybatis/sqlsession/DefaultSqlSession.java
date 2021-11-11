package com.kkb.mybatis.sqlsession;

import java.util.List;

import com.kkb.mybatis.config.Configuration;
import com.kkb.mybatis.config.MappedStatement;
import com.kkb.mybatis.executor.CachingExecutor;
import com.kkb.mybatis.executor.SimpleExecutor;
import com.kkb.mybatis.executor.iface.Executor;

public class DefaultSqlSession implements SqlSession {
	// 注入Configuration对象
	private Configuration configuration;

	public DefaultSqlSession(Configuration configuration) {
		this.configuration = configuration;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T selectOne(String statementId, Object param) {
		List<Object> list = this.selectList(statementId, param);
		if (list != null && list.size() == 1) {
			return (T) list.get(0);
		}
		return null;
	}

	@Override
	public <T> List<T> selectList(String statementId, Object param) {
		// 根据statementId获取MappedStatement对象
		MappedStatement mappedStatement = configuration.getMappedStatementById(statementId);

		Executor executor = new CachingExecutor(new SimpleExecutor());
		return executor.query(mappedStatement, configuration, param);
	}

}
