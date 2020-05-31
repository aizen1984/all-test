package com.caoc.test.batchTest;

import com.caoc.test.TestApplication;
import com.caoc.test.domain.TLendApply;
import com.caoc.test.domain.TLendApplyExample;
import com.caoc.test.mapper.TLendApplyMapper;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(TestApplication.class)
public class BatchTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());

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
		//通过jdbc 读取数据过来
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

	@Test
	public void doUpdateAction() {
		DataSourceTransactionManager dataSourceTransactionManager = applicationContext.getBean("transactionManager", DataSourceTransactionManager.class);
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		List<Integer> ids = IntStream.rangeClosed(1000, 1005).boxed().collect(Collectors.toList());
		List<Integer> updateIds = new ArrayList<>();
		try {

			int batchLimit = 20;
			int batchCount = 1;

			for (int i = 0; i < ids.size(); i++) {
				updateIds.add(ids.get(i));
				if (batchLimit == updateIds.size() || i == (ids.size() - 1)) {
					TransactionStatus status = dataSourceTransactionManager.getTransaction(def);
					try {
						batchCount++;
						tLendApplyMapper.updateBatchPayOffByOrderByIds(ids);
						dataSourceTransactionManager.commit(status);
					} catch (Exception e) {
						dataSourceTransactionManager.rollback(status);
						logger.warn("执行错误，转为单条执行", e);
						for (Integer t : updateIds) {
							try {
								TLendApply tLendApply = new TLendApply();
								tLendApply.setApplyStatus("payOff");
								TLendApplyExample example = new TLendApplyExample();
								example.createCriteria().andIdEqualTo(t);
								tLendApplyMapper.updateByExampleSelective(tLendApply, example);
							} catch (Exception e1) {
								logger.warn("更新单条失败id:{}message:{}", t, e.getMessage());
							}
						}
					} finally {
						updateIds.clear();
					}
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 批量插入逻辑
	 */
	@Test
	public void doInsertAction() {
		DataSourceTransactionManager dataSourceTransactionManager = applicationContext.getBean("transactionManager", DataSourceTransactionManager.class);
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		List<TLendApply> list = IntStream.rangeClosed(1, 100).mapToObj(t -> buIldLendApply(t)).collect(Collectors.toList());
		List<TLendApply> insertList = new ArrayList<>();
		int batchLimit = 20;
		int batchCount = 1;
		for (int i = 0; i < list.size(); i++) {
			insertList.add(list.get(i));
			if (batchLimit == insertList.size() || i == (list.size() - 1)) {
				TransactionStatus status = dataSourceTransactionManager.getTransaction(def);
				try {

					tLendApplyMapper.insertBatchPayOffSelective(insertList);
					if (batchCount == 3) {
						throw new RuntimeException("1111");
					}
					dataSourceTransactionManager.commit(status);

				} catch (Exception e) {
					dataSourceTransactionManager.rollback(status);
					logger.warn("执行错误，转为单条执行", e);
					for (TLendApply t : insertList) {
						try {
							tLendApplyMapper.insert(t);
						} catch (Exception e1) {
							logger.warn("插入单条执行错误订单号{}{}", t.getOrderNo(), e.getMessage());
						}
					}
				} finally {
					batchCount++;
					insertList.clear();
				}
			}
		}
	}

	@NotNull
	private TLendApply buIldLendApply(int t) {
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
		return lendApply;
	}


}
