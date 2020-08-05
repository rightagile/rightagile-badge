package rightagile.badge.accent.shared.domain;

import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;

import java.util.Objects;
import java.util.StringTokenizer;

public class NameValue implements JsonSerializable {
    private String name;
    private String value;

    public NameValue(String name, String value) {
        this.setName(name);
        this.setValue(value);
    }

    public static NameValue fromJson(String json) {
        return (NameValue) JsonUtil.fromJson(json, NameValue.class);
    }

    public String toString() {
        return this.toJson();
    }

    public boolean equals(Object target) {
        if (this == target) {
            return true;
        } else if (target != null && this.getClass() == target.getClass()) {
            NameValue nameValue = (NameValue)target;
            return Objects.equals(this.name, nameValue.name) && Objects.equals(this.value, nameValue.value);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name + this.value});
    }

    public String toSimpleString() {
        return String.format("%s:%s", this.name, this.value);
    }

    public static NameValue fromSimpleString(String nameValueString) {
        StringTokenizer tokenizer = new StringTokenizer(nameValueString, ":");
        String name = tokenizer.nextToken();
        String value = tokenizer.nextToken();
        return new NameValue(name, value);
    }

    public static NameValue sample() {
        return new NameValue("name", "Cheolsoo Kim");
    }

    public static void main(String[] args) {
        System.out.println(sample());
        System.out.println(sample().toSimpleString());
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public NameValue() {
    }
}
