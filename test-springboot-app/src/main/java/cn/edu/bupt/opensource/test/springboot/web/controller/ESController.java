package cn.edu.bupt.opensource.test.springboot.web.controller;

import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * <p>Title: ESController</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-05 16:40</p>
 * @author ChengTengfei
 * @version 1.0
 */
@RestController
@RequestMapping("/es")
public class ESController {

    @Autowired
    private TransportClient transportClient;

    @RequestMapping("/test")
    public void test() throws ExecutionException, InterruptedException {
        // 搜索数据
        GetResponse response = transportClient.prepareGet("website", "blog", "1").execute().get();
        System.out.println(response.getSourceAsString());
    }

    @RequestMapping("/isExists")
    public void isExists(String indexName) {
        // 判定索引是否存在
        IndicesExistsResponse response=transportClient.admin().indices().prepareExists(indexName).get();
        System.out.println(response.isExists());
    }

    @RequestMapping("/createIndex")
    public void createIndex(String indexName) {
        // 创建索引
        CreateIndexResponse reponse=transportClient.admin().indices().prepareCreate(indexName.toLowerCase()).get();
        System.out.println(reponse.isAcknowledged());
    }

    @RequestMapping("/deleteIndex")
    public void deleteIndex(String indexName) {
        // 删除索引
        DeleteIndexResponse reponse = transportClient.admin().indices()
                .prepareDelete(indexName.toLowerCase())
                .execute()
                .actionGet();
        System.out.println(reponse.isAcknowledged());
    }













}
