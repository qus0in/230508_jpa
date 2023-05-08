package io.playdata.jpa.repository;

import io.playdata.jpa.model.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoeRepository extends JpaRepository<Shoe, Long> {
    // TODO : 생성 규칙에 따른 메소드 생성
    // TODO : SQL Query를 통한 메소드 생성
}