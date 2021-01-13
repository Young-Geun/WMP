package com.wmp.wmpapp.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wmp.wmpapp.service.RearrangeService;
import com.wmp.wmpapp.util.WmpValidUtil;
import com.wmp.wmpapp.vo.SearchCondVO;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	RearrangeService rearrangeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView index(@RequestBody SearchCondVO searchCondVO) {

		logger.debug("searchCondVO : " + searchCondVO.toString());

		ModelAndView mav = new ModelAndView("jsonView");

		if (!WmpValidUtil.isUrlPattern(searchCondVO.getUrl())) {
			mav.addObject("msg", "올바른 URL이 아닙니다.");
			return mav;
		}

		if (!WmpValidUtil.isNaturalNum(searchCondVO.getUnit())) {
			mav.addObject("msg", "자연수만 입력할 수 있습니다.");
			return mav;
		}

		try {
			Map<String, String> map = rearrangeService.getRearrangeStr(searchCondVO);
			if (map == null) {
				mav.addObject("msg", "오류가 발생하였습니다. 관리자에게 문의하세요.");
			} else {
				mav.addObject("result", map);
			}
		} catch (Exception e) {
			mav.addObject("msg", "오류가 발생하였습니다. 관리자에게 문의하세요.");
			logger.error(e.toString());
		}

		return mav;
	}

}
