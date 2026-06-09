package jp.co.sss.practice.p04.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p04.q01.form.BmiForm;

@Controller
public class Practice0401Controller {
	//	入力画面表示用
	@RequestMapping(path = "/bmi/input", method = RequestMethod.GET)
	public String bmiInput() {
		return "practice04/01/bmi_input";

	}

	//	入力値受け取り、計算、出力用
	@RequestMapping(path = "/bmi/result", method = RequestMethod.POST)
	public String bmiCalculation(BmiForm bmiForm, Model model) {
		Double weight = bmiForm.getWeight();
		Double height = bmiForm.getHeight() / 100;
		bmiForm.setBmi(weight / ((height) * (height)));
		model.addAttribute("bmiForm", bmiForm);//フォームをリクエストスコープに保存
		return "practice04/01/bmi_result";

	}

}
