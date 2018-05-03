package com.raycoding.popularmoviemvp.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Movie {
    @Id
    private Long id;
    @Property
    private String title;
    @Property
    private String poster;
    @Property
    private String synopsis;
    @Property
    private String rating;
    @Property
    private Date releaseDate;
    @Generated(hash = 790229990)
    public Movie(Long id, String title, String poster, String synopsis,
            String rating, Date releaseDate) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.synopsis = synopsis;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }
    @Generated(hash = 1263461133)
    public Movie() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPoster() {
        return this.poster;
    }
    public void setPoster(String poster) {
        this.poster = poster;
    }
    public String getSynopsis() {
        return this.synopsis;
    }
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    public String getRating() {
        return this.rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public Date getReleaseDate() {
        return this.releaseDate;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
