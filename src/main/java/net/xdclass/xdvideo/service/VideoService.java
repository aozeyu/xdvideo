package net.xdclass.xdvideo.service;

import net.xdclass.xdvideo.domain.Video;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: xdvideo
 * @description: 222
 * @packagename: net.xdclass.xdvideo.service
 * @author: 姚泽宇
 * @date: 2022-05-02 16:15
 **/
public interface VideoService {

    List<Video> findAll();

    Video findById(int id);

    int update(Video video);

    int delete(int id);

    int save(Video video);
}
