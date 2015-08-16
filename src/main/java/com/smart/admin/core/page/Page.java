package com.smart.admin.core.page;

import java.io.Serializable;
/**使用说明>
 * </p>
 * Makedate:2014-1-10 下午3:03:40
 * 
 * @author gaowenming
 * @version V1.0
 */
public class Page implements Serializable {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 当前页码，从0开始
	 */
	private int index;

	/**
	 * 每页记录数
	 */
	private int pageSize;

	/**
	 * 总记录数
	 */
	private int total;

	/**
	 * 构造方法
	 * 
	 * @param index
	 *            当前页码，从0开始
	 * @param pageSize
	 *            每页记录数
	 * @param total
	 *            总记录数
	 */
	public Page(int index, int pageSize, int total) {
		this.index = index;
		this.pageSize = pageSize;
		this.total = total;
	}

	public Page() {
	}

	/**
	 * 获取总页数
	 * 
	 * @return 总页数
	 */
	public int getPageCount() {
		return (int) Math.ceil((double) total / (double) pageSize);
	}

	/**
	 * 是否有下一页
	 * 
	 * @return true,如果有下一页，否则为false
	 */
	public boolean isHasNext() {
		return index >= 0 && index < getPageCount() - 1;
	}

	/**
	 * 是否有上一页
	 * 
	 * @return true,如果有上一页，否则为false
	 */
	public boolean isHasPrev() {
		return index > 0 && index < getPageCount();
	}

	/**
	 * 是否有后几页，offset可以为负数
	 * 
	 * @param offset
	 *            偏移量
	 * @return 如果有对应于该偏移量的页，返回true否则返回false
	 */
	public boolean isHasOffset(int offset) {
		int target = index + offset;
		return target >= 0 && target < getPageCount();
	}

	/**
	 * 获取当前页标识的数据集起始位置
	 * 
	 * @return 起始位置
	 */
	public int getRecordStartIndex() {
		return index * pageSize;
	}

	/**
	 * 描述 : <获取当前页标识的数据集结束位置>. <br>
	 * <p>
	 * <使用方法说明>
	 * </p>
	 * 
	 * @return
	 */
	public int getRecordLastIndex() {
		return (index + 1) * pageSize > total ? total : (index + 1) * pageSize;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}