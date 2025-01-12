/**
 * @FileName: ArticleTypeServiceImpl
 * @Author: code-fusheng
 * @Date: 2020/3/22 13:11
 * Description: 文章类型业务逻辑接口实现类
 */
package com.hnxx.zy.clms.core.service.impl;

import com.hnxx.zy.clms.common.enums.StateEnum;
import com.hnxx.zy.clms.common.exception.ClmsException;
import com.hnxx.zy.clms.core.entity.ArticleType;
import com.hnxx.zy.clms.core.mapper.ArticleTypeMapper;
import com.hnxx.zy.clms.core.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    /**
     * 保存添加 文章类型
     * @param articleType
     */
    @Override
    public void save(ArticleType articleType) {
        // 查询文章分类是否存在
        ArticleType t = articleTypeMapper.getByName(articleType.getTypeName());
        if(t == null){
            articleTypeMapper.save(articleType);
        }
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public ArticleType getById(Integer id) {
        return articleTypeMapper.getById(id);
    }

    /**
     * 前台查询所有
     * @return
     */
    @Override
    public List<ArticleType> getList() {
        return articleTypeMapper.getList();
    }

    /**
     * 后台查询所有
     * @return
     */
    @Override
    public List<ArticleType> getAll() {
        return articleTypeMapper.getAll();
    }

    /**
     * 更新修改
     * @param articleType
     */
    @Override
    public void update(ArticleType articleType) {
        articleTypeMapper.update(articleType);
    }

    /**
     * 根据id删除 [逻辑删除]
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        articleTypeMapper.deleteById(id);
    }

    /**
     * 根据id启用
     * @param id
     */
    @Override
    public void enabledById(Integer id) {
        // 先查询在启用
        ArticleType type = articleTypeMapper.getById(id);
        type.setIsEnabled(StateEnum.ENABLED.getCode());
        articleTypeMapper.updateEnable(type);
    }

    /**
     * 根据id弃用
     * @param id
     */
    @Override
    public void disabledById(Integer id) {
        // 先查询在弃用 保障数据完整性
        ArticleType type = articleTypeMapper.getById(id);
        type.setIsEnabled(StateEnum.NOT_ENABLE.getCode());
        articleTypeMapper.updateEnable(type);
    }

}
