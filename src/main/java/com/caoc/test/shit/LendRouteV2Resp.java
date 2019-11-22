package com.caoc.test.shit;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @Auther: houjun
 * @Date: 2018/6/8 13:23
 * @Description:
 */
@Data
public class LendRouteV2Resp extends LendengineBaseResp {
	/**
	 * 资方
	 */
	private String assetBank;
	/**
	 * 资方产品
	 */
	private String assetProductId;
	/**
	 * 聚合期数
	 */
	private String groupStage;
	/**
	 * 资方金额聚合范围
	 */
	private String groupRangeLend;
	/**
	 * 资方聚合最小金额
	 */
	private String groupMinLend;
	/**
	 * 资方聚合最大金额
	 */
	private String groupMaxLend;
	/**
	 * 资方聚合还款方式
	 */
	private String groupRepayType;
	/**
	 * 下限
	 */
	private Integer minLend;
	/**
	 * 上限
	 */
	private Integer maxLend;
	/**
	 * 期数
	 */
	private Integer stage;
	/**
	 * 还款方式
	 */
	private String repayType;
	/**
	 * 优惠券列表
	 */
	private String couponId;
	/**
	 * 支持卡类型
	 */
	private String cardId;


	public static void main(String[] args) {

		LendRouteV2Resp lendRouteV2Resp = new LendRouteV2Resp();
		lendRouteV2Resp.setAssetBank("HTBANK");
		lendRouteV2Resp.setAssetProductId("HTBANK");
		lendRouteV2Resp.setGroupStage("1,3,6,9");
		lendRouteV2Resp.setGroupRangeLend("{[100,1000],[1500,10000]}");
		lendRouteV2Resp.setGroupMinLend("100");
		lendRouteV2Resp.setGroupMaxLend("10000");
		lendRouteV2Resp.setGroupRepayType("REPAY-ANY,STAGE");
		lendRouteV2Resp.setMinLend(100);
		lendRouteV2Resp.setMaxLend(10000);
		lendRouteV2Resp.setStage(3);
		lendRouteV2Resp.setRepayType("REPAY-ANY");
        lendRouteV2Resp.setRespCode(200);
        lendRouteV2Resp.setRespMsg("处理成功");

        System.out.println(JSON.toJSON(lendRouteV2Resp));





	}

}
