package rightagile.badge.accent.shared.domain;

import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;

public class Offset implements JsonSerializable {
    private int offset = 0;
    private int limit = 20;

    public Offset(int offset, int limit) {
        this.offset = offset;
        this.limit = limit > 0 ? limit : 20;
    }

    public static Offset newDefault() {
        return new Offset(0, 20);
    }

    public static Offset newOne(int offset, int limit) {
        return new Offset(offset, limit);
    }

    public String toString() {
        return this.toJson();
    }

    public static Offset fromJson(String json) {
        return JsonUtil.fromJson(json, Offset.class);
    }

    public static Offset sample() {
        return new Offset(0, 20);
    }

    public int offset() {
        return this.offset;
    }

    public int limit() {
        return this.limit;
    }

    public int page() {
        if(limit == 0) {
            limit = 20;
        }
        return offset / this.limit;
    }

    public int sum() {
        return this.offset + this.limit;
    }

    public static void main(String[] args) {
        System.out.println(sample());
    }

    public int getOffset() {
        return this.offset;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Offset() {
    }
}
