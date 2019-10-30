
package com.laith.crawler.stackoverflow.entities;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("items")
    @Expose
    @Valid
    private List<Item> items = new ArrayList<Item>();

    @SerializedName("has_more")
    @Expose
    private Boolean has_more;

    @SerializedName("backoff")
    @Expose
    private Long backoff;

    @SerializedName("quota_max")
    @Expose
    private Long quota_max;

    @SerializedName("quota_remaining")
    @Expose
    private Long quota_remaining;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Boolean getHas_more() {
        return has_more;
    }

    public void setHas_more(Boolean has_more) {
        this.has_more = has_more;
    }

    public Long getBackoff() {
        return backoff;
    }

    public void setBackoff(Long backoff) {
        this.backoff = backoff;
    }

    public Long getQuota_max() {
        return quota_max;
    }

    public void setQuota_max(Long quota_max) {
        this.quota_max = quota_max;
    }

    public Long getQuota_remaining() {
        return quota_remaining;
    }

    public void setQuota_remaining(Long quota_remaining) {
        this.quota_remaining = quota_remaining;
    }

}
