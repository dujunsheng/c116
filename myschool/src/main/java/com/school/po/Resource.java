package com.school.po;

public class Resource {
    private Integer id;//资源id
    private String user_id;//该资源是谁上传的
    private Integer class_id;//资源所属班级，0代表学校资源
    private String title;//资源的标题
    private String relative_path;//资源存储的相对路径1
    private String thumb_path;//资源缩略图的相对路径
    private String time;//资源上传的时间
    private Integer type;//资源的类型1.图片2.视频3.普通文件
    public Integer getId() {
        return id;
    }
    public String getThumb_path() {
        return thumb_path;
    }
    public void setThumb_path(String thumb_path) {
        this.thumb_path = thumb_path;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String u_id) {
        this.user_id = u_id;
    }
    public Integer getClass_id() {
        return class_id;
    }
    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }
    public String getRelative_path() {
        return relative_path;
    }
    public void setRelative_path(String relative_path) {
        this.relative_path = relative_path;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
