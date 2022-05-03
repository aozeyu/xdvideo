package net.xdclass.xdvideo.service.impl;

import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.mapper.VideoMapper;
import net.xdclass.xdvideo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: xdvideo
 * @description: 222
 * @packagename: net.xdclass.xdvideo.service.impl
 * @author: 姚泽宇
 * @date: 2022-05-02 16:16
 **/
@Service
public class VideoServiceIml implements VideoService {
    @Autowired
    VideoMapper videoMapper;
    public List<Video> findAll() {
        return videoMapper.findAll();
    }

    @Override
    public Video findById(int id) {
        return videoMapper.findById(id);
    }

    @Override
    public int update(Video video) {
        return videoMapper.update(video);
    }

    @Override
    public int delete(int id) {
        return videoMapper.delete(id);
    }

    @Override
    public int save(Video video) {
       int rows = videoMapper.save(video);
        System.out.println(video.getId());
       return rows;
    }


}
