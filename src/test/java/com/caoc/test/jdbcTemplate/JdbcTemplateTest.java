package com.caoc.test.jdbcTemplate;

import com.caoc.test.TestApplication;
import com.ethan.test.domain.CasFLendengineLightAssetDataFromLoanTemp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(TestApplication.class)
public class JdbcTemplateTest {

	@Autowired
	ApplicationContext applicationContext;

	@Test
	public void testJdbcInsertOne() {

		DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		final String strSql = "insert into cas_f_lendengine_light_asset_data_from_loan_temp(dd_no, uid, jkk_id, jk_jj, fqs, sq_zt, cj_sj, gx_sj, sq_no,\n" +
				"                                                             fk_zf, zs_zh, yw_id, sq_ly, fk_zf_id, yhq_id, etl_id,\n" +
				"                                                             etl_crt_tim, etl_upd_tim)\n" +
				"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		jdbcTemplate.update(conn -> {
			int i = 0;
			java.sql.PreparedStatement ps = conn.prepareStatement(strSql);
			ps = conn.prepareStatement(strSql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(++i, ""); //参考 跟问号相等
			ps.setString(++i, ""); //参考 跟问号相等
			ps.setString(++i, ""); //参考 跟问号相等
			ps.setString(++i, ""); //参考 跟问号相等
			//---
			return ps;
		}, keyHolder);
		System.out.println(keyHolder.getKey().intValue());

	}


	@Test
	public void testJdbcInsertBatch() {
		List<CasFLendengineLightAssetDataFromLoanTemp> list = IntStream.rangeClosed(1, 100)
				.mapToObj(t -> buildCasFLendengineLightAssetDataFromLoanTemp(t)).collect(Collectors.toList());
		List<CasFLendengineLightAssetDataFromLoanTemp> insertList = new ArrayList<>();
		int batchLimit = 20;
		int batchCount = 1;
		for (int i = 0; i < list.size(); i++) {
			insertList.add(list.get(i));
			if (batchLimit == insertList.size() || i == (list.size() - 1)) {
				try {
					batchInsert(insertList);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					batchCount++;
					insertList.clear();
				}
			}
		}
	}

	private CasFLendengineLightAssetDataFromLoanTemp buildCasFLendengineLightAssetDataFromLoanTemp(int i) {
		CasFLendengineLightAssetDataFromLoanTemp temp = new CasFLendengineLightAssetDataFromLoanTemp();
		temp.setDdNo("orderNo" + i);
		temp.setUid(UUID.randomUUID().toString());
		temp.setJkkId(UUID.randomUUID().toString());
		temp.setJkJj(99999);
		temp.setFqs((byte) 3);
		temp.setSqZt("lent0101");
		temp.setCjSj(new Date());
		temp.setGxSj(new Date());
		temp.setSqNo("biz_serial" + i);
		temp.setFkZf("asset_bank");
		temp.setZsZh("account_type");
		temp.setYwId("biz_serial" + i);
		temp.setSqLy("source" + i);
		temp.setFkZfId("asset_product_id" + i);
		temp.setYhqId("coupon_id" + i);
		temp.setEtlId(i);
		temp.setEtlCrtTim(new Date());
		temp.setEtlUpdTim(new Date());
		return temp;

	}


	private void batchInsert(List<CasFLendengineLightAssetDataFromLoanTemp> temps) {
		final List<CasFLendengineLightAssetDataFromLoanTemp> list = temps;
		final String strSql = "insert into cas_f_lendengine_light_asset_data_from_loan_temp(dd_no, uid, jkk_id, jk_jj, fqs, sq_zt, cj_sj, gx_sj, sq_no,\n" +
				"                                                             fk_zf, zs_zh, yw_id, sq_ly, fk_zf_id, yhq_id, etl_id,\n" +
				"                                                             etl_crt_tim, etl_upd_tim)\n" +
				"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.batchUpdate(strSql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				int index = 0;
				ps.setString(++index, list.get(i).getDdNo());
				ps.setString(++index, list.get(i).getUid());
				ps.setString(++index, list.get(i).getJkkId());
				ps.setInt(++index, list.get(i).getJkJj());
				ps.setInt(++index, list.get(i).getFqs());
				ps.setString(++index, list.get(i).getSqZt());
				ps.setDate(++index, new java.sql.Date(list.get(i).getCjSj().getTime()));
				ps.setDate(++index, new java.sql.Date(list.get(i).getGxSj().getTime()));
				ps.setString(++index, list.get(i).getSqNo());

				ps.setString(++index, list.get(i).getFkZf());
				ps.setString(++index, list.get(i).getZsZh());
				ps.setString(++index, list.get(i).getYwId());
				ps.setString(++index, list.get(i).getSqLy());
				ps.setString(++index, list.get(i).getFkZfId());
				ps.setString(++index, list.get(i).getYhqId());
				ps.setInt(++index, list.get(i).getEtlId());
				ps.setDate(++index, new java.sql.Date(new Date().getTime()));
				ps.setDate(++index, new java.sql.Date(new Date().getTime()));

			}

			@Override
			public int getBatchSize() {
				return list.size();
			}
		});
	}


}
