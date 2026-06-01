package jp.co.sss.practice.p03.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Practice0301Controller {
	//	入力画面表示用
	@RequestMapping(path = "/input", method = RequestMethod.GET)
	public String inputpage() {
		return "practice03/01/input_form";

	}

	//	GETメソッドでのパラメータ取得用
	@RequestMapping(path = "/send/get_method", method = RequestMethod.GET)
	public String getpage(String color) {
		System.out.println("##GET メソッドで受け取りました");
		System.out.println("##パラメータの値：" + color);
		return "practice03/01/get_result";

	}

	//	POSTメソッドでのパラメータ取得用
	@RequestMapping(path = "/send/post_method", method = RequestMethod.POST)
	public String sendpage(String color) {
		System.out.println("==POST メソッドで受け取りました");
		System.out.println("==パラメータの値:" + color);
		return "practice03/01/post_result";

	}

}
