package jp.co.sss.practice.p03.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p03.q02.form.FavoriteForm;

@Controller
public class Practice0302Controller {

	//入力画面表示メソッド
	@RequestMapping(path = "/favorite/input")
	public String inputView() {
		return "practice03/02/favorite_input";

	}

	//Formクラスでパラメータを取得するメソッド
	@RequestMapping(path = "/favorite/result", method = RequestMethod.POST)
	public String getForm(FavoriteForm favoriteForm) {
		System.out.println("==パラメータを受け取りました");
		System.out.println("果物：" + favoriteForm.getFruit());
		System.out.println("スナック：" + favoriteForm.getSnack());
		System.out.println("スイーツ：" + favoriteForm.getSweet());
		System.out.println("おかず：" + favoriteForm.getSidedish());
		return "practice03/02/favorite_result";

	}

}
