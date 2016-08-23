package controllers;

import models.Computer;

import javax.inject.Singleton;
import java.util.List;

/**
 * Used to represent a computers page.
 */
public class Page {

    private final int pageSize;
    private final long totalRowCount;
    private final int pageIndex;
    private final List<Computer> list;

    public Page(List<Computer> data, long total, int page, int pageSize) {
        this.list = data;
        this.totalRowCount = total;
        this.pageIndex = page;
        this.pageSize = pageSize;
    }

    public long getTotalRowCount() {
        return totalRowCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public List<Computer> getList() {
        return list;
    }

    public boolean hasPrev() {
        return pageIndex > 1;
    }

    public boolean hasNext() {
        return (totalRowCount/pageSize) >= pageIndex;
    }

    public String getDisplayXtoYofZ() {
        int start = ((pageIndex - 1) * pageSize + 1);
        int end = start + Math.min(pageSize, list.size()) - 1;
        return start + " to " + end + " of " + totalRowCount;
    }

}