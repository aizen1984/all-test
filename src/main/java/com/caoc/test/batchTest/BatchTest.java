package com.caoc.test.batchTest;

import com.caoc.test.TestApplication;
import com.caoc.test.domain.TLendApply;
import com.caoc.test.domain.TLendApplyExample;
import com.caoc.test.mapper.TLendApplyMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
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
	private TLendApplyMapper tLendApplyMapper;


	@Test
	public void transactionTest() {

		DataSourceTransactionManager dataSourceTransactionManager = applicationContext.getBean("transactionManager", DataSourceTransactionManager.class);
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		TransactionStatus status = dataSourceTransactionManager.getTransaction(def);
		DefaultTransactionDefinition def2 = new DefaultTransactionDefinition();
		TransactionStatus status2 = dataSourceTransactionManager.getTransaction(def2);
		try {
			tLendApplyMapper.deleteByExample(null);
			doInsertAction();
			dataSourceTransactionManager.commit(status);
			doUpdateAction();
			dataSourceTransactionManager.commit(status2);
			doSelectAction();
		} catch (Exception e) {
			e.printStackTrace();
			dataSourceTransactionManager.rollback(status);
			dataSourceTransactionManager.rollback(status2);
		}


	}

	private void doSelectAction() {
		List<String> listOrderNos = Lists.newArrayList("order1", "order2", "order3");
		System.out.println(tLendApplyMapper.selectBatchForPayOffByOrderNos(listOrderNos));
	}



	public void testLogic() {
		//1 范围数据  假设构造1000条
		List<String> list = IntStream.rangeClosed(1, 1000).mapToObj(t -> Integer.toString(t)).collect(Collectors.toList());
		List<String> resultList = doQuery(list);
		list.forEach(t -> {
			resultList.add(t);
			if (resultList.size() == 50 || t.equals(list.get(list.size() - 1))) {
				List<String> needUpdate = Lists.newArrayList(resultList);
				List<String> needInsert = Lists.newArrayList(resultList);
				// 获取查询或者更新c
				needUpdate.retainAll(resultList);
				needInsert.removeAll(resultList);
				resultList.clear();
			}


		});
	}


	private List<String> doQuery(List<String> queryList) {
		//处理查询范围 可以用mybatis来使用
		String orderNos = queryList.stream().map(s -> "'" + s + "'").collect(Collectors.joining(",", "(", ")"));
		System.out.println("orderNos->" + orderNos);
		return Lists.newArrayList();
	}

	private void doUpdateAction() {
		List<TLendApply> updateList = Lists.newArrayList();
		TLendApply tLendApply = new TLendApply();
		tLendApply.setOrderNo("order1");
		updateList.add(tLendApply);
		TLendApply tLendApply2 = new TLendApply();
		tLendApply2.setOrderNo("order2");
		updateList.add(tLendApply2);
		tLendApplyMapper.updateBatchPayOffByOrderNo(updateList);
	}

	private void doInsertAction() {
		tLendApplyMapper.insertBatchPayOffSelective(IntStream.rangeClosed(1, 100).mapToObj(t -> {
			TLendApply lendApply = new TLendApply();
			lendApply.setLendApplyNo("i" + t);
			lendApply.setUid("i" + t);
			lendApply.setBizSerial("i" + t);
			lendApply.setLendType("i" + t);
			lendApply.setApplyTime(new Date());
			lendApply.setApplyStatus("payoff2222");
			lendApply.setSource("app");
			lendApply.setUpdatedAt(new Date());
			lendApply.setVersionNumber(t);
			lendApply.setLendAmount(t);
			lendApply.setCreatedAt(new Date());
			lendApply.setOrderNo("order" + t);
			try {
				if (t == 99) {
					throw new RuntimeException("故意的异常");
				}

			} catch (RuntimeException e) {
				System.out.println("吃掉掉");
			}
			return lendApply;
		}).collect(Collectors.toList()));


	}


}
