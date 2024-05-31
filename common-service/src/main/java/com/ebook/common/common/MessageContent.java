package com.ebook.common.common;

/**
 * @Author: Cliffe
 * @Date: 2022-11-17 11:28 上午
 */
public class MessageContent {

    public static final String NEW_DOCUMENT_REVIEW_TITLE = "EBook: New Document Review Request";

    public static final String NEW_DOCUMENT_REVIEW_CONTENT = "EBook: New Document Review Request\n"+
                "Please log in to your account to review the document uploaded by @";

    public static final String NEW_DOCUMENT_UPLOAD_TITLE = "EBook: document upload confirmation";

    public static final String NEW_DOCUMENT_UPLOAD_CONTENT = "You have upload a new document.";

    public static final String DOCUMENT_STATUS_CHANGE_TITLE = "EBook: Document Review Result";

    public static final String DOCUMENT_STATUS_APPROVE_CONTENT = "The file you uploaded was approved by the reviewer.";

    public static final String DOCUMENT_STATUS_DENY_CONTENT = "The file you uploaded was denied by the reviewer. " +
            "The file now has been deleted.";

    public static final String PURCHASE_SUCCESS_TITLE = "EBook: Thank you for your purchasing";

    public static final String PURCHASE_SUCCESS_CONTENT =  "You have successfully placed an order on EBook!";
}
