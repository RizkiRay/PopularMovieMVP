
package com.raycoding.popularmoviemvp.data.network.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class MovieResponse {

    @SerializedName("page")
    private Long Page;
    @SerializedName("results")
    private List<MovieResult> Results;
    @SerializedName("total_pages")
    private Long TotalPages;
    @SerializedName("total_results")
    private Long TotalResults;

    public Long getPage() {
        return Page;
    }

    public void setPage(Long page) {
        Page = page;
    }

    public List<MovieResult> getResults() {
        return Results;
    }

    public void setResults(List<MovieResult> results) {
        Results = results;
    }

    public Long getTotalPages() {
        return TotalPages;
    }

    public void setTotalPages(Long totalPages) {
        TotalPages = totalPages;
    }

    public Long getTotalResults() {
        return TotalResults;
    }

    public void setTotalResults(Long totalResults) {
        TotalResults = totalResults;
    }

}
