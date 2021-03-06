package net.xdclass.xdvideo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.domain.VideoOrder;
import net.xdclass.xdvideo.service.VideoService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("page")
    public Object pageVideo(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10") int size
                            ) {
        PageHelper.startPage(page, size);
        List<Video> list = videoService.findAll();
        PageInfo<Video> pageInfo = new PageInfo<>(list);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size",pageInfo.getTotal());
        data.put("total_page",pageInfo.getPages());
        data.put("current_page",page);
        data.put("data",pageInfo.getList());
        return data;
    }

    @GetMapping("find_by_id")
    public Object findById(@RequestParam(value = "video_id",required = true) int videoId) {
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

    @PostMapping("save")
    public int save(String title){
        Video video = new Video();
        video.setTitle(title);
        return videoService.save(video);
    }
}