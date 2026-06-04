package jp.co.sss.practice.p05.q02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

// Practice6-01
@Controller
public class Practice0502Controller {

	@Autowired
	FruitsSeasonRepository fruitsSeasonRepository;

	//	一覧画面表示用
	@RequestMapping(path = "/fruits/list/sort/season")
	public String showFruitsListSortBySeason(Model model) {
		// DBからデータを取得し、seasonMonthの昇順で並べ替えてリクエストスコープに保存
		model.addAttribute("fruitsList", fruitsSeasonRepository.findAllByOrderBySeasonMonthAsc());

		return "practice05/02/fruits_list";

	}

}
