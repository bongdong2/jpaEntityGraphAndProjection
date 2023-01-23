package me.seungui.entitygraph;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Test
    void getCommnet() {
        //Optional<Comment> byId = repository.findById(1L);

//        Comment comment = new Comment();
//        comment.setComment("test");
//        repository.save(comment);

        // LOAD로 설정했으므로 EAGER로 가져오길 기대한다.
        Optional<Comment> comment = commentRepository.getByid(1L);
        System.out.println("===============================");
        commentRepository.findById(1L);
    }

    @Test
    void projectionInterfaceTest() {
        Post post = new Post();
        post.setTitle("hello");
        post.setContent("test");
        Post savedPost = postRepository.save(post);

        Comment comment = new Comment();
        comment.setComment("hello");
        comment.setUp(100);
        comment.setDown(30);
        comment.setPost(savedPost);
        Comment savedComment = commentRepository.save(comment);

        commentRepository.findCommentById(2L, CommentSummary.class).forEach(c -> {
            System.out.println("=====================================================================");
            System.out.println(c.getVotes());
            System.out.println("=====================================================================");
        });


    }

    @Test
    void projectionClassTest() {
        Post post = new Post();
        post.setTitle("hello");
        post.setContent("test");
        Post savedPost = postRepository.save(post);

        Comment comment = new Comment();
        comment.setComment("hello");
        comment.setUp(100);
        comment.setDown(30);
        comment.setPost(savedPost);
        Comment savedComment = commentRepository.save(comment);

        commentRepository.findCommentById(2L, CommentOnly.class).forEach(c -> {
            System.out.println("=====================================================================");
            System.out.println(c.getComment());
            System.out.println("=====================================================================");
        });
    }


}















