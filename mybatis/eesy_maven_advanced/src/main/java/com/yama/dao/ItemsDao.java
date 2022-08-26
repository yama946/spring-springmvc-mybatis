package com.yama.dao;

import com.yama.domain.Items;

public interface ItemsDao {
    Items findByID(Integer id);
}
