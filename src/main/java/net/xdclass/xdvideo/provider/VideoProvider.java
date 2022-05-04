package net.xdclass.xdvideo.provider;

import net.xdclass.xdvideo.domain.Video;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;

/**
 * @program: xdvideo
 * @description: 2222
 * @packagename: net.xdclass.xdvideo.provider
 * @author: 姚泽宇
 * @date: 2022-05-04 08:42
 **/
public class VideoProvider {
    public String updateVideo(final Video video){
        return new SQL(){{
            UPDATE("video");
            //条件写法.
            if(video.getId()!= null){
                SET("author_id=#{authorId}");
            }
            if(video.getSummary()!= null){
                SET("summary=#{summary}");
            }
            WHERE("id=#{id}");
        }}.toString();
    }
}
