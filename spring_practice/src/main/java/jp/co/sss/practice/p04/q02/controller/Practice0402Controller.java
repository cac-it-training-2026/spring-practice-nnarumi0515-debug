package jp.co.sss.practice.p04.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class Practice0402Controller {
	//	当たりの数値生成、開始画面表示用
	@RequestMapping(path = "/numguess/start", method = RequestMethod.GET)
	public String numGenerater(HttpSession session) {
		Integer hitNumber = (int) (Math.floor(Math.random() * 9) + 1);
		session.setAttribute("hitNumber", hitNumber);
		System.out.println(hitNumber);
		return "practice04/02/numguess_start";

	}

	//	入力画面表示用
	@RequestMapping(path = "/numguess/input", method = RequestMethod.GET)
	public String numInput() {
		return "practice04/02/numguess_input";

	}

	//入力値受付、判定処理用
	@RequestMapping(path = "/numguess/judge", method = RequestMethod.GET)
	public String numJudge(HttpSession session, Integer inputNum) {
		//セッションスコープから当たりの数値を取り出す
		Integer hitnum = (Integer) session.getAttribute("hitNumber");
		//		当たりの数字と入力された数値が同じか比較する
		if (hitnum == inputNum) {
			return "redirect:/numguess/hit";

		} else {
			return "practice04/02/numguess_judge";

		}

	}

	//	終了処理
	@RequestMapping(path = "/numguess/hit", method = RequestMethod.GET)
	public String numEnd(Model model, HttpSession session) {
		Integer hitnum = (Integer) session.getAttribute("hitNumber");
		String message = "当たりです！正解は" + hitnum + "でした。";
		model.addAttribute("message", message);
		session.removeAttribute("hitNumber");
		return "practice04/02/numguess_end";

	}

}
