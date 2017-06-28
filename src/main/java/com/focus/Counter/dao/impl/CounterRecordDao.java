package com.focus.Counter.dao.impl;

import com.focus.Counter.dao.ICounterRecordDao;
import com.focus.Counter.entity.CounterRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CounterRecordDao extends BaseDao implements
		ICounterRecordDao {
		
	//插入
	@Override
	public boolean insert(CounterRecord obj) {
		int num = this.getSqlSession().insert("CounterRecord.insert", obj);
		return num > 0;
	}
	//批量插入
	@Override
	public boolean insertBatch(List<CounterRecord> list) {
		int num = this.getSqlSession().insert("CounterRecord.insertBatch", list);
		return num > 0;
	}
	//更新
	@Override
	public boolean updatecounterRecord(CounterRecord obj){
		int num = this.getSqlSession().update("CounterRecord.updatecounterRecord", obj);
		return num > 0;
	}
	//根据主键删除
	@Override
	public boolean deletecounterRecordByKey(String id){
		int num = this.getSqlSession().delete("CounterRecord.deletecounterRecordByKey", id);
		return num > 0;
	}
	
	//根据主键查询
	@Override
	public List<CounterRecord> getcounterRecordByKey(String id){
		List<CounterRecord> result = this.getSqlSession().selectList("CounterRecord.getcounterRecordByKey", id);
		return result;
	}
	
	//根据HashMap组合参数And查询
	@Override
	public List<CounterRecord> getcounterRecordByFilters(Map map){
		List<CounterRecord> result = this.getSqlSession().selectList("CounterRecord.getcounterRecordByFilters", map);
		return result;
	}
	
	//根据HashMap组合参数Or查询
	@Override
	public List<CounterRecord> getcounterRecordByFiltersII(Map map){
		List<CounterRecord> result = this.getSqlSession().selectList("CounterRecord.getcounterRecordByFiltersII", map);
		return result;
	}
	
	//根据HashMap组合参数删除
	@Override
	public boolean deletecounterRecordByFilters(Map map){
		int num = this.getSqlSession().delete("CounterRecord.deletecounterRecordByFilters", map);
		return num > 0;
	}
}