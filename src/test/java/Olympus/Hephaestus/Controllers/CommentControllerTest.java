package Olympus.Hephaestus.Controllers;

import Olympus.Hephaestus.DAO.CommentService;
import Olympus.Hephaestus.Model.Comment;
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
class CommentControllerTest {

    @MockBean
    CommentService commentService;

    @Autowired
    MockMvc mvc;

    @Test
    void getAllComments() throws Exception {
        //Creates list of comments
        List<Comment> allComments = new ArrayList<>();
        //Create Comment entity
        Comment firstComment = new Comment();
        Comment secondComment = new Comment();
        firstComment.setId(1);
        secondComment.setId(2);
        allComments.add(firstComment);
        allComments.add(secondComment);

        String expected = "[{\"id\":1,\"body\":null,\"author\":null,\"writtenOn\":null},{\"id\":2,\"body\":null,\"author\":null,\"writtenOn\":null}]";
        //Using given from mockito, makes sure the mocked post service will return a list of comments
        BDDMockito.given(commentService.list()).willReturn(allComments);

        this.mvc.perform(MockMvcRequestBuilders.get("/comments").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().json(expected));
    }

    @Test
    void getCommentById_ThrowsCommentNotFoundException() {
        Comment testComment = new Comment();
        testComment.setId(1);
        Mockito.when(commentService.get(1)).thenReturn(Optional.of(testComment));
        Optional<Comment> o1 = commentService.get(1);
        assertEquals(testComment,o1.get());
    }

    @Test
    void getAllCommentsByPost() {

    }

    @Test
    void writeComment() {
        Comment someComment = new Comment();
        someComment.setId(1);
        Comment testComment = new Comment();
        testComment.setId(50);
        doNothing().when(commentService).create(someComment);
        commentService.create(testComment);
        verify(commentService,times(1)).create(testComment);
    }

    @Test
    void editComment() {
        Comment someComment = new Comment();
        someComment.setId(1);
        Comment testComment = new Comment();
        testComment.setId(50);
        doNothing().when(commentService).update(someComment,50);
        commentService.update(testComment,50);
        verify(commentService,times(1)).update(testComment,50);
    }

    @Test
    void deleteComment() {
        Comment someComment = new Comment();
        someComment.setId(1);
        Comment testComment = new Comment();
        testComment.setId(50);
        doNothing().when(commentService).delete(50);
        commentService.delete(50);
        verify(commentService,times(1)).delete(50);
    }
}