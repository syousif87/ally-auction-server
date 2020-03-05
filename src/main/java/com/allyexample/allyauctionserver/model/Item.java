package com.allyexample.allyauctionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "item", indexes = { @Index(columnList = "item_id") })
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Setter
    @Column(name = "item_id")
    @JsonProperty("itemId")
    private String itemId;

    @Getter
    @Setter
    @Column(name = "description")
    @JsonProperty("description")
    private String description;

}
