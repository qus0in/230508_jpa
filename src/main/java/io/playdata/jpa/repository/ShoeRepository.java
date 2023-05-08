package io.playdata.jpa.repository;

import io.playdata.jpa.model.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoeRepository extends JpaRepository<Shoe, Long> {
    // 생성 규칙에 따른 메소드 생성
    // 1. 이름으로 신발 검색하기
    List<Shoe> findByNameContaining(String name);
    // 2. 가격 범위 내 신발 검색하기
    List<Shoe> findByPriceBetween(int minPrice, int maxPrice);

    // SQL Query를 통한 메소드 생성
    // 1. 브랜드별 신발 개수 구하기
    @Query(value = "SELECT brand, COUNT(*) AS count FROM shoe GROUP BY brand", nativeQuery = true)
    List<Object[]> countByBrand();
    // 2. 가격이 가장 높은 신발 구하기
    @Query(value = "SELECT * FROM shoe ORDER BY price DESC LIMIT 1", nativeQuery = true)
    Shoe findMostExpensive();
}