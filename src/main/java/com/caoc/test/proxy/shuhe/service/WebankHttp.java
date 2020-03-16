package com.caoc.test.proxy.shuhe.service;

import com.caoc.test.proxy.shuhe.entity.OrgOpenAcctApplyReq;
import com.caoc.test.proxy.shuhe.entity.OrgOpenAcctApplyResp;

public interface WebankHttp {

	OrgOpenAcctApplyResp orgOpenAcctApply(OrgOpenAcctApplyReq orgOpenAcctApplyReq);
}
