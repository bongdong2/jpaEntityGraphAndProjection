package me.seungui.entitygraph;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @EntityGraph(value = "Comment.post", type = EntityGraph.EntityGraphType.LOAD)
    Optional<Comment> getByid(Long id);

//    List<CommentSummary> findPostById(Long id);
//
//    List<CommentVoteOnly> findVoteById(Long id);

    <T> List<T> findVoteById(Long id, Class<T> type);
}
