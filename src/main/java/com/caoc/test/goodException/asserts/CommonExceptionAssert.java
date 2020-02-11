package com.caoc.test.goodException.asserts;

import com.caoc.test.goodException.constant.enums.IResponseEnum;
import com.caoc.test.goodException.exceptions.ArgumentException;
import com.caoc.test.goodException.exceptions.BaseException;
import com.caoc.test.goodException.exceptions.BusinessException;

import java.text.MessageFormat;

public interface CommonExceptionAssert extends IResponseEnum,Assert {
	@Override
	default BaseException newException(Object... args){
		String msg = MessageFormat.format(this.getMessage(), args);
		return new ArgumentException(this, args, msg);
	}

	@Override
	default BaseException newException(Throwable t, Object... args){
		String msg = MessageFormat.format(this.getMessage(), args);
		return new ArgumentException(this, args, msg, t);
	}
}
