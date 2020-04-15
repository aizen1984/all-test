package com.caoc.test.lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

@RequiredArgsConstructor
@Getter
public class DelegateTest {
	//	@Delegate
//	private List<String> address;
//	@Delegate(excludes = InnerB.class)
	@Delegate()
	private ProcessParameter processParameter;

	public static void main(String[] args) {
		DelegateTest delegateTest = new DelegateTest();

	}

	@RequiredArgsConstructor
	@Getter
	public static class ProcessParameter {

		/* 流水线的执行参数 */
		private Object requestParam;

		/* 流水线当前执行的 process 的次序 */
		private Integer order;

		/* 流水线当前执行的 process 在数据库中的 id */
		private Integer id;

		/* 上一个 process 传递过来的 resultParam */
		private Object resultParam;

		private InnerA innerA;
	}

	@Getter
	public static class InnerA {
		/* 流水线当前执行的 process 在数据库中的 id */
		private Long id;
	}

	public interface InnerB {
		Integer getId();
	}
}
