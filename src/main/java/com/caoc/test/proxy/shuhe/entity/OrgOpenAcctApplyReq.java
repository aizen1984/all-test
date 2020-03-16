package com.caoc.test.proxy.shuhe.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.caoc.test.aop.shuhe.base.AbstractReq;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class OrgOpenAcctApplyReq extends AbstractReq {
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
	 * 卡号
	 * String(32)
	 * M
	 */
	@Size(max = 32)
	@JSONField(name = "card_number")
	@NotNull
	private String cardNumber;

	/**
	 * 绑定的手机号
	 * String(14)
	 * M
	 */
	@Size(max = 14)
	@JSONField(name = "bind_phone")
	@NotNull
	private String bindPhone;

	/**
	 * 开户协议版本号
	 * String(8)
	 * 微众协议文件对应的协议版本号
	 * M
	 */
	@Size(max = 8)
	@JSONField(name = "contract_ver_kh")
	@NotNull
	private String contractVerKh;

	/**
	 * 同意开户时间
	 * 用户同意提交开户申请的时间
	 * YYYYMMDDHHMMSS
	 * M
	 */
	@Size(max = 14)
	@JSONField(name = "agree_protocol_time")
	@NotNull
	private String agreeProtocolTime;

	/**
	 * 机构OPT验证结果
	 * 后台开户必须，S-通过，F-不通过
	 * String(8)
	 * O
	 */
	@Size(max = 8)
	@JSONField(name = "otp_verify_result")
	private String otpVerifyResult;

	/**
	 * 验证OTP时间
	 * 合作机构验证OTP的时间
	 * YYYYMMDDHHMMSS
	 * String(14)
	 * O
	 */
	@Size(max = 14)
	@JSONField(name = "yd_suc_time")
	private String ydSucTime;

	/**
	 * 客户终端IP
	 * String(16)
	 * M
	 */
	@Size(max = 16)
	@JSONField(name = "scence_ip")
	@NotBlank
	private String scenceIp;

	/**
	 * 前端页面版本号
	 * String(8)
	 * O
	 */
	@Size(max = 8)
	@JSONField(name = "h5_ver")
	private String h5Ver;

	/**
	 * 设备号
	 * IOS：供应商标识符 IDFV 安卓：IMEI(手机设备识别码)
	 * String(32)
	 * M
	 */
	@Size(max = 32)
	@JSONField(name = "device_id")
	@NotBlank
	private String deviceId;

	/**
	 * Otp验证码
	 * String(10)
	 * O
	 */
	@Size(max = 10)
	@JSONField(name = "otp_code")
	private String otpCode;

	/**
	 * 税收居民身份
	 * 税收居民身份（1、中国税收居民；2、非居民；3、既是中国税收居民又是其他国家（地区）税收居民）
	 * String(2)
	 * M
	 */
	@Size(max = 2)
	@NotNull
	private String residentsTax;

	/**
	 * 处理类型。标识是否是新处理模式。对应到开户接口的deal_type
	 * 默认值01
	 * 01：老的开户模式
	 * 02：新的开户模式，目前萨摩耶使用
	 * String(8)
	 * O
	 */
	@Size(max = 8)
	@JSONField(name = "deal_type")
	private String dealType;

	/**
	 * 密码
	 * String(100)
	 * O
	 */
	@Size(max = 100)
	private String password;

	/**
	 * 密码因子
	 * String(100)
	 * O
	 */
	@Size(max = 100)
	@JSONField(name = "pwd_factor")
	private String pwdFactor;

	/**
	 * 合作方账龄（区间）
	 * 适用产品类型：基金/消费金融
	 * 申请开微众户时，距离合作方账户开户的时间（天）
	 * 1：1天内 2：2-7天 3：7-30天 4：30-90天 5：90-180天 6：180-360天 7：360天以上
	 * String(12)
	 * M
	 */
	@Size(max = 12)
	@JSONField(name = "risk_partner_acct_receivable_period")
//    @NotNull
	private String riskPartnerAcctReceivablePeriod;

	/**
	 * 合作方是否有进行人脸识别
	 * 适用产品类型：基金/消费金融
	 * 1:人脸识别已通过；2:人脸识别未通过；3：无人脸识别记录
	 * String(8)
	 * M
	 */
	@Size(max = 8)
	@JSONField(name = "risk_if_partner_acct_face_recog")
//    @NotNull
	private String riskIfPartnerAcctFaceRecog;

	/**
	 * 合作方账户预留手机号实名校验结果
	 * 适用产品类型：基金/消费金融
	 * 1:已实名验证通过；2:实名验证未通过；3：未实名验证
	 * String(8)
	 * M
	 */
	@Size(max = 8)
	@JSONField(name = "risk_partner_acct_phone_verify_result")
//    @NotNull
	private String riskPartnerAcctPhoneVerifyResult;

	/**
	 * 合作方账户银行卡绑卡手机号实名校验结果
	 * 适用产品类型：基金/消费金融
	 * 1:已实名验证通过；2:实名验证未通过；3：未实名验证
	 * String(8)
	 * M
	 */
	@Size(max = 8)
	@JSONField(name = "risk_partner_acct_bankcard_phone_verify_result")
//    @NotNull
	private String riskPartnerAcctBankcardPhoneVerifyResult;

	/**
	 * 合作方账户是否有90天以上逾期还款记录--消费金融
	 * 适用产品类型：消费金融
	 * 1:是；0:否
	 * String(8)
	 * M
	 */
	@Size(max = 8)
	@JSONField(name = "risk_if_overdue")
//    @NotNull
	private String riskIfOverdue;

	/**
	 * 合作方账户是否有交易否认记录
	 * 适用产品类型：基金/消费金融
	 * 1:是；0:否
	 * String(8)
	 * M
	 */
	@Size(max = 8)
	@JSONField(name = "risk_if_fraud")
//    @NotNull
	private String riskIfFraud;
}
