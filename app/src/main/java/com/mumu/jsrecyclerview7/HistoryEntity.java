package com.mumu.jsrecyclerview7;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * @author : zlf
 * date    : 2019/9/6
 * github  : https://github.com/mamumu
 * blog    : https://www.jianshu.com/u/281e9668a5a6
 * desc    :
 */
public class HistoryEntity implements Serializable {
    @Expose
    private String name;
    @Expose
    private int id;

    public HistoryEntity(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
