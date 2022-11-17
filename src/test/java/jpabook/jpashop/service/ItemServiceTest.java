package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Album;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.item.Movie;
import jpabook.jpashop.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired ItemService itemService;
    @Autowired ItemRepository itemRepository;
    @Autowired EntityManager em;

    @Test
    public void 아이템_저장() throws Exception {
        //given
        Item book = new Book();
        book.setName("myBook");

        //when
        itemService.saveItem(book);

        //then
        Item findItem = em.find(Item.class, book.getId());
        assertThat(book).isEqualTo(findItem);
    }

    @Test
    public void 아이템_전부_조회() throws Exception {
        //given
        Item book = new Book();
        Item movie = new Movie();
        Item album = new Album();

        //when
        itemService.saveItem(book);
        itemService.saveItem(movie);
        itemService.saveItem(album);

        List<Item> items = itemService.findItems();

        //then
        assertThat(items.size()).isEqualTo(3);
    }

    @Test
    public void 아이템_찾기() throws Exception {
        //given
        Item book = new Book();
        book.setName("myBook");

        //when
        itemService.saveItem(book);
        Item findItem = itemRepository.findOne(book.getId());

        //then
        assertThat(findItem).isEqualTo(book);
        assertThat(findItem).isInstanceOf(Book.class);

    }
}