package com.focus.Counter.dao;

import com.focus.Counter.entity.*;

import java.util.List;
import java.util.Map;

public interface ICounterRecordDao {

	//插入
	boolean insert(CounterRecord obj);
	
	//批量插入
	boolean insertBatch(List<CounterRecord> list);
	
	//更新
	boolean updatecounterRecord(CounterRecord obj);
	
	//根据主键删除
	boolean deletecounterRecordByKey(String id);
	
	//根据主键查询
	List<CounterRecord> getcounterRecordByKey(String id);
	
	//根据HashMap组合参数And查询
	List<CounterRecord> getcounterRecordByFilters(Map map);
	
	//根据HashMap组合参数Or查询
	List<CounterRecord> getcounterRecordByFiltersII(Map map);
	
	//根据HashMap组合参数删除
	boolean deletecounterRecordByFilters(Map map);
	
}