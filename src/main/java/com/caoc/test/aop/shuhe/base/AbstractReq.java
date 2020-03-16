package com.caoc.test.aop.shuhe.base;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class AbstractReq {
	/**
	 * 交易日期
	 * STRING(8)
	 * M
	 * 格式：YYYYMMDD
	 */
	@Size(min = 8, max = 8)
	@NotNull
	@JSONField(name = "head_req_date")
	private String headReqDate;

	/**
	 * 交易时间
	 * STRING(10)
	 * M
	 * 格式：MMDDHHMMSS
	 */
	@Size(min = 10, max = 10)
	@NotNull
	@JSONField(name = "head_req_time")
	private String headReqTime;

	/**
	 * 发起机构
	 * STRING(14)
	 * M
	 * 报文发送方的机构标识，由webank分配
	 */
	@Size(max = 14)
	@NotNull
	@JSONField(name = "head_snd_organ")
	private String headSndOrgan;
	/**
	 * 接收机构
	 * STRING(14)
	 * M
	 * 报文接收方的机构标识，由webank分配
	 */
	@Size(max = 14)
	@NotNull
	@JSONField(name = "head_rev_organ")
	private String headRevOrgan;

	/**
	 * 交易流水号
	 * STRING(32): for example: 23569637541246552808132909333874
	 * M
	 * 所有业务及日期中唯一并包含第三方支付平台机构号交易日期等信息
	 */
	@Size(min = 32, max = 32)
	@NotNull
	@JSONField(name = "head_business_id")
	private String headBusinessId;

	/**
	 * 报文类型
	 * STRING(20)
	 * M
	 * 参考3.8交易定义
	 *
	 * @see
	 */
	@Size(max = 20)
	@NotNull
	@JSONField(name = "head_tran_name")
	private String headTranName;

	/**
	 * 版本号
	 * STRING(4)
	 * M
	 * 初始1.0
	 */
	@Size(max = 4)
	@NotNull
	@JSONField(name = "head_msg_version")
	private String headMsgVersion;
	/**
	 * 报文签名
	 */
	@Size(max = 512)
	@NotNull
	private String abstr;
}
