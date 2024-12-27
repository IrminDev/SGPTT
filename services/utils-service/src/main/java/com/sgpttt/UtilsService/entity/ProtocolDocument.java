package com.sgpttt.UtilsService.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "protocol")
public class ProtocolDocument {
    @Id
    private Long id;

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Text)
    private String keywords;

    @Field(type = FieldType.Text)
    private String protocolAbstract;

    public ProtocolDocument() {
    }

    public ProtocolDocument(Long id, String title, String keywords, String protocolAbstract) {
        this.id = id;
        this.title = title;
        this.keywords = keywords;
        this.protocolAbstract = protocolAbstract;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getProtocolAbstract() {
        return protocolAbstract;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setProtocolAbstract(String protocolAbstract) {
        this.protocolAbstract = protocolAbstract;
    }
}
