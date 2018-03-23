
package br.com.flexvision.befd.flex4.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "statement_id",
    "series"
})
public class Result {

    @JsonProperty("statement_id")
    private Integer statementId;
    @JsonProperty("series")
    private List<Series> series = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("statement_id")
    public Integer getStatementId() {
        return statementId;
    }

    @JsonProperty("statement_id")
    public void setStatementId(Integer statementId) {
        this.statementId = statementId;
    }

    @JsonProperty("series")
    public List<Series> getSeries() {
        return series;
    }

    @JsonProperty("series")
    public void setSeries(List<Series> series) {
        this.series = series;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
