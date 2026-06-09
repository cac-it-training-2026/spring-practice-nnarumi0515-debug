package jp.co.sss.practice.p05.q01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

// Practice6-01
@Controller
public class Practice0501Controller {
	@Autowired //フィールドの型に対応するクラスのオブジェクトが予め生成されフィールドに代入される（DI）
	FruitsSeasonRepository fruitRepository;

	@RequestMapping(path = "/fruits/list/all", method = RequestMethod.GET)
	public String showFruitsList(Model model) {
		model.addAttribute("fruitsList", fruitRepository.findAll());
		return "practice05/01/fruits_list";

	}

}
