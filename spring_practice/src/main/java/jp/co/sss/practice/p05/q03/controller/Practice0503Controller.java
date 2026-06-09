package jp.co.sss.practice.p05.q03.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0503Controller {

	@Autowired
	FruitsSeasonRepository fruitsSeasonRepository;

	@RequestMapping(path = "/fruits/list/sort/id", method = RequestMethod.GET)
	public String fruitsListOrderbyid(Model model) {

		model.addAttribute("fruitsList", fruitsSeasonRepository.findAllByOrderByFruitId());
		return "practice05/03/fruits_list";
	}

	//	主キーでの検索処理、結果表示用
	@RequestMapping(path = "/fruits/detail/{fruitId}", method = RequestMethod.GET)
	public String fruitsresarch(@PathVariable Integer fruitId, Model model) {//@PathVariableでURLからデータ取得
		//		入力された値を受け取り、DBの検索条件として利用
		FruitsSeason fruit = fruitsSeasonRepository.getReferenceById(fruitId);
		//		JavaBeanオブジェクト生成
		FruitsSeasonBean fruitsSeasonBean = new FruitsSeasonBean();
		//		検索結果（Fruitエンティティ）をJavaBeanオブジェクトにコピー
		BeanUtils.copyProperties(fruit, fruitsSeasonBean);
		//		fruitsSeasonBean.setFruitId(fruitsSeasonBean.getFruitId());
		//		fruitsSeasonBean.setFruitName(fruitsSeasonBean.getFruitName());
		//		fruitsSeasonBean.setSeasonMonth(fruitsSeasonBean.getSeasonMonth());
		//		JavaBeanオブジェクトをリクエストスコープに保存
		model.addAttribute("fruit", fruitsSeasonBean);
		return "practice05/03/fruit_detail";
	}

}
