package com.cyh.util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @className: PageInfo
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/07 19:55
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
@NoArgsConstructor
public class PageInfo<T> {
    /**
     * 当前页 前端传输
     */
    private Integer currentPage;

    /**
     * 每页条数 固定条数
     */
    private Integer pageSize;
    /**
     * 总条数 sql
     */
    private Integer totalSize;
    /**
     * 查询的数据 sql
     */
    private List<T> list;
    /**
     * 前一页
     */
    private Integer prevPage;
    /**
     * 后一页
     */
    private Integer nextPage;

    /**
     * 总页数
     */
    private Integer totalPage;

    public PageInfo(Integer currentPage, Integer pageSize, Integer totalSize, List<T> list, Integer prevPage, Integer nextPage, Integer totalPage) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.list = list;
        this.totalPage = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;
        this.prevPage = currentPage - 1 > 1 ? currentPage - 1 : 1;
        this.nextPage = currentPage + 1 < this.totalPage ? currentPage + 1 : this.totalPage;

    }
}
