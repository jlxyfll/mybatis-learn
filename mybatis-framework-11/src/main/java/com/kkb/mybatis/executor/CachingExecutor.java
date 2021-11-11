package com.kkb.mybatis.executor;

import java.util.List;

import com.kkb.mybatis.config.Configuration;
import com.kkb.mybatis.config.MappedStatement;
import com.kkb.mybatis.executor.iface.Executor;

public class CachingExecutor implements Executor {

	private Executor delegate;
	
	public CachingExecutor(Executor delegate) {
		this.delegate = delegate;
	}

	@Override
	public <T> List<T> query(MappedStatement mappedStatement, Configuration configuration, Object param) {
		// 处理二级缓存
		return delegate.query(mappedStatement, configuration, param);
	}

}
