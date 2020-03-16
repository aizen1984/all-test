package com.caoc.test.proxy.shuhe.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.caoc.test.aop.shuhe.base.AbstractReq;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class AccountQueryReq extends AbstractReq {
	/**
	 * 合作机构号客户ID
	 * String(40)
	 * M
	 */
	@Size(max = 40)
	@JSONField(name = "open_id")
	@NotNull
	private String openId;

	/**
	 * 证件类型
	 * String(3)
	 * 01:身份证
	 * M
	 */
	@Size(max = 3)
	@JSONField(name = "id_type")
	@NotNull
	private String idType;

	/**
	 * 证件号码
	 * String(32)
	 * M
	 */
	@Size(max = 32)
	@JSONField(name = "id_code")
	@NotNull
	private String idCode;

	/**
	 * 姓名
	 * String(100)
	 * M
	 */
	@Size(max = 100)
	@NotNull
	private String name;

	/**
	 * 微众卡号
	 * 新模式开户第一次上传身份证时微众卡号可以为空。特别注意：当开户人工审核失败第二次发起身份证上传时必须传入微众卡号
	 * String(32)
	 * O
	 */
	@Size(max = 32)
	@JSONField(name = "webank_number")
	private String webankNumber;

	/**
	 * 消息扩展
	 * String(256)
	 * O
	 */
	@Size(max = 256)
	private String remark;
}
