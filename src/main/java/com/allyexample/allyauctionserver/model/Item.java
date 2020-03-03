package com.allyexample.allyauctionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "item")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Setter
    @Column(name = "item_id")
    @JsonProperty("item_id")
    private String itemId;

    @Getter
    @Setter
    @Column(name = "description")
    @JsonProperty("description")
    private String description;

}
