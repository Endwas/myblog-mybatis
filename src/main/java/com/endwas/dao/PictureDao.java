package com.endwas.dao;

import com.endwas.entity.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：endwas
 * @description：图片管理持久层接口
 * @date ：Created in 2021/1/11 23:28
 * @url ：https://endwas.cn
 * @version： 1.0
 */
@Mapper
@Repository
public interface PictureDao {
    List<Picture> listPicture();

    int savePicture(Picture picture);

    Object getPicture(Long id);

    int updatePicture(Picture picture);

    void deletePicture(Long id);
}
