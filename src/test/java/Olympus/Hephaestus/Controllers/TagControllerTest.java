package Olympus.Hephaestus.Controllers;

import Olympus.Hephaestus.DAO.TagService;
import Olympus.Hephaestus.Model.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TagControllerTest {

    @MockBean
    TagService tagService;

    @Autowired
    MockMvc mvc;

    @Test
    void getAllTags() throws Exception{
        //CReates list of tags
        List<Tag> allTags = new ArrayList<>();
        //Creates Tag entity and sets id.
        Tag firstTag = new Tag();
        Tag secondTag = new Tag();
        firstTag.setId(1);
        secondTag.setId(2);
        allTags.add(firstTag);
        allTags.add(secondTag);

        String expected = "[{\"id\":1,\"label\":null,\"postId\":0},{\"id\":2,\"label\":null,\"postId\":0}]";
        //Using given from mockito, makes sure the mocked tag service will return a list of tags
        BDDMockito.given(tagService.list()).willReturn(allTags);
        //Performs a get request to the mocked service and performs simple assertions
        //Status -is Successful
        //JSON object has 2 entities same as expected
        this.mvc.perform(MockMvcRequestBuilders.get("/tags").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().json(expected));
    }

    @Test
    void getTagById() {
        Tag firstTag = new Tag();
        firstTag.setId(1);
        Mockito.when(tagService.get(1)).thenReturn(Optional.of(firstTag));
        Optional<Tag> o1=tagService.get(1);
        assertEquals(firstTag,o1.get());
    }

    @Test
    void getTagByPost() {
    }

    @Test
    void makeTag() {
        //For mocking void method when-then mechanism of mockito does not work
        //because it needs return value.
        // doNothing completely ignore the void method
    Tag firstTag = new Tag();
    firstTag.setId(1);
    Tag randomTag = new Tag();
    randomTag.setId(65);
    doNothing().when(tagService).create(firstTag);
    tagService.create(randomTag);
    verify(tagService,Mockito.times(1)).create(randomTag);
    }

    @Test
    void changeTag() {
        Tag firstTag = new Tag();
        firstTag.setId(1);
        Tag randomTag = new Tag();
        randomTag.setId(65);
        doNothing().when(tagService).update(firstTag,1);
        tagService.update(randomTag,65);
        verify(tagService,Mockito.times(1)).update(randomTag,65);
    }

    @Test
    void deleteTag() {
        Tag firstTag = new Tag();
        firstTag.setId(1);
        Tag randomTag = new Tag();
        randomTag.setId(65);
        doNothing().when(tagService).delete(1);
        tagService.delete(65);
        verify(tagService,Mockito.times(1)).delete(65);
    }
}