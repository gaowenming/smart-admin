package com.smart.admin.modules.utils;

/**
 * 
 * @Description: 系统常量
 * @author gaowenming
 * @date 2014年8月5日 下午10:33:37
 *
 */
public class Constants {

	public static final String REPLACENAME = "###";
	
	// 制码申请单状态
	public static final int READY = 0; // 等待
	public static final int REJECT = 9;// 驳回
	public static final int ACCEPT = 1;// 通过

	// 制码队列状态
	public static final int READY2MAKE = 0; // 等待制码
	public static final int MAKEFAIL = 9; // 制码失败
	public static final int MAKESUCCESS = 1; // 制码成功

	// 码图大小
	public static final int WIDTH = 300;
	public static final int HEIGHT = 300;

	// 下发状态
	public static final int SEND_SUCCESS = 1; // 下发成功
	public static final int SEND_WAITTIP = 2;// 等待状态报告返回
	public static final int SEND_FAIL = 3;// 失败

	// 下发方式
	public static final int SEND_EMAIL = 1;
	public static final int SEND_SMS = 2;
	public static final int SEND_MMS = 3;

	// 辅助码长度
	public static final int ASSISTNUM_LENGTH = 16;

	// 凭证状态
	public static final int QRCODE_STATE_NORMAL = 1; // 有效
	public static final int QRCODE_STATE_DISABLE = 9; // 无效

}
