package net.xdclass.xdvideo.mapper;

import net.xdclass.xdvideo.domain.Video;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: xdvideo
 * @description: 2222
 * @packagename: net.xdclass.xdvideo.mapper
 * @author: 姚泽宇
 * @date: 2022-05-03 10:03
 **/
public interface VideoMapper {

    @Select("select  * from video")
    @Results({
            @Result(column = "create_time", property = "createTime")
    })
    List<Video> findAll();

    @Select("select * from video where id = #{id} ")
    Video findById(int id);

    @Update("update video set title=#{title} where id =#{id}")
    int update(Video video);

    @Delete("delete from video where id=#{id}")
    int delete(int id);

    @Insert("INSERT INTO `video` ( `title`, `summary`, `cover_img`, `view_num`, `price`, `create_time`, `online`, `point`) VALUES (#{title}, #{summary}, #{coverImg}, #{viewNum}, #{price}, #{createTime}, #{online}, #{point});")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int save(Video video);
}
