package jp.co.sss.practice.p02.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Webリクエストを受け取る役割を持つクラス
public class Practice0201Controller {
	@RequestMapping(path = "/first") ///firstにアクセスしたとき、下記のメソッドを実行
	public String first() {
		return "practice02/01/before_redirect";//practice02/01/before_redirectのHTMLを表示する
	}

	@RequestMapping(path = "/second")
	public String second() {
		return "redirect:/third";//リダイレクト指示/thirdへいく
	}

	@RequestMapping(path = "/third") //余計な空白入れると動かないので注意！
	public String third() {
		return "practice02/01/after_redirect";//practice02/01/after_redirectのHTMLを表示する

	}

}
