package com.caoc.test.batchTest;

import com.caoc.test.TestApplication;
import com.caoc.test.domain.TApplyInfo;
import com.caoc.test.mapper.TApplyInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.testng.collections.Lists;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(TestApplication.class)
public class BatchTest {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private TApplyInfoMapper tApplyInfoMapper;


	@Test
	public void test() {

		DataSourceTransactionManager dataSourceTransactionManager = applicationContext.getBean("transactionManager", DataSourceTransactionManager.class);
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		TransactionStatus status = dataSourceTransactionManager.getTransaction(def);
		//1 范围数据  假设构造1000条
		List<String> list = IntStream.rangeClosed(1, 1000).mapToObj(t -> Integer.toString(t)).collect(Collectors.toList());
		List<String> resultList = doQuery(list);
//		list.forEach(t -> {
//			resultList.add(t);
//			if (resultList.size() == 50 || t.equals(list.get(list.size() - 1))) {
//				List<String> needUpdate = Lists.newArrayList(resultList);
//				List<String> needInsert = Lists.newArrayList(resultList);
//				// 获取查询或者更新c
//				needUpdate.retainAll(resultList);
//				needInsert.removeAll(resultList);
//				resultList.clear();
//			}
//
//
//		});
		doInsertAction();
		dataSourceTransactionManager.commit(status);
		dataSourceTransactionManager.rollback(status);

	}

	private List<String> doQuery(List<String> queryList) {
		//处理查询范围 可以用mybatis来使用
		String orderNos = queryList.stream().map(s -> "'" + s + "'").collect(Collectors.joining(",", "(", ")"));
		System.out.println("orderNos->" + orderNos);
		return Lists.newArrayList();
	}

	private void doUpdateAction() {


	}

	private void doInsertAction() {
		IntStream.rangeClosed(1, 100).forEach(t -> {
			TApplyInfo tApplyInfo = new TApplyInfo();
			tApplyInfo.setUserName("caoc");
			tApplyInfo.setUserCode("code_caoc");
			tApplyInfo.setAge(11);
			tApplyInfo.setCreateAt(new Date());
			tApplyInfo.setUpdateAt(new Date());
			tApplyInfoMapper.insert(tApplyInfo);
		});


	}


}
