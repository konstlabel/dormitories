package com.konstl.dormitories.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PageResponse<T> {

    private List<T> content;

    private int page;

    private int pageSize;

    private long size;

    private long totalPages;

    private boolean last;

    public PageResponse() {}

    public PageResponse(List<T> content, int page, int pageSize, long size, int totalPages, boolean last) {
        setContent(content);
        this.page = page;
        this.pageSize = pageSize;
        this.size = size;
        this.totalPages = totalPages;
        this.last = last;
    }

    public List<T> getContent() {
        return content == null ? null : new ArrayList<>(content);
    }

    public final void setContent(List<T> content) {
        if (content == null) {
            this.content = null;
        } else {
            this.content = Collections.unmodifiableList(content);
        }
    }

    public boolean isLast() {
        return last;
    }

}
