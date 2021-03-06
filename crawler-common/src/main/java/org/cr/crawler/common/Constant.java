/**
 *
 */
package org.cr.crawler.common;

/**
 * @author caorong
 */
public class Constant {
    public static final Integer TASK_STATE_INITIAL = 0;
    public static final Integer TASK_STATE_FETCHING = 1;
    public static final Integer TASK_STATE_DOWNLOADING = 2;

    public static final Integer TASK_STATE_SUCCESS = 5;
    public static final Integer TASK_STATE_FAILED = 6;
    public static final Integer TASK_STATE_RETRYING = 7;

    // list or detail
    public static final Integer LIST_TASK_TYPE = 1;
    public static final Integer DETAIL_TASK_TYPE = 2;
}
