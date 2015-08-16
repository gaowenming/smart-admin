package com.smart.admin.modules.utils;

/**
 * 
 * @Description: 选择器，如checkbox和radio
 * @author gaowenming
 * @date 2014年6月29日 下午4:26:43
 *
 */
public class ChosenItem {

	private String id;
	private String value;
	private boolean chosen;

	public ChosenItem(String id, String value, boolean chosen) {
		super();
		this.id = id;
		this.value = value;
		this.chosen = chosen;
	}

	public ChosenItem() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isChosen() {
		return chosen;
	}

	public void setChosen(boolean chosen) {
		this.chosen = chosen;
	}

}
