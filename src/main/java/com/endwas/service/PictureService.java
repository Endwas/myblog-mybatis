package com.endwas.service;

import com.endwas.entity.Picture;

import java.util.List;

/**
 * @author ：endwas
 * @description：图片管理服务层接口
 * @date ：Created in 2021/1/11 23:26
 * @url ：https://endwas.cn
 * @version： 1.0
 */
public interface PictureService {
    List<Picture> listPicture();

    int savePicture(Picture picture);

    Object getPicture(Long id);

    int updatePicture(Picture picture);

    void deletePicture(Long id);
}
