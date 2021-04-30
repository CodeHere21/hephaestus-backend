package Olympus.Hephaestus.Controllers;

import Olympus.Hephaestus.DAO.TagService;
import Olympus.Hephaestus.Model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/tags")
@RestController
public class TagController {
    private TagService tagService;

    @Autowired
    public TagController(TagService t){tagService=t;}

    @GetMapping
    public List<Tag> getAllTags(){return tagService.list();}

    @GetMapping(path="{id}")
    public Optional<Tag> getTagById(@PathVariable int id){return tagService.get(id);}

    @PostMapping
    public void makeTag(@RequestBody Tag t){tagService.create(t);}

    @PutMapping
    public void changeTag(@RequestBody Tag t, @PathVariable int id){ tagService.update(t,id);}

    @DeleteMapping
    public void deleteTag(@PathVariable int id){deleteTag(id);}

}
