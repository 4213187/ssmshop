package cn.bikan8.service.impl;


import cn.bikan8.entity.Category;
import cn.bikan8.mapper.CategoryMapper;
import cn.bikan8.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 小浩
 * @version 1.0
 * @date 2019/10/8 18:22
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    public  CategoryServiceImpl(){}
    public  CategoryServiceImpl(CategoryMapper categoryMapper){
        this.categoryMapper =categoryMapper;
    }
    @Override
    public List<Category> findAll() {
        return categoryMapper.findAll();
    }

    @Override
    public void addRoot(Category category) {
        categoryMapper.addRoot(category);
    }

    @Override
    public void addChild(Category category) {
        categoryMapper.addChild(category);
    }

    @Override
    public Category findById(int id) {
        return categoryMapper.findById(id);
    }

    @Override
    public void updateLeafById(int id) {
        categoryMapper.updateLeafById(id);
    }

    @Override
    public void updateInfo(Category category) {
        categoryMapper.updateInfo(category);
    }
}
