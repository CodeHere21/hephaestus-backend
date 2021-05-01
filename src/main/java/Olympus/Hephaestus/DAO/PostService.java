package Olympus.Hephaestus.DAO;

import Olympus.Hephaestus.Model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements DAO<Post> {

    private static final Logger log = LoggerFactory.getLogger(PostService.class);
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Post> rows=(rs,rowNum)->{
        Post post=new Post();
        post.setId(rs.getInt("ID"));
        post.setTitle(rs.getString("TITLE"));
        post.setAuthor(rs.getString("AUTHOR"));
        post.setBody(rs.getString("BODY"));
        post.setPublished(rs.getDate("PUBLISHED"));
    return post;
    };


    @Autowired
    public PostService(JdbcTemplate j){jdbcTemplate=j;}

    @Override
    public List<Post> list() {
        String sql="SELECT ID, TITLE, AUTHOR, BODY, PUBLISHED FROM POST";
        return jdbcTemplate.query(sql, rows);
    }

    @Override
    public void create(Post post) {
        String sql="INSERT INTO POST(TITLE, AUTHOR, BODY, PUBLISHED) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, post.getTitle(),post.getAuthor(), post.getBody(), post.getPublished());
    }

    @Override
    public Optional<Post> get(int id) {
        String sql="SELECT ID, TITLE, AUTHOR, BODY, PUBLISHED FROM POST WHERE ID=?";
        Post post=null;
        try{post=jdbcTemplate.queryForObject(sql, rows, id);}
        catch(DataAccessException e){log.info("Blog not found");}

        return Optional.ofNullable(post);
    }

    @Override
    public void update(Post post, int id) {
        String sql="UPDATE POST SET TITLE=?, AUTHOR=?, BODY=?, PUBLISHED=? WHERE ID=?";
        int update= jdbcTemplate.update(sql, post.getTitle(), post.getAuthor(), post.getBody(),post.getPublished() ,id);
        if(update==1){log.info("Post Updated");}
    }

    @Override
    public void delete(int id) {
            jdbcTemplate.update("DELETE FROM POST WHERE ID=?",id);
    }
}
