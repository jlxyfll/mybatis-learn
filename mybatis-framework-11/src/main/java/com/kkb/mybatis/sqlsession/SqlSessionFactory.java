package com.kkb.mybatis.sqlsession;

/**
 * 主要用来生产SqlSession
 * @author 灭霸詹
 *
 */
public interface SqlSessionFactory {

	SqlSession openSession();

}
