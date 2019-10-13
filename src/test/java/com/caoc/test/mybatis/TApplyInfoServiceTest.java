package com.caoc.test.mybatis;

import com.caoc.test.TestApplication;
import com.caoc.test.mapper.TApplyInfoMapper;
import com.caoc.test.domain.TApplyInfo;
import com.caoc.test.domain.TApplyInfoExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(TestApplication.class)
public class TApplyInfoServiceTest {

	@Autowired
	TApplyInfoMapper tApplyInfoMapper;

	@Test
	public void testInsert() {
		TApplyInfo tApplyInfo = new TApplyInfo();
		tApplyInfo.setUserName("caoc");
		tApplyInfo.setUserCode("code_caoc");
		tApplyInfo.setAge(11);
		tApplyInfo.setCreateAt(new Date());
		tApplyInfo.setUpdateAt(new Date());
		tApplyInfoMapper.insert(tApplyInfo);
	}

	@Test
	public void deleteTest() {
		TApplyInfo tApplyInfo = new TApplyInfo();
		tApplyInfo.setAge(11);
		TApplyInfoExample tApplyInfoExample = new TApplyInfoExample();
		tApplyInfoExample.createCriteria().andAgeEqualTo(11);
		System.out.println(tApplyInfoMapper.deleteByExample(tApplyInfoExample));
	}


	@Test
	public void insetMore() {
		IntStream.range(0, 20).forEach(i -> {
			TApplyInfo tApplyInfo = new TApplyInfo();
			tApplyInfo.setUserName("caoc" + i);
			tApplyInfo.setUserCode("code_caoc" + i);
			tApplyInfo.setAge(i);
			tApplyInfo.setCreateAt(new Date());
			tApplyInfo.setUpdateAt(new Date());
			tApplyInfoMapper.insert(tApplyInfo);
		});
	}

	@Test
	public void selectSome() {
		TApplyInfoExample tApplyInfoExample = new TApplyInfoExample();
		tApplyInfoExample.createCriteria().andAgeGreaterThanOrEqualTo(5)
				.andAgeLessThanOrEqualTo(12);
		List<TApplyInfo> tApplyInfoList = tApplyInfoMapper.selectByExample(tApplyInfoExample);
		System.out.println(tApplyInfoList.size());
	}

	@Test
	public void delete(){
		TApplyInfoExample tApplyInfoExample = new TApplyInfoExample();
		tApplyInfoExample.createCriteria().andAgeLessThanOrEqualTo(10);
		tApplyInfoMapper.deleteByExample(tApplyInfoExample);
	}
}
