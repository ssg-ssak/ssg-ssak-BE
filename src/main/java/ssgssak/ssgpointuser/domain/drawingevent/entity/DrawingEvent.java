package ssgssak.ssgpointuser.domain.drawingevent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DrawingEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "event_list_id")
    private Long eventListId;

    @Column(nullable = false, name = "title")
    private String title;

    @Column(nullable = false, name = "contents_image_url")
    private String contentsImageUrl;

    public void updateDrawingEvent(String title, String contentsImageUrl){
        this.title = title;
        this.contentsImageUrl = contentsImageUrl;
    }
}