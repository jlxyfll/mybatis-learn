package com.kkb.mybatis.sqlsession;

import java.util.List;

/**
 * 表示一次Sql会话
 * 
 * @author 灭霸詹
 *
 */
public interface SqlSession {

	/**
	 * 查询单个对象
	 * 
	 * @param statementId
	 * @param param
	 * @return
	 */
	<T> T selectOne(String statementId, Object param);

	<T> List<T> selectList(String statementId, Object param);

}
