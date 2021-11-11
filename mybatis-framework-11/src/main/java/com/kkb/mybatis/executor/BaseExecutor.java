package com.kkb.mybatis.executor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kkb.mybatis.config.Configuration;
import com.kkb.mybatis.config.MappedStatement;
import com.kkb.mybatis.executor.iface.Executor;
import com.kkb.mybatis.sqlsource.BoundSql;

public abstract class BaseExecutor implements Executor {

	private Map<String, List<Object>> oneLevelCache = new HashMap<>();

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> query(MappedStatement mappedStatement, Configuration configuration, Object param) {
		// 调用SqlSource获取BoundSql
		BoundSql boundSql = mappedStatement.getSqlSource().getBoundSql(param);
		// 处理一级缓存
		List<Object> results = oneLevelCache.get(boundSql.getSql());
		if (results != null) {
			return (List<T>) results;
		}

		// 查询数据库
		results = queryFromDataBase(mappedStatement, configuration, param, boundSql);

		oneLevelCache.put(boundSql.getSql(), results);
		return (List<T>) results;
	}

	public abstract List<Object> queryFromDataBase(MappedStatement mappedStatement, Configuration configuration,
			Object param, BoundSql boundSql);

}
