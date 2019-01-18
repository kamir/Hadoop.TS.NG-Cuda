
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
    "name",
    "time",
    "filters",
    "metrics",
    "expressions",
    "outputs"
})
public class Query {

    @JsonProperty("name")
    private Object name;
    @JsonProperty("time")
    private Time time;
    @JsonProperty("filters")
    private List<Filter> filters = null;
    @JsonProperty("metrics")
    private List<Metric> metrics = null;
    @JsonProperty("expressions")
    private List<Expression> expressions = null;
    @JsonProperty("outputs")
    private List<Output_> outputs = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Query() {
    }

    /**
     * 
     * @param time
     * @param metrics
     * @param name
     * @param outputs
     * @param filters
     * @param expressions
     */
    public Query(Object name, Time time, List<Filter> filters, List<Metric> metrics, List<Expression> expressions, List<Output_> outputs) {
        super();
        this.name = name;
        this.time = time;
        this.filters = filters;
        this.metrics = metrics;
        this.expressions = expressions;
        this.outputs = outputs;
    }

    @JsonProperty("name")
    public Object getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Object name) {
        this.name = name;
    }

    public Query withName(Object name) {
        this.name = name;
        return this;
    }

    @JsonProperty("time")
    public Time getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Time time) {
        this.time = time;
    }

    public Query withTime(Time time) {
        this.time = time;
        return this;
    }

    @JsonProperty("filters")
    public List<Filter> getFilters() {
        return filters;
    }

    @JsonProperty("filters")
    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public Query withFilters(List<Filter> filters) {
        this.filters = filters;
        return this;
    }

    @JsonProperty("metrics")
    public List<Metric> getMetrics() {
        return metrics;
    }

    @JsonProperty("metrics")
    public void setMetrics(List<Metric> metrics) {
        this.metrics = metrics;
    }

    public Query withMetrics(List<Metric> metrics) {
        this.metrics = metrics;
        return this;
    }

    @JsonProperty("expressions")
    public List<Expression> getExpressions() {
        return expressions;
    }

    @JsonProperty("expressions")
    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }

    public Query withExpressions(List<Expression> expressions) {
        this.expressions = expressions;
        return this;
    }

    @JsonProperty("outputs")
    public List<Output_> getOutputs() {
        return outputs;
    }

    @JsonProperty("outputs")
    public void setOutputs(List<Output_> outputs) {
        this.outputs = outputs;
    }

    public Query withOutputs(List<Output_> outputs) {
        this.outputs = outputs;
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

    public Query withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(time).append(filters).append(metrics).append(expressions).append(outputs).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Query) == false) {
            return false;
        }
        Query rhs = ((Query) other);
        return new EqualsBuilder().append(name, rhs.name).append(time, rhs.time).append(filters, rhs.filters).append(metrics, rhs.metrics).append(expressions, rhs.expressions).append(outputs, rhs.outputs).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
