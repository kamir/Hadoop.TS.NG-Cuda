
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
    "tagk",
    "filter",
    "group_by",
    "type"
})
public class Tag {

    @JsonProperty("tagk")
    private String tagk;
    @JsonProperty("filter")
    private String filter;
    @JsonProperty("group_by")
    private Boolean groupBy;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Tag() {
    }

    /**
     * 
     * @param groupBy
     * @param tagk
     * @param type
     * @param filter
     */
    public Tag(String tagk, String filter, Boolean groupBy, String type) {
        super();
        this.tagk = tagk;
        this.filter = filter;
        this.groupBy = groupBy;
        this.type = type;
    }

    @JsonProperty("tagk")
    public String getTagk() {
        return tagk;
    }

    @JsonProperty("tagk")
    public void setTagk(String tagk) {
        this.tagk = tagk;
    }

    public Tag withTagk(String tagk) {
        this.tagk = tagk;
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

    public Tag withFilter(String filter) {
        this.filter = filter;
        return this;
    }

    @JsonProperty("group_by")
    public Boolean getGroupBy() {
        return groupBy;
    }

    @JsonProperty("group_by")
    public void setGroupBy(Boolean groupBy) {
        this.groupBy = groupBy;
    }

    public Tag withGroupBy(Boolean groupBy) {
        this.groupBy = groupBy;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Tag withType(String type) {
        this.type = type;
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

    public Tag withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(tagk).append(filter).append(groupBy).append(type).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Tag) == false) {
            return false;
        }
        Tag rhs = ((Tag) other);
        return new EqualsBuilder().append(tagk, rhs.tagk).append(filter, rhs.filter).append(groupBy, rhs.groupBy).append(type, rhs.type).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
