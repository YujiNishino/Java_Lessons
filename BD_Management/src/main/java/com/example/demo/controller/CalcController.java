package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Calc;
import com.example.demo.service.CalcService;


// ▼ クラスに対して【 @RequestMapping 】を付けておくと、クラス内のメソッド全てに適用される
//		- このクラスのメソッドは全て、http://localhost:8080/calcs から始まるURLにマッピングされている

@Controller
@RequestMapping("/calcs")
public class CalcController {

	// ▼ CalcServiceでDBを操作するヨ
	@Autowired
	private CalcService calcService;

	// ▼ 一覧画面の表示
	@GetMapping
	public String index(Model model) {				// - Modelのインスタンスが自動的に渡される
		List<Calc> calcs = calcService.findAll();	// - Service-interfaceを経由してDBからデータを取得する
		model.addAttribute("calcs", calcs);			// - ModelインスタンスにCalcs[リスト]情報を渡す
		return "calcs/index";						// - src/main/resources/templates/配下から指定したファイルを
													//   見つけてユーザに返す
	}

	// ▼ 新規作成画面の表示
	@GetMapping("new")
	public String newCalc(Model model) {
		Calc calc = new Calc();
		model.addAttribute("calc", calc);
		return "calcs/new";
	}

	// ▼ 編集画面の表示
	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) {	// - @PathVariableを設定するとURL上の値を取得することができる
		Calc calc = calcService.findById(id);					// - 【 http://localhost/players/1 】 にアクセスされるとidには【 1 】が入る
		model.addAttribute("calc", calc);
		return "calcs/edit";
	}

	// ▼ 参照画面の表示
	@GetMapping("{id}")
	public String show(@PathVariable Long id , Model model) {
		Calc calc = calcService.findById(id);
		model.addAttribute("calc", calc);
		return "calcs/show";
	}

	// ▼ データの保存
	@PostMapping
	public String create(@Valid @ModelAttribute Calc calc, BindingResult bidingResult) {	// - @ModelAttributeをつけると送信されたリクエストのbodyの情報を取得できる
		if(bidingResult.hasErrors()) return "calcs/new";	// - エラーがあるとbindingResultの中にエラーの情報がセットされる
		calcService.save(calc);
		return "redirect:/calcs";							// - "redirect:/players"とすると/playersにリダイレクトされる
	}														// - createメソッドの処理が終わった後、勝手にアクセスされる感じ

	// ▼ データの更新
	@PutMapping("{id}")
	public String update(@PathVariable Long id, @Valid @ModelAttribute Calc calc, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "calcs/edit";
		calc.setId(id);
		calcService.save(calc);
		return "redirect:/calcs";
	}

	// ▼ データの削除
	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		calcService.delete(id);
		return "redirect:/calcs";
	}


}
