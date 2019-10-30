
package com.laith.crawler.stackoverflow.entities;

import javax.validation.Valid;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Item {

    @SerializedName("owner")
    @Expose
    @Valid
    private Owner owner;

    @SerializedName("score")
    @Expose
    private Long score;

    @SerializedName("last_edit_date")
    @Expose
    private Long last_edit_date;

    @SerializedName("last_activity_date")
    @Expose
    private Long last_activity_date;

    @SerializedName("creation_date")
    @Expose
    private Long creation_date;

    @SerializedName("post_type")
    @Expose
    private String post_type;

    @SerializedName("post_id")
    @Expose
    private Long post_id;

    @SerializedName("link")
    @Expose
    private String link;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getLast_edit_date() {
        return last_edit_date;
    }

    public void setLast_edit_date(Long last_edit_date) {
        this.last_edit_date = last_edit_date;
    }

    public Long getLast_activity_date() {
        return last_activity_date;
    }

    public void setLast_activity_date(Long last_activity_date) {
        this.last_activity_date = last_activity_date;
    }

    public Long getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Long creation_date) {
        this.creation_date = creation_date;
    }

    public String getPost_type() {
        return post_type;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Map<String, Object> getItemMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("creation_date", this.creation_date);
        map.put("last_activity_date", this.last_activity_date);
        map.put("last_edit_date", this.last_edit_date);
        map.put("item_link", this.link);
        map.put("post_id", this.post_id);
        map.put("post_type", this.post_type);
        map.put("score", this.score);
        if(this.owner != null) {
            map.putAll(this.owner.getOwnerMap());
        } else {
            System.out.println("Empty Owner ");
        }
        return map;
    }
}
