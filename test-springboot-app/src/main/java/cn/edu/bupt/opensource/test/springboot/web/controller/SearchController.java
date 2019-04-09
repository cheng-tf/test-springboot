package cn.edu.bupt.opensource.test.springboot.web.controller;

import cn.edu.bupt.opensource.test.springboot.domain.result.SearchRes;
import cn.edu.bupt.opensource.test.springboot.domain.result.TaotaoResult;
import cn.edu.bupt.opensource.test.springboot.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * <p>Title: SearchController</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-05 17:15</p>
 * @author ChengTengfei
 * @version 1.0
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    private static final Logger log = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private SearchService searchService;

    @RequestMapping("/importItemsToIndex")
    public TaotaoResult importItemsToIndex() {
        log.info("------开始添加文档------");
        return searchService.importItemsToIndex2();
    }

    @RequestMapping("/search")
    public SearchRes search(String queryString, Integer page, Integer rows) throws UnsupportedEncodingException {
        //queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
        log.info("开始搜索 queryString = {}, page/rows = {}", queryString, String.valueOf(page) + "/" + String.valueOf(rows));
        return searchService.search2(queryString, page, rows);
    }

}
