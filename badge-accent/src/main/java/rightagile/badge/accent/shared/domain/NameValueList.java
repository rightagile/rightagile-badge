package rightagile.badge.accent.shared.domain;

import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NameValueList implements JsonSerializable {
    private List<NameValue> nameValues;

    public NameValueList() {
        this.nameValues = new ArrayList();
    }

    public NameValueList(NameValue nameValue) {
        this();
        this.nameValues.add(nameValue);
    }

    public NameValueList(String name, String value) {
        this();
        this.nameValues.add(new NameValue(name, value));
    }

    public NameValueList(NameValueList nameValues) {
        this();
        this.nameValues.addAll(nameValues.list());
    }

    public static NameValueList newInstance(String name, String value) {
        return new NameValueList(name, value);
    }

    public static NameValueList newEmptyInstance() {
        return new NameValueList();
    }

    public String toString() {
        return this.toJson();
    }

    public static NameValueList sample() {
        return new NameValueList("name", "Cheolsoo Kim");
    }

    public static NameValueList fromJson(String json) {
        return (NameValueList) JsonUtil.fromJson(json, NameValueList.class);
    }

    public NameValueList add(NameValue nameValue) {
        this.nameValues.add(nameValue);
        return this;
    }

    public NameValueList addAll(NameValueList nameValues) {
        this.nameValues.addAll(nameValues.list());
        return this;
    }

    public NameValueList add(String name, String value) {
        this.nameValues.add(new NameValue(name, value));
        return this;
    }

    public NameValueList remove(String name) {
        NameValue targetNameValue = null;
        Iterator var3 = this.nameValues.iterator();

        while(var3.hasNext()) {
            NameValue nameValue = (NameValue)var3.next();
            if (nameValue.getName().equals(name)) {
                targetNameValue = nameValue;
                break;
            }
        }

        if (targetNameValue != null) {
            this.nameValues.remove(targetNameValue);
        }

        return this;
    }

    public String getValueOf(String name) {
        return this.getNameValue(name).getValue();
    }

    public NameValue getNameValue(String name) {
        return (NameValue)this.nameValues.stream().filter((nameValue) -> {
            return name.equals(nameValue.getName());
        }).findFirst().orElse(null);
    }

    public void addAll(List<NameValue> nameValues) {
        this.nameValues.addAll(nameValues);
    }

    public List<NameValue> list() {
        return this.nameValues;
    }

    public boolean containsName(String name) {
        return this.nameValues.stream().anyMatch((nv) -> {
            return nv.getName().equals(name);
        });
    }

    public int size() {
        return this.nameValues.size();
    }

    public static void main(String[] args) {
        System.out.println(sample());
    }

    public List<NameValue> getNameValues() {
        return this.nameValues;
    }

    public void setNameValues(List<NameValue> nameValues) {
        this.nameValues = nameValues;
    }
}
