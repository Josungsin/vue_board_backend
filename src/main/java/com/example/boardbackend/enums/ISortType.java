package com.example.boardbackend.enums;

import com.querydsl.core.types.OrderSpecifier;

public interface ISortType {
    OrderSpecifier getOrder(ISortName sortName);
}
