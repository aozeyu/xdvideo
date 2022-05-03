package net.xdclass.xdvideo.controller;

import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.service.VideoService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("page")
    public Object pageVideo() {
        return videoService.findAll();
    }

    @GetMapping("find_by_id")
    public Object findById(int videoId) {
        return videoService.findById(videoId);
    }

    @DeleteMapping("del_by_id")
    public int deleteById(int videoId) {
        return videoService.delete(videoId);
    }

    @PutMapping("update_by_id")
    public int update(int videoId, String title) {
        Video video = new Video();
        video.setTitle(title);
        video.setId(videoId);
        return videoService.update(video);
    }
}