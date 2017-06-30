package com.focus.Counter.service;

import com.focus.Counter.dao.ICounterRecordDao;
import com.focus.Counter.entity.CounterRecord;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CounterRecordService {
	
	private static Logger logger = Logger.getLogger(CounterRecordService.class);
	
	@Resource
	private ICounterRecordDao _counterRecordDao;

	public ICounterRecordDao get_counterRecordDao() {
		return _counterRecordDao;
	}

	public void set_counterRecordDao(ICounterRecordDao _counterRecordDao) {
		this._counterRecordDao = _counterRecordDao;
	}
	
	//插入
	public boolean insert(CounterRecord obj){
		return _counterRecordDao.insert(obj);
	}
	
	//批量插入
	public boolean insertBatch(List<CounterRecord> list){
		return _counterRecordDao.insertBatch(list);
	}
	
	//更新
	public boolean updatecounterRecord(CounterRecord obj){
		return _counterRecordDao.updatecounterRecord(obj);
	}
		
	//根据主键删除
	public	boolean deletecounterRecordByKey(String id){
		return _counterRecordDao.deletecounterRecordByKey(id);
	}
		
	//根据主键查询
	public	List<CounterRecord> getcounterRecordByKey(String id){
		return _counterRecordDao.getcounterRecordByKey(id);
	}
		
	//根据HashMap组合参数And查询
	public	List<CounterRecord> getcounterRecordByFilters(){
		return _counterRecordDao.getcounterRecordByFilters();
	}


	//根据HashMap组合参数And查询
	public	List<CounterRecord> getcounterRecordByClientIp(String clientIp){
		return _counterRecordDao.getcounterRecordByClientIp(clientIp);
	}
	//根据HashMap组合参数删除
	public	boolean deletecounterRecordByFilters(Map map){
		return _counterRecordDao.deletecounterRecordByFilters(map);
	}
	
	
}