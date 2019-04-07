
// ---------------------------------------------------
//	<JPAを使ってCalcテーブルの操作をできるようにする[2]>
//		- repositoryの処理を呼び出すserviceを作成する
//		- serviceにはビジネスロジックを書いて、repositoryはDBアクセスのみという棲み分け
//		- DBにアクセスするような処理を行いたい時はserviceのメソッドを呼ぶようにする
//		- 現段階ではビジネスロジックはないのでrepositoryのメソッドを呼ぶ処理だけ書いておく
// ---------------------------------------------------

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Calc;
import com.example.demo.repository.CalcRepository;

@Service
public class CalcService {

	// ▼ @Autowiredを付けて宣言すると
	//	  Beanをインジェクトしてくれるのでnewしなくても使うことができる

    @Autowired
    private CalcRepository calcRepository;

    public List<Calc> findAll() {
        return calcRepository.findAll();
    }

    public Calc findById(Long id) {
        return calcRepository.findById(id).orElse(null);
    }

    public Calc save(Calc calc) {
        return calcRepository.save(calc);
    }

    public void delete(Long id) {
    	calcRepository.deleteById(id);
    }

}
