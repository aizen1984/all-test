package com.caoc.test.spring.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.support.TaskUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author caochen
 */
@Component
@Slf4j
public class LoggingErrorHandler implements RejectedExecutionHandler, ErrorHandler {
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		log.error("batch job queue reach max limit");
	}


	@Override
	public void handleError(Throwable throwable) {
		TaskUtils.LOG_AND_SUPPRESS_ERROR_HANDLER.handleError(throwable);
	}
}
