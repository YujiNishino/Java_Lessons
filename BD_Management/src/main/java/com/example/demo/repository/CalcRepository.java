// ---------------------------------------------------
//	<JPAを使ってCalcテーブルの操作をできるようにする[1]>
//		- テーブルへアクセスするための基本的な処理はJPAがが用意してくれているのでSQLを書かなくてよい
//		- JPAのJpaRepositoryを継承したinterfaceを作成することで利用できる
//		- findAllやsave等用意されている典型的な操作以外のことをしたくなったら、
//		  repositoryに追記していくことになる
// ---------------------------------------------------

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Calc;

@Repository
public interface CalcRepository extends JpaRepository<Calc, Long> {

}
