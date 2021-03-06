/**
 * 
 */
package org.cr.crawler.node.operation.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.cr.crawler.common.Constant;
import org.cr.crawler.common.model.Task;
import org.cr.crawler.common.service.TaskService;
import org.cr.crawler.node.operation.PageOperation;
import org.cr.crawler.node.parse.Parser;
import org.cr.crawler.node.utils.ConfigConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author caorong
 * 
 */
public class ListPageOperation extends PageOperation {

	private Logger logger = LoggerFactory.getLogger(ListPageOperation.class);

	@Autowired
	private TaskService taskService;

	@Autowired
	private ConfigConstant configConstant;

	@Override
	public Task operate(Task task) {
		try {
			if (!StringUtils.isEmpty(task.getUrl())) {
				Parser parser = getParser(task.getUrl());
				// get urls
				List<Map<String, String>> detailsUrls = parser
						.getDetailUrls(task);
				// make urls to task model type 2
				if (taskService.submitTaskFromListMap(detailsUrls, task,
						configConstant.getWorkerNodeName())) {
					task.setState(Constant.TASK_STATE_SUCCESS);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			task.setStateFlag(false);
		}
		return task;
	}

	@Override
	public String getName() {
		return "parse";
	}

}
