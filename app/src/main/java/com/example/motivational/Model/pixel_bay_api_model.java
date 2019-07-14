package com.example.motivational.Model;

import java.util.List;

public class pixel_bay_api_model {
    private int totalHits;
    private List<Hits> hits;

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public List<Hits> getHits() {
        return hits;
    }

    public void setHits(List<Hits> hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return "pixel_bay_api_model{" +
                "totalHits=" + totalHits +
                ", hits=" + hits +
                '}';
    }
}
