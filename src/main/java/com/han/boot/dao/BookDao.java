package com.han.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.han.boot.bean.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao extends BaseMapper<Book>  {

}
