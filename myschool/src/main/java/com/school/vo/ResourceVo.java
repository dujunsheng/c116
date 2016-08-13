package com.school.vo;

public class ResourceVo {
    private String absolutePath;
    private String title;//客户端传过来的实际文件名做为title
    private String relative_path;
    private String thumb_path;
    private String relativeThumbPath;
    private int type = 3;//默认为3表示其他文件
    private String fileName;
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getRelativeThumbPath() {
        return relativeThumbPath;
    }
    public void setRelativeThumbPath(String relativeThumbPath) {
        this.relativeThumbPath = relativeThumbPath;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getAbsolutePath() {
        return absolutePath;
    }
    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getRelative_path() {
        return relative_path;
    }
    public void setRelative_path(String relative_path) {
        this.relative_path = relative_path;
    }
    public String getThumb_path() {
        return thumb_path;
    }
    public void setThumb_path(String thumb_path) {
        this.thumb_path = thumb_path;
    }
    
}
