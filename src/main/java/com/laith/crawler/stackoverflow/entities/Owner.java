
package com.laith.crawler.stackoverflow.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Owner {

    @SerializedName("reputation")
    @Expose
    private Long reputation;

    @SerializedName("user_id")
    @Expose
    private Long user_id;

    @SerializedName("user_type")
    @Expose
    private String user_type;

    @SerializedName("profile_image")
    @Expose
    private String profile_image;

    @SerializedName("display_name")
    @Expose
    private String display_name;

    @SerializedName("link")
    @Expose
    private String link;

    @SerializedName("accept_rate")
    @Expose
    private Long accept_rate;

    public Long getReputation() {
        return reputation;
    }

    public void setReputation(Long reputation) {
        this.reputation = reputation;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getAccept_rate() {
        return accept_rate;
    }

    public void setAccept_rate(Long accept_rate) {
        this.accept_rate = accept_rate;
    }

    public Map<String, Object> getOwnerMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("accept_rate", this.accept_rate);
        map.put("display_name", this.display_name);
        map.put("owner_link", this.link);
        map.put("profile_image", this.profile_image);
        map.put("reputation", this.reputation);
        map.put("user_id", this.user_id);
        map.put("user_type", this.user_type);
        return map;
    }
}
