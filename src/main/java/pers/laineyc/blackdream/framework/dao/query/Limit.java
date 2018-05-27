package pers.laineyc.blackdream.framework.dao.query;

import java.io.Serializable;

/**
 * @author LaineyC
 */
public class Limit implements Serializable {

    private Integer firstResult;

    private Integer maxResults;

    public Limit(Integer firstResult, Integer maxResults) {
        this.firstResult = firstResult;
        this.maxResults = maxResults;
    }

    public Integer getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(Integer firstResult) {
        this.firstResult = firstResult;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

}
