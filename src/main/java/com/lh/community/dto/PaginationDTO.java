package com.lh.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanhu
 * @create 2020-01-22 18:33
 */
@Data
public class PaginationDTO {
    private List questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer currentPage;
    private Integer totalPage;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        totalPage = totalCount % size == 0 ? totalCount / size : totalCount / size + 1;

        if (page < 1){
            page = 1;
        }

        if (page > totalPage){
            page = totalPage;
        }
        currentPage = page;
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }
        //是否展示上一页
        showPrevious = page != 1;
        //是否展示下一页
        showNext = !page.equals(totalPage);
        //是否展示第一页
        showFirstPage = !pages.contains(1);
        //是否展示最后一页
        showEndPage = !pages.contains(totalPage);
    }
}
