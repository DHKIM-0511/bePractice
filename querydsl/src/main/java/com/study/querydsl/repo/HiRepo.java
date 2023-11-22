package com.study.querydsl.repo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.querydsl.entity.QHi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HiRepo {

    private final JPAQueryFactory jpaQueryFactory;





}
