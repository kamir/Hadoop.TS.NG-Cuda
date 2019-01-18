
package opentsdb.api;

import java.util.HashMap;
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
    "metric",
    "id",
    "filter",
    "aggregator",
    "fillPolicy",
    "timeOffset"
})
public class Metric {

    @JsonProperty("metric")
    private String metric;
    @JsonProperty("id")
    private String id;
    @JsonProperty("filter")
    private String filter;
    @JsonProperty("aggregator")
    private Object aggregator;
    @JsonProperty("fillPolicy")
    private FillPolicy fillPolicy;
    @JsonProperty("timeOffset")
    private Object timeOffset;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Metric() {
    }

    /**
     * 
     * @param id
     * @param aggregator
     * @param fillPolicy
     * @param metric
     * @param timeOffset
     * @param filter
     */
    public Metric(String metric, String id, String filter, Object aggregator, FillPolicy fillPolicy, Object timeOffset) {
        super();
        this.metric = metric;
        this.id = id;
        this.filter = filter;
        this.aggregator = aggregator;
        this.fillPolicy = fillPolicy;
        this.timeOffset = timeOffset;
    }

    @JsonProperty("metric")
    public String getMetric() {
        return metric;
    }

    @JsonProperty("metric")
    public void setMetric(String metric) {
        this.metric = metric;
    }

    public Metric withMetric(String metric) {
        this.metric = metric;
        return this;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Metric withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("filter")
    public String getFilter() {
        return filter;
    }

    @JsonProperty("filter")
    public void setFilter(String filter) {
        this.filter = filter;
    }

    public Metric withFilter(String filter) {
        this.filter = filter;
        return this;
    }

    @JsonProperty("aggregator")
    public Object getAggregator() {
        return aggregator;
    }

    @JsonProperty("aggregator")
    public void setAggregator(Object aggregator) {
        this.aggregator = aggregator;
    }

    public Metric withAggregator(Object aggregator) {
        this.aggregator = aggregator;
        return this;
    }

    @JsonProperty("fillPolicy")
    public FillPolicy getFillPolicy() {
        return fillPolicy;
    }

    @JsonProperty("fillPolicy")
    public void setFillPolicy(FillPolicy fillPolicy) {
        this.fillPolicy = fillPolicy;
    }

    public Metric withFillPolicy(FillPolicy fillPolicy) {
        this.fillPolicy = fillPolicy;
        return this;
    }

    @JsonProperty("timeOffset")
    public Object getTimeOffset() {
        return timeOffset;
    }

    @JsonProperty("timeOffset")
    public void setTimeOffset(Object timeOffset) {
        this.timeOffset = timeOffset;
    }

    public Metric withTimeOffset(Object timeOffset) {
        this.timeOffset = timeOffset;
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

    public Metric withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(metric).append(id).append(filter).append(aggregator).append(fillPolicy).append(timeOffset).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Metric) == false) {
            return false;
        }
        Metric rhs = ((Metric) other);
        return new EqualsBuilder().append(metric, rhs.metric).append(id, rhs.id).append(filter, rhs.filter).append(aggregator, rhs.aggregator).append(fillPolicy, rhs.fillPolicy).append(timeOffset, rhs.timeOffset).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
