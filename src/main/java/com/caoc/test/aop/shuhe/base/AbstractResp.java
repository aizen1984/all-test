package com.caoc.test.aop.shuhe.base;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AbstractResp implements AbstrNeedBo {
	/**
	 * 响应日期
	 * STRING(8)
	 * M
	 * 格式：YYYYMMDD
	 */
	@ApiModelProperty(value = "响应日期")
	@JSONField(name = "head_rsp_date")
	private String headRspDate;
	/**
	 * 响应时间
	 * STRING(10)
	 * M
	 * 格式：MMDDHHMMSS
	 */
	@ApiModelProperty(value = "响应时间")
	@JSONField(name = "head_rsp_time")
	private String headRspTime;
	/**
	 * 发起机构
	 * STRING(14)
	 * M
	 * 报文发送方的机构标识，由webank分配
	 */
	@ApiModelProperty(value = "发起机构")
	@JSONField(name = "head_snd_organ")
	private String headSndOrgan;
	/**
	 * 接收机构
	 * STRING(14)
	 * M
	 * 报文接收方的机构标识，由webank分配
	 */
	@ApiModelProperty(value = "接收机构")
	@JSONField(name = "head_rev_organ")
	private String headRevOrgan;
	/**
	 * 交易流水号
	 * STRING(32)
	 * M
	 * 所有业务及日期中唯一并包含第三方支付平台机构号交易日期等信息
	 */
	@ApiModelProperty(value = "交易流水号")
	@JSONField(name = "head_business_id")
	private String headBusinessId;

	/**
	 * 返回码
	 * STRING(4)
	 * M
	 * 错误码：见3.17节
	 */
	@ApiModelProperty(value = "返回码")
	private String retCode;

	/**
	 * 返回信息
	 * STRING(256)
	 * O
	 * 交易失败时填写
	 */
	@ApiModelProperty(value = "返回信息")
	private String retMsg;

	/**
	 * 返回信息
	 * STRING(4)
	 * M
	 * 初始1.0
	 */
	@ApiModelProperty(value = "返回信息")
	@JSONField(name = "head_msg_version")
	private String headMsgVersion;

	/**
	 * 摘要
	 * String(512)
	 * M
	 */
	@ApiModelProperty(value = "摘要")
	private String abstr;
}
