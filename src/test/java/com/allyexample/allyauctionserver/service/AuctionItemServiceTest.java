package com.allyexample.allyauctionserver.service;

import com.allyexample.allyauctionserver.model.AuctionItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AuctionItemServiceTest {

    @Autowired
    private AuctionItemService auctionItemService;

    @Test()
    public void loads() throws Exception {
        assertThat(auctionItemService).isNotNull();
    }

    @Test()
    public void saveItem() {
        var ret = this.auctionItemService.addAuctionItem(new AuctionItem());
        assertThat(ret).isNotNull();
    }

    @Test()
    public void findAll() {
        var ret = this.auctionItemService.getAll();
        assertThat(ret).isNotNull();
    }

    @Test()
    public void findById() throws Exception {
        var a = new AuctionItem();
        this.auctionItemService.addAuctionItem(a);
        var ret = this.auctionItemService.getById(a.getAuctionItemId());
        assertThat(ret).isNotNull();
    }
}
