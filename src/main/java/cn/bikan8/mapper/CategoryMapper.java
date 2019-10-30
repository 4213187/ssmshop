package cn.bikan8.mapper;



import cn.bikan8.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryMapper {
    /**
     * 递归查询所有的类别
     *
     * @return List<Category>
     */
    List<Category> findAll();

    /**
     * 添加根节点
     *
     * @param category 类别
     */
    void addRoot(Category category);

    /**
     * 添加子类别点
     *
     * @param category 类别
     */
    void addChild(Category category);

    /**
     * 通过id查找对应的类别
     *
     * @param id 类别的id
     * @return 类别对象
     */
    Category findById(int id);

    /**
     * 通过id修改类别是否为叶子结点
     *
     * @param id 类别的id
     */
    void updateLeafById(int id);

    /**
     * 修改类型的信息
     * @param category 修改的类型
     */
    void updateInfo(Category category);

}
