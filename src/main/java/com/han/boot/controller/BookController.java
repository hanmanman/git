package com.han.boot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.han.boot.bean.Book;
import com.han.boot.controller.utils.R;
import com.han.boot.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @GetMapping
    public R getAll(){
        return new R(true,iBookService.list());
    }
    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
//        R r = new R();
//        boolean flag = bookService.save(book);
//        r.setFlag(flag);
        if (book.getName().equals("123") ) throw new IOException();
        boolean flag = iBookService.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(iBookService.modify(book));
    }
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(iBookService.delete(id));
    }
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        System.out.println("asd");
        System.out.println("asd");

        return new R(true,iBookService.getById(id));
    }
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
//        System.out.println("参数==>"+book);

        IPage<Book> page = iBookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = iBookService.getPage((int)page.getPages(), pageSize,book);
        }
        return new R(true, page);
    }
}
