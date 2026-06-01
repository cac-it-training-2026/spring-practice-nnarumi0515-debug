package jp.co.sss.practice.p02.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Practice0202Controller {
	@RequestMapping(path = "/show/redirect_page")
	//http://localhost:5555/practice/show/redirect_pageにアクセスしたとき下記のメソッド実行
	public String showRedirectPage() {
		return "Practice02/02/redirect_link";

	}

	@RequestMapping(path = "/absolute")
	public String absolutePath() {
		return "redirect:https://www.google.co.jp/";

	}

	@RequestMapping(path = "/relative")
	public String reactivePath() {
		return "redirect:/result";
	}

	@RequestMapping(path = "/result")
	public String redirectResultPage() {
		return "Practice02/02/redirect_result";
	}

}
