
package opentsdb.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "outputs",
    "statsSummary",
    "query"
})
public class QueryResult {

    @JsonProperty("outputs")
    private List<Output> outputs = null;
    @JsonProperty("statsSummary")
    private StatsSummary statsSummary;
    @JsonProperty("query")
    private Query query;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public QueryResult() {
    }

    /**
     * 
     * @param query
     * @param statsSummary
     * @param outputs
     */
    public QueryResult(List<Output> outputs, StatsSummary statsSummary, Query query) {
        super();
        this.outputs = outputs;
        this.statsSummary = statsSummary;
        this.query = query;
    }

    @JsonProperty("outputs")
    public List<Output> getOutputs() {
        return outputs;
    }

    @JsonProperty("outputs")
    public void setOutputs(List<Output> outputs) {
        this.outputs = outputs;
    }

    public QueryResult withOutputs(List<Output> outputs) {
        this.outputs = outputs;
        return this;
    }

    @JsonProperty("statsSummary")
    public StatsSummary getStatsSummary() {
        return statsSummary;
    }

    @JsonProperty("statsSummary")
    public void setStatsSummary(StatsSummary statsSummary) {
        this.statsSummary = statsSummary;
    }

    public QueryResult withStatsSummary(StatsSummary statsSummary) {
        this.statsSummary = statsSummary;
        return this;
    }

    @JsonProperty("query")
    public Query getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(Query query) {
        this.query = query;
    }

    public QueryResult withQuery(Query query) {
        this.query = query;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public QueryResult withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(outputs).append(statsSummary).append(query).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof QueryResult) == false) {
            return false;
        }
        QueryResult rhs = ((QueryResult) other);
        return new EqualsBuilder().append(outputs, rhs.outputs).append(statsSummary, rhs.statsSummary).append(query, rhs.query).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
