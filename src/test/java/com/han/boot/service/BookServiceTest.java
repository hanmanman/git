package com.han.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.han.boot.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private IBookService ibookService;
    @Test
    void testGetById(){
        System.out.println(ibookService.getById(6));
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        ibookService.save(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(12);
        book.setType("-----------------");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        ibookService.updateById(book);
    }
    @Test
    void testDelete(){
        ibookService.removeById(12);
    }

    @Test
    void testGetAll(){
        ibookService.list();
    }

    @Test
    void testGetPage(){
        IPage<Book> page = new Page<Book>(2,5);
        ibookService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
}
