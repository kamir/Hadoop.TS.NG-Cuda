
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
    "start",
    "end",
    "timezone",
    "downsampler",
    "aggregator"
})
public class Time {

    @JsonProperty("start")
    private String start;
    @JsonProperty("end")
    private Object end;
    @JsonProperty("timezone")
    private Object timezone;
    @JsonProperty("downsampler")
    private Object downsampler;
    @JsonProperty("aggregator")
    private String aggregator;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Time() {
    }

    /**
     * 
     * @param downsampler
     * @param timezone
     * @param aggregator
     * @param start
     * @param end
     */
    public Time(String start, Object end, Object timezone, Object downsampler, String aggregator) {
        super();
        this.start = start;
        this.end = end;
        this.timezone = timezone;
        this.downsampler = downsampler;
        this.aggregator = aggregator;
    }

    @JsonProperty("start")
    public String getStart() {
        return start;
    }

    @JsonProperty("start")
    public void setStart(String start) {
        this.start = start;
    }

    public Time withStart(String start) {
        this.start = start;
        return this;
    }

    @JsonProperty("end")
    public Object getEnd() {
        return end;
    }

    @JsonProperty("end")
    public void setEnd(Object end) {
        this.end = end;
    }

    public Time withEnd(Object end) {
        this.end = end;
        return this;
    }

    @JsonProperty("timezone")
    public Object getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(Object timezone) {
        this.timezone = timezone;
    }

    public Time withTimezone(Object timezone) {
        this.timezone = timezone;
        return this;
    }

    @JsonProperty("downsampler")
    public Object getDownsampler() {
        return downsampler;
    }

    @JsonProperty("downsampler")
    public void setDownsampler(Object downsampler) {
        this.downsampler = downsampler;
    }

    public Time withDownsampler(Object downsampler) {
        this.downsampler = downsampler;
        return this;
    }

    @JsonProperty("aggregator")
    public String getAggregator() {
        return aggregator;
    }

    @JsonProperty("aggregator")
    public void setAggregator(String aggregator) {
        this.aggregator = aggregator;
    }

    public Time withAggregator(String aggregator) {
        this.aggregator = aggregator;
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

    public Time withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(start).append(end).append(timezone).append(downsampler).append(aggregator).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Time) == false) {
            return false;
        }
        Time rhs = ((Time) other);
        return new EqualsBuilder().append(start, rhs.start).append(end, rhs.end).append(timezone, rhs.timezone).append(downsampler, rhs.downsampler).append(aggregator, rhs.aggregator).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
