package org.cr.crawler.node.parse;

import org.cr.crawler.common.model.Task;

import java.util.HashMap;
import java.util.List;

/**
 * Author: caorong
 * Date: 13-11-16
 * Time: 下午10:29
 * To change this template use File | Settings | File Templates.
 */
public interface Parser {
    List<HashMap<String, String>> getDetailUrls(Task task) throws Exception;

}
