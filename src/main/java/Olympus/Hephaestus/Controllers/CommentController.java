package Olympus.Hephaestus.Controllers;

import Olympus.Hephaestus.DAO.CommentService;
import Olympus.Hephaestus.Model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/comments")
@RestController
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService c){commentService=c;}

    @GetMapping
    public List<Comment> getAllComments(){return commentService.list();}

    @GetMapping(path="{id}")
    public Optional<Comment> getCommentById(@PathVariable int id){return commentService.get(id);}

    @PostMapping
    public void writeComment(@RequestBody Comment c){commentService.create(c);}

    @PutMapping(path="{id}")
    public void editComment(@RequestBody Comment c, @PathVariable int id){
        commentService.update(c,id);
    }

    @DeleteMapping(path="{id}")
    public void deleteComment(@PathVariable int id){commentService.delete(id);}


}
