package com.focus.Counter.controller;

import com.focus.Counter.entity.CounterRecord;
import com.focus.Counter.entity.RestResponse;
import com.focus.Counter.entity.PagedResult;
import com.focus.Counter.service.CounterRecordService;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/counterRecord")
public class CounterRecordController {

	private static Logger logger = Logger.getLogger(CounterRecordController.class);
	
	@Resource
	private CounterRecordService _counterRecordService;


	/**
	 * 执行新增操作
	 * @param data
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public RestResponse add(@RequestBody CounterRecord data , RestResponse rp){
		if (data == null) {
			rp.ErrorReply("保存失败");
			return rp;
		}
		boolean result = _counterRecordService.insert(data);
		if(result){
			rp.SuccessReply("保存成功");
		}else{
			rp.ErrorReply("保存失败");
		}
		return rp;
	}
	/**
	 * 执行编辑操作
	 * @param data
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public RestResponse edit(@RequestBody CounterRecord data , RestResponse rp){
		if (data == null) {
			rp.ErrorReply("保存失败");
			return rp;
		}
		boolean result = _counterRecordService.updatecounterRecord(data);
		if(result){
			rp.SuccessReply("保存成功");
		}else{
			rp.ErrorReply("保存失败");
		}
		return rp;
	}
	/**
	 * 执行删除操作
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public RestResponse delete(String id,RestResponse rp){
		boolean result = _counterRecordService.deletecounterRecordByKey(id);
		if(result){
			rp.SuccessReply("删除成功");
		}else{
			rp.ErrorReply("删除失败");
		}
		return rp;
	}
	

	/**
	 * 默认列表查询方法
	 * @return
	 */	
	@RequestMapping("/list")
	@ResponseBody
	public RestResponse getcounterRecordByFilters(Integer pageNo, Integer pageSize,RestResponse rp,PagedResult<CounterRecord> page){
		if(pageNo == null){
			pageNo = 0;
		}
		if(pageSize == null){
			pageSize = 0;
		}
		List<CounterRecord> list = null;
		PageHelper.startPage(pageNo, pageSize);
		Map map = new HashMap();
		Map param = new HashMap();
		param.put("map", map);
		list = _counterRecordService.getcounterRecordByFilters(param);

		rp.SuccessReply("查询成功",page.toPagedResult(list));
		return rp;
	}
}