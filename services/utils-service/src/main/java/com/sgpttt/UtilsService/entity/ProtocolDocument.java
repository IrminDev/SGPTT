package com.sgpttt.UtilsService.entity;

import java.time.LocalDateTime;

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
    private String abstractText;

    private LocalDateTime creationDate;

    public ProtocolDocument() {
    }

    public ProtocolDocument(Long id, String title, String keywords, String abstractText, LocalDateTime creationDate) {
        this.id = id;
        this.title = title;
        this.keywords = keywords;
        this.abstractText = abstractText;
        this.creationDate = creationDate;
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

    public String getAbstractText() {
        return abstractText;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
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

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
