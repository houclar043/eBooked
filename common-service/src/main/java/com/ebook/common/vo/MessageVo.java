package com.ebook.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import static com.ebook.common.vo.MessageVo.MessageType.*;

/**
 * @Author: Cliffe
 * @Date: 2022-10-22 4:25 下午
 */
@Data
public class MessageVo implements Serializable {

    private String hashKey;

    private String messageType;

    private Long senderId;

    private String senderNickname;

    private String senderAvatar;

    private Long receiverId;

    private String receiverNickname;

    private String content;

    private Date createTime;

    private String bookTitle;

    private long bookId;

    private String url;

    public static class MessageType{
        /**
         * TODO: add annotation here
         */
        public static String COMMENT_REPLY = "Reply Notification Message";
        public static String UPLOAD_NOTIFICATION = "Upload Notification Message";
        public static String REVIEW_NOTIFICATION = "Review Notification Message";
        public static String PURCHASE_NOTIFICATION = "Purchase Notification";
    }

    public String getUrl() {
        if(messageType.equals(COMMENT_REPLY)){
            return "https://localhost/book/item/detail/"+bookId;
        }else if(messageType.equals(UPLOAD_NOTIFICATION)
                || messageType.equals(REVIEW_NOTIFICATION)){
            return "https://localhost/user/page/review/"+bookId+"/"+hashKey;
        }
        return "#";
    }
}
