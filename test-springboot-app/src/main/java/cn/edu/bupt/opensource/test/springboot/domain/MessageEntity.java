package cn.edu.bupt.opensource.test.springboot.domain;

import lombok.Data;

import java.util.Date;

/**
 * 消息实体类
 * @author chengtf
 * @date 2019/4/10
 */
@Data
public class MessageEntity {

    // ID
    private Long id;

    // 消息
    private String msg;

    // 时间戳
    private Date sendTime;

}