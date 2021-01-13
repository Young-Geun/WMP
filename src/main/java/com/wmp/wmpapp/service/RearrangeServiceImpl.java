package com.wmp.wmpapp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wmp.wmpapp.constant.TypeConst;
import com.wmp.wmpapp.util.WmpConvertUtil;
import com.wmp.wmpapp.util.WmpStringUtil;
import com.wmp.wmpapp.vo.SearchCondVO;

@Service
public class RearrangeServiceImpl implements RearrangeService {

	@Override
	public Map<String, String> getRearrangeStr(SearchCondVO searchCondVO) throws Exception {
		Map<String, String> map = null;

		// URL호출을 통한 TEXT 추출
		String str = WmpConvertUtil.htmlToString(searchCondVO.getUrl());
		if ("".equals(str)) {
			return null;
		} else {
			map = new HashMap<String, String>();
		}

		// Type에 따른 필터링
		if (searchCondVO.getScope() == TypeConst.HTML_EXCLUDE) {
			str = WmpStringUtil.removeHtmlTag(str);
		}

		// 필터링
		String enStr = WmpStringUtil.removeWithoutEn(str);
		String numStr = WmpStringUtil.removeWithoutNum(str);

		// 정렬
		enStr = WmpStringUtil.enStrSort(enStr);
		numStr = WmpStringUtil.numStrSort(numStr);

		// 병합
		String mergeStr = WmpStringUtil.mergeStr(enStr, numStr);

		// 출력 묶음 단위 기반의 텍스트 분리
		int splitIdx = mergeStr.length() % searchCondVO.getUnit();
		map.put("quotient", mergeStr.substring(0, mergeStr.length() - splitIdx));
		map.put("remainder", mergeStr.substring(mergeStr.length() - splitIdx, mergeStr.length()));

		return map;
	}

}
