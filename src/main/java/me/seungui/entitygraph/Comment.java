package me.seungui.entitygraph;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;

@Entity
@Getter
@Setter
//@NamedEntityGraph(name = "Comment.post", attributeNodes = @NamedAttributeNode("post"))
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY) // one으로 끝나는 건 EAGER many로 끝나는 건 LAZY
    private Post post;

    private int up;

    private int down;

    private boolean best;
}













