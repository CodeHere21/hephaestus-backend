package Olympus.Hephaestus.Controllers;

import Olympus.Hephaestus.DAO.PostService;
import Olympus.Hephaestus.Model.Post;

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
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @MockBean
    PostService postService;

    @Autowired
    MockMvc mvc;


    @Test
    void getAllPosts() throws Exception {
        List<Post> allPosts = new ArrayList<>();
        Post firstPost = new Post();
        Post secondPost = new Post();
        firstPost.setId(1);
        secondPost.setId(2);
        allPosts.add(firstPost);
        allPosts.add(secondPost);

        String expected="[{\"id\":1,\"title\":null,\"body\":null,\"author\":null,\"published\":null},{\"id\":2,\"title\":null,\"body\":null,\"author\":null,\"published\":null}]";

        BDDMockito.given(postService.list()).willReturn(allPosts);
        this.mvc.perform(MockMvcRequestBuilders.get("/posts").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().json(expected));
    }

    @Test
    void getPostById_ThrowsPostNotFoundException() throws Exception {
        Post firstPost = new Post();
        firstPost.setId(1);
        Mockito.when(postService.get(1)).thenReturn(Optional.of(firstPost));
        Optional<Post> o1=postService.get(1);
        assertEquals(firstPost,o1.get());
    }

    @Test
    void getPostByTag() {
    }

    @Test
    void writeBlog() {
        Post firstPost = new Post();
        firstPost.setId(1);
        Post testPost = new Post();
        testPost.setId(65);
        doNothing().when(postService).create(firstPost);
        postService.create(testPost);
        verify(postService,times(1)).create(testPost);
    }

    @Test
    void updatePostWithDoNothing() {
        Post firstPost = new Post();
        firstPost.setId(1);
        Post secondPost = new Post();
        secondPost.setId(65);
        secondPost.setTitle("test");
        doNothing().when(postService).update(firstPost,1);
        postService.update(secondPost,65);
        verify(postService,times(1)).update(secondPost,65);
    }

    @Test
    void deletePostById() throws Exception{
        Post firstPost = new Post();
        firstPost.setId(1);
        Post secondPost = new Post();
        secondPost.setId(65);
        secondPost.setTitle("test");
        doNothing().when(postService).delete(1);
        postService.delete(65);
        verify(postService,times(1)).delete(65);
    }
    @Test
    void deleteHouseByIdError() throws Exception{
        int typeId = 65;
        Post existingRecord = new Post();
        existingRecord.setId(typeId);
        Optional<Post> nullPost= Optional.of(new Post());
        BDDMockito
                .given(postService.get(typeId))
                .willReturn(null);

        this.mvc.perform(MockMvcRequestBuilders
                .delete("/posts/" + typeId))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

    }
}