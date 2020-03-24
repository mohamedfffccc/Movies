
package com.example.moviesflix2.data.model.vdata;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vdata {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("results")
    @Expose
    private List<data> results = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<data> getResults() {
        return results;
    }

    public void setResults(List<data> results) {
        this.results = results;
    }

}
