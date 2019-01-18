
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
    "index",
    "metrics",
    "commonTags",
    "aggregatedTags"
})
public class Metum {

    @JsonProperty("index")
    private Integer index;
    @JsonProperty("metrics")
    private List<String> metrics = null;
    @JsonProperty("commonTags")
    private CommonTags commonTags;
    @JsonProperty("aggregatedTags")
    private List<Object> aggregatedTags = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Metum() {
    }

    /**
     * 
     * @param index
     * @param commonTags
     * @param metrics
     * @param aggregatedTags
     */
    public Metum(Integer index, List<String> metrics, CommonTags commonTags, List<Object> aggregatedTags) {
        super();
        this.index = index;
        this.metrics = metrics;
        this.commonTags = commonTags;
        this.aggregatedTags = aggregatedTags;
    }

    @JsonProperty("index")
    public Integer getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(Integer index) {
        this.index = index;
    }

    public Metum withIndex(Integer index) {
        this.index = index;
        return this;
    }

    @JsonProperty("metrics")
    public List<String> getMetrics() {
        return metrics;
    }

    @JsonProperty("metrics")
    public void setMetrics(List<String> metrics) {
        this.metrics = metrics;
    }

    public Metum withMetrics(List<String> metrics) {
        this.metrics = metrics;
        return this;
    }

    @JsonProperty("commonTags")
    public CommonTags getCommonTags() {
        return commonTags;
    }

    @JsonProperty("commonTags")
    public void setCommonTags(CommonTags commonTags) {
        this.commonTags = commonTags;
    }

    public Metum withCommonTags(CommonTags commonTags) {
        this.commonTags = commonTags;
        return this;
    }

    @JsonProperty("aggregatedTags")
    public List<Object> getAggregatedTags() {
        return aggregatedTags;
    }

    @JsonProperty("aggregatedTags")
    public void setAggregatedTags(List<Object> aggregatedTags) {
        this.aggregatedTags = aggregatedTags;
    }

    public Metum withAggregatedTags(List<Object> aggregatedTags) {
        this.aggregatedTags = aggregatedTags;
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

    public Metum withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(index).append(metrics).append(commonTags).append(aggregatedTags).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Metum) == false) {
            return false;
        }
        Metum rhs = ((Metum) other);
        return new EqualsBuilder().append(index, rhs.index).append(metrics, rhs.metrics).append(commonTags, rhs.commonTags).append(aggregatedTags, rhs.aggregatedTags).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
