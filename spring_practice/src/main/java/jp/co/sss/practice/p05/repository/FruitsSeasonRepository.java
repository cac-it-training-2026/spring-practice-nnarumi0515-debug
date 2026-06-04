package jp.co.sss.practice.p05.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.practice.p05.entity.FruitsSeason;

public interface FruitsSeasonRepository extends JpaRepository<FruitsSeason, Integer> {

	//昇順に並べ替え昇順の（Asc）は省略可能
	List<FruitsSeason> findAllByOrderBySeasonMonthAsc();

}
