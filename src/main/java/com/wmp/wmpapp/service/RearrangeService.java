package com.wmp.wmpapp.service;

import java.util.Map;

import com.wmp.wmpapp.vo.SearchCondVO;

public interface RearrangeService {

	Map<String, String> getRearrangeStr(SearchCondVO searchCondVO) throws Exception;

}
