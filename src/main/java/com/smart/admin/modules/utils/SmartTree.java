package com.smart.admin.modules.utils;

import java.util.List;

/**
 * 
 * 树形结构
 * 
 * @author gaowenming
 *
 */
public class SmartTree {

	private String id;
	private String text;
	private String value;
	private boolean showcheck;
	private boolean complete;
	private boolean isexpand;
	private boolean hasChildren;
	private int checkstate;
	private List<SubSmartTree> childNodes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isShowcheck() {
		return showcheck;
	}

	public void setShowcheck(boolean showcheck) {
		this.showcheck = showcheck;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public boolean isIsexpand() {
		return isexpand;
	}

	public void setIsexpand(boolean isexpand) {
		this.isexpand = isexpand;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

	public int getCheckstate() {
		return checkstate;
	}

	public void setCheckstate(int checkstate) {
		this.checkstate = checkstate;
	}

	public List<SubSmartTree> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(List<SubSmartTree> childNodes) {
		this.childNodes = childNodes;
	}

}
